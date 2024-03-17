package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionMenu extends JFrame{

    private final JFrame previousWindow;

    public InstructionMenu(JFrame previousWindow) {
        // Set the title of the window
        setTitle("FlavorFusion Instructions");

        this.previousWindow = previousWindow;


        // Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout
        setLayout(new BorderLayout());

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
        JLabel titleLabel = new JLabel("FlavorFusion Instructions");
        titlePanel.add(titleLabel);

        // Add the title panel to the NORTH region of the JFrame
        add(titlePanel, BorderLayout.NORTH);

        // Create the instructional text area
        JTextArea instructionsText = new JTextArea(10, 40);
        instructionsText.setText("Welcome to FlavorFusion!\n\n" +
                "Here's how to get started:\n" +
                "1. Choose your base flavor.\n" +
                "2. Select additional ingredients.\n" +
                "3. Mix them up!\n" +
                "4. Enjoy your personalized flavor creation.");
        instructionsText.setEditable(false);
        add(instructionsText, BorderLayout.CENTER);

        // Create a back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the OptionMenu
                setVisible(false); // 修改了这里，隐藏了当前的 OptionMenu 窗口

                // Show the previous window (MainMenu)
                if (previousWindow != null) {
                    previousWindow.setVisible(true); // 修改了这里，显示之前的 MainMenu 窗口
                }
            }
        });

        // Create a panel for the back button with BorderLayout
        JPanel buttonPanel = new JPanel(new BorderLayout());
        // Add the back button to the EAST (right) side of the buttonPanel
        buttonPanel.add(backButton, BorderLayout.EAST);

        // Add some space on the right for better visual appearance
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        // Add the button panel to the SOUTH region of the JFrame
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
