package com.tharindu.oodp2.Prototype;

class Document_OLD{
    String type;
    String content;

    public Document_OLD(String type, String content) {
        this.type = type;
        this.content = content;
        System.out.println("Document created: " + type + " with content: " + content);
    }

    public void show(){
        System.out.println("Document Type: " + type);
        System.out.println("Content: " + content);
    }
}

public class Without_Prototype_Pattern {
    public static void main(String[] args) {
        Document_OLD document1 = new Document_OLD("Invoice", "Account Summery for the month of October");
        Document_OLD document2 = new Document_OLD("Resume", "My Resume for the year 2025");
        Document_OLD document3 = new Document_OLD("Letter", "Dear Sir/Madam, this is a letter regarding your request.");

        document1.show();
        document2.show();
        document3.show();
    }
}
