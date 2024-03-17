package uk.ac.soton.flavorfusion.ui;

import java.awt.*;
import javax.swing.*;

public class WeatherMenu extends JFrame{

  public WeatherMenu() {
    // 设置整个窗体的大小
    setSize(1000, 700);
    // 设置窗体的标题
    setTitle("Globe-Trotter's Kitchen: Pick a City!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 使用 BorderLayout，左边占 40%，右边占 60%
    getContentPane().setLayout(new BorderLayout());

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
    JButton buttonCommit = new JButton("commit");
    buttonCommit.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttonCommit.setFocusPainted(false); // 去除点击时的边框
    leftPanel.add(buttonCommit);

    leftPanel.add(Box.createRigidArea(new Dimension(0, 175)));

    // 创建并添加按钮 "continue"
    JButton buttonContinue = new JButton("continue");
    buttonContinue.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttonContinue.setFocusPainted(false);
    leftPanel.add(buttonContinue);

    // 创建右边的面板，它占整个面板的 60%
    JPanel rightPanel = new JPanel(new GridLayout(10, 1)); // 10 行 1 列的网格布局

    //添加带有标题的条目-------------------
    JPanel entryPanel1 = new JPanel(new BorderLayout());
    JLabel labelTitle1 = new JLabel("Temperature(°C):" + '\t'); // 替换为对应的标题，如"temperature: "
    labelTitle1.setPreferredSize(new Dimension(135, labelTitle1.getPreferredSize().height));
    JTextField textField1 = new JTextField(); // 用于显示数据
    entryPanel1.add(labelTitle1, BorderLayout.WEST);
    entryPanel1.add(textField1, BorderLayout.CENTER);
    rightPanel.add(entryPanel1);

    JPanel entryPanel2 = new JPanel(new BorderLayout());
    JLabel labelTitle2 = new JLabel("Pressure:"); // 替换为对应的标题，如"temperature: "
    labelTitle2.setPreferredSize(new Dimension(135, labelTitle2.getPreferredSize().height));
    JTextField textField2 = new JTextField(); // 用于显示数据
    entryPanel2.add(labelTitle2, BorderLayout.WEST);
    entryPanel2.add(textField2, BorderLayout.CENTER);
    rightPanel.add(entryPanel2);

    JPanel entryPanel3 = new JPanel(new BorderLayout());
    JLabel labelTitle3 = new JLabel("Humidity:"); // 替换为对应的标题，如"temperature: "
    labelTitle3.setPreferredSize(new Dimension(135, labelTitle3.getPreferredSize().height));
    JTextField textField3 = new JTextField(); // 用于显示数据
    entryPanel3.add(labelTitle3, BorderLayout.WEST);
    entryPanel3.add(textField3, BorderLayout.CENTER);
    rightPanel.add(entryPanel3);

    JPanel entryPanel4 = new JPanel(new BorderLayout());
    JLabel labelTitle4 = new JLabel("UV Index:"); // 替换为对应的标题，如"temperature: "
    labelTitle4.setPreferredSize(new Dimension(135, labelTitle4.getPreferredSize().height));
    JTextField textField4 = new JTextField(); // 用于显示数据
    entryPanel4.add(labelTitle4, BorderLayout.WEST);
    entryPanel4.add(textField4, BorderLayout.CENTER);
    rightPanel.add(entryPanel4);

    JPanel entryPanel5 = new JPanel(new BorderLayout());
    JLabel labelTitle5 = new JLabel("Weather Condition:"); // 替换为对应的标题，如"temperature: "
    labelTitle5.setPreferredSize(new Dimension(135, labelTitle5.getPreferredSize().height));
    JTextField textField5 = new JTextField(); // 用于显示数据
    entryPanel5.add(labelTitle5, BorderLayout.WEST);
    entryPanel5.add(textField5, BorderLayout.CENTER);
    rightPanel.add(entryPanel5);

    JPanel entryPanel6 = new JPanel(new BorderLayout());
    JLabel labelTitle6 = new JLabel("Wind Speed:"); // 替换为对应的标题，如"temperature: "
    labelTitle6.setPreferredSize(new Dimension(135, labelTitle6.getPreferredSize().height));
    JTextField textField6 = new JTextField(); // 用于显示数据
    entryPanel6.add(labelTitle6, BorderLayout.WEST);
    entryPanel6.add(textField6, BorderLayout.CENTER);
    rightPanel.add(entryPanel6);

    JPanel entryPanel7 = new JPanel(new BorderLayout());
    JLabel labelTitle7 = new JLabel("Precipitation:"); // 替换为对应的标题，如"temperature: "
    labelTitle7.setPreferredSize(new Dimension(135, labelTitle7.getPreferredSize().height));
    JTextField textField7 = new JTextField(); // 用于显示数据
    entryPanel7.add(labelTitle7, BorderLayout.WEST);
    entryPanel7.add(textField7, BorderLayout.CENTER);
    rightPanel.add(entryPanel7);

    JPanel entryPanel8 = new JPanel(new BorderLayout());
    JLabel labelTitle8 = new JLabel("Visibility:"); // 替换为对应的标题，如"temperature: "
    labelTitle8.setPreferredSize(new Dimension(135, labelTitle8.getPreferredSize().height));
    JTextField textField8 = new JTextField(); // 用于显示数据
    entryPanel8.add(labelTitle8, BorderLayout.WEST);
    entryPanel8.add(textField8, BorderLayout.CENTER);
    rightPanel.add(entryPanel8);

    JPanel entryPanel9 = new JPanel(new BorderLayout());
    JLabel labelTitle9 = new JLabel("Day/Night"); // 替换为对应的标题，如"temperature: "
    labelTitle9.setPreferredSize(new Dimension(135, labelTitle9.getPreferredSize().height));
    JTextField textField9 = new JTextField(); // 用于显示数据
    entryPanel9.add(labelTitle9, BorderLayout.WEST);
    entryPanel9.add(textField9, BorderLayout.CENTER);
    rightPanel.add(entryPanel9);

    JPanel entryPanel10 = new JPanel(new BorderLayout());
    JLabel labelTitle10 = new JLabel("Wind Direction:"); // 替换为对应的标题，如"temperature: "
    labelTitle10.setPreferredSize(new Dimension(135, labelTitle10.getPreferredSize().height));
    JTextField textField10 = new JTextField(); // 用于显示数据
    entryPanel10.add(labelTitle10, BorderLayout.WEST);
    entryPanel10.add(textField10, BorderLayout.CENTER);
    rightPanel.add(entryPanel10);

    // 添加到内容面板
    getContentPane().add(leftPanel, BorderLayout.WEST);
    getContentPane().add(rightPanel, BorderLayout.CENTER);

    setVisible(true);
  }


  public static void main(String[] args) {

    SwingUtilities.invokeLater(() -> new WeatherMenu());
  }
}
