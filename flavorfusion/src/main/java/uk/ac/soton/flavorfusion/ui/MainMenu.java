package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        // Set the title of the window
        setTitle("Flavour Fusion");

        // Setting the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout
        setLayout(new BorderLayout());

        // Here we set the BackgroundPanel as the content pane of the frame
        setContentPane(new BackgroundPanel("/images/Background 2.PNG")); // Replace with your actual image path


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
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/FlavourFusion Logo.png"));
        Image originalImage = originalIcon.getImage();
        // Resize the image (Change the width and height as needed)
        Image resizedImage = originalImage.getScaledInstance(800, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Create a label with the resized image
        JLabel imageLabel = new JLabel(resizedIcon);

        // Add the image label to the NORTH region of the JFrame
        add(imageLabel, BorderLayout.NORTH);

        // Create a panel for the right half of the window
        JPanel rightPanel = new JPanel();
        // Set the layout for the right panel (optional)
        rightPanel.setLayout(new GridLayout(3, 1, 0, 20)); // 3 rows, 1 column, gap of 10 pixels between components
        // Add some space around the components in the right panel (optional)
        rightPanel.setBorder(BorderFactory.createEmptyBorder(40, 200, 10, 200));
        rightPanel.setOpaque(false);

        // Add the right panel to the CENTER region of the JFrame
        add(rightPanel, BorderLayout.CENTER);

        // Create the "Start" button
        JButton startButton = new JButton("Start");
        makeButtonTransparent(startButton);
        addButtonHoverEffect(startButton, Color.GRAY, Color.BLACK);


        // Set the font for the "Start" button
        startButton.setFont(new Font("Arial", Font.BOLD, 24));

        // Add the "Start" button to the right panel
        rightPanel.add(startButton);

        // Create the "Instruction" button
        JButton instructionButton = new JButton("Instruction");
        makeButtonTransparent(instructionButton);
        addButtonHoverEffect(instructionButton, Color.GRAY, Color.BLACK);


        // Set the font for the "Instruction" button
        instructionButton.setFont(new Font("Arial", Font.BOLD, 24));
        // Add the "Instruction" button to the right panel
        rightPanel.add(instructionButton);

        // Create the "Exit" button
        JButton exitButton = new JButton("Exit");
        makeButtonTransparent(exitButton);
        addButtonHoverEffect(exitButton, Color.GRAY, Color.BLACK);


        // Set the font for the "Exit" button
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        // Add action listener to the "Exit" button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Terminate the program
            }
        });
        // Add the "Exit" button to the right panel
        rightPanel.add(exitButton);

    }

    /*private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false); // This will remove the focus border when clicked.
        button.setBorder(BorderFactory.createEmptyBorder()); // This will remove the border completely.
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setForeground(Color.BLACK); // Set this to the color you want for the text.
    }*/
    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false); // Remove the focus border when clicked.
        button.setBorder(BorderFactory.createEmptyBorder()); // Remove the border completely.
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setForeground(Color.BLACK); // Initial text color.
    }

    private void addButtonHoverEffect(JButton button, Color hoverColor, Color originalColor) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(originalColor);
            }
        });
    }


    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    // Constructor for the BackgroundPanel class
    public BackgroundPanel(String filePath) {
        try {
            backgroundImage = new ImageIcon(getClass().getResource(filePath)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

