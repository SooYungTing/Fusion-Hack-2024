package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;

public class RecipeMenu extends JFrame {

    public RecipeMenu() {
        // Set the title of the window
        setTitle("Recipe Menu");

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
        JLabel titleLabel = new JLabel("Recipe Menu");
        titlePanel.add(titleLabel);

        // Add the title panel to the NORTH region of the JFrame
        add(titlePanel, BorderLayout.NORTH);

        // Create a panel for the left half of the window
        JPanel leftPanel = new JPanel();
        // Set the background color (optional)
        leftPanel.setBackground(Color.WHITE);
        // Add the left panel to the WEST (left) region of the JFrame
        add(leftPanel, BorderLayout.WEST);

        // Create a panel for the right half of the window
        JPanel rightPanel = new JPanel();
        // Set the layout for the right panel (optional)
        rightPanel.setLayout(new GridLayout(2, 1)); // 2 rows, 1 column
        // Add some space around the components in the right panel (optional)
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Add the right panel to the CENTER region of the JFrame
        add(rightPanel, BorderLayout.CENTER);

        // Create an image panel
        JPanel imagePanel = new JPanel();
        // Load and display an image (optional)
        ImageIcon imageIcon = new ImageIcon("your_image_path.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
        // Add the image panel to the right panel
        rightPanel.add(imagePanel);

        // Create a text panel
        JPanel textPanel = new JPanel();
        // Set the layout for the text panel (optional)
        textPanel.setLayout(new BorderLayout());
        // Add some space around the text (optional)
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Create a text area with scrollbars
        JTextArea textArea = new JTextArea("Recipe Description");
        // Set the font size
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        // Set the text area to be non-editable (optional)
        textArea.setEditable(false);
        // Add the text area to a scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        // Add the scroll pane to the text panel
        textPanel.add(scrollPane, BorderLayout.CENTER);
        // Add the text panel to the right panel
        rightPanel.add(textPanel);
    }

    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RecipeMenu().setVisible(true);
            }
        });
    }
}