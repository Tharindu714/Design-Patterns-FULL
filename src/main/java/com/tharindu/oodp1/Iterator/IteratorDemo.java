package com.tharindu.oodp1.Iterator;

import java.util.ArrayList;
import java.util.List;

// 1. The Iterator interface
interface Iterator {
    boolean hasNext();

    Song next();
}

// 2. The Container interface
interface Container {
    Iterator getIterator();
}

// 3. A simple Song data class
class Song {
    private final String title;
    private final String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "\"" + getTitle() + "\" by " + getArtist();
    }
}

// 4. Concrete Container: a Playlist of songs
class SongCollection implements Container {
    private final List<Song> songs;

    public SongCollection() {
        songs = new ArrayList<>();
    }

    public void addSong(Song s) {
        songs.add(s);
    }

    @Override
    public Iterator getIterator() {
        return new SongIterator(songs);
    }
}

// 5. Concrete Iterator
class SongIterator implements Iterator {
    private final List<Song> songs;
    private int position = 0;

    public SongIterator(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public Song next() {
        return songs.get(position++);
    }
}

// 6. Client code
public class IteratorDemo {
    public static void main(String[] args) {
        SongCollection playlist = new SongCollection();
        playlist.addSong(new Song("Levels", "Avicii"));
        playlist.addSong(new Song("Strobe", "deadmau5"));
        playlist.addSong(new Song("One More Time", "Daft Punk"));

        System.out.println("=== DJ Playlist ===");
        Iterator it = playlist.getIterator();
        while (it.hasNext()) {
            Song s = it.next();
            System.out.println("Now playing: " + s);
        }
    }
}
