package uk.ac.soton.flavorfusion;

import java.net.URI;
import java.net.URL;
import uk.ac.soton.flavorfusion.ui.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;
import java.util.Objects;

public class App {
    public static void main(String[] args) {
        /*URL urlString = App.class.getResource("/music/track1.mp3");
        System.out.println(urlString);
        Thread musicThread = new Thread(new MP3Player(urlString.getPath()));
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
    }*/
        try {
            URL url = App.class.getResource("/music/track1.mp3");
            if (url != null) {
                // Convert URL to URI to properly escape characters
                URI uri = url.toURI();
                // Convert URI to path, handling special characters and file system differences
                String path = Paths.get(uri).toString();
                System.out.println(path);
                Thread musicThread = new Thread(new MP3Player(path));
                musicThread.start();
            } else {
                System.out.println("Resource not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
