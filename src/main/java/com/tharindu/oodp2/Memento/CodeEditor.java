package com.tharindu.oodp2.Memento;

class EditorState {
    private final String code;

    public EditorState(String code) {
        this.code = code;
    }

    public String getContent() {
        return code;
    }
}

class Editor {
    private String code = "";

    public void write(String code) {
        this.code += code;
    }

    public EditorState Save() {
        return new EditorState(this.code);
    }

    public void Restore(EditorState state) {
        this.code = state.getContent();
    }

    public String getCode() {
        return code;
    }
}


class HistoryManager {
    private final java.util.Stack<EditorState> history = new java.util.Stack<>();
    private final java.util.Stack<EditorState> redoStack = new java.util.Stack<>();

    public void save(Editor editor) {
        history.push(editor.Save());
        redoStack.clear(); // Clear redo stack on new save
    }

    public void undo(Editor editor) {
        if (!history.isEmpty()) {
            redoStack.push(editor.Save());
            editor.Restore(history.pop());
        }
    }

    public void redo(Editor editor) {
        if (!redoStack.isEmpty()) {
            history.push(editor.Save());
            editor.Restore(redoStack.pop());
        }
    }
}

public class CodeEditor {
    public static void main(String[] args) {
        Editor editor = new Editor();
        HistoryManager history = new HistoryManager();

        editor.write("Hello, ");
        history.save(editor); // Save the state after writing "Hello,"

        editor.write("world!");
        history.save(editor); // Save the state after writing "world!"

        editor.write(" How are you?");
        history.save(editor); // Save the state after writing, "How are you"

        System.out.println("Current Code: " + editor.getCode());

        history.undo(editor); // Undo last change
        System.out.println("After Undo: " + editor.getCode());

        history.undo(editor); // Undo another change
        System.out.println("After another Undo: " + editor.getCode());

        history.redo(editor); // Redo last undone change
        System.out.println("After Redo: " + editor.getCode());
    }
}

// Output:
// Current Code: Hello, world! How are you?
// After Undo: Hello, world!
// After another Undo: Hello,
// After Redo: Hello, world! How are you?

//Note:
// This code demonstrates the Memento pattern by allowing an editor to save, undo, and redo changes to its content.
