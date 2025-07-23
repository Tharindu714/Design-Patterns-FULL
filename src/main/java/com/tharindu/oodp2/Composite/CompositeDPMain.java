package com.tharindu.oodp2.Composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails(String indent);
}

class FileDP implements FileSystemComponent {
    private final String name;
    private final double size;

    public FileDP(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + " MB)");
    }
}

class DirectoryDP implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    public DirectoryDP(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails(indent + "  ");
        }
    }
}

public class CompositeDPMain {
    public static void main(String[] args) {
        FileSystemComponent fsc1 = new FileDP("Resume.txt", 1.5);
        FileSystemComponent fsc2 = new FileDP("CV.pdf", 12.8);
        FileSystemComponent fsc3 = new FileDP("Photo.png", .290);

        DirectoryDP dir1 = new DirectoryDP("My-Files");
        dir1.addComponent(fsc1);
        dir1.addComponent(fsc2);

        DirectoryDP dir2 = new DirectoryDP("My-Photos");
        dir2.addComponent(fsc3);
        dir2.addComponent(dir1);

        System.out.println("File System Structure:");
        dir2.showDetails("");
    }
}
