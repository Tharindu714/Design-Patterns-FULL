package com.tharindu.oodp1.Factory;

public class MyLegalFactory {

    // 1. Target interface
    interface Gun {
        void fire();
    }

    // 2. Concrete implementations
    static class Pistol implements Gun {
        @Override
        public void fire() {
            System.out.println("\uD83D\uDC80\uD83D\uDD2B");
        }
    }

    static class Rifle implements Gun {
        @Override
        public void fire() {
            System.out.println("▄︻デ╦═一━");
        }
    }

    static class Shotgun implements Gun {
        @Override
        public void fire() {
            System.out.println("⌐╦╦═─");
        }
    }

    static class AK47 implements Gun {
        @Override
        public void fire() {
            System.out.println("▄︻╦芫≡══--");
        }
    }

    static class SniperRifle implements Gun {
        @Override
        public void fire() {
            System.out.println("︻╦̵̵̿╤━─");
        }
    }

    // 3. Factory
    static class GunFactory {
        public Gun makeGun(String variety) {
            switch (variety) {
                case "Pistol":
                    return new Pistol();
                case "Rifle":
                    return new Rifle();
                case "Shotgun":
                    return new Shotgun();
                case "AK47":
                    return new AK47();
                case "SniperRifle":
                    return new SniperRifle();
                default:
                    throw new IllegalArgumentException("Unknown gun type: " + variety);
            }
        }
    }

    // 4. Entry point
    public static void main(String[] args) {
        GunFactory factory = new GunFactory();

        System.out.println("=== Weapon Test Firing ===");

        System.out.println("\n1️⃣ Firing Pistol:");
        factory.makeGun("Pistol").fire();

        System.out.println("\n2️⃣ Firing Rifle:");
        factory.makeGun("Rifle").fire();

        System.out.println("\n3️⃣ Firing Shotgun:");
        factory.makeGun("Shotgun").fire();

        System.out.println("\n4️⃣ Firing AK47:");
        factory.makeGun("AK47").fire();

        System.out.println("\n5️⃣ Firing Sniper Rifle:");
        factory.makeGun("SniperRifle").fire();

        System.out.println("\n=== All weapons fired! ===");
    }
}

