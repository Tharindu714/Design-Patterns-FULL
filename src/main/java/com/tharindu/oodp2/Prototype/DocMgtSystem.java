package com.tharindu.oodp2.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Document Management System using Prototype Pattern
 * This system allows cloning of document templates and customizing them.
 * It demonstrates the Prototype design pattern in Java.
 */

interface DocumentTemplate {
    DocumentTemplate cloneTemplate(); // prototype clone method

    String getName();

    String getContent();

    void setContent(String content);

    void print();
}

class Editor {
    private final Map<String, DocumentTemplate> prototypes = new HashMap<>();

    void registerPrototype(String key, DocumentTemplate prototype) {
        prototypes.put(key.toLowerCase(), prototype);
        System.out.println("Registered prototype: " + key);
    }

    DocumentTemplate create(String key) {
        DocumentTemplate proto = prototypes.get(key.toLowerCase());
        if (proto == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }
        return proto.cloneTemplate(); // produce a brand-new copy
    }

    public void printPrototype(String key) {
        DocumentTemplate prototype = prototypes.get(key);
        if (prototype != null) {
            String formatted = prototype.getContent().replace("\\n", "\n");
            System.out.println(formatted);
        } else {
            System.out.println("❌ No prototype found for: " + key);
        }
    }
}

class Invoice implements DocumentTemplate {
    String name;
    private String content;

    Invoice(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public DocumentTemplate cloneTemplate() {
        // create a new instance copying fields (simple deep copy of strings)
        return new Invoice(this.name, this.content);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("---- " + name + " ----");
        System.out.println(content);
        System.out.println("--------------------\n");
    }
}

class Resume implements DocumentTemplate {
    String name;
    private String content;

    Resume(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public DocumentTemplate cloneTemplate() {
        return new Resume(this.name, this.content);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("---- " + name + " ----");
        System.out.println(content);
        System.out.println("--------------------\n");
    }
}

class Letter implements DocumentTemplate {
    String name;
    private String content;

    Letter(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public DocumentTemplate cloneTemplate() {
        return new Letter(this.name, this.content);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("---- " + name + " ----");
        System.out.println(content);
        System.out.println("--------------------\n");
    }
}

public class DocMgtSystem {

    // ANSI color codes (common terminals)
    private final String RESET = "\u001B[0m";
    private final String BOLD = "\u001B[1m";
    private final String CYAN = "\u001B[36m";
    String MAGENTA = "\u001B[35m";
    String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        // run in instance context so inner classes remain instance classes
        new DocMgtSystem().start();
    }

    private void start() {
        printTitle("Document Management System ✨", "Prototype Pattern Demo");

        Editor editor = new Editor();

        // Register base templates (prototypes)
        editor.registerPrototype("invoice", new Invoice("Invoice",
                "Company: %COMPANY%\\nDate: %DATE%\\nItems: %ITEMS%\\nTotal: %TOTAL%"));
        editor.registerPrototype("resume", new Resume("Resume",
                "Name: %NAME%\\nEmail: %EMAIL%\\nExperience: %EXPERIENCE%"));
        editor.registerPrototype("letter", new Letter("Letter",
                "Dear %RECIPIENT%,\\n\\n%BODY%\\n\\nSincerely,\\n%SENDER%"));

        printlnInfo("Creating clones from prototypes...");

        // Create clones and customize them (Invoice 1)
        DocumentTemplate inv1 = editor.create("invoice"); // clone
        inv1.setContent(inv1.getContent().replace("%COMPANY%", "Acme Ltd")
                .replace("%DATE%", "2025-08-10")
                .replace("%ITEMS%", "Widgets x10")
                .replace("%TOTAL%", "$500"));
        printAction("✅ Created", "Invoice Copy 1");
        printDocument(inv1);

        // Invoice 2
        DocumentTemplate inv2 = editor.create("invoice"); // another clone, prototype unchanged
        inv2.setContent(inv2.getContent().replace("%COMPANY%", "Beta Co")
                .replace("%DATE%", "2025-08-11")
                .replace("%ITEMS%", "Gears x5")
                .replace("%TOTAL%", "$250"));
        printAction("✅ Created", "Invoice Copy 2");
        printDocument(inv2);

        // Resume
        DocumentTemplate resume = editor.create("resume");
        resume.setContent(resume.getContent().replace("%NAME%", "Tharindu Chanaka")
                .replace("%EMAIL%", "tharindu@example.com")
                .replace("%EXPERIENCE%", "Software Engineer - 3 years"));
        printAction("✅ Created", "Resume Copy");
        printDocument(resume);

        // Letter
        DocumentTemplate letter = editor.create("letter");
        letter.setContent(letter.getContent().replace("%RECIPIENT%", "Hiring Manager")
                .replace("%BODY%", "I am writing to express my interest.")
                .replace("%SENDER%", "Tharindu"));
        printAction("✅ Created", "Letter Copy");
        printDocument(letter);

        // Show prototypes remain unchanged (proof)
        printSection("🔒 Prototype Originals (unchanged)");
        editor.printPrototype("invoice");
        editor.printPrototype("resume");
        editor.printPrototype("letter");

        printFooter("Demo complete — prototypes remain pristine. 🎉");
    }

