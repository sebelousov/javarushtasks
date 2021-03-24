package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BotClient extends Client {


    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            // Вывести в консоль текст полученного сообщения message
            ConsoleHelper.writeMessage(message);

            // Получить из message имя отправителя и текст сообщения. Они разделены ": "
            String senderName = "";
            String senderMessageText;

            if (message.contains(": ")) {
                senderName = message.substring(0, message.indexOf(": "));
                senderMessageText = message.substring(message.indexOf(": ") + 2);
            } else {
                senderMessageText = message;
            }


            SimpleDateFormat format = null;
            // Отправить ответ в зависимости от текста принятого сообщения. Если текст сообщения:
            if ("дата".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("d.MM.YYYY");
            } else if ("день".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("d");
            } else if ("месяц".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("MMMM");
            } else if ("год".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("YYYY");
            } else if ("время".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("H:mm:ss");
            } else if ("час".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("H");
            } else if ("минуты".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("m");
            } else if ("секунды".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("s");
            }

            if (format != null) {
                sendTextMessage("Информация для " + senderName + ": " + format.format(Calendar.getInstance().getTime()));
            }

//            String name = message.replaceAll(": .*", "");
//            String textOfMessage = message.replaceAll(".*: ", "");
//            String formatDate = null;
//            ConsoleHelper.writeMessage(message);
//            switch (textOfMessage) {
//                case "дата": formatDate = "d.MM.YYYY";
//                break;
//                case "день": formatDate = "d";
//                break;
//                case "месяц": formatDate = "MMMM";
//                break;
//                case "год": formatDate = "YYYY";
//                break;
//                case "время": formatDate = "H:mm:ss";
//                break;
//                case "час": formatDate = "H";
//                break;
//                case "минуты": formatDate = "m";
//                break;
//                case "секунды": formatDate = "s";
//                break;
//            }
//
//            if (formatDate != null) {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
//                Calendar calendar = new GregorianCalendar();
//                Date currentDate = calendar.getTime();
//                sendTextMessage("Информация для " + name + ": " + simpleDateFormat.format(currentDate));
//            }

        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }
}
