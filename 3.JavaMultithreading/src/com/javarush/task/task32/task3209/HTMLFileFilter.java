package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.nio.file.Path;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        Path path = f.toPath();

        return f.isDirectory()
               || f.getName().toLowerCase().matches(".*\\.html")
               || f.getName().toLowerCase().matches(".*\\.htm");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
