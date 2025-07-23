package com.tharindu.oodp2.Composite;

import java.util.ArrayList;
import java.util.List;

class File {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void Open() {
        System.out.println("Opening file: " + getName());
    }
}

class Directory {
    private final String name;
    private final List<File> files = new ArrayList<>();
    private final List<Directory> directories = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        directories.add(directory);
    }

    public void openAll() {
        System.out.println("Opening directory: " + name);
        for (File file : files) {
            file.Open();
        }
        for (Directory directory : directories) {
            directory.openAll();
        }
    }
}

public class FileComposite {
    public static void main(String[] args) {

    }
}
