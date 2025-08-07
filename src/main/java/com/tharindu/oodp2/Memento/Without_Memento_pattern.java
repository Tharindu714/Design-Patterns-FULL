package com.tharindu.oodp2.Memento;

class TextEditor {
    private String content;

    public void type(String words) {
        this.content += words;
    }

    String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class Without_Memento_pattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.setContent("Hello, ");
        editor.type("world!");

        // Save the current state
        String savedContent = editor.getContent(); //Manually Save
        System.out.println("Current Content: " + savedContent);

        editor.setContent(savedContent); //Manually Restore
        System.out.println("Restored Content: " + editor.getContent() +" - Recovered");
    }
}
