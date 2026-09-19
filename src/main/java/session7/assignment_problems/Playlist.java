import java.util.Scanner;

public class Playlist {

    private final String[] songs;
    private int songCount;

    // Constructor
    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    // Add a song
    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    // Return a copy of the songs
    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    // Return number of songs
    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum playlist size: ");
        int maxSongs = sc.nextInt();
        sc.nextLine();

        Playlist playlist = new Playlist(maxSongs);

        System.out.print("Enter number of songs to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Do not accept more songs than the maximum size
        if (n > maxSongs) {
            System.out.println("Only " + maxSongs + " songs can be added.");
            n = maxSongs;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song " + (i + 1) + ": ");
            String song = sc.nextLine();

            playlist.addSong(song);
        }

        System.out.println("Song Count = " + playlist.getSongCount());

        String[] copy = playlist.getSongs();

        System.out.println("Songs in Playlist:");

        for (String song : copy) {
            System.out.println(song);
        }

        sc.close();
    }
}