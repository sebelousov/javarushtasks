package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен...");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> m : connectionMap.entrySet()) {
            try {
                m.getValue().send(message);
            } catch (IOException e) {
                try {
                    m.getValue().send(new Message(MessageType.TEXT, "Не смогли доставить сообщение..."));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());

            try (Connection connection = new Connection(socket)) {
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным адресом " + socket.getRemoteSocketAddress() + " закрыто.");
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом" + socket.getRemoteSocketAddress());
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message reply = connection.receive();
                if (reply.getType() == MessageType.USER_NAME && !reply.getData().isEmpty() && !connectionMap.keySet().contains(reply.getData())) {
                    connectionMap.put(reply.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return reply.getData();
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> user : connectionMap.entrySet()) {
                String name = user.getKey();
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String formatMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, formatMessage));
                }
                else {
                    ConsoleHelper.writeMessage("Некорректный формат сообщения типа TEXT.");
                }
            }
        }
    }
}
