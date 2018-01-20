package fun;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Shop extends JPanel implements ActionListener{
	Player player = null;
	Store store = null;
	String up = "��";
	String down = "��";
	int b,pci;
	int[] v1 = {35,45,50,60,70};
	int[] v2 = {60,70,80,90,100};
	int[] v3 = {10,20,30,40,60};
	int[] v4 = {40,50,65,100,150};
	int[] v5 = {160,180,200,240,300};
	int[] v6 = {350,400,500,600,800};
	int[] v7 = {400,600,700,900,1000};
	int[] v8 = {160,190,220,280,350};
	int[] v9 = {650,700,850,1050,1200};
	int[] v10 = {50,80,100,150,180};
	int[] v11 = {800,930,1000,1250,1400};
	int[] v12 = {600,750,800,950,1050};
	int[] v13 = {560,650,780,890,1040};
	int[] v14 = {1060,1200,1500,1750,1960};
	Random r = new Random();
	int rv = r.nextInt(4);
	
	static String[] GoodsNames = {"˿��","����","��Ҷ",
		"��˿","��֬","��ƥ",
		"����","��֦","��˹��",
		"��ʳ","��Ƥ","����",
		"¹��","������"};
	int[] prices = {50,80,30,
			65,200,500,
			700,220,850,
			100,1000,800,
			650,1500};
	String[] head = {"����","�۸�"};
	//JTextField[] txt = new JTextField[15];
	
	JLabel head2 = new JLabel(""+head[0]+"",JLabel.CENTER);
	JLabel head3 = new JLabel(""+head[1]+"",JLabel.CENTER);
	//JLabel head4 = new JLabel("sss",JLabel.CENTER);
	JLabel[] name = new JLabel[14];
	JLabel[] pricelab = new JLabel[14];
	//JLabel[] but = new JLabel[14];
	Font ft = new Font("",Font.BOLD,16);
	JButton[] bt = new JButton[2];
	String[] str = {"���ͼ������","��    ��"};
	
	JButton yes = new JButton("ȷ��");
	JButton no = new JButton("ȡ��");
	ButtonGroup bgp = new ButtonGroup();
	ImageIcon[] im = new ImageIcon[14];
	String[] path = {
			 "/˿��.png"
			,"/�մ���.png"
			,"/��Ҷ.png"
			,"/��˿����.png"
			,"/��ױ3.png"
			,"/��.png"
			,"/��.png"
			,"/��֦.png"
			,"/��.png"
			,"/��ʳ.png"
			,"/����.png"
			,"/¹.png"
			,"/szxdf-ʥ��¹��1.png"
			,"/�˲�.png"
	};
	
	JRadioButton[] jrb = new JRadioButton[14];
	JLabel[] lab = new JLabel[14];
	Shop(Player p,Store st){
		player = p;store = st;
		
		this.setLayout(new GridLayout(17,2));
		head2.setFont(ft);
		head3.setFont(ft);
		
		head2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		head3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(head2);this.add(head3);
		Font ft = new Font("",Font.BOLD,16);
		
		
		for(int i=0;i<=13;i++) {
			im[i] = new ImageIcon(getClass().getResource(path[i]));
			jrb[i] = new JRadioButton(""+Shop.GoodsNames[i]+"");
			jrb[i].setIcon(im[i]);
			jrb[i].setFont(ft);
			lab[i] = new JLabel(""+prices[i]+"",JLabel.CENTER);
			lab[i].setFont(ft);
			lab[i].setBorder(BorderFactory.createLineBorder(Color.black));
			jrb[i].setBackground(Color.white);
			jrb[i].addActionListener(this);
			bgp.add(jrb[i]);
			
			this.add(jrb[i]);this.add(lab[i]);
			}
		
		bt[0] = new JButton(""+str[0]+"");
		bt[1] = new JButton(""+str[1]+"");
		bt[0].setFont(ft);
		bt[1].setFont(ft);
		bt[0].addActionListener(this);
		bt[1].addActionListener(this);
		this.add(bt[0]);this.add(bt[1]);
		this.setBounds(240, 170, 300, 520);
		this.setBackground(Color.WHITE);
		this.setBorder(new TitledBorder("��Ʒ"));
		this.setVisible(true);
	}
	public int getPrice(String s) {
		for(int i=0;i<GoodsNames.length;i++) {
			if(GoodsNames[i]==s) {
				return prices[i];
			}
		}
		return 0;
		
		
	}
	public void refresh() {
		for(int i=0;i<prices.length;i++) {
			if(lab[i]==null) {
				
				lab[i] = new JLabel();
			
			}
				
				lab[i].setText(String.valueOf(prices[i]));
		}
	}
	
	int price = 0;
	
	public void actionPerformed(ActionEvent e) {
		
		JRadioButton but = (JRadioButton)e.getSource();
		String temp = but.getText();
		JButton aa;
		
		JSlider js = new JSlider();
		JLabel[] lab = new JLabel[3];
		int max = 0;
		Font ft = new Font("",Font.BOLD,20);
		JFrame frm = new JFrame();
		JButton bt = new JButton("ȷ������");
		for(int i=0;i<prices.length;i++) {
			if(but==jrb[i]) {
				price = prices[i];
				if(store.currhouse==0&&player.money/prices[i]<store.warehouse) {
					max = player.money/prices[i];
					js.setMaximum(max);
				}else if(store.currhouse==0&&player.money/prices[i]>store.warehouse) {
					max = store.warehouse;
					js.setMaximum(max);
				}else if(store.currhouse!=0&&player.money/prices[i]>store.warehouse-store.currhouse) {
					max = store.warehouse-store.currhouse;
					js.setMaximum(max);
				}else if(store.currhouse!=0&&player.money/prices[i]<store.warehouse-store.currhouse)
					max = player.money/prices[i];
					js.setMaximum(max);
				break;
			}
		}
		lab[0] = new JLabel("��ǰ�ֽ�:"+player.money+" ��  ",JLabel.CENTER);
		lab[1] = new JLabel("��ǰ�ɹ�������:"+max+"",JLabel.CENTER);
		lab[2] = new JLabel("Ŀǰѡ����:"+max/2+" ��Ҫ��"+(max/2)*price+" ��",JLabel.CENTER);
		lab[0].setFont(ft);
		lab[1].setFont(ft);
		lab[0].setBounds(0, 0, 400,60);
		lab[1].setBounds(0, 60, 400, 60);
		lab[0].setBorder(BorderFactory.createLineBorder(Color.black));
		lab[1].setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp2.setLayout(null);
		frm.setLayout(new GridLayout(2, 1));
		frm.setBounds(950, 550, 420, 400);
		js.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int a = js.getValue();	
				lab[1].setText("Ŀǰѡ����:"+a+" ��  ��Ҫ��"+a*price+" ��");
			}
		});
		js.setPreferredSize(new Dimension(350, 300));				
		js.setMinimum(0);
		//js.setMajorTickSpacing(100);
		//js.setMinorTickSpacing(10);
		//js.setPaintTicks(true);
		//js.setPaintLabels(true);
		js.setVisible(true);
		jp2.add(lab[0]);
		jp2.add(lab[1]);
		jp1.setLayout(new GridLayout(2,1));
		jp1.add(js);
		bt.setFont(ft);
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JButton btt = (JButton)arg0.getSource();
				if(btt==bt) {
					
					String goodName = but.getText();
					int number = js.getValue();
					int sum = price*number;
					player.money -= sum;
					player.refresh();
					boolean get = store.buy(goodName, price, number);
					if(!get) {
						JOptionPane.showMessageDialog(MainScreen.main
								,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+"�ֿ�Ų�����"+"</font></html>"
								,"�ֿ�"
								,JOptionPane.PLAIN_MESSAGE);
					}
					frm.setVisible(false);
					frm.dispose();
					
				}
			}
		});
		jp1.add(bt);
		jp1.setBounds(0, 0, 400, 200);
		jp2.setBounds(200, 0, 400, 200);
		frm.add(jp2);
		frm.add(jp1);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
		
}

	
