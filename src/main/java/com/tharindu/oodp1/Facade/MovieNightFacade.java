package com.tharindu.oodp1.Facade;

class TV {
    void on() {
        System.out.println("TV turned on");
    }

    void setInput() {
        System.out.println("TV input set to " + "HDMI");
    }
}

class DVDPlayer {
    void on() {
        System.out.println("DVD Player on");
    }

    void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class SoundSystem {
    void on() {
        System.out.println("Sound system on");
    }

    void setVolume() {
        System.out.println("Volume set to " + 100);
    }
}

class Lights {
    void dim() {
        System.out.println("Lights dimmed");
    }
}

// FACADE
class HomeTheaterFacade {
    private final TV tv;
    private final DVDPlayer dvd;
    private final SoundSystem sound;
    private final Lights lights;

    public HomeTheaterFacade(TV tv, DVDPlayer dvd, SoundSystem sound, Lights lights) {
        this.tv = tv;
        this.dvd = dvd;
        this.sound = sound;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("\nGet ready to watch a movie...");
        lights.dim();
        tv.on();
        tv.setInput();
        sound.on();
        sound.setVolume();
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting down the theater...");
        // you could add more shutdown logic here
    }
}

public class MovieNightFacade {
    public static void main(String[] args) {
        TV tv = new TV();
        DVDPlayer dvd = new DVDPlayer();
        SoundSystem sound = new SoundSystem();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, dvd, sound, lights);

        homeTheater.watchMovie("Avengers: Endgame");
        homeTheater.endMovie();
    }
}

