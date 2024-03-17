package uk.ac.soton.flavorfusion.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.*;

public class DIYMenu extends JFrame {

  private JFrame previousWindow;

  public DIYMenu(JFrame previousWindow) {
    this.previousWindow = previousWindow;

    setTitle("DIY Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initComponents(); // Initialize components

    setSize(1000, 700);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void initComponents() {
    // Load the background image
    ImageIcon originalIcon =
        new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Background 1.PNG")));
    Image originalImage = originalIcon.getImage();
    // Resize the image if necessary
    Image resizedImage =
        originalImage.getScaledInstance(
            1000, 700, Image.SCALE_SMOOTH); // Adjust the width and height as needed
    ImageIcon backgroundImage = new ImageIcon(resizedImage);

    // Create a label with the resized background image
    JLabel backgroundLabel = new JLabel(backgroundImage);

    // Set layout of the frame
    setLayout(new BorderLayout());

    // Add the background label to the content pane
    getContentPane().add(backgroundLabel, BorderLayout.CENTER);

    // Panel for input fields
    JPanel inputPanel = new JPanel(new GridLayout(5, 2, 30, 30)); // 5 rows, 2 columns, gap: 30px
    inputPanel.setOpaque(false); // Make panel transparent
    inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 80, 20, 80));

    // Add Day/Night selection box to the input panel with a title
    addSelectionBox(inputPanel, "Day/Night:");

    // Add input fields to the input panel with titles
    addInputField(inputPanel, "Weather Condition:");
    addInputField(inputPanel, "Temperature (°C):");
    addInputField(inputPanel, "Wind Direction:");
    addInputField(inputPanel, "Wind Speed:");
    addInputField(inputPanel, "Pressure:");
    addInputField(inputPanel, "Precipitation:");
    addInputField(inputPanel, "Humidity:");
    addInputField(inputPanel, "Visibility:");
    addInputField(inputPanel, "UV Index:");

    // Panel for the back button
    JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    backButtonPanel.setOpaque(false); // Make panel transparent
    backButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Back button
    JButton backButton = new JButton("Back");
    backButton.addActionListener(
        (ActionEvent e) -> {
          setVisible(false);
          if (previousWindow != null) {
            previousWindow.setVisible(true);
          }
        });
    backButtonPanel.add(backButton);

    JPanel commitButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center alignment
    commitButtonPanel.setOpaque(false); // Make panel transparent
    commitButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

    // Commit button
    JButton commitButton = new JButton("Commit");
    commitButton.addActionListener(
        e -> {
          setVisible(false); // Hide DIYMenu
          RecipeMenu recipeMenu =
              new RecipeMenu(this); // Pass DIYMenu as the previous window to RecipeMenu
          recipeMenu.setVisible(true);
        });

    commitButtonPanel.add(commitButton);

    // Add panels to the background panel
    JPanel buttonPanel = new JPanel(new BorderLayout());
    buttonPanel.setOpaque(false); // Make panel transparent
    buttonPanel.add(backButtonPanel, BorderLayout.EAST);
    buttonPanel.add(commitButtonPanel, BorderLayout.WEST);

    // Add panels to the background panel
    backgroundLabel.setLayout(new BorderLayout());
    backgroundLabel.add(inputPanel, BorderLayout.CENTER);
    backgroundLabel.add(buttonPanel, BorderLayout.SOUTH);
  }

  // Method to add an input field to the panel with a title
  private void addInputField(JPanel panel, String label) {
    JPanel fieldPanel = new JPanel(new BorderLayout());
    fieldPanel.setOpaque(false); // Make panel transparent
    JLabel fieldLabel = new JLabel(label);
    fieldLabel.setFont(new Font("Arial", Font.BOLD, 16));
    JTextField textField = new JTextField();
    fieldPanel.add(fieldLabel, BorderLayout.NORTH);
    fieldPanel.add(textField, BorderLayout.CENTER);
    panel.add(fieldPanel);
  }

  // Method to add a selection box to the panel with a title
  private void addSelectionBox(JPanel panel, String label) {
    JPanel boxPanel = new JPanel(new BorderLayout());
    boxPanel.setOpaque(false); // Make panel transparent
    JLabel boxLabel = new JLabel(label);
    boxLabel.setFont(new Font("Arial", Font.BOLD, 16));
    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.addItem("Day");
    comboBox.addItem("Night");
    boxPanel.add(boxLabel, BorderLayout.NORTH);
    boxPanel.add(comboBox, BorderLayout.CENTER);
    panel.add(boxPanel);
  }
}
