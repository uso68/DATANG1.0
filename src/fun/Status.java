package fun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Status extends JPanel{
	static Status status = new Status();
	String[] gr = {"开元通宝","汇兑","债务","体力","名声"};
	int money = 1000,savings=0,debt=5000,stamina=100,renown=50;
	int[] value = {money,savings,debt,stamina,renown};
	
		int fullstamina,fullrenown;
	
	Status(){
		
		GridLayout grd = new GridLayout(5,2);
		JLabel[] lab1 = new JLabel[5];
		JLabel[] lab2 = new JLabel[5];
		
		Font ft = new Font("",Font.BOLD,16);
		for(int i=0;i<=4;i++) {
			lab1[i] = new JLabel(gr[i],JLabel.CENTER);
			lab2[i] = new JLabel(""+value[i]+"",JLabel.CENTER);
			lab1[i].setFont(ft);
			lab2[i].setFont(ft);
			}
			this.add(lab1[0]);this.add(lab2[0]);
			this.add(lab1[1]);this.add(lab2[1]);
			this.add(lab1[2]);this.add(lab2[2]);
			this.add(lab1[3]);this.add(lab2[3]);
			this.add(lab1[4]);this.add(lab2[4]);
		this.setLayout(grd);
		this.setBounds(250, 420, 300, 300);
		
		this.setBackground(Color.PINK);
		this.setBorder(new TitledBorder("个人状态"));
		this.setVisible(true);
	}
	
}
