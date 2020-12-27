package com.potato.fileupload;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Potato
 * @email root_potato@163.com
 * @date 2020/12/27 21:50
 **/
public class LoginFrame {

    private JFrame jFrame = new JFrame("登录");
    private Container c = jFrame.getContentPane();
    private JLabel a1 = new JLabel("用户名:");
    private JTextField username = new JTextField();
    private JLabel a2 = new JLabel("密   码:");
    private JPasswordField password = new JPasswordField();
    private JButton okbtn = new JButton("登录");
    private JButton cancelbtn = new JButton("取消");

    public LoginFrame() {
        //设置窗体的位置及大小
        jFrame.setBounds(800, 300, 500, 350);
        //设置一层相当于桌布的东西
        c.setLayout(new BorderLayout());//布局管理器
        //设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //初始化--往窗体里放其他控件
        init();
        //设置窗体可见
        jFrame.setVisible(true);
    }

    public void init() {
        /*标题部分--North*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("登录系统"));
        c.add(titlePanel, "North");

        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        a1.setBounds(90, 40, 100, 40);
        a1.setFont(new Font("宋体bai", Font.BOLD, 16));
        a2.setBounds(90, 100, 100, 40);
        a2.setFont(new Font("宋体bai", Font.BOLD, 16));
        // 添加事件
        listerner();
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        username.setBounds(150, 45, 200, 30);
        password.setBounds(150, 105, 200, 30);
        fieldPanel.add(username);
        fieldPanel.add(password);
        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        Dimension preferredSize = new Dimension(80,35);//设置尺寸
        okbtn.setPreferredSize(preferredSize);
        okbtn.setBorder(BorderFactory.createRaisedBevelBorder());
        okbtn.setFont(new java.awt.Font("宋体bai", 1, 15));
        cancelbtn.setPreferredSize(preferredSize);
        cancelbtn.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelbtn.setFont(new java.awt.Font("宋体bai", 1, 15));
        buttonPanel.add(okbtn);
        buttonPanel.add(cancelbtn);
        c.add(buttonPanel, "South");
    }

    //测试
    public static void main(String[] args) {
        new LoginFrame();
    }

    public void listerner() {
        //确认按下去获取
        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = username.getText();
                String pwd = String.valueOf(password.getPassword());
                System.out.println(uname + pwd);
            }
        });
        //取消按下去清空
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
            }
        });
    }
}
