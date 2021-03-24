package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = "";
            StringBuilder productName = new StringBuilder(30);
            Product product;

            while (fileName.isEmpty()) {
                System.out.println("Введите имя файла");
                fileName = reader.readLine();
            }
            reader.close();

            productName.append(args[1]);

            if (args.length > 4) {
                productName.append(" ");
                for (int i = 2; i < args.length - 2; i++) {
                    productName.append(args[i]);
                    if (i < args.length - 3) productName.append(" ");
                }
            }

            product = new Product(productName.toString(), Double.parseDouble(args[args.length - 2]), Integer.parseInt(args[args.length - 1]));

            FileInputStream fis = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String strLine;
            int max = 0;

            while ((strLine = br.readLine()) != null) {
                String temp = strLine.substring(0, 8);
                int x = temp.indexOf(" ");
                if (x > 0) {
                    if (Integer.parseInt(temp.substring(0, x)) > max) max = Integer.parseInt(temp.substring(0, x));
                }
                else {
                    if (Integer.parseInt(temp) > max) max = Integer.parseInt(temp);
                }
            }

            br.close();

            product.setId(max + 1);

            FileOutputStream fos = new FileOutputStream(fileName, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos), 128);
            bw.newLine();
            bw.write(product.toString());

            bw.close();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет параметров");
        }


    }
}
