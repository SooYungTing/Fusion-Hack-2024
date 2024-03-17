package uk.ac.soton.flavorfusion;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MP3Player implements Runnable{
  private String filePath;

  public MP3Player(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public void run() {
    try {
      FileInputStream fileInputStream = new FileInputStream(filePath);
      BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
      Player player = new Player(bufferedInputStream);
      player.play();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("MP3 file not found: " + filePath);
    } catch (JavaLayerException e) {
      e.printStackTrace();
      System.out.println("Error playing the MP3 file.");
    }
  }

  public static void main(String[] args) {
    //Thread musicThread = new Thread(new MP3Player("src/main/resources/music/Daft Punk - Random Access Memories (Vanderway Edit).mp3"));
    Thread musicThread = new Thread(new MP3Player("src/main/resources/music/Maryse Letarte - Ô Traîneau Dans Le Cie.mp3"));
    musicThread.start();
  }
}
