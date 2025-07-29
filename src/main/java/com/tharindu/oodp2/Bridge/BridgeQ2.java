package com.tharindu.oodp2.Bridge;

// The Implementor
interface Channel {
    void send(String message);
}

// Concrete Implementors
class Email implements Channel {
    @Override
    public void send(String message) {
        System.out.println("📧 [Email] " + message);
    }
}

class SMS implements Channel {
    @Override
    public void send(String message) {
        System.out.println("📱 [SMS] " + message);
    }
}

class PushNotification implements Channel {
    @Override
    public void send(String message) {
        System.out.println("📲 [Push] " + message);
    }
}

// The Abstraction
abstract class Notification {
    protected Channel channel;

    public Notification(Channel channel) {
        this.channel = channel;
    }

    // refined by sub‑classes
    public abstract void notify(String message);
}

// Refined Abstractions
class AlertNotification extends Notification {
    public AlertNotification(Channel channel) {
        super(channel);
    }

    @Override
    public void notify(String message) {
        channel.send("🔔 [Alert] " + message);
    }
}

class ReminderNotification extends Notification {
    public ReminderNotification(Channel channel) {
        super(channel);
    }

    @Override
    public void notify(String message) {
        channel.send("⏰ [Reminder] " + message);
    }
}

class PromotionNotification extends Notification {
    public PromotionNotification(Channel channel) {
        super(channel);
    }

    @Override
    public void notify(String message) {
        channel.send("🎉 [Promotion] " + message);
    }
}

// Client code
public class BridgeQ2 {
    public static void main(String[] args) {
        Notification alertByEmail     = new AlertNotification(new Email());
        Notification reminderBySMS    = new ReminderNotification(new SMS());
        Notification promoByPush      = new PromotionNotification(new PushNotification());

        alertByEmail.notify("Server CPU usage is over 90%!");
        reminderBySMS.notify("Your appointment is tomorrow at 10 AM.");
        promoByPush.notify("Flash sale: 50% OFF all tea products!");
    }
}

//Output:
////📧 [Email] 🔔 [Alert] Server CPU usage is over 90%!
////📱 [SMS] ⏰ [Reminder] Your appointment is tomorrow at 10 AM.
////📲 [Push] 🎉 [Promotion] Flash sale: 50% OFF all tea products!