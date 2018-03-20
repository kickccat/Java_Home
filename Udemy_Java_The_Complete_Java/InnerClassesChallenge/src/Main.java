import model.Album;
import model.Song;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep purple");
        album.addSong("some", 4.3);
        album.addSong("two", 2.1);
        album.addSong("three", 3.5);

        albums.add(album);

        album = new Album("lalala", "red black");
        album.addSong("four", 6.3);
        album.addSong("five", 2.9);
        album.addSong("six", 3.1);

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("two", playlist);
        albums.get(0).addToPlaylist("some", playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(3, playlist);

        printMenu();
        play(playlist);
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> songListIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No song in playlist");
            return;
        } else {
            System.out.println("Now playing " + songListIterator.next().toString());
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");;
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        forward = true;
                    }
                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing " + songListIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (songListIterator.hasPrevious()) {
                            songListIterator.previous();
                        }
                        forward = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing " + songListIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Now replaying " + songListIterator.previous()
                                    .toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (songListIterator.hasNext()) {
                            System.out.println("Now replaying " + songListIterator.next().toString
                                    ());
                            forward = true;
                        } else {
                            System.out.println("We are reaching the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        songListIterator.remove();
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing " + songListIterator.next());
                        } else if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing " + songListIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> songIterator = playlist.iterator();
        System.out.println("=============================");
        while (songIterator.hasNext()) {
            System.out.println(songIterator.next());
        }
        System.out.println("=============================");
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit\n" +
                            "1 - to play next song\n" +
                            "2 - to play previous song\n" +
                            "3 - to replay the current song\n" +
                            "4 - list songs in the playlist\n" +
                            "5 - print available actions\n" +
                            "6 - delete current song from playlist");
    }


}
