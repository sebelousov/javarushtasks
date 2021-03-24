package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = "";
            while (fileName.isEmpty()) {
                System.out.println("Введите имя файла");
                fileName = reader.readLine();
            }
            reader.close();

            List<String> list = new ArrayList<>();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String strLine;
            while ((strLine = buffer.readLine()) != null) {
                list.add(strLine);
            }
            buffer.close();

            switch (args[0]) {
                case "-u":
                    StringBuilder productName = new StringBuilder(30);
                    Product product;
                    productName.append(args[2]);

                    if (args.length > 5) {
                        productName.append(" ");
                        for (int i = 3; i < args.length - 2; i++) {
                            productName.append(args[i]);
                            if (i < args.length - 3) productName.append(" ");
                        }
                    }

                    product = new Product(Integer.parseInt(args[1]), productName.toString(), Double.parseDouble(args[args.length - 2]), Integer.parseInt(args[args.length - 1]));
                    writeListInFile(update(list, product), fileName);
                    break;
                case "-d":
                    writeListInFile(delete(list, args[1]), fileName);
                    break;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Программа запущена без параметров");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при добавлении имени файла");
        }
    }

    public static List<String> update(List<String> list, Product product) {
        String temp;
        String[] products = new String[list.size()];

        for (int j = 0; j < list.size(); j++) {
            products[j] = list.get(j);
        }

        for (int i = 0; i < products.length; i++) {
            temp = products[i];
            int x = temp.substring(0, 8).indexOf(" ");
            if (x > 0) {
                if (Integer.parseInt(temp.substring(0, x)) == product.getId()) {
                    products[i] = product.toString();
                    break;
                }
            }
            else {
                if (Integer.parseInt(temp.substring(0, 8)) == product.getId()) {
                    products[i] = product.toString();
                    break;
                }
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < products.length; i++) {
            list.add(products[i]);
        }

        return list;
    }

    public static List<String> delete(List<String> list, String id) {
        String temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            int x = temp.substring(0, 8).indexOf(" ");
            if (x > 0) {
                if (temp.substring(0, x).equals(id)) {
                    list.remove(i);
                    break;
                }
            }
            else {
                if (temp.substring(0, 8).equals(id)) {
                    list.remove(i);
                    break;
                }
            }
        }
        return list;
    }

    public static void writeListInFile(List<String> list, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName, false);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos), 128);
        int temp = 1;
        for (String x : list) {
            bw.write(x);

            if (temp != list.size()) bw.newLine();
            temp++;
        }

        bw.close();
    }
}
