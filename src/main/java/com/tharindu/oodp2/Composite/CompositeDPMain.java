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

    }
}
