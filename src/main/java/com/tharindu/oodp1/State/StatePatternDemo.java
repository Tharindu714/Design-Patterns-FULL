package com.tharindu.oodp1.State;

// 1. State interface
interface State {
    void handleInput(Guard guard, String input);
    void update(Guard guard);
}

// 2. Concrete States
class PatrolState implements State {
    @Override
    public void handleInput(Guard guard, String input) {
        if ("seeEnemy".equals(input)) {
            System.out.println("[PatrolState] Intruder spotted! Switching to ALERT state.");
            guard.setState(new AlertState());
        }
    }
    @Override
    public void update(Guard guard) {
        System.out.println("[PatrolState] Guard is patrolling the area.");
    }
}

class AlertState implements State {
    @Override
    public void handleInput(Guard guard, String input) {
        if ("enemyInRange".equals(input)) {
            System.out.println("[AlertState] Target in range! Switching to ATTACK state.");
            guard.setState(new AttackState());
        } else if ("loseEnemy".equals(input)) {
            System.out.println("[AlertState] Lost sight of intruder. Returning to PATROL state.");
            guard.setState(new PatrolState());
        }
    }
    @Override
    public void update(Guard guard) {
        System.out.println("[AlertState] Guard is taking cover and surveying the area.");
    }
}

class AttackState implements State {
    @Override
    public void handleInput(Guard guard, String input) {
        if ("loseEnemy".equals(input)) {
            System.out.println("[AttackState] Target escaped! Switching to PATROL state.");
            guard.setState(new PatrolState());
        }
    }
    @Override
    public void update(Guard guard) {
        System.out.println("[AttackState] Guard is engaging the enemy aggressively.");
    }
}

// 3. Context
class Guard {
    private State currentState;

    public Guard() {
        this.currentState = new PatrolState();  // default
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void handleInput(String input) {
        currentState.handleInput(this, input);
    }

    public void update() {
        currentState.update(this);
    }
}

// 4. Demo
public class StatePatternDemo {
    public static void main(String[] args) {
        Guard sentinel = new Guard();

        // 1. Patrol
        sentinel.update();

        // 2. Spotted an enemy
        sentinel.handleInput("seeEnemy");
        sentinel.update();

        // 3. Enemy in range
        sentinel.handleInput("enemyInRange");
        sentinel.update();

        // 4. The Enemy escaped
        sentinel.handleInput("loseEnemy");
        sentinel.update();
    }
}