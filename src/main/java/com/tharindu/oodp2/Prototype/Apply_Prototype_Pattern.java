package com.tharindu.oodp2.Prototype;

import java.util.HashMap;

interface DocumentPrototype extends Cloneable {
    DocumentPrototype clone();
}

class Document implements DocumentPrototype {
    String type;
    String content;

    public Document(String type, String content) {
        this.type = type;
        this.content = content;
        System.out.println("Document created: " + type + " with content: " + content);
    }

    @Override
    public DocumentPrototype clone() {
        try {
            return (DocumentPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported for Document", e);
        }
    }

    public void Show() {
        System.out.println("Document Type: " + type);
        System.out.println("Content: " + content);
    }
}

// This class is responsible for managing the documents,
// But this is an optional class and not necessary for the prototype pattern
class DocumentManager {
    static HashMap<String, DocumentPrototype> documents = new HashMap<>();

    public static void loadDocuments() {
        documents.put("Invoice", new Document("Invoice", "Account Summary for the month of October"));
        documents.put("Resume", new Document("Resume", "My Resume for the year 2025"));
        documents.put("Letter", new Document("Letter", "Dear Sir/Madam, this is a letter regarding your request."));
    }

    public static DocumentPrototype getDocument(String type) {
        DocumentPrototype prototype = documents.get(type);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
}

public class Apply_Prototype_Pattern {
    public static void main(String[] args) {
        DocumentManager.loadDocuments();

        //Separating the output for clarity
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Loading documents...");
        // Here we can load documents from a database or any other source.
        System.out.println("Documents loaded successfully!");
        // Adding some sample documents to the HashMap
        System.out.println("-------------------------------------------------------------------");

        // Now we can retrieve and clone documents using the prototype pattern
        DocumentPrototype document1 = DocumentManager.getDocument("Invoice");
        DocumentPrototype document2 = DocumentManager.getDocument("Resume");
        DocumentPrototype document3 = DocumentManager.getDocument("Letter");

        assert document1 != null;
        ((Document) document1).Show();
        System.out.println("-------------------------------------------------------------------");
        assert document2 != null;
        ((Document) document2).Show();
        System.out.println("-------------------------------------------------------------------");
        assert document3 != null;
        ((Document) document3).Show();
        System.out.println("-------------------------------------------------------------------");
    }
}

// This code demonstrates the Prototype design pattern by creating a Document class that can be cloned.
//Output
/*
Document created: Invoice with content: Account Summary for the month of October
Document created: Resume with content: My Resume for the year 2025
Document created: Letter with content: Dear Sir/Madam, this is a letter regarding your request.
-------------------------------------------------------------------
Loading documents...
Documents loaded successfully!
-------------------------------------------------------------------
Document Type: Invoice
Content: Account Summary for the month of October
-------------------------------------------------------------------
Document Type: Resume
Content: My Resume for the year 2025
-------------------------------------------------------------------
Document Type: Letter
Content: Dear Sir/Madam, this is a letter regarding your request.
-------------------------------------------------------------------
*/
