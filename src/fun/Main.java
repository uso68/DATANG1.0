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
		
		
		JFrame story = new JFrame("�����Ҫ");
		JPanel jp = new JPanel();
		JTextArea txt = new JTextArea();
		Font ft = new Font("",Font.BOLD,30);
		String title = "���Ƹ����ǹ��¼��";
		
		String str = "        "+title+"\n"+"\n"+"        �����һ������ؽ��볤�������꣬��ʼ��ֻ��2000��ͨ����"
				+ "���һ�Ƿ������5000����������Ƿ�����ÿ��20%����Ϣ����������"
				+ "�����������Ǿ��̵��˷ǳ��࣬���������и��ָ�������Ʒ���㵹������"+"\n"
				+ "        ��ֻ��50��ʱ�䣬ÿ�ε�һ���ص����һ�죬�����¼�����������úð���ÿһ�λ��ᣬ�ɾ����ڳ������̽紫˵��";
		JButton bt = new JButton("������Ϸ");
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
