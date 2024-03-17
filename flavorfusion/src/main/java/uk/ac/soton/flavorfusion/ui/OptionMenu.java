package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;

public class OptionMenu extends JFrame {

    public OptionMenu() {
        // Set the title of the window
        setTitle("FlavorFusion Options");

        // Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout
        setLayout(new BorderLayout());

        // Create an instance of the BackgroundPanel with the path to your background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("/images/Background 2.PNG");
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel); 


        // Add UI components
        initComponents();

        // Set the size of the window
        setSize(1000, 700);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }


    private void initComponents() {
        // Create a panel with FlowLayout for centering the title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create the title label and add it to the panel
        JLabel titleLabel = new JLabel("FlavorFusion Options");
        titlePanel.add(titleLabel);

        // Add the title panel to the NORTH region of the JFrame
        add(titlePanel, BorderLayout.NORTH);

        // Create a panel for the left half of the window
        JPanel leftPanel = new JPanel();
        // Set the background color (optional)
        leftPanel.setBackground(Color.WHITE);
        // Add the left panel to the WEST (left) region of the JFrame
        add(leftPanel, BorderLayout.EAST);

        // Create a panel for the right half of the window
        JPanel rightPanel = new JPanel();
        // Set the layout for the right panel (optional)
        rightPanel.setLayout(new GridLayout(2, 2, 0, 80)); // 3 rows, 1 column, gap of 10 pixels between components
        // Add some space around the components in the right panel (optional)
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 500, 10, 50));
        // Add the right panel to the CENTER region of the JFrame
        add(rightPanel, BorderLayout.CENTER);

        // Create the "Weather" button
        JButton weatherButton = new JButton("Weather");
        // Add the "Weather" button to the right panel
        rightPanel.add(weatherButton);

        // Create the "DIY" button
        JButton diyButton = new JButton("DIY");
        // Add the "DIY" button to the right panel
        rightPanel.add(diyButton);

        // Create a panel for the back button
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Add the back button to the EAST (right) side of the buttonPanel
        JButton backButton = new JButton("Back");
        backButtonPanel.add(backButton);
        // Add the button panel to the SOUTH region of the JFrame
        add(backButtonPanel, BorderLayout.SOUTH);

        titlePanel.setOpaque(false);
        rightPanel.setOpaque(false);
        backButtonPanel.setOpaque(false);
    }

    public static void main(String[] args){
        new OptionMenu();
    }
}
