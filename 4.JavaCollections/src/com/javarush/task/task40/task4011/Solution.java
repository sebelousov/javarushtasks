package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");

    }

    public static void decodeURLString(String s) throws MalformedURLException {
        try {
            URL url = new URL(s);

            List<String> list = new ArrayList<>();
            list.add(url.getProtocol());
            list.add(url.getAuthority());
            list.add(url.getFile());
            list.add(url.getHost());
            list.add(url.getPath());
            list.add(String.valueOf(url.getPort()));
            list.add(String.valueOf(url.getDefaultPort()));
            list.add(url.getQuery());
            list.add(url.getRef());

            for (String e : list)
                System.out.println(e);
        }
        catch (MalformedURLException e) {
            System.out.println(String.format("Parameter %s is not a valid URL.", s));
        }


    }
}

