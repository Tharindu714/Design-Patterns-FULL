package com.tharindu.oodp1.Command;

// 1. Command interface
interface Command {
    void execute();
}

// 2. Receivers
class Superman {
    public void flyToCity() {
        System.out.println("[Superman] Flying at hypersonic speed to Metropolis!");
    }
    public void rescueCivilians() {
        System.out.println("[Superman] Rescuing civilians from collapsing buildings!");
    }
}

class Batman {
    public void deployBatarang() {
        System.out.println("[Batman] Launching Batarang to disable the drone swarm!");
    }
}

class Flash {
    public void speedRescue() {
        System.out.println("[Flash] Speed-blur rescuing victims in seconds!");
    }
}

// 3. Concrete Commands
class FlyCommand implements Command {
    private final Superman hero;
    public FlyCommand(Superman hero) {
        this.hero = hero;
    }
    @Override
    public void execute() {
        hero.flyToCity();
        hero.rescueCivilians();
    }
}

class BatarangCommand implements Command {
    private final Batman hero;
    public BatarangCommand(Batman hero) {
        this.hero = hero;
    }
    @Override
    public void execute() {
        hero.deployBatarang();
    }
}

class SpeedRescueCommand implements Command {
    private final Flash hero;
    public SpeedRescueCommand(Flash hero) {
        this.hero = hero;
    }
    @Override
    public void execute() {
        hero.speedRescue();
    }
}

// 4. Invoker
class ControlPanel {
    private Command slot;  // one-button panel for simplicity

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        if (slot != null) {
            System.out.println("\n[ControlPanel] Activating command...");
            slot.execute();
        } else {
            System.out.println("[ControlPanel] No command assigned!");
        }
    }
}

// 5. Client / Demo
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Receivers
        Superman superman = new Superman();
        Batman batman     = new Batman();
        Flash flash       = new Flash();

        // Concrete Commands
        Command flyCmd       = new FlyCommand(superman);
        Command batarangCmd  = new BatarangCommand(batman);
        Command speedRescue  = new SpeedRescueCommand(flash);

        // Invoker
        ControlPanel panel = new ControlPanel();

        System.out.println("=== Crisis: \uD83D\uDEF8 Alien Drone Attack ===");
        panel.setCommand(flyCmd);
        panel.pressButton();

        System.out.println("\n=== Crisis: \uD83E\uDD21 Joker’s Drone Swarm ===");
        panel.setCommand(batarangCmd);
        panel.pressButton();

        System.out.println("\n=== Crisis: \uD83D\uDE87 Collapsed Subway Tunnel ===");
        panel.setCommand(speedRescue);
        panel.pressButton();
    }
}