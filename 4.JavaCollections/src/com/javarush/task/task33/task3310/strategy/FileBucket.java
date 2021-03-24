package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() throws IOException {
        this.path = Files.createTempFile(null, null);
        Files.deleteIfExists(path);
        Files.createFile(path);
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
            return 0L;
        }
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
            oos.writeObject(entry);
            oos.close();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0L) return null;

        try {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
            Entry entry = (Entry) ois.readObject();
            ois.close();
            return entry;
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.log(e);
            return null;
        }
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
