package uk.ac.soton.flavorfusion.ui;

import uk.ac.soton.flavorfusion.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class MainMenu extends JFrame {

    public MainMenu() {

        // Call setIconImage method
        App.setIconImage(this);

        // Set the title of the window
        setTitle("Flavour Fusion");

        // Setting the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout
        setLayout(new BorderLayout());

        // Here we set the BackgroundPanel as the content pane of the frame
        setContentPane(new BackgroundPanel("/images/Background 2.PNG"));


        // Add UI components
        initComponents();

        // Set the size of the window
        setSize(1000, 700);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);

        setupEscapeKey();

    }

    private void initComponents() {
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/FlavourFusion Logo.png")));
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
        // Set the layout for the right panel
        rightPanel.setLayout(new GridLayout(3, 1, 0, 20)); // 3 rows, 1 column, gap of 10 pixels between components
        // Add some space around the components in the right panel
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 200, 10, 200));
        rightPanel.setOpaque(false);

        // Add the right panel to the CENTER region of the JFrame
        add(rightPanel, BorderLayout.CENTER);

        // Create the "Start" button
        JButton startButton = new JButton("Start");
        makeButtonTransparent(startButton);
        addButtonHoverEffect(startButton, Color.GRAY, Color.BLACK);


        // Set the font for the "Start" button
        startButton.setFont(new Font("Arial", Font.BOLD, 32));

        // Add ActionListener to the "Start" button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display OptionMenu
                OptionMenu optionMenu = new OptionMenu(MainMenu.this);
                optionMenu.setVisible(true);

                // Hide the MainMenu
                setVisible(false);
            }
        });

        // Add the "Start" button to the right panel
        rightPanel.add(startButton);

        // Create the "Instruction" button
        JButton instructionButton = new JButton("Instruction");
        makeButtonTransparent(instructionButton);
        addButtonHoverEffect(instructionButton, Color.GRAY, Color.BLACK);


        // Set the font for the "Instruction" button
        instructionButton.setFont(new Font("Arial", Font.BOLD, 32));

        instructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display OptionMenu
                InstructionMenu instructionMenu = new InstructionMenu(MainMenu.this);
                instructionMenu.setVisible(true);

                // Hide the MainMenu
                setVisible(false);
            }
        });

        // Add the "Instruction" button to the right panel
        rightPanel.add(instructionButton);

        // Create the "Exit" button
        JButton exitButton = new JButton("Exit");
        makeButtonTransparent(exitButton);
        addButtonHoverEffect(exitButton, Color.GRAY, Color.BLACK);


        // Set the font for the "Exit" button
        //exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        exitButton.setFont(new Font("Arial", Font.BOLD, 32));
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

    private void setupEscapeKey() {
        // Get the InputMap and ActionMap of the root pane to set up key bindings
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        // Define the key stroke for the ESC key
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);

        // Put the key stroke in the input map with a key "ESCAPE"
        inputMap.put(escapeKeyStroke, "ESCAPE");

        // Now put an action in the action map that quits the application when the "ESCAPE" key is invoked
        actionMap.put("ESCAPE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when the ESC key is pressed
                System.exit(0);
            }
        });
    }
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

