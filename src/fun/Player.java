package fun;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Player extends JPanel{
	String[] gr = {"开元通宝","汇兑","债务","体力","总资产"};
	String[] unit = {"铢","铢","铢","点","铢"};
	GridLayout grd = new GridLayout(5,2);
	JLabel[] lab1 = new JLabel[5];
	JLabel[] lab2 = new JLabel[5];
	Font ft = new Font("",Font.BOLD,16);
	int money,saves,debt,stamina,totalRich;
	City ct = null;
	Player(){
		money = 2000;
		saves = 0;
		debt = 5000;
		stamina = 100;
		totalRich = money+saves-debt;
		
		
		String Cmoney = String.valueOf(this.money);
		String Csavings = String.valueOf(this.saves);
		String Cdebt = String.valueOf(this.debt);
		String Cstamina = String.valueOf(this.stamina);
		String Ctotal = String.valueOf(this.totalRich);
		
		String[] value = {Cmoney,Csavings,Cdebt,Cstamina,Ctotal};
		
		for(int i=0;i<=4;i++) {
			lab1[i] = new JLabel(gr[i],JLabel.CENTER);
			lab2[i] = new JLabel(value[i]+"  "+unit[i]+"",10);
			lab2[i].setHorizontalAlignment(JTextField.CENTER);
			lab1[i].setFont(ft);
			lab2[i].setFont(ft);
			lab1[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
			lab2[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
			//lab2[i].setEnabled(true);
			this.add(lab1[i]);this.add(lab2[i]);
		}
		
		
		this.setLayout(grd);
		this.setBounds(240, 660, 300, 200);
		
		this.setBackground(Color.lightGray);
		this.setBorder(new TitledBorder("个人状态"));
		
		this.setVisible(true);
	}
	public int getRich() {
		totalRich = money+saves-debt;
		return totalRich;
	}
	public void refresh() {
		
		lab2[0].setText(String.valueOf(money)+" 铢");
		lab2[1].setText(String.valueOf(saves)+" 铢");
		lab2[2].setText(String.valueOf(debt)+" 铢");
		lab2[3].setText(String.valueOf(stamina)+" 点");
		lab2[4].setText(String.valueOf(getRich())+" 铢");
		
	}
}
