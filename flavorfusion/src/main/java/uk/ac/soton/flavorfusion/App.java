package uk.ac.soton.flavorfusion;

import uk.ac.soton.flavorfusion.ui.MainMenu;

import javax.swing.*;
import java.util.Objects;

public class App {
    public static void main(String[] args) {
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
            frame.setIconImage(icon.getImage());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
