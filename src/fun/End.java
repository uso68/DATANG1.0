package fun;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class End extends JFrame{
	JTextField blank;
	Player player = null;
	Rank rank = null;
	List<Entry<String, Integer>> ranklist;
	End(Player player,Rank rank){
		Font ft = new Font("",Font.BOLD,30);
		this.player = player;
		this.rank = rank;
		JFrame txt = new JFrame("请输入您的尊姓大名");
		JButton bt = new JButton("确定");
		JTextField blank = new JTextField();
		JPanel jp = new JPanel();
		txt.setBounds(500, 500, 600, 200);
		jp.setBounds(0, 0, 600, 200);
		bt.setBounds(250, 100, 100, 50);
		blank.setBounds(0, 0, 600, 70);
		blank.setFont(ft);
		blank.setEditable(true);
		jp.setLayout(null);
		jp.add(blank);
		jp.add(bt);
		txt.add(jp);
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = blank.getText();
				int total = player.getRich();
				
				try {
					rank.addEndShow(name, total);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				txt.dispose();
				
			}
		});
		txt.setVisible(true);
		txt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
}
