package com.tharindu.oodp1.Proxy;

interface Database {
    void insert();
    void update();
    void delete();
    void select(String query);
}

class RealDatabase implements Database {
    @Override
    public void insert() {
        System.out.println("[RealDatabase] Inserting data into the database.");
    }

    @Override
    public void update() {
        System.out.println("[RealDatabase] Updating data in the database.");
    }

    @Override
    public void delete() {
        System.out.println("[RealDatabase] Deleting data from the database.");
    }

    @Override
    public void select(String query) {
        System.out.println("[RealDatabase] Selecting data with query: " + query);
    }
}

class ProxyDatabase implements Database {
    private final RealDatabase realDatabase;
    private final String username;
    private final String password;

    public ProxyDatabase(String username, String password) {
        this.username = username;
        this.password = password;
        this.realDatabase = new RealDatabase();
    }

    @Override
    public void insert() {
        if (authenticate()) {
            System.out.println("[ProxyDatabase] Authenticated. Delegating insert().");
            realDatabase.insert();
        }
    }

    @Override
    public void update() {
        if (authenticate()) {
            System.out.println("[ProxyDatabase] Authenticated. Delegating update().");
            realDatabase.update();
        }
    }

    @Override
    public void delete() {
        if (authenticate()) {
            System.out.println("[ProxyDatabase] Authenticated. Delegating delete().");
            realDatabase.delete();
        }
    }

    @Override
    public void select(String query) {
        if (authenticate()) {
            System.out.println("[ProxyDatabase] Authenticated. Delegating select().");
            realDatabase.select(query);
        }
    }

    private boolean authenticate() {
        if ("Tharindu".equals(username) && "deltaCodex8754".equals(password)) {
            return true;
        } else {
            System.out.println("[ProxyDatabase] Authentication failed. Access denied.");
            return false;
        }
    }
}

public class MainProxy {
    public static void main(String[] args) {
        System.out.println("=== Attempt with valid credentials ===");
        ProxyDatabase proxy1 = new ProxyDatabase("Tharindu", "deltaCodex8754");
        proxy1.insert();
        proxy1.update();
        proxy1.delete();
        proxy1.select("SELECT * FROM users");

        System.out.println("\n=== Attempt with invalid credentials ===");
        ProxyDatabase proxy2 = new ProxyDatabase("Alice", "wrongPass");
        proxy2.insert();
        proxy2.update();
        proxy2.delete();
        proxy2.select("SELECT * FROM products");
    }
}