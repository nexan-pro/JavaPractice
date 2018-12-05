package Collections.HashTable;

import java.util.Hashtable;

class Catalog {
  Hashtable<String, String> songs = new Hashtable<>();
  Hashtable<String, Hashtable<String, String>> disks = new Hashtable<>();

  void addDisk(String title, Hashtable<String, String> songs) {
    disks.put(title, songs);
  }

  void removeDisk(String title) {
    disks.remove(title);
  }

  void addSong(String title, String author) {
    songs.put(title, author);
  }

  void removeSong(String title) {
    songs.remove(title);
  }

  void show() {
    System.out.print(disks);
  }

  void showDisk(String title) {
    System.out.println(disks.get(title).keySet() + " " + disks.get(title).values());
  }

  void showSongs(String author) {
    System.out.println(songs.get(author));
  }
}

public class HashTableTask {
  public static void main(String[] args) {
    Catalog obj = new Catalog();
    Catalog obj1 = new Catalog();
    obj1.addSong("qwer", "df");
    obj.addSong("song_title", "song_author");
    obj.addSong("song_title1", "song_author1");
    obj.addDisk("disk1_title", obj.songs);
    obj.addDisk("disk2_title", obj1.songs);
    obj.showDisk("disk1_title");
    obj.showSongs("song_title1");
    obj.show();
  }
}
