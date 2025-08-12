package com.tharindu.oodp2.Visitor;

import java.util.ArrayList;
import java.util.List;

//Visitor Interface
interface ClientVisitor {
    void visit(IndividualClient_new individualClient);

    void visit(BusinessClient_new businessClient);
}

//Element Interface
interface ClientElement {
    void accept(ClientVisitor visitor);
}

//Concrete Element for Individual Client
class ReportGenerateVisitor implements ClientVisitor {
    @Override
    public void visit(IndividualClient_new individualClient) {
        System.out.println("Generating report for individual client: " + individualClient.getName() + ", Age: " + individualClient.getAge());
    }

    @Override
    public void visit(BusinessClient_new businessClient) {
        System.out.println("Generating report for business client: " + businessClient.getName() + ", Revenue: $" + businessClient.getRevenue() + ", Employees: " + businessClient.getEmployees());
    }
}

class PremiumCalculatorVisitor implements ClientVisitor {

    @Override
    public void visit(IndividualClient_new individualClient) {
        double premium; // Base premium
        if (individualClient.getAge() < 30) {
            premium = 1000; // Base premium for young individuals
        } else if (individualClient.getAge() < 60) {
            premium = 1500; // Base premium for middle-aged individuals
        } else {
            premium = 2000; // Base premium for seniors
        }
        System.out.println("Calculating premium for individual client: " + individualClient.getName() + ", Age: " + individualClient.getAge() + ", Premium: $" + premium);
    }

    @Override
    public void visit(BusinessClient_new businessClient) {
        double premium = businessClient.getRevenue() * 0.1 + businessClient.getEmployees() * 50; // Base premium based on revenue and number of employees
        System.out.println("Calculating premium for business client: " + businessClient.getName() + ", Revenue: $" + businessClient.getRevenue() + ", Employees: " + businessClient.getEmployees() + ", Premium: $" + premium);
    }
}

//Concrete Elements
class BusinessClient_new implements ClientElement {
    private final String name;
    private final double revenue;
    private final int employees;

    public BusinessClient_new(String name, double revenue, int employees) {
        this.name = name;
        this.revenue = revenue;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getEmployees() {
        return employees;
    }

    @Override
    public void accept(ClientVisitor visitor) {
        visitor.visit(this);

    }
}

class IndividualClient_new implements ClientElement {
    private final String name;
    private final int age;

    public IndividualClient_new(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void accept(ClientVisitor visitor) {
        visitor.visit(this);
    }
}

public class Visitor_Pattern {
    public static void main(String[] args) {
        List<ClientElement> clients = new ArrayList<>();
        clients.add(new BusinessClient_new("TechCrop", 5000, 10));
        clients.add(new IndividualClient_new("John Doe", 25));

        ClientVisitor premiumCalculator = new PremiumCalculatorVisitor();
        ClientVisitor reportGenerator = new ReportGenerateVisitor();

        for (ClientElement client : clients) {
            client.accept(premiumCalculator);
            client.accept(reportGenerator);
        }
    }
}
