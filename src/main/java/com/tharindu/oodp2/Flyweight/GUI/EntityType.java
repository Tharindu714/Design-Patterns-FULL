package com.tharindu.oodp2.Flyweight.GUI;

import javax.swing.*;
import java.awt.*;

// ----- Flyweight: EntityType -----
public class EntityType {
    private final String emoji;

    public EntityType(String name, String emoji) {
        this.emoji = emoji;
        System.out.println("[Flyweight Created] " + name + " " + emoji);
    }

    /**
     * Build a JLabel at (x,y) to render the emoji in full color
     */
    JLabel createLabel(int x, int y) {
        JLabel icon = new JLabel(emoji);
        icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        Dimension size = icon.getPreferredSize();
        icon.setSize(size);
        icon.setLocation(x, y);
        return icon;
    }
}
