package encapsulation.assigment_problems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public boolean addSong(String title) {
        if (count >= songs.length) {
            return false;
        }
        songs[count++] = title;
        return true;
    }

    // Returns a copy, so changing it can never affect the playlist's real contents.
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Modified copy:       " + Arrays.toString(copy));
        System.out.println("Playlist still has:  " + Arrays.toString(p.getSongs()));
        System.out.println("Song count = " + p.getSongCount());
    }
}
