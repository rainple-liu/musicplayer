package ui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainFrame extends JFrame  {

    public static void main(String[] args)
    {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setTitle("QQ登录程序");
        jf.setSize(200,300);
        jf.setLocation(200,300);
        jf.setResizable(false);//false不能调整窗口大小
        jf.setLayout(new FlowLayout());//创建面板布局
        //创建标签
        JLabel label1 = new JLabel("QQ号码");
        jf.add(label1);
        //创建文本框，长度10
        JTextField userName = new JTextField(10);
        jf.add(userName);

        JLabel label2 = new JLabel("密 码");
        jf.add(label2);

        JPasswordField password = new JPasswordField(10);
        jf.add(password);
        //创建按钮
        JButton loginBtn = new JButton("登录");
        jf.add(loginBtn);

        JButton resetBtn = new JButton("退出");
        jf.add(resetBtn);
    }

}
