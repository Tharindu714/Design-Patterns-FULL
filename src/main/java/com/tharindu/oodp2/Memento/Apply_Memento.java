package com.tharindu.oodp2.Memento;

import java.util.Stack;

class State {
    private final String state;

    public State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

//Originator Class
class TextEditor_memento{
    private String content = "● ";

    public void type(String words) {
        this.content += words;
    }
    public String getContent() {
        return content;
    }

    public State Save() {
        return new State(content);
    }

    public void Restore(State state) {
        this.content = state.getState();
    }
}

class CareTaker{
private final Stack<State> History = new Stack<>();

    public void Save(TextEditor_memento editor) {
        History.push(editor.Save());
    }

    public void Restore(TextEditor_memento editor) {
        if (!History.isEmpty()) {
            editor.Restore(History.pop());
        } else {
            System.out.println("No previous state to restore.");
        }
    }
}

public class Apply_Memento {
    public static void main(String[] args) {
        TextEditor_memento editor = new TextEditor_memento();
        CareTaker careTaker = new CareTaker();

        editor.type("Hello, ");
        careTaker.Save(editor); // Save state after typing "Hello,"
        System.out.println("Current Content: " + editor.getContent());

        editor.type(" how are you? ");
        System.out.println("Current Content: " + editor.getContent());

        careTaker.Restore(editor); // Restore to previous state
        System.out.println("Restored Content: " + editor.getContent() + " - Recovered");
    }
}
