package uk.ac.soton.flavorfusion;

import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

  public MainMenu() {
    // Setting the title of the window
    setTitle("Flavour Fushion");

    // Setting the default close operation
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Setting the layout of the container
    setLayout(new FlowLayout());

    // Creating buttons
    JButton btnStart = new JButton("Start");
    JButton btnInstruction = new JButton("Instruction");
    JButton btnExit = new JButton("Exit");

    // Adding action listener to the "Exit" button
    btnExit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0); // Terminate the program
      }
    });

    // Adding buttons to the JFrame
    add(btnStart);
    add(btnInstruction);
    add(btnExit);

    // Setting the size of the window
    setSize(300, 200);

    // Setting the window's icon
    //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));

    // Centering the window on the screen
    setLocationRelativeTo(null);
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
