package fun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Serv extends JPanel implements ActionListener{
	Store store;
	
	int[] volume = {200,500,1000,2000};
	int[] housePrices = {200000,500000,1000000,2000000};
	Player player;
	//״̬������
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	/**/
	//City cy = new City(null,null,0);

	
	
	
		int fullstamina,fullrenown;
	//�����������
		
		
		String str = "�ؼ�������ȥ��";
		String str1 = "��Ǯû�ط����ǲ�����";
		String str2 = "û����ҽԺ�������ˣ�";
		JSlider account;
		JSlider cash;
		JSlider savemoney;
		JSlider hospital;
		JSlider fz;

		JButton bt1 = new JButton("Ǯׯ");
		JButton bt2 = new JButton("ҽ��");
		JButton bt3 = new JButton("������");
		JButton bt4 = new JButton("����ͷ");
		ImageIcon im1 = new ImageIcon(getClass().getResource("/����1.png"));
		ImageIcon im2 = new ImageIcon(getClass().getResource("/ҽԺ.png"));
		ImageIcon im3 = new ImageIcon(getClass().getResource("/��ծ���.png"));
		ImageIcon im4 = new ImageIcon(getClass().getResource("/����ʩ��ҵ.png"));
		//״̬�����췽��
	Serv(){
		
	}
	
	//����������췽��
	Serv(Player p,Store s){
		GridLayout grd = new GridLayout(4,1,0,40);
		store = s;
		player = p;
		Font ft = new Font("",Font.BOLD,30);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt1.setIcon(im1);
		bt2.setIcon(im2);
		bt3.setIcon(im3);
		bt4.setIcon(im4);
		bt1.setFont(ft);
		bt2.setFont(ft);
		bt3.setFont(ft);
		bt4.setFont(ft);
		this.setLayout(grd);
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(10, 170, 220, 700);
		this.setBorder(new TitledBorder("��������"));
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JButton bt;
		bt = (JButton)e.getSource();
		if(bt==bt1) {
			JFrame frm = new JFrame();
			GridLayout grd = new GridLayout(2, 1);
			frm.setLayout(grd);
			Font ft = new Font("", Font.BOLD, 20);
			JPanel jp1 = new JPanel(new GridLayout(1, 3));
			JPanel jp2 = new JPanel(new GridLayout(2, 1));
			ImageIcon[] im = new ImageIcon[2];
			JLabel[] lab = new JLabel[3];
			String path = "saves.png";
			ImageIcon icon = new ImageIcon(getClass().getResource(path));
			/*lab[i].setIcon(ic[i]);
			lab[i].setSize(ic[i].getIconWidth(),ic[i].getIconHeight());
			lab[i].setText(str[i]);
			lab[i].setVisible(true);*/
			int min,max,totalRich;
			min = player.money;
			max = player.saves;
			totalRich = player.money+player.saves;
			
			account = new JSlider();
			account.setMinimum(-min);
			account.setMaximum(max);

			account.setMinorTickSpacing(50);
			account.setMajorTickSpacing(1000);
			//account.setPaintTicks(true);
			//account.setPaintLabels(true);
			
			lab[0] = new JLabel("�ֽ���"+player.money,JLabel.CENTER);
			lab[1] = new JLabel("�����"+player.saves,JLabel.CENTER);
			
			
			lab[2] = new JLabel(icon);
		/*	lab[2].setIcon(icon);
			lab[2].setSize(icon.getIconWidth(),icon.getIconHeight());
			lab[2].setVisible(true);*/
			lab[0].setFont(ft);
			lab[1].setFont(ft);
			for(int i=0;i<lab.length;i++) {
				lab[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			jp1.add(lab[0]);
			jp1.add(lab[1]);
			jp1.add(lab[2]);
			account.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					int a = account.getValue();	
					int money = 0,saves = 0;
					
					money = player.money + a;
					saves = player.saves - a;
					
						lab[0].setText("�ֽ���"+money);
						lab[1].setText("�����"+saves);
						
						
					
				}
			});
			JButton yes,no;
			
			yes = new JButton("ȷ��");
			yes.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					JButton butt = (JButton) e.getSource();
					if(butt==yes) {
						player.money += account.getValue();
						player.saves -= account.getValue();
						
						player.refresh();
						frm.dispose();
					}
				}

				
			});
			no = new JButton("��������");
			frm.setLayout(new GridLayout(2,1));
			cash = new JSlider();
			cash.setPreferredSize(new Dimension(450, 100));
			cash.setMajorTickSpacing(500);
			cash.setMinorTickSpacing(1);
			cash.setMinimum(0);
			//cash.setMaximum(cashes);
			cash.setPaintTicks(true);
			cash.setPaintLabels(true);
			//cash.setLocation(50, 150);
			savemoney = new JSlider();
			savemoney.setPreferredSize(new Dimension(450, 100));
			savemoney.setMajorTickSpacing(500);
			savemoney.setMinorTickSpacing(1);
			savemoney.setMinimum(0);
		//	savemoney.setMaximum(save);
			savemoney.setPaintTicks(true);
			savemoney.setPaintLabels(true);
			//savings.setLocation(50, 400);
			frm.setLocation(500, 200);
			frm.setSize(900, 500);
			jp1.setSize(900, 250);
			jp1.setBorder(BorderFactory.createLineBorder(Color.black));
			jp2.setSize(900, 250);
			jp2.setBorder(BorderFactory.createLineBorder(Color.black));
			//jp1.add(cash);
			jp2.add(account);
			jp2.add(yes);
			frm.add(jp1);//frm.add(yes);
			frm.add(jp2);//frm.add(no);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setVisible(true);
		}else if(bt==bt2) {
			if(player.money<20000) {
				JOptionPane.showMessageDialog(MainScreen.main
						,"<html><font color="+"blue"+" face ="+"����"+" size="+"5"+">"+str+"</font></html>"
						,"����������"
						, JOptionPane.PLAIN_MESSAGE);
			}else if(player.stamina==100){
				JOptionPane.showMessageDialog(MainScreen.main
						,"<html><font color="+"blue"+" face ="+"����"+" size="+"5"+">"+str2+"</font></html>"
						,"����������"
						, JOptionPane.PLAIN_MESSAGE);
			}else {
			JFrame frm = new JFrame();
			GridLayout grd = new GridLayout(2,1);
			JPanel jp1 = new JPanel(new GridLayout(1,3));
			JPanel jp2 = new JPanel(grd);
			frm.setLayout(grd);
			String path = "hospital.jpg";
			int needStamina = 100-player.stamina;
			int needStaminaMax = player.money/20000;
			int needMoney1 = needStamina*20000;
			int needMoney2 = needStaminaMax*20000;
			
			hospital = new JSlider();
			if(needStamina>needStaminaMax) {
				
				hospital.setMaximum(needStaminaMax);
				lab2 = new JLabel("��Ҫ���ƶ�������"+needStaminaMax+" ��",JLabel.CENTER);
				lab1 = new JLabel("������Ҫ "+needMoney2+" ��",JLabel.CENTER);
			}else if(needStamina<needStaminaMax) {
				hospital.setMaximum(needStamina);
				lab2 = new JLabel("��Ҫ���ƶ�������"+needStamina+" ��",JLabel.CENTER);
				lab1 = new JLabel("������Ҫ "+needMoney1+" ��",JLabel.CENTER);
			}
			
			Font ft  = new Font("",Font.BOLD,20);
			
			
			hospital.setPreferredSize(new Dimension(450, 100));
			hospital.setMajorTickSpacing(10);
			hospital.setMinorTickSpacing(1);	
			//hospital.setPaintTicks(true);
			//hospital.setPaintLabels(true);
			hospital.setMinimum(1);
			
			
			//hospital.setMaximum(cashes);
			hospital.setPaintTicks(true);
			hospital.setPaintLabels(true);
			hospital.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					int a = hospital.getValue();	
					
					lab1.setText("������Ҫ "+a*20000+" ��");
					lab2.setText("��Ҫ���ƶ�������"+a+" ��");
				}
			});
			ImageIcon icon = new ImageIcon(getClass().getResource(path));
			JLabel lab = new JLabel();
			
			lab1.setFont(ft);
			lab2.setFont(ft);
			jp1.add(lab1);
			lab.setIcon(icon);
			lab.setSize(icon.getIconWidth(),icon.getIconHeight());
			lab.setVisible(true);
			jp1.add(lab);
			jp1.add(lab2);
			JButton but = new JButton("ȷ��");
			but.setFont(ft);
			
			but.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					JButton butt = (JButton) e.getSource();
					if(butt==but) {
						player.stamina += hospital.getValue();
						player.money -= hospital.getValue()*20000;
						
						player.refresh();
						frm.dispose();
					}
				}

				
			});
			frm.setLocation(500, 200);
			frm.setSize(700, 600);
			jp1.setSize(700, 300);
			jp2.setSize(700, 300);
			jp1.setBorder(new TitledBorder("ҽ��(�շѱ�׼��20000��/��)"));
			jp2.add(hospital);
			jp2.add(but);
			frm.add(jp1);
			frm.add(jp2);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setVisible(true);}
		}else if(bt==bt3) {
			if(player.debt==0) {
				JOptionPane.showMessageDialog(MainScreen.main
						,"<html><font color="+"blue"+" face ="+"����"+" size="+"5"+">"+str1+"</font></html>"
						,"����������"
						, JOptionPane.PLAIN_MESSAGE);
			}else {
			JFrame frm = new JFrame();
			GridLayout grd = new GridLayout(2, 1);
			frm.setLayout(grd);
			JPanel jp1 = new JPanel(new GridLayout(1,3));
			JPanel jp2 = new JPanel(new GridLayout(2,1));
			String path = "debt.jpg";
			ImageIcon icon = new ImageIcon(getClass().getResource(path));
			int pay = player.money;
			fz = new JSlider();
			if(pay>player.debt) {
				fz.setMaximum(player.debt);
			}else if(pay<=player.debt) {
				fz.setMaximum(pay);
			}
			Font ft = new Font("",Font.BOLD,20);
			JLabel lab = new JLabel();
			JLabel lab1 = new JLabel("Ҫ������: "+pay,JLabel.CENTER);
			JLabel lab2 = new JLabel("ʣ��ծ��: "+player.debt,JLabel.CENTER);
			lab1.setFont(ft);
			lab2.setFont(ft);
			JButton but = new JButton("ȷ��");
			but.setFont(ft);
			
			
			but.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					JButton butt = (JButton) e.getSource();
					if(butt==but) {
						player.money -= fz.getValue();
						player.debt -= fz.getValue();
						player.refresh();
						frm.dispose();
					}
				}

				
			});
			lab.setIcon(icon);
			lab.setSize(icon.getIconWidth(),icon.getIconHeight());
			//lab.setVisible(true);
			jp1.add(lab);
			jp1.add(lab1);
			jp1.add(lab2);
			
			fz.setPreferredSize(new Dimension(450, 100));
			fz.setMajorTickSpacing(500);
			fz.setMinorTickSpacing(1);
			fz.setMinimum(0);
			
			fz.addChangeListener(new ChangeListener() {
				
				public void stateChanged(ChangeEvent e) {
					int a = fz.getValue();	
					lab1.setText("Ҫ������"+a);
					lab2.setText("ʣ��ծ��"+(player.debt-a));
				}
				
			});
			//fz.setPaintTicks(true);
			//fz.setPaintLabels(true);
			
			frm.setBounds(500, 100, 600, 600);
			jp1.setSize(600, 300);
			jp2.setSize(600, 300);
			jp1.setBorder(new TitledBorder("������"));
			jp2.add(fz);
			jp2.add(but);
			frm.add(jp1);
			frm.add(jp2);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setVisible(true);
			}
			
		}else if(bt==bt4){
			String[] str = {"С�ͻ�ջ1000����","���ͻ�ջ2500����","���ͻ�ջ5000����","���ͻ�ջ8000����"};
			JFrame frm = new JFrame();
			
			//GridLayout grd1 = new GridLayout(2, 1);
			frm.setLayout(null);
			GridLayout grd2 = new GridLayout(1, 4);
			GridLayout grd3 = new GridLayout(1, 4,10,0);
			JPanel jp1 = new JPanel();
			jp1.setLayout(grd2);
			JPanel jp2 = new JPanel();
			jp2.setLayout(grd3);
			JButton[] but = new JButton[4];
			String[] stname = {"35�򣬻�ջ����1000����","50�򣬻�ջ����2500����","150�򣬻�ջ����5000����","450�򣬻�ջ����8000����"};
			JLabel[] lab= new JLabel[4];
			String[] path = {
					"/11 - ����.jpg"
					,"/22 - ����.jpg"
					,"/33 - ����.jpg"
					,"/44 - ����.jpg"};
			ImageIcon[] ic = new ImageIcon[4];
			Font ft = new Font("",Font.BOLD,18);
			for(int i=0;i<=3;i++) {
				ic[i] = new ImageIcon(getClass().getResource(path[i]));
				lab[i] = new JLabel();
				lab[i].setIcon(ic[i]);
				lab[i].setSize(ic[i].getIconWidth(),ic[i].getIconHeight());
				/*lab[i].setText(str[i]);*/
				lab[i].setVisible(true);
				jp1.add(lab[i]);
				but[i] = new JButton(stname[i]);
				but[i].setFont(ft);
				but[i].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						JButton butt = (JButton) e.getSource();
						if(butt==but[0]) {
							if(player.money>=350000 && store.warehouse==500) {
								store.warehouse = 1000;
								player.money -= 350000;
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"��ջ������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
								
							}else if(store.warehouse>=1000) {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"�Ѿ���������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"Ǯ�������´������ɡ�"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
						
						}else if(butt==but[1]) {
							if(player.money>=500000 && store.warehouse==1000 | store.warehouse==500) {
								store.warehouse = 2500;
								player.money -= 500000;
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"��ջ������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
								
							}else if(store.warehouse>=2500) {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"�Ѿ���������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"Ǯ�������´������ɡ�"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
						
							
						}else if(butt==but[2]) {
							if(player.money>=1500000 && store.warehouse==2500 | store.warehouse==1000 | store.warehouse==500) {
								store.warehouse = 5000;
								player.money -= 1500000;
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"��ջ������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
								
							}else if(store.warehouse>=5000) {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"�Ѿ���������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"Ǯ�������´������ɡ�"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
						
							
						}else if(butt==but[3]) {
							if(player.money>=4500000 && store.warehouse==5000 | store.warehouse==2500 | store.warehouse==1000 | store.warehouse==500) {
								store.warehouse = 10000;
								player.money -= 4500000;
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"��ջ������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
								
							}else if(store.warehouse>=10000) {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"��Ļ�ջ�Ѿ���ȫ�����ڶ�������"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(MainScreen.main
										,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"Ǯ�������´������ɡ�"+"</font></html>"
										,"����������"
										,JOptionPane.PLAIN_MESSAGE);
							}
							
						}
						store.refresh();
						player.refresh();
					}

					
				});
				jp2.add(but[i]);
			}
			frm.setTitle("������Ļ�ջ");
			frm.setLocation(500, 500);
			frm.setSize(1200, 400);
			jp1.setBounds(50,0,1100,250);
			jp2.setBounds(30,250,1100,100);
			frm.add(jp1);
			frm.add(jp2);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setVisible(true);
			
		}
}
	
	
}
