package uk.ac.soton.flavorfusion.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Objects;
import javax.swing.*;

import uk.ac.soton.flavorfusion.App;
import uk.ac.soton.flavorfusion.Meal;
import uk.ac.soton.flavorfusion.MealCalculator;
import uk.ac.soton.flavorfusion.WeatherData;

public class DIYMenu extends JFrame {

  HashMap<String, JTextField> inputs = new HashMap<>();
  JComboBox<String> dayNight;

  private JFrame previousWindow;

  public DIYMenu(JFrame previousWindow) {
    // Call setIconImage method
    App.setIconImage(this);

    this.previousWindow = previousWindow;

    setTitle("DIY Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initComponents(); // Initialize components

    setSize(1000, 700);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public Meal getMeal()
  {
    WeatherData data = null;

    String condition = checkStringData("weather condition");
    if (condition == null) return null;

    Float temperature = checkFloatData("temperature", -272.15f, 70f);
    if (temperature == null) return null;

    Integer cloud = checkIntegerData("cloud", 0, 100);
    if (cloud == null) return null;

    Float wind_speed = checkFloatData("wind speed", 0f, 100f);
    if (wind_speed == null) return null;

    Float pressure = checkFloatData("pressure", 0f, 50f);
    if (pressure == null) return null;

    Float precipitation = checkFloatData("precipitation", 0f, 500f);
    if (precipitation == null) return null;

    Integer humidity = checkIntegerData("humidity", 0, 100);
    if (humidity == null) return null;

    Float visibility = checkFloatData("visibility", 0f, 100f);
    if (visibility == null) return null;

    Float uvIndex = checkFloatData("uv index", 0f, 100f);
    if (uvIndex == null) return null;

    int dayNightVal = 0;
    String dayNightString = dayNight.getSelectedItem().toString();
    if (dayNightString.equals("1")) dayNightVal = 1;

    data = new WeatherData(temperature, humidity, pressure, uvIndex, condition, wind_speed, precipitation, visibility, dayNightVal, cloud);
    Meal result = MealCalculator.getMeal(data);
    System.out.println("result: " + result);
    return result;
  }

  String checkStringData(String key)
  {
    JTextField inputField = inputs.get(key);
    String raw_text = inputField.getText();
    boolean showMessage = false;
    if (raw_text == null || raw_text.isEmpty())
    {
      showMessage = true;
    }
    else{
      return raw_text;
    }

    if (showMessage)
    {
      JOptionPane.showMessageDialog(DIYMenu.this,"value for " + key + " should be a non-empty String.", "invalid input", JOptionPane.WARNING_MESSAGE);
    }
    return null;
  }

  Integer checkIntegerData(String key, int min, int max)
  {
    JTextField inputField = inputs.get(key);
    String raw_text = inputField.getText();
    boolean showMessage = false;
    if (raw_text == null || raw_text.isEmpty())
    {
      showMessage = true;
    }
    else
    {
      try
      {
        Integer i = Integer.parseInt(raw_text);
        if (i > max || i < min) showMessage = true;
        else return i;
      }
      catch (NumberFormatException e)
      {
        showMessage = true;
      }
    }

    if (showMessage)
    {
      JOptionPane.showMessageDialog(DIYMenu.this,"value for " + key + " should be a integer value with value between " + min + " and " + max + ".", "invalid input", JOptionPane.WARNING_MESSAGE);
    }
    return null;
  }

  Float checkFloatData(String key, float min, float max)
  {
    JTextField inputField = inputs.get(key);
    String raw_text = inputField.getText();
    boolean showMessage = false;
    if (raw_text == null || raw_text.isEmpty())
    {
      showMessage = true;
    }
    else
    {
      try
      {
        float f = Float.parseFloat(raw_text);
        if (f > (float) max || f < (float) min) showMessage = true;
        else return f;
      }
      catch (NumberFormatException e)
      {
        showMessage = true;
      }
    }

    if (showMessage)
    {
      JOptionPane.showMessageDialog(DIYMenu.this,"value for " + key + " should be a floating point value with value between " + min + " and " + max + ".", "invalid input", JOptionPane.WARNING_MESSAGE);
    }
    return null;
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
    dayNight = addSelectionBox(inputPanel, "Day/Night:");

    // Add input fields to the input panel with titles
    addInputField(inputPanel, "Weather Condition:", "weather condition");
    addInputField(inputPanel, "Temperature (°C):", "temperature");
    addInputField(inputPanel, "Cloud (%):", "cloud");
    addInputField(inputPanel, "Wind Speed (km/h):", "wind speed");
    addInputField(inputPanel, "Pressure (inHg):", "pressure");
    addInputField(inputPanel, "Precipitation (mm):", "precipitation");
    addInputField(inputPanel, "Humidity (%):", "humidity");
    addInputField(inputPanel, "Visibility (km):", "visibility");
    addInputField(inputPanel, "UV Index:", "uv index");

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
          Meal meal = getMeal();
          System.out.println(meal);

          if (meal != null)
          {
            setVisible(false); // Hide DIYMenu
            RecipeMenu recipeMenu =
                new RecipeMenu(this,meal); // Pass DIYMenu as the previous window to RecipeMenu
                //TODO:replace the new Meal with a meal class as the second parameter.

            recipeMenu.setVisible(true);
          }
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
  private void addInputField(JPanel panel, String label, String key) {
    JPanel fieldPanel = new JPanel(new BorderLayout());
    fieldPanel.setOpaque(false); // Make panel transparent
    JLabel fieldLabel = new JLabel(label);
    fieldLabel.setFont(new Font("Arial", Font.BOLD, 16));
    JTextField textField = new JTextField();
    fieldPanel.add(fieldLabel, BorderLayout.NORTH);
    fieldPanel.add(textField, BorderLayout.CENTER);
    panel.add(fieldPanel);
    inputs.put(key, textField);
  }

  // Method to add a selection box to the panel with a title
  private JComboBox<String> addSelectionBox(JPanel panel, String label) {
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
    return comboBox;
  }
}
