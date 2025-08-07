package com.tharindu.oodp2.Mediator;

interface ATCTower{
    void requestTakeoff(Plane airplane);
    void requestLanding(Plane airplane);
}

class Controller implements ATCTower{
    @Override
    public void requestTakeoff(Plane airplane) {
        airplane.notifyATC("Requesting to take off");
    }

    @Override
    public void requestLanding(Plane airplane) {
        airplane.notifyATC("Requesting to land");
    }
}

interface Plane{
    void takeOff();
    void landing();
    void notifyATC(String message);
}

class PrivateJet implements Plane{
    private final ATCTower mediator;

    public PrivateJet(ATCTower mediator) {
        this.mediator = mediator;
    }

    @Override
    public void takeOff() {
        mediator.requestTakeoff(this);
    }

    @Override
    public void landing() {
    mediator.requestLanding(this);
    }

    @Override
    public void notifyATC(String message) {
        System.out.println("Private Jet: " + message);
    }
}

public class AirportMediator {
    public static void main(String[] args) {
        ATCTower tower =new Controller();

        Plane plan1 = new PrivateJet(tower);
        Plane plan2 = new PrivateJet(tower);
        Plane plan3 = new PrivateJet(tower);

        plan1.landing();
        plan2.takeOff();
    }
}
