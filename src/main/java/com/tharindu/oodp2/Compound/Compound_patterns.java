package com.tharindu.oodp2.Compound;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

//Model - Observer Pattern
class StudentModel {
    private String name;
    private int age;
    private final List<Observer> observers = new ArrayList<>();

    public void setStudentData(String name, int age) {
        this.name = name;
        this.age = age;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

//View - 
class StudentView implements Observer {
    private final StudentModel model;

    public StudentView(StudentModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void displayStudent() {
        System.out.println("=== Student Details ===");
        System.out.println("Student Name: " + model.getName());
        System.out.println("Student Age: " + model.getAge());
        System.out.println("========================");
    }

    @Override
    public void update() {
        displayStudent();
    }
}

//Controller - Strategy Pattern
interface ActionStrategy {
    void execute(StudentModel studentModel, String name, int age);
}

class AddStudentAction implements ActionStrategy {
    @Override
    public void execute(StudentModel studentModel, String name, int age) {
        System.out.println("[Controller] Adding Student...");
        studentModel.setStudentData(name, age);
    }
}

class UpdateStudentAction implements ActionStrategy {
    @Override
    public void execute(StudentModel studentModel, String name, int age) {
        System.out.println("[Controller] Updating Student...");
        studentModel.setStudentData(name, age);
    }
}

//Controller - uses Strategy Pattern to handle actions
class StudentController {
    private final StudentModel model;
    private ActionStrategy actionStrategy;

    public StudentController(StudentModel model, ActionStrategy actionStrategy) {
        this.model = model;
        this.actionStrategy = actionStrategy;
    }

    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    public void handleRequest(String name, int age) {
        actionStrategy.execute(model, name, age);
    }
}

public class Compound_patterns {
    public static void main(String[] args) {
        StudentModel model = new StudentModel(); //create model
        StudentView view = new StudentView(model); //attach view to model
        StudentController controller = new StudentController(model, new AddStudentAction()); // create controller with initial action
        controller.handleRequest("John", 30); //add student
        controller.setActionStrategy(new UpdateStudentAction()); // change action strategy
    }
}
