package com.tharindu.oodp1.Observer;

import java.util.*;

// 1. Observer interface
interface Observer {
    void update(String clue);
}

// 2. Subject interface
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// 3. ConcreteSubject
class CrimeScene implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String latestClue;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(latestClue);
        }
    }

    // Investigator drops a new clue
    public void addClue(String clue) {
        System.out.println("\n[CrimeScene] New clue discovered: \"" + clue + "\"");
        this.latestClue = clue;
        notifyObservers();
    }
}

// 4. ConcreteObservers
class ForensicAnalyst implements Observer {
    @Override
    public void update(String clue) {
        System.out.println("🧪 ForensicAnalyst: Dusting the keys for prints on clue → " + clue);
    }
}

class PsychicMedium implements Observer {
    @Override
    public void update(String clue) {
        System.out.println("🔮 PsychicMedium: I hear whispers chanting '" + clue + "'!");
    }
}

class TechGeek implements Observer {
    @Override
    public void update(String clue) {
        System.out.println("💻 TechGeek: Arduino logged keystroke sequence: [" + clue + "]");
    }
}

// 5. Client
public class ObserverDemo {
    public static void main(String[] args) {
        CrimeScene scene = new CrimeScene();

        // specialists subscribe to the scene
        scene.addObserver(new ForensicAnalyst());
        scene.addObserver(new PsychicMedium());
        scene.addObserver(new TechGeek());

        // ghost types a series of clues
        scene.addClue("MURDER AT MIDNIGHT");
        scene.addClue("LOOK UNDER THE FLOORBOARD");
        scene.addClue("THE BUTLER DID IT");
    }
}