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
    // 循环添加带有标题的条目
    for (int i = 0; i < 10; i++) {
      JPanel entryPanel = new JPanel(new BorderLayout());
      JLabel labelTitle = new JLabel("Item " + (i+1) + ": "); // 替换为对应的标题，如"temperature: "
      JTextField textField = new JTextField(); // 用于显示数据
      entryPanel.add(labelTitle, BorderLayout.WEST);
      entryPanel.add(textField, BorderLayout.CENTER);
      rightPanel.add(entryPanel);
    }

    // 添加到内容面板
    getContentPane().add(leftPanel, BorderLayout.WEST);
    getContentPane().add(rightPanel, BorderLayout.CENTER);

    setVisible(true);
  }


  public static void main(String[] args) {

    SwingUtilities.invokeLater(() -> new WeatherMenu());
  }
}
