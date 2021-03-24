package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

        @Override
        public void run() {
            String address = getServerAddress();
            int port = getServerPort();

            try (Socket socket = new Socket(address, port)) {
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }

        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                }
                else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                else if (message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                else if (message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                else throw new IOException("Unexpected MessageType");
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        SocketThread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();
        synchronized (this) {
            try {
                wait();
                if (clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

                while (clientConnected) {
                    String message = ConsoleHelper.readString();
                    if (message.equals("exit")) break;
                    if (shouldSendTextFromConsole()) sendTextMessage(message);
                }

            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Во время ожидания возникла проблема...");
                return;
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Пожалуйста, введите адрес сервера.");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Пожалуйста, введите порт сервера.");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Пожалуйста, введите имя пользователя.");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("При отправке сообщения произошла ошибка.");
        }
    }

//    Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера,
//    подсоединиться к указанному адресу, получить запрос имени от сервера, спросить имя
//    у пользователя, отправить имя пользователя серверу, дождаться принятия имени сервером.
//    После этого клиент может обмениваться текстовыми сообщениями с сервером.
//    Обмен сообщениями будет происходить в двух параллельно работающих потоках.
//    Один будет заниматься чтением из консоли и отправкой прочитанного серверу, а второй
//    поток будет получать данные от сервера и выводить их в консоль.
}
