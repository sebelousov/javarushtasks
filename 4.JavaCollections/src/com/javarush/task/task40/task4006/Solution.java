package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket clientSocket = new Socket(url.getHost(), url.getDefaultPort());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("GET " + url.getPath() + " HTTP/1.1");
            out.println("Host: " + url.getHost());
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String answer;

            while ((answer = in.readLine()) != null) {
                System.out.println(answer);
            }

            in.close();
            out.close();




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}