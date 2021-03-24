package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private int count;

    private List<Path> foundFiles = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        int result = 0;

        if (partOfName != null && file.getFileName().toString().contains(partOfName)) {
            result++;
        }

        String contentOfFile = new String(content);
        if (partOfContent != null && contentOfFile.contains(partOfContent)) {
            result++;
        }

        if (minSize != 0 && content.length > minSize) {
            result++;
        }

        if (maxSize != 0 && content.length < maxSize) {
            result++;
        }

        if (result == count) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.count++;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.count++;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.count++;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.count++;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
