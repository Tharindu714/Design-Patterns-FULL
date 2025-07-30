package com.tharindu.oodp2.Chain;
//Abstract class for the Handler in the Chain of Responsibility pattern.
abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issueType);
}

//Concrete class for the Help Desk handler.
class Basic extends Handler {
    @Override
    public void handleRequest(String issueType) {
        if (issueType.equals("Basic")) {
            System.out.println("Basic issue handled by Help Desk.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issueType);
        } else {
            System.out.println("Help Desk cannot handle this issue, no further handlers available.");
        }
    }
}

//Concrete class for the Intermediate handler.
class Intermediate extends Handler {
    @Override
    public void handleRequest(String issueType) {
        if (issueType.equals("Intermediate")) {
            System.out.println("Intermediate issue handled by Help Desk.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issueType);
        } else {
            System.out.println("Help Desk cannot handle this issue, no further handlers available.");
        }
    }
}

//Concrete class for the Advanced handler.
class Advanced extends Handler {
    @Override
    public void handleRequest(String issueType) {
        if (issueType.equals("Advanced")) {
            System.out.println("Advanced issue handled by Help Desk.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issueType);
        } else {
            System.out.println("Help Desk cannot handle this issue, no further handlers available.");
        }
    }
}

//Main class to demonstrate the Chain of Responsibility pattern.
public class Chain_of_Responsibility {
    public static void main(String[] args) {
        // Create handlers
        Handler basicHandler = new Basic();
        Handler intermediateHandler = new Intermediate();
        Handler advancedHandler = new Advanced();

        // Set up the chain of responsibility
        basicHandler.setNextHandler(intermediateHandler);
        intermediateHandler.setNextHandler(advancedHandler);

        // Test the chain with different issue types
        String[] issues = {"Basic", "Intermediate", "Advanced", "Unknown"};

        for (String issue : issues) {
            System.out.println("Handling issue: " + issue);
            basicHandler.handleRequest(issue);
            System.out.println();
        }
    }
}
