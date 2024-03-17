package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class OptionMenu extends JFrame {

    private JFrame previousWindow;

    public OptionMenu(JFrame previousWindow) {
        this.previousWindow = previousWindow;
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

        setupEscapeKey();

    }


    private void initComponents() {
        // Create a panel with FlowLayout for centering the title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false); // Make panel transparent

        // Add the title panel to the NORTH region of the JFrame
        add(titlePanel, BorderLayout.NORTH);

        // Create a panel for the right half of the window
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false); // Make panel transparent
        rightPanel.setLayout(new GridLayout(3, 2, 0, 0)); // 2 rows, 2 columns, no gap
        rightPanel.setBorder(BorderFactory.createEmptyBorder(125, 50, 175, 50));

        // Add the right panel to the CENTER region of the JFrame
        add(rightPanel, BorderLayout.CENTER);

        // Create the "Weather" button
        JButton weatherButton = new JButton("Choose a city, cook its weather!");
        makeButtonTransparent(weatherButton);
        weatherButton.setFont(new Font("Arial", Font.BOLD, 40));
        addButtonHoverEffect(weatherButton, Color.GRAY, weatherButton.getForeground());
    weatherButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Hide the current OptionMenu
            setVisible(false);

            // Show the DIYMenu
            WeatherMenu weatherMenu = new WeatherMenu(OptionMenu.this);
            weatherMenu.setVisible(true);
          }
        });
        rightPanel.add(weatherButton);

        JPanel orWord = new JPanel();
        JLabel or = new JLabel("Or..");
        or.setFont(new Font("Arial", Font.BOLD,30));
        orWord.add(or);
        orWord.setOpaque(false);
        rightPanel.add(orWord);

        // Create the "DIY" button
        JButton diyButton = new JButton("Set the weather, find the flavor!");
        makeButtonTransparent(diyButton);
        diyButton.setFont(new Font("Arial", Font.BOLD, 50));
        addButtonHoverEffect(diyButton, Color.GRAY, diyButton.getForeground());
        diyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current OptionMenu
                setVisible(false);

                // Show the DIYMenu
                DIYMenu diyMenu = new DIYMenu(OptionMenu.this);
                diyMenu.setVisible(true);
            }
        });
        rightPanel.add(diyButton);

        // Create a panel for the back button with FlowLayout for right alignment
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backButtonPanel.setOpaque(false); // Make panel transparent

        // Add the back button to the buttonPanel
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the OptionMenu
                setVisible(false);

                // Show the previous window (MainMenu)
                if (previousWindow != null) {
                    previousWindow.setVisible(true);
                }
            }
        });
        backButtonPanel.add(backButton);

        // Add the button panel to the SOUTH region of the JFrame
        add(backButtonPanel, BorderLayout.SOUTH);

        titlePanel.setOpaque(false);
        rightPanel.setOpaque(false);
        backButtonPanel.setOpaque(false);
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
                // Instead of exiting, we hide the current window and show the previous one
                setVisible(false); // Hide the current window
                if (previousWindow != null) {
                    previousWindow.setVisible(true); // Show the previous window
                }
            }
        });
    }

    private void makeButtonTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.BLACK);
    }
}

