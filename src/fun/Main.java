package fun;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Main extends JFrame{
	
	public static void main(String[] args) {
		
		
		JFrame story = new JFrame("剧情概要");
		JPanel jp = new JPanel();
		JTextArea txt = new JTextArea();
		Font ft = new Font("",Font.BOLD,30);
		String title = "大唐浮生记故事简介";
		
		String str = "        "+title+"\n"+"\n"+"        你扮演一个从外地进入长安的青年，开始你只有2000铢通宝，"
				+ "并且还欠地主家5000铢高利贷，欠款会以每天20%的利息滚动增长。"
				+ "好在来长安城经商的人非常多，长安城内有各种各样的商品供你倒买倒卖，"+"\n"
				+ "        你只有50天时间，每次到一个地点计算一天，各种事件接踵而来，好好把握每一次机会，成就你在长安的商界传说。";
		JButton bt = new JButton("进入游戏");
		txt.setText(str);
		txt.setFont(ft);
		txt.setBounds(0, 0, 400, 650);
		txt.setLineWrap(true);
		txt.setForeground(Color.BLUE);
		txt.setBackground(Color.LIGHT_GRAY);
		txt.setEditable(false);
		bt.setFont(new Font("",Font.BOLD,20));
		bt.setBounds(100, 680, 200, 80);
		story.setBounds(800, 100, 400, 800);
		jp.setBounds(0, 0, 400, 800);
		jp.setLayout(null);
		jp.add(txt);
		jp.add(bt);
		
		story.add(jp);
		
		story.setVisible(true);
		story.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				story.dispose();
				MainScreen mainScreen = new MainScreen();
			}
		});
		
	}

}
