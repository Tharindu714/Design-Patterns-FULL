package com.tharindu.oodp2.Chain;

class HelpDesk {
    public void Handler(String issueType) {
        if (!issueType.equals("Basic")) {
            if (issueType.equals("Intermediate")) {
                System.out.println("Intermediate issue handled by Help Desk.");
            } else if (issueType.equals("Advanced")) {
                System.out.println("Advanced issue handled by Help Desk.");
            } else {
                System.out.println("Help Desk cannot handle this issue, passing to Technical Support.");
            }
        } else {
            System.out.println("Basic issue handled by Help Desk.");
        }
    }
}
// This is a simple implementation of the Chain of Responsibility pattern.
// The HelpDesk class handles different types of issues and passes them to the appropriate handler.

public class WithoutChainPattern {
    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();
        String[] issues = {"Basic", "Intermediate", "Advanced", "Unknown"};

        for (String issue : issues) {
            System.out.println("Handling issue: " + issue);
            helpDesk.Handler(issue);
            System.out.println();
        }
    }
}
// This is the main class for the Chain of Responsibility pattern.
// You can add your own implementation and test the chain of responsibility here.