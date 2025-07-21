package com.tharindu.oodp1.Template;

// 1. Abstract Template
abstract class Hero {
    // Template method — defines skeleton of the ritual
    public final void battleRitual() {
        prepare();
        engage();
        defend();
        celebrate();
    }

    protected abstract void prepare();

    protected abstract void engage();

    protected abstract void defend();

    // optional hook
    protected void celebrate() { /* default: no celebration */ }
}

// 2. Concrete Heroes
class Warrior extends Hero {
    @Override
    protected void prepare() {
        System.out.println("[Warrior] Donning heavy armor and readying sword.");
    }

    @Override
    protected void engage() {
        System.out.println("[Warrior] Charges forward with a battle cry!");
    }

    @Override
    protected void defend() {
        System.out.println("[Warrior] Raises shield to block incoming blows.");
    }

    @Override
    protected void celebrate() {
        System.out.println("[Warrior] Roars victoriously and pounds chest.");
    }
}

class Mage extends Hero {
    @Override
    protected void prepare() {
        System.out.println("[Mage] Chanting incantations and gathering mana.");
    }

    @Override
    protected void engage() {
        System.out.println("[Mage] Hurls a blazing fireball at the enemy!");
    }

    @Override
    protected void defend() {
        System.out.println("[Mage] Conjures a shimmering magical barrier.");
    }

    // uses default celebrate()
}

class Archer extends Hero {
    @Override
    protected void prepare() {
        System.out.println("[Archer] Docking arrow and adjusting quiver.");
    }

    @Override
    protected void engage() {
        System.out.println("[Archer] Fires a volley of arrows with deadly precision.");
    }

    @Override
    protected void defend() {
        System.out.println("[Archer] Dodges and keeps distance from foes.");
    }

    @Override
    protected void celebrate() {
        System.out.println("[Archer] Salutes enemy before vanishing into the trees.");
    }
}

// 3. Driver
public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== ⚔️\uD83C\uDFC7\uD83C\uDFFC Warrior’s Ritual ===");
        new Warrior().battleRitual();

        System.out.println("\n=== \uD83E\uDDD9\u200D♀️ Mage’s Ritual ===");
        new Mage().battleRitual();

        System.out.println("\n=== \uD83C\uDFF9 Archer’s Ritual ===");
        new Archer().battleRitual();
    }
}