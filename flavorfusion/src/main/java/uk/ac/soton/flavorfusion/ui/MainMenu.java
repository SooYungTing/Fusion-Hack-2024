package uk.ac.soton.flavorfusion.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

  public MainMenu() {
    // Set the title of the window
    setTitle("Flavour Fushion");

    // Setting the default close operation
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
    // Create a panel for the right half of the window
    JPanel rightPanel = new JPanel();
    // Set the layout for the right panel (optional)
    rightPanel.setLayout(new GridLayout(3, 1, 0, 20)); // 3 rows, 1 column, gap of 10 pixels between components
    // Add some space around the components in the right panel (optional)
    rightPanel.setBorder(BorderFactory.createEmptyBorder(300, 200, 10, 200));
    // Add the right panel to the CENTER region of the JFrame
    add(rightPanel, BorderLayout.CENTER);

    // Create the "Start" button
    JButton startButton = new JButton("Start");
    // Add the "Start" button to the right panel
    rightPanel.add(startButton);

    // Create the "Instruction" button
    JButton instructionButton = new JButton("Instruction");
    // Add the "Instruction" button to the right panel
    rightPanel.add(instructionButton);

    // Create the "Exit" button
    JButton exitButton = new JButton("Exit");
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

  public static void main(String[] args) {
    // Ensure the GUI is created on the Event Dispatch Thread for thread safety
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MainMenu().setVisible(true);
      }
    });
  }
}






//package uk.ac.soton.flavorfusion.ui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainMenu extends JFrame {
//
//  public MainMenu() {
//    // Setting the title of the window
//    setTitle("Flavour Fushion");
//
//    // Setting the default close operation
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    // Setting the layout of the container
//    setLayout(new FlowLayout());
//
//    // Creating buttons
//    JButton btnStart = new JButton("Start");
//    JButton btnInstruction = new JButton("Instruction");
//    JButton btnExit = new JButton("Exit");
//
//    // Adding action listener to the "Exit" button
//    btnExit.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        System.exit(0); // Terminate the program
//      }
//    });
//
//    // Adding buttons to the JFrame
//    add(btnStart);
//    add(btnInstruction);
//    add(btnExit);
//
//    // Setting the size of the window
//    setSize(300, 200);
//
//    // Setting the window's icon
//    //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
//
//    // Centering the window on the screen
//    setLocationRelativeTo(null);
//  }
//
//  public static void main(String[] args) {
//    // Ensure the GUI is created on the Event Dispatch Thread for thread safety
//    SwingUtilities.invokeLater(new Runnable() {
//      public void run() {
//        new MainMenu().setVisible(true);
//      }
//    });
//  }
//}
