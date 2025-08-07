package com.tharindu.oodp2.Mediator;

import java.util.ArrayList;
import java.util.List;

interface Mediator{
    void sendMessage(String message, User sender);
    void addUser(User user);
}


//concrete mediator
class ChatRoom implements Mediator{
    private final List<User> users=new ArrayList<>();

    @Override
    public void sendMessage(String message, User sender) {
        for (User user:users){
            if (user != sender){
                user.receive(message,sender.getName());
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

//colleague
class User{
    String name;
    Mediator mediator;

    public User(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void send(String message){
        mediator.sendMessage(message, this);
    }

    public void receive(String message,String senderName){
        System.out.println(senderName+" to "+name+" : "+message);
    }
}

public class ChatApp {
    public static void main(String[] args) {
        ChatRoom chatRoom=new ChatRoom();

        User Maxine=new User("Maxine", chatRoom);
        User Andrew=new User("Andrew", chatRoom);
        User Jacob=new User("Jacob", chatRoom);

        chatRoom.addUser(Maxine);
        chatRoom.addUser(Andrew);
        chatRoom.addUser(Jacob);

        Maxine.send("Hello");
        Andrew.send("Good morning");
        Jacob.send("Whats good you all!");
    }
}
