package ui;

import sun.text.normalizer.Trie;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame {

    //总容器
//    private Component component;
    //三个container
    private Container conTop;
    private Container conMid;
    private Container conBot;
    //包含在conTop中的两个容器
    private JPanel jpList;
//    private JTextArea jTextArea;
    private JLabel jbTopLeft;
    private JList jList;
    //包含在conMid中的
//    private JLabel jbMidLeft; //歌曲时间
//    private JLabel jbMidRight;
    private JSlider jSliderPlayProgress;
    //包含在conBot中的控件
    private JPanel jpBLeft;
    private JPanel jpBMid;
    private JPanel jpBRight;

    private JLabel jbPricture;//包含在jpBleft
    private JLabel jbInf;

    private JButton open;//包含在jpBMid
    private JButton stop;
    private JButton pre;
    private JButton next;
    private JButton restart;

//    private JButton Volume;//静音，包含在jpBLeft
    private JSlider jSliderVolume;//包


    public MainView(){


        conTop = new Container();
        conTop.setLayout(new BorderLayout());
        conTop.setSize(900,400);

//        jTextArea = new JTextArea();
//        jTextArea.setSize(600, 350);
//        conTop.add(jTextArea, BorderLayout.WEST);

        jbTopLeft = new JLabel(String.valueOf(new String[]{"222222"}));
        jbTopLeft.setPreferredSize(new Dimension(550,400));
//        jbTopLeft.setSize(600,350);
        jbTopLeft.setOpaque(true);
        jbTopLeft.setBackground(Color.GREEN);
        conTop.add(jbTopLeft,BorderLayout.WEST);

        jpList = new JPanel();
        jpList.setPreferredSize(new Dimension(350,400));
        jpList.setOpaque(true);
        PlayList playList = new PlayList();
        jpList.add(playList,BorderLayout.EAST);

//        jList = new JList(new String[]{"2222"});
//        jList.setPreferredSize(new Dimension(350,400));
//        jList.setOpaque(true);
////        jList.setSize(300, 350);
//        jList.setBackground(Color.blue);
//        jList.setFixedCellHeight(40);
//        jList.setFixedCellWidth(250);
//        conTop.add(new JScrollPane(jList), BorderLayout.EAST);

        conMid = new Container();
        conMid.setLayout(new BorderLayout());
        conMid.setSize(900, 20);

        jSliderPlayProgress = new JSlider();
        jSliderPlayProgress.setValue(0);
//        jSliderPlayProgress.setEnabled(false);
        jSliderPlayProgress.setPreferredSize(new Dimension(880, 15));
        conMid.add(jSliderPlayProgress, BorderLayout.NORTH);

        conBot = new Container();
        conBot.setSize(900, 100);
        conBot.setLayout(new BorderLayout());

        jpBLeft = new JPanel();
        jpBLeft.setLayout(new FlowLayout());

        jbPricture = new JLabel(String.valueOf(new String[]{"22"}));
        jbPricture.setPreferredSize(new Dimension(80,80));
//        jbPricture.setSize(160, 160);
        jbPricture.setOpaque(true);
        jbPricture.setBackground(Color.RED);
        jpBLeft.add(jbPricture);

        jbInf = new JLabel(String.valueOf(new String[]{"22"}));
        jbInf.setPreferredSize(new Dimension(80, 80));
//        jbInf.setSize(160, 160);
        jbInf.setOpaque(true);
        jbInf.setBackground(Color.GREEN);
        jpBLeft.add(jbInf);
        conBot.add(jpBLeft,BorderLayout.WEST);

        jpBMid = new JPanel();
        jpBMid.setLayout(new FlowLayout());
        open = new JButton("start");
        stop = new JButton("stop");
        pre = new JButton("pre");
        next = new JButton("next");
        restart = new JButton("restart");
        jpBMid.add(restart);
        jpBMid.add(pre);
        jpBMid.add(open);
        jpBMid.add(stop);
        jpBMid.add(next);
        conBot.add(jpBMid,BorderLayout.CENTER);

        jpBRight = new JPanel();
        jSliderVolume = new JSlider();
        jSliderVolume.setValue(30);
        jSliderVolume.setPreferredSize(new Dimension(100, 20));//设置滚动条长度
        jpBRight.add(jSliderVolume);
        conBot.add(jpBRight,BorderLayout.EAST);

//        conTop.setVisible(true);
//        conMid.setVisible(true);
//        conBot.setVisible(true);

        add(conTop);
        add(conMid);
        add(conBot);

        this.setTitle("音乐播放器");
        this.setLocation(450, 220);
//        this.setLocationRelativeTo(this);
        this.setSize(900,500);
//        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame music =  new MainView();

//        Thread thread = new Thread((Runnable) mainView);
//        thread.start();
//        music.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
