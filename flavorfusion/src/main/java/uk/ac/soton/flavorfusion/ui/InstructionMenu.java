package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Objects;

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


    /*private void initComponents() {
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
    }*/
    /*private void initComponents() {
        // Assuming "background.jpg" is in your project directory or an accessible path
        BackgroundPanel backgroundPanel = new BackgroundPanel("/images/Background 1.PNG");
        backgroundPanel.setLayout(new BorderLayout());
        add(backgroundPanel);

        // Other components...
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false); // Make panel transparent

        JLabel titleLabel = new JLabel("FlavorFusion Instructions");
        titlePanel.add(titleLabel);

        backgroundPanel.add(titlePanel, BorderLayout.NORTH);

        JTextArea instructionsText = new JTextArea(10, 40);
        instructionsText.setText("Welcome to FlavorFusion!\n\n" +
                "Here's how to get started:\n" +
                "1. Choose your base flavor.\n" +
                "2. Select additional ingredients.\n" +
                "3. Mix them up!\n" +
                "4. Enjoy your personalized flavor creation.");
        instructionsText.setEditable(false);
        instructionsText.setOpaque(false); // Make text area transparent
        backgroundPanel.add(instructionsText, BorderLayout.CENTER);

        // Continue with JButton and other components, ensuring to add them to backgroundPanel
        // and setting them opaque as needed

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
    }*/

    private void initComponents() {

        // Assuming this part stays as is, for setting up the background image
        setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Background 1.PNG")))));
        setLayout(new BorderLayout()); // Use BorderLayout for the main layout

        // Calculate the white area's position and dimensions
        // These are arbitrary values, you should adjust them based on your background
        int horizontalPadding = 150; // Adjust this to center the text within the white area
        int verticalPadding = 10;  // The width of the white area

        // Correctly setting the font for titleLabel
        JLabel titleLabel = new JLabel("Instructions");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set the font of the titleLabel

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(titleLabel);
        titlePanel.setOpaque(false); // Optionally, make the title panel transparent

        getContentPane().add(titlePanel, BorderLayout.NORTH); // Add the title panel to the top



        // Panel for the recipe text content with padding
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false); // Make panel transparent


        JTextArea stepsText =
                new JTextArea("Welcome to FlavorFusion!\n\n" +
                        "Here's how to get started:\n" +
                        "1. Choose your base flavor.\n" +
                        "2. Select additional ingredients.\n" +
                        "3. Mix them up!\n" +
                        "4. Enjoy your personalized flavor creation.");
        JScrollPane scrollPane = new JScrollPane(stepsText);

        textPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setOpaque(false);
        containerPanel.setBorder(BorderFactory.createEmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
        containerPanel.add(textPanel, BorderLayout.CENTER);

        // Add the container panel to the frame
        getContentPane().add(containerPanel, BorderLayout.CENTER);



        // Use an empty border to create padding on the left (and possibly other sides if needed)

        // Add your text panel to this container
        containerPanel.add(textPanel, BorderLayout.CENTER);

        // Add the container panel to the frame
        getContentPane().add(containerPanel, BorderLayout.CENTER);

        // Panel for the image, also transparent
        JPanel imagePanel = new JPanel();
        imagePanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align
        imagePanel.setOpaque(false); // Transparency

        // Panel for the steps (text), also transparent
        JPanel stepsPanel = new JPanel(new BorderLayout());
        stepsPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align
        stepsPanel.setOpaque(false); // Transparency
        stepsText.setWrapStyleWord(true);
        stepsText.setLineWrap(true);
        stepsText.setEditable(false);
        stepsText.setOpaque(false); // Text area transparency
        JScrollPane stepsScrollPane = new JScrollPane(stepsText);
        stepsScrollPane.setOpaque(false); // Scroll pane transparency
        stepsScrollPane.getViewport().setOpaque(false); // Viewport transparency
        stepsPanel.add(stepsScrollPane);


        // Adding panels to the content panel
        containerPanel.add(imagePanel);
        containerPanel.add(stepsPanel);

        // JScrollPane for scrolling, with minimal visibility settings
    /*JScrollPane scrollPane = new JScrollPane(containerPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setOpaque(false);
    scrollPane.getViewport().setOpaque(false);*/

        // Add a mouse wheel listener to the JScrollPane if needed
        scrollPane.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                JScrollBar bar = scrollPane.getVerticalScrollBar();
                int amount = e.getWheelRotation() * bar.getUnitIncrement();
                bar.setValue(bar.getValue() + amount);
            }
        });



        getContentPane().add(containerPanel, BorderLayout.CENTER);
// Adjusting only the part for the back button to ensure transparency
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            // Hide the current window
            setVisible(false);

            // Show the previous window
            if (previousWindow != null) {
                previousWindow.setVisible(true);
            }
        });

        // Panel for the back button
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false); // Ensure the panel is transparent
        buttonPanel.add(backButton, BorderLayout.EAST);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10)); // Adjust padding as needed

        // Add the button panel directly to the frame, ensuring transparency
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
}