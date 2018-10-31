package GUI.test;

import javax.swing.*;

public class TestGUI {

    public static void main(String[] args) {
        //主窗体
        JFrame f = new JFrame("窗体名字");
        //主窗体大小
        f.setSize(640, 360);
        //主窗体位置
        f.setLocation(200, 200);
        //主窗体中的组件位置为绝对定位
        f.setLayout(null);
        //按钮组件
        JButton b = new JButton("按钮内容");
        //同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);
        //把按钮加入到主窗体中
        f.add(b);
        //关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ;
        //让窗体变得可见
        f.setVisible(true);
    }
}
