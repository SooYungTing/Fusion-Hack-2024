package uk.ac.soton.flavorfusion.ui;

import uk.ac.soton.flavorfusion.App;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Objects;
import javax.swing.*;

public class InstructionMenu extends JFrame {

  private final JFrame previousWindow;

  public InstructionMenu(JFrame previousWindow) {
    // Set the title of the window
    setTitle("FlavorFusion Instructions");

    // Call setIconImage method
    App.setIconImage(this);

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

    // Assuming this part stays as is, for setting up the background image
    setContentPane(
        new JLabel(
            new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Background 1.PNG")))));
    setLayout(new BorderLayout()); // Use BorderLayout for the main layout

    // Calculate the white area's position and dimensions
    // These are arbitrary values, you should adjust them based on your background
    int horizontalPadding = 150; // Adjust this to center the text within the white area
    int verticalPadding = 10; // The width of the white area

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
        new JTextArea(
            "Welcome to FlavorFusion!\n\n"
                + "Here's how to get started:\n"
                + "1. Press the 'Start' button to start the app.\n"
                + "2. On the option menu, you can choose recipe through weather.\n"
                + "       Choose 'Choose a city, cook its weather!' button, if you would like to input the weather information.\n"
                + "       Choose 'Set the weather, find the flavor!' Button if you would like to input the city name.\n"
                + "3. The Recipe is then generated for you.\n"
                + "4. Enjoy your personalized recipe recommendation!");
    JScrollPane scrollPane = new JScrollPane(stepsText);

    textPanel.add(scrollPane, BorderLayout.CENTER);

    JPanel containerPanel = new JPanel(new BorderLayout());
    containerPanel.setOpaque(false);
    containerPanel.setBorder(
        BorderFactory.createEmptyBorder(
            verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
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

    // Add a mouse wheel listener to the JScrollPane if needed
    scrollPane.addMouseWheelListener(
        new MouseWheelListener() {
          public void mouseWheelMoved(MouseWheelEvent e) {
            JScrollBar bar = scrollPane.getVerticalScrollBar();
            int amount = e.getWheelRotation() * bar.getUnitIncrement();
            bar.setValue(bar.getValue() + amount);
          }
        });

    getContentPane().add(containerPanel, BorderLayout.CENTER);
    // Adjusting only the part for the back button to ensure transparency
    JButton backButton = new JButton("Back");
    backButton.addActionListener(
        e -> {
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
    buttonPanel.setBorder(
        BorderFactory.createEmptyBorder(10, 0, 10, 10)); // Adjust padding as needed

    // Add the button panel directly to the frame, ensuring transparency
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
  }
}
