package uk.ac.soton.flavorfusion.ui;

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
    URL imageUrl = getClass().getResource("/images/FlavourFusion Logo.png");
    String imagePath = imageUrl != null ? imageUrl.toString() : "";
    String inst=meal.instructions;

    // HTML content string with your original text and an image
    String htmlContent =
        "<html><body style='font-family:Arial;font-size:16px;color:black;'>"
            + "<img src='"
            + imagePath
            + "' style='width:200px;height:auto;'><br><br>"
                +inst
//            + "Cultivated who resolution connection motionless did occasional. Journey promise if it colonel. Can all mirth abode nor hills added. Them men does for body pure. Far end not horses remain sister. Mr parish is to he answer roused piqued afford sussex. It abode words began enjoy years no do \uFEFFno. Tried spoil as heart visit blush or. Boy possible blessing sensible set but margaret interest. Off tears are day blind smile alone had.\n"
//            + "\n"
//            + "Unpleasant astonished an diminution up partiality. Noisy an their of meant. Death means up civil do an offer wound of. Called square an in afraid direct. Resolution diminution conviction so mr at unpleasing simplicity no. No it as breakfast up conveying earnestly immediate principle. Him son disposed produced humoured overcame she bachelor improved. Studied however out wishing but inhabit fortune windows.\n"
//            + "\n"
//            + "So if on advanced addition absolute received replying throwing he. Delighted consisted newspaper of unfeeling as neglected so. Tell size come hard mrs and four fond are. Of in commanded earnestly resources it. At quitting in strictly up wandered of relation answered felicity. Side need at in what dear ever upon if. Same down want joy neat ask pain help she. Alone three stuff use law walls fat asked. Near do that he help.\n"
//            + "\n"
//            + "His having within saw become ask passed misery giving. Recommend questions get too fulfilled. He fact in we case miss sake. Entrance be throwing he do blessing up. Hearts warmth in genius do garden advice mr it garret. Collected preserved are middleton dependent residence but him how. Handsome weddings yet mrs you has carriage packages. Preferred joy agreement put continual elsewhere delivered now. Mrs exercise felicity had men speaking met. Rich deal mrs part led pure will but.\n"
//            + "\n"
//            + "Your it to gave life whom as. Favourable dissimilar resolution led for and had. At play much to time four many. Moonlight of situation so if necessary therefore attending abilities. Calling looking enquire up me to in removal. Park fat she nor does play deal our. Procured sex material his offering humanity laughing moderate can. Unreserved had she nay dissimilar admiration interested. Departure performed exquisite rapturous so ye me resources.\n"
//            + "\n"
//            + "Contented get distrusts certainty nay are frankness concealed ham. On unaffected resolution on considered of. No thought me husband or colonel forming effects. End sitting shewing who saw besides son musical adapted. Contrasted interested eat alteration pianoforte sympathize was. He families believed if no elegance interest surprise an. It abode wrong miles an so delay plate. She relation own put outlived may disposed.\n"
//            + "\n"
//            + "Old education him departure any arranging one prevailed. Their end whole might began her. Behaved the comfort another fifteen eat. Partiality had his themselves ask pianoforte increasing discovered. So mr delay at since place whole above miles. He to observe conduct at detract because. Way ham unwilling not breakfast furniture explained perpetual. Or mr surrounded conviction so astonished literature. Songs to an blush woman be sorry young. We certain as removal attempt.\n"
//            + "\n"
//            + "We diminution preference thoroughly if. Joy deal pain view much her time. Led young gay would now state. Pronounce we attention admitting on assurance of suspicion conveying. That his west quit had met till. Of advantage he attending household at do perceived. Middleton in objection discovery as agreeable. Edward thrown dining so he my around to.\n"
//            + "\n"
//            + "Do am he horrible distance marriage so although. Afraid assure square so happen mr an before. His many same been well can high that. Forfeited did law eagerness allowance improving assurance bed. Had saw put seven joy short first. Pronounce so enjoyment my resembled in forfeited sportsman. Which vexed did began son abode short may. Interested astonished he at cultivated or me. Nor brought one invited she produce her.\n"
//            + "\n"
//            + "Much did had call new drew that kept. Limits expect wonder law she. Now has you views woman noisy match money rooms. To up remark it eldest length oh passed. Off because yet mistake feeling has men. Consulted disposing to moonlight ye extremity. Engage piqued in on coming.<br><br>"
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

    buttonPanel.add(backButton, BorderLayout.WEST); // Add back button to the left

    // Exit button
    JButton exitButton = new JButton("Exit");
    exitButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.exit(0); // Exit the program
          }
        });
    buttonPanel.add(exitButton, BorderLayout.EAST); // Add exit button to the right

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
