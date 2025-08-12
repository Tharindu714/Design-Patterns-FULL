package com.tharindu.oodp2.Visitor;

abstract class Client {
    String name;

    public Client(String name) {
        this.name = name;
    }

    abstract void calculatePremium();

    abstract void generateReport();
}

class IndividualClient extends Client {
    int age;

    public IndividualClient(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    void calculatePremium() {
        double premium; // Base premium
        if (age < 30) {
            premium = 1000; // Base premium for young individuals
        } else if (age < 60) {
            premium = 1500; // Base premium for middle-aged individuals
        } else {
            premium = 2000; // Base premium for seniors
        }
        System.out.println("Calculating premium for individual client: " + name + ", Age: " + age + ", Premium: $" + premium);
    }

    @Override
    void generateReport() {
        System.out.println("Generating report for individual client: " + name + ", Age: " + age);
    }
}

class BusinessClient extends Client {
    double revenue;
    int employees;

    public BusinessClient(String name, double revenue, int employees) {
        super(name);
        this.revenue = revenue;
        this.employees = employees;
    }

    @Override
    void calculatePremium() {
        double premium = revenue * 00.1 + employees * 50; // Base premium based on revenue and number of employees
        System.out.println("Calculating premium for business client: " + name + ", Revenue: $" + revenue + ", Employees: " + employees + ", Premium: $" + premium);
    }

    @Override
    void generateReport() {
        System.out.println("Generating report for business client: " + name + ", Revenue: $" + revenue + ", Employees: " + employees);
    }
}

public class Without_Visitor_Pattern {
    public static void main(String[] args) {
        Client[] clients = {
                new IndividualClient("Alice", 25),
                new IndividualClient("Bob", 45),
                new BusinessClient("TechCorp", 500000, 50),
                new BusinessClient("BizSolutions", 1000000, 200)
        };
        for (Client client : clients) {
            client.calculatePremium();
            client.generateReport();
        }
    }
}
