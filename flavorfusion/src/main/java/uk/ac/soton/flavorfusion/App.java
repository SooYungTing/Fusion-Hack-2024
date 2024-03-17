package uk.ac.soton.flavorfusion;

import uk.ac.soton.flavorfusion.ui.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class App {
    public static void main(String[] args) {
        Thread musicThread = new Thread(new MP3Player("src/main/resources/music/Maryse Letarte - Ô Traîneau Dans Le Cie.mp3"));
        musicThread.start();
        // Ensure the GUI is created on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create MainMenu and set it visible
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);

                // Set custom icon for the main frame
                setIconImage(mainMenu);
            }
        });
    }

    /*public static void setIconImage(JFrame frame) {
        // Set custom icon for the frame
        try {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(App.class.getResource("/images/icon.PNG")));
            frame.setIconImage(icon.getImage());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }*/
    public static void setIconImage(JFrame frame) {
        // Set custom icon for the frame
        try {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(App.class.getResource("/images/icon.PNG")));
            Image image = icon.getImage();

            // Check if the OS is macOS
            if (System.getProperty("os.name").startsWith("Mac")) {
                // Java 9 and later approach using Taskbar
                if (java.awt.Taskbar.isTaskbarSupported()) {
                    java.awt.Taskbar.getTaskbar().setIconImage(image);
                }
                // For older versions of Java, you might need to use reflection for com.apple.eawt.Application
                // to set the dock icon, but this is generally not needed for modern Java versions.
            } else {
                // For other operating systems, set the JFrame icon
                frame.setIconImage(image);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
