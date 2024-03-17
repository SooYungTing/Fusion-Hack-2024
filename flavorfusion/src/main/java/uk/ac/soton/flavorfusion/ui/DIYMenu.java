package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DIYMenu extends JFrame {

    private JFrame previousWindow;

    public DIYMenu(JFrame previousWindow) {
        this.previousWindow = previousWindow;

        setTitle("DIY Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 30, 30)); // 5 rows, 2 columns, gap: 30px
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

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
        backButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener((ActionEvent e) -> {
            setVisible(false);
            if (previousWindow != null) {
                previousWindow.setVisible(true);
            }
        });
        backButtonPanel.add(backButton);

        // Add panels to the main frame
        add(inputPanel, BorderLayout.CENTER);
        add(backButtonPanel, BorderLayout.SOUTH);

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to add an input field to the panel with a title
    private void addInputField(JPanel panel, String label) {
        JPanel fieldPanel = new JPanel(new BorderLayout());
        JLabel fieldLabel = new JLabel(label);
        JTextField textField = new JTextField();
        fieldPanel.add(fieldLabel, BorderLayout.NORTH);
        fieldPanel.add(textField, BorderLayout.CENTER);
        panel.add(fieldPanel);
    }

    // Method to add a selection box to the panel with a title
    private void addSelectionBox(JPanel panel, String label) {
        JPanel boxPanel = new JPanel(new BorderLayout());
        JLabel boxLabel = new JLabel(label);
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Day");
        comboBox.addItem("Night");
        boxPanel.add(boxLabel, BorderLayout.NORTH);
        boxPanel.add(comboBox, BorderLayout.CENTER);
        panel.add(boxPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new DIYMenu(null); // Pass null as previousWindow since it's the main window
        });
    }
}
