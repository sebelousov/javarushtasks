package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // C:/result.mp3 C:/pathToTest/test.zip.003 C:/pathToTest/test.zip.001 C:/pathToTest/test.zip.004 C:/pathToTest/test.zip.002

        if (args.length < 2) return;

        String resultFileName = args[0];
        List<String> fileNamePart = new ArrayList<>(args.length - 1);
        for (int i = 1; i < args.length; i++) fileNamePart.add(args[i]);
        Collections.sort(fileNamePart);

        List<InputStream> streams = new ArrayList<>(fileNamePart.size());
        fileNamePart.forEach(path -> {
            try {
                streams.add(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(streams));

        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024]; // 1MB buffer
        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();





    }
}
