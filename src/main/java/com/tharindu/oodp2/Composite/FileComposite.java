package com.tharindu.oodp2.Composite;

import java.util.ArrayList;
import java.util.List;

class File {
    private final String name;
    private final double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public void Open() {
        System.out.println("Opening file: " + getName()+ "(" + getSize() + " MB)");
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
        File file1 = new File("Tharindu_CV.docx", 4.5);
        File file2 = new File("Tharindu_Doc.txt", 10);
        File file3 = new File("Tharindu_Budget.xlsx", 0.5);
        File file4 = new File("Tharindu_Presentation.pptx", 2.7);

        Directory subDirectory1 = new Directory("subDirectory_1");
        subDirectory1.addFile(file2);
        subDirectory1.addFile(file3);

        Directory subDirectory2 = new Directory("subDirectory_2");
        subDirectory2.addFile(file1);
        subDirectory2.addFile(file4);

        Directory mainDirectory = new Directory("root_Directory");
        mainDirectory.addFile(new File("MyPhoto.jpg", 3.5));
        mainDirectory.addDirectory(subDirectory1);
        mainDirectory.addDirectory(subDirectory2);

        mainDirectory.openAll();
    }
}