    // ---------- Pretty print helpers ----------

    private void printTitle(String title, String subtitle) {
        System.out.println();
        System.out.println(CYAN + BOLD + "┏" + repeat("━", 58) + "┓" + RESET);
        System.out.printf(CYAN + BOLD + "┃ %-" + 56 + "s ┃%n" + RESET, title);
        System.out.printf(CYAN + "┃ %-" + 56 + "s ┃%n" + RESET, subtitle);
        System.out.println(CYAN + BOLD + "┗" + repeat("━", 58) + "┛" + RESET);
        System.out.println();
    }

    private void printSection(String heading) {
        System.out.println();
        System.out.println(MAGENTA + BOLD + "» " + heading + RESET);
        System.out.println(MAGENTA + repeat("─", heading.length() + 2) + RESET);
    }

    private void printAction(String badge, String text) {
        System.out.println(BLUE + BOLD + "→ " + badge + RESET + " " + YELLOW + text + RESET);
    }

    private void printlnInfo(String message) {
        System.out.println(" " + YELLOW + "ℹ️  " + message + RESET);
    }

    private void printDocument(DocumentTemplate doc) {
        // Pretty box containing document content
        String header = " " + GREEN + BOLD + "📄 " + doc.getName() + RESET + " ";
        String content = doc.getContent().replace("\\n", "\n"); // ensure newlines render
        String[] lines = content.split("\n", -1);

        int width = Math.max(40, header.length());
        for (String line : lines) {
            width = Math.max(width, stripAnsi(line).length() + 2);
        }

        System.out.println(GREEN + "┌" + repeat("─", width) + "┐" + RESET);
        System.out.printf(GREEN + "│" + RESET + BOLD + "%-" + width + "s" + RESET + GREEN + "│%n" + RESET, header);
        System.out.println(GREEN + "├" + repeat("─", width) + "┤" + RESET);

        for (String line : lines) {
            System.out.printf(GREEN + "│ " + RESET + "%-" + (width - 2) + "s" + GREEN + " │%n" + RESET, line);
        }

        System.out.println(GREEN + "└" + repeat("─", width) + "┘" + RESET);
        System.out.println();
    }

    private void printFooter(String text) {
        System.out.println();
        System.out.println(CYAN + repeat("=", 60) + RESET);
        System.out.println(CYAN + BOLD + "✨ " + text + RESET);
        System.out.println(CYAN + repeat("=", 60) + RESET);
    }

    // Utility: repeat a string n times
    private String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder(times * s.length());
        for (int i = 0; i < times; i++) sb.append(s);
        return sb.toString();
    }

    // Utility: rough ANSI stripper to compute printable length
    private String stripAnsi(String input) {
        return input.replaceAll("\u001B\\[[;\\d]*m", "");
    }
}

// Output will show the created documents with customized content
/*
┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
┃ Document Management System ✨                            ┃
┃ Prototype Pattern Demo                                   ┃
┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛

Registered prototype: invoice
Registered prototype: resume
Registered prototype: letter
 ℹ️  Creating clones from prototypes...
→ ✅ Created Invoice Copy 1
┌────────────────────────────────────────┐
│ 📄 Invoice                │
├────────────────────────────────────────┤
│ Company: Acme Ltd                      │
│ Date: 2025-08-10                       │
│ Items:                                 │
│ - Widgets x10                          │
│ Total: $500                            │
└────────────────────────────────────────┘

→ ✅ Created Invoice Copy 2
┌────────────────────────────────────────┐
│ 📄 Invoice                │
├────────────────────────────────────────┤
│ Company: Beta Co                       │
│ Date: 2025-08-11                       │
│ Items:                                 │
│ - Gears x5                             │
│ Total: $250                            │
└────────────────────────────────────────┘

→ ✅ Created Resume Copy
┌────────────────────────────────────────┐
│ 📄 Resume                 │
├────────────────────────────────────────┤
│ Name: Tharindu Chanaka                 │
│ Email: tharindu@example.com            │
│ Experience:                            │
│ - Software Engineer - 3 years          │
└────────────────────────────────────────┘

→ ✅ Created Letter Copy
┌────────────────────────────────────────┐
│ 📄 Letter                 │
├────────────────────────────────────────┤
│ Dear Hiring Manager,                   │
│                                        │
│ I am writing to express my interest.   │
│                                        │
│ Sincerely,                             │
│ Tharindu                               │
└────────────────────────────────────────┘

» 🔒 Prototype Originals (unchanged)
────────────────────────────────────
Company: %COMPANY%
Date: %DATE%
Items: %ITEMS%
Total: %TOTAL%
Name: %NAME%
Email: %EMAIL%
Experience: %EXPERIENCE%
Dear %RECIPIENT%,

============================================================
✨ Demo complete — prototypes remain pristine. 🎉
============================================================
*/