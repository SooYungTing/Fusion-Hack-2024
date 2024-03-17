package uk.ac.soton.flavorfusion.ui;

import uk.ac.soton.flavorfusion.App;
import uk.ac.soton.flavorfusion.Meal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;

public class RecipeMenu extends JFrame {

  private JFrame previousWindow;
  Meal meal;

  public RecipeMenu(JFrame previousWindow, Meal meal) {
    this.previousWindow = previousWindow;
    this.meal=meal;

    // Call setIconImage method
    App.setIconImage(this);

    // Set the title of the window
    setTitle("Recipe Menu");

    // Specify an action for the close button
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set background image
    setContentPane(
        new JLabel(
            new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Background 1.PNG")))));

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
    System.out.println("meal: " + meal);
    // Background setup remains unchanged
    setContentPane(
        new JLabel(
            new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Background 1.PNG")))));
    setLayout(new BorderLayout());

    JTextPane textPane = new JTextPane();
    textPane.setContentType("text/html"); // Allows for HTML content
    textPane.setEditable(false); // Make the JTextPane non-editable
    textPane.setOpaque(false); // Make its background transparent

    // Assuming "/images/yourImage.png" is the path to your image
    //URL imageUrl = getClass().getResource("/images/FlavourFusion Logo.png");
    String imagePath = meal.imageAddress != null ? meal.imageAddress.toString() : "";
    String inst=meal.instructions;

    // HTML content string with your original text and an image
    String htmlContent =
        "<html><body style='font-family:Arial;font-size:16px;color:black;'>"
            + "<img src='"
            + imagePath
            + "' style='width:150px;height:auto;'><br><br>" + "<h2>"+ meal.name+ "</h2><h3>Cooking Instructions</h3><p>"
                +inst + "</p>"
            + "</body></html>";

    textPane.setText(htmlContent);

    JScrollPane scrollPane = new JScrollPane(textPane);
    scrollPane.setOpaque(false); // Make JScrollPane transparent
    scrollPane.getViewport().setOpaque(false); // Make its viewport transparent
    scrollPane.setBorder(null); // Remove border if needed

    JPanel containerPanel = new JPanel(new BorderLayout());
    containerPanel.setOpaque(false); // Ensure containerPanel is transparent
    containerPanel.add(scrollPane, BorderLayout.CENTER); // Add scrollPane to containerPanel

    // Adjust padding as needed
    int horizontalPadding = 150;
    int verticalPadding = 50;
    containerPanel.setBorder(
        BorderFactory.createEmptyBorder(
            verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));

    // Add the containerPanel to the frame
    getContentPane().add(containerPanel, BorderLayout.CENTER);

    // Panel for the buttons with empty border for spacing
    JPanel buttonPanel = new JPanel(new BorderLayout());
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30)); // Add spacing
    buttonPanel.setOpaque(false); // Make panel transparent
    // Back button
    JButton backButton = new JButton("Back");

    backButton.addActionListener(
        (ActionEvent e) -> {
          this.setVisible(false); // Hide RecipeMenu
          if (previousWindow != null) {
            previousWindow.setVisible(true); // Show DIYMenu
          }
        });

    buttonPanel.add(backButton, BorderLayout.EAST); // Add back button to the left

    // Exit button
    JButton exitButton = new JButton("Exit");
    exitButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.exit(0); // Exit the program
          }
        });
    buttonPanel.add(exitButton, BorderLayout.WEST); // Add exit button to the right

    // Add the button panel to the SOUTH region of the JFrame
    add(buttonPanel, BorderLayout.SOUTH);

    getContentPane().add(containerPanel, BorderLayout.CENTER);
  }

  // Ensure loadImage method or similar logic is present for loading images

  // Example method to load an image
  private ImageIcon loadImage(String path) {
    URL url = getClass().getResource(path);
    if (url != null) {
      return new ImageIcon(url);
    }
    return null; // or a default image
  }
}
