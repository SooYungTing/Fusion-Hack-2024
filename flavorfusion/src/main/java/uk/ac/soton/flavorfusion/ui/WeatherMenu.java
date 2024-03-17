package uk.ac.soton.flavorfusion.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import uk.ac.soton.flavorfusion.App;
import uk.ac.soton.flavorfusion.Meal;
import uk.ac.soton.flavorfusion.MealAPI;
import uk.ac.soton.flavorfusion.MealCalculator;
import uk.ac.soton.flavorfusion.WeatherAPI;
import uk.ac.soton.flavorfusion.WeatherData;

public class WeatherMenu extends JFrame{
  WeatherData wd;
  public WeatherMenu(OptionMenu optionMenu) {
    // 设置整个窗体的大小
    setSize(1000, 700);
    // 设置窗体的标题
    setTitle("Globe-Trotter's Kitchen: Pick a City!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 将带有背景图片的 JLabel 设置为内容面板
    JLabel background = new JLabel(new ImageIcon(
        Objects.requireNonNull(getClass().getResource("/images/Background 1.PNG"))
    ));
    setContentPane(background);

    // 使用 BorderLayout，左边占 40%，右边占 60%
    // getContentPane().setLayout(new BorderLayout());
    background.setLayout(new BorderLayout());

    // 创建左边的面板，它占整个面板的 40%
    JPanel leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(400, 700)); // 这是基于整个 JFrame 的大小
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // 可以根据需要选择布局
    // 添加左边面板中的组件...

    leftPanel.add(Box.createRigidArea(new Dimension(0, 200))); // 高度为10的间隙
    // 创建并添加标签 "选择你的城市"
    JLabel labelCity = new JLabel("Enter Your Flavor Zone: Zip or City!");
    labelCity.setFont(new Font("Arial", Font.BOLD,20));
    labelCity.setAlignmentX(Component.CENTER_ALIGNMENT);
    leftPanel.add(labelCity);

    leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));

    // 创建并添加输入框
    JTextField textFieldCity = new JTextField();
    textFieldCity.setMaximumSize(new Dimension(300, 30));
    textFieldCity.setAlignmentX(Component.CENTER_ALIGNMENT);
    leftPanel.add(textFieldCity);

    // 创建并添加输入提示标签
    JLabel labelHint = new JLabel("Please enter the name of city, or a UK-standard postcode.");
    labelHint.setFont(new Font("Arial", Font.PLAIN, 12));
    labelHint.setAlignmentX(Component.CENTER_ALIGNMENT);
    leftPanel.add(labelHint);

    JLabel labelHintSec = new JLabel("e.g. \"Paris\" | \"SO171BJ\"");
    labelHintSec.setFont(new Font("Arial", Font.PLAIN, 12));
    labelHintSec.setAlignmentX(Component.CENTER_ALIGNMENT);
    leftPanel.add(labelHintSec);

    // 添加间隙
    leftPanel.add(Box.createRigidArea(new Dimension(0, 80))); // 高度为10的间隙

    // 创建并添加按钮 "commit"
    JButton buttonCommit = new JButton("Commit");
    buttonCommit.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttonCommit.setFocusPainted(false); // 去除点击时的边框
    buttonCommit.setPreferredSize(new Dimension(50, 40));
    buttonCommit.setMaximumSize(new Dimension(150, 40));
    leftPanel.add(buttonCommit);

    leftPanel.add(Box.createRigidArea(new Dimension(0, 175)));

    // 创建并添加按钮 "continue"
    JButton buttonContinue = new JButton("FlavorFusion!!!");
    buttonContinue.setFont(new Font("Arial", Font.BOLD, 15));
    buttonContinue.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttonContinue.setFocusPainted(false);
    buttonContinue.setPreferredSize(new Dimension(80, 55));
    buttonContinue.setMaximumSize(new Dimension(170, 55));
    leftPanel.add(buttonContinue);

    // 创建右边的面板，它占整个面板的 60%
    JPanel rightPanel = new JPanel(new GridLayout(10, 1)); // 10 行 1 列的网格布局

    //添加带有标题的条目-------------------
    JPanel entryPanel1 = new JPanel(new BorderLayout());

    entryPanel1.setOpaque(false);

    JLabel labelTitle1 = new JLabel("Temperature(°C):"); // 替换为对应的标题，如"temperature: "

    labelTitle1.setOpaque(false);

    labelTitle1.setPreferredSize(new Dimension(135, labelTitle1.getPreferredSize().height));
    JLabel textField1 = new JLabel(); // 用于显示数据
    //textField1.setText();
    entryPanel1.add(labelTitle1, BorderLayout.WEST);
    entryPanel1.add(textField1, BorderLayout.CENTER);
    rightPanel.add(entryPanel1);

    JPanel entryPanel2 = new JPanel(new BorderLayout());

    entryPanel2.setOpaque(false);

    JLabel labelTitle2 = new JLabel("Pressure(inHg):"); // 替换为对应的标题，如"temperature: "

    labelTitle2.setOpaque(false);

    labelTitle2.setPreferredSize(new Dimension(135, labelTitle2.getPreferredSize().height));
    JLabel textField2 = new JLabel(); // 用于显示数据
    textField2.setText("");
    entryPanel2.add(labelTitle2, BorderLayout.WEST);
    entryPanel2.add(textField2, BorderLayout.CENTER);
    rightPanel.add(entryPanel2);

    JPanel entryPanel3 = new JPanel(new BorderLayout());

    entryPanel3.setOpaque(false);

    JLabel labelTitle3 = new JLabel("Humidity(%):"); // 替换为对应的标题，如"temperature: "

    labelTitle3.setOpaque(false);

    labelTitle3.setPreferredSize(new Dimension(135, labelTitle3.getPreferredSize().height));
    JLabel textField3 = new JLabel(); // 用于显示数据
    textField3.setText("");
    entryPanel3.add(labelTitle3, BorderLayout.WEST);
    entryPanel3.add(textField3, BorderLayout.CENTER);
    rightPanel.add(entryPanel3);

    JPanel entryPanel4 = new JPanel(new BorderLayout());

    entryPanel4.setOpaque(false);

    JLabel labelTitle4 = new JLabel("UV Index:"); // 替换为对应的标题，如"temperature: "

    labelTitle4.setOpaque(false);

    labelTitle4.setPreferredSize(new Dimension(135, labelTitle4.getPreferredSize().height));
    JLabel textField4 = new JLabel(); // 用于显示数据
    textField4.setText("");
    entryPanel4.add(labelTitle4, BorderLayout.WEST);
    entryPanel4.add(textField4, BorderLayout.CENTER);
    rightPanel.add(entryPanel4);

    JPanel entryPanel5 = new JPanel(new BorderLayout());

    entryPanel5.setOpaque(false);

    JLabel labelTitle5 = new JLabel("Weather Condition:"); // 替换为对应的标题，如"temperature: "

    labelTitle5.setOpaque(false);

    labelTitle5.setPreferredSize(new Dimension(135, labelTitle5.getPreferredSize().height));
    JLabel textField5 = new JLabel(); // 用于显示数据
    textField5.setText("");
    entryPanel5.add(labelTitle5, BorderLayout.WEST);
    entryPanel5.add(textField5, BorderLayout.CENTER);
    rightPanel.add(entryPanel5);

    JPanel entryPanel6 = new JPanel(new BorderLayout());

    entryPanel6.setOpaque(false);

    JLabel labelTitle6 = new JLabel("Wind Speed(km/h):"); // 替换为对应的标题，如"temperature: "

    labelTitle6.setOpaque(false);

    labelTitle6.setPreferredSize(new Dimension(135, labelTitle6.getPreferredSize().height));
    JLabel textField6 = new JLabel(); // 用于显示数据
    textField6.setText("");
    entryPanel6.add(labelTitle6, BorderLayout.WEST);
    entryPanel6.add(textField6, BorderLayout.CENTER);
    rightPanel.add(entryPanel6);

    JPanel entryPanel7 = new JPanel(new BorderLayout());

    entryPanel7.setOpaque(false);

    JLabel labelTitle7 = new JLabel("Precipitation(mm):"); // 替换为对应的标题，如"temperature: "

    labelTitle7.setOpaque(false);

    labelTitle7.setPreferredSize(new Dimension(135, labelTitle7.getPreferredSize().height));
    JLabel textField7 = new JLabel(); // 用于显示数据
    textField7.setText("");
    entryPanel7.add(labelTitle7, BorderLayout.WEST);
    entryPanel7.add(textField7, BorderLayout.CENTER);
    rightPanel.add(entryPanel7);

    JPanel entryPanel8 = new JPanel(new BorderLayout());

    entryPanel8.setOpaque(false);

    JLabel labelTitle8 = new JLabel("Visibility(km):"); // 替换为对应的标题，如"temperature: "

    labelTitle8.setOpaque(false);

    labelTitle8.setPreferredSize(new Dimension(135, labelTitle8.getPreferredSize().height));
    JLabel textField8 = new JLabel(); // 用于显示数据
    textField8.setText("");
    entryPanel8.add(labelTitle8, BorderLayout.WEST);
    entryPanel8.add(textField8, BorderLayout.CENTER);
    rightPanel.add(entryPanel8);

    JPanel entryPanel9 = new JPanel(new BorderLayout());

    entryPanel9.setOpaque(false);

    JLabel labelTitle9 = new JLabel("Day/Night"); // 替换为对应的标题，如"temperature: "

    labelTitle9.setOpaque(false);

    labelTitle9.setPreferredSize(new Dimension(135, labelTitle9.getPreferredSize().height));
    JLabel textField9 = new JLabel(); // 用于显示数据
    textField9.setText("");
    entryPanel9.add(labelTitle9, BorderLayout.WEST);
    entryPanel9.add(textField9, BorderLayout.CENTER);
    rightPanel.add(entryPanel9);

    JPanel entryPanel10 = new JPanel(new BorderLayout());

    entryPanel10.setOpaque(false);

    JLabel labelTitle10 = new JLabel("Cloud (%):"); // 替换为对应的标题，如"temperature: "

    labelTitle10.setOpaque(false);

    labelTitle10.setPreferredSize(new Dimension(135, labelTitle10.getPreferredSize().height));
    JLabel textField10 = new JLabel(); // 用于显示数据
    textField10.setText("");
    entryPanel10.add(labelTitle10, BorderLayout.WEST);
    entryPanel10.add(textField10, BorderLayout.CENTER);
    rightPanel.add(entryPanel10);

    // 添加到内容面板
    getContentPane().add(leftPanel, BorderLayout.WEST);
    getContentPane().add(rightPanel, BorderLayout.CENTER);

    // ------
    leftPanel.setOpaque(false);
    rightPanel.setOpaque(false);

    // Center the window on the screen
    setLocationRelativeTo(null);

    // Make the window visible
    setVisible(true);

    buttonContinue.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

            if (wd != null) {
              Meal meal = MealCalculator.getMeal(wd);
              if (meal != null) {
                System.out.println("meal generated: " + meal);
                // Close current WeatherMenu window.
                dispose();
                // Display RecipeMenu window.
                new RecipeMenu(WeatherMenu.this).setVisible(true);
              }
            }
          }
        });

    buttonCommit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String location = textFieldCity.getText();
        wd = WeatherAPI.query(location);
        textField1.setText(Float.toString(wd.temperature));
        textField2.setText(Float.toString(wd.pressure));
        textField3.setText(Integer.toString(wd.humidity));
        textField4.setText(Float.toString(wd.uvIndex));
        textField5.setText(wd.weatherCondition);
        textField6.setText(Float.toString(wd.windSpeed));
        textField7.setText(Float.toString(wd.precipitation));
        textField8.setText(Float.toString(wd.visibility));
        textField9.setText(Integer.toString(wd.daynight));
        textField10.setText(Integer.toString(wd.cloud));
      }
    });
  }

}
