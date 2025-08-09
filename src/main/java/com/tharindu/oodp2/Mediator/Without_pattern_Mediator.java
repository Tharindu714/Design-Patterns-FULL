package com.tharindu.oodp2.Mediator;

class User_OLD {
    String name;

    public User_OLD(String name) {
        this.name = name;
    }

    public void sendMessages(String message, User_OLD receiver) {
        System.out.println(name + " sends message: " + message + " to " + receiver.name);
    }

}

public class Without_pattern_Mediator {
    public static void main(String[] args) {
        User_OLD alice = new User_OLD("Alice");
        User_OLD bob = new User_OLD("Bob");
        User_OLD charlie = new User_OLD("Charlie");
        User_OLD dave = new User_OLD("Dave");

        alice.sendMessages("Hello Bob!", bob);
        bob.sendMessages("Hi Alice!", alice);
        charlie.sendMessages("Hey Dave!", dave);
        dave.sendMessages("Hello Charlie!", charlie);
        alice.sendMessages("How are you Charlie?", charlie);
        charlie.sendMessages("I'm good, thanks Alice!", alice);
        bob.sendMessages("Charlie, how's it going?", charlie);
    }
}
