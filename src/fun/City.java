package fun;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class City extends JPanel implements ActionListener{
	Player player = null;
	Shop shop = null;
	Store store = null;
	MainScreen main = null;
	Rank rank = new Rank();
	List<Entry<String, Integer>> ranklist;
	int count = 1;
	//String str132 = "40����㻹����ծ�񣬻�׬��һ���Ǯ"+player.totalRich+",ƾ����һ���Ǯ���Ϊ�˳���һ�ԡ�����������";
	int b;
	String[] str = 
		{
			"���Ʀ��������Ԫͨ����ʧ10%��"//0
			,"�����̶ӵ��ó����������ϵ���������ƥ���ۡ�"//1
			,"�ʵ��������ѡ������������μӣ���֬�۸��ǡ�"//2
			,"��������������չ���Ҷ��"//3
			,"���й��������֦�ˡ�"//4
			,"��ެ�̶ӽ��볤��,˿����֦����˿�۸����ǡ�"//5
			,"��ͷ�贫�����δ󲹡�"//6
			,"���������������¹�����֡�"//7
			,"��˹���˵��ó�����˿�񡢴�������Ҷ���Σ���˹�汩������"//8
			,"���ƦΧŹ�������½�20�㡣"//9
			,"������H�������ó�������Ƥ�����㱩������˿���ǣ�"//10
			,"�ƾ���ͻ�ʾ��ӷ�����ս��������������ƥ��"//11
			,"�������˺���˵������������Ǽҽ���������ծ���ӡ�"//12
			,"�ʹ��ٰ���䣬�ð����ʣ��г���Ʒ���ǡ�"//13
			,"���г�����ײ��һ�£���Ԫͨ����ʧ5%��"//14
			,"�ƺӾ��̣���������ӿ�볤������ʳ�Ǽۣ���"//15
			,"��ʳ������"//16
		};
	String[] path = 
		{	
				 "/e1.jpg"
				,"/e2.jpg"
				,"/e3.jpg"
				,"/e4.jpg"
				,"/e5.jpg"
				,"/e6.jpg"
				,"/e7.jpg"
				,"/e8.jpg"
				,"/e9.jpg"
				,"/e10.jpg"
				,"/e11.jpg"
				,"/e12.jpg"
				,"/e13.jpg"
				,"/e14.jpg"
				,"/e15.jpg"
				,"/e16.jpg"
				,"/e17.jpg"
			
	};
	Icon[] im = new ImageIcon[17];
	
	City(Player p, Shop s){
		player = p;
		shop = s;
		GridLayout grd = new GridLayout(4, 3,10,30);
		JButton[] bt = new JButton[12];
		String[] CSname = {
				"��Զ��","�ʳǴ���","���칬",
				"����","��ȸ��","����",
				"�����","���","��ȶ���",
				"��ƽ��","������","������",};
		Font ft = new Font("",Font.BOLD,20);
		for(int i=0;i<=11;i++) {
			bt[i] = new JButton(CSname[i]+"");
			bt[i].setFont(ft);
			bt[i].addActionListener(this);
			
		}
		this.setLayout(grd);
		this.setBounds(550, 490, 400, 380);
		this.add(bt[0]);this.add(bt[1]);this.add(bt[2]);
		this.add(bt[3]);this.add(bt[4]);this.add(bt[5]);
		this.add(bt[6]);this.add(bt[7]);this.add(bt[8]);
		this.add(bt[9]);this.add(bt[10]);this.add(bt[11]);
		//this.setCount(count);
		this.setBorder(new TitledBorder("����  ��"+count+"��"));
		this.setVisible(true);
	}
	void setMain(MainScreen m) {
		main = m;
	}
	
	void addCount() {
		player.debt *= 1.2;
		player.refresh();
		count++;
		this.setBorder(new TitledBorder("����  ��"+count+"��"));

		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		Random r = new Random();
		Random rp = new Random();
		//double b = 0.045;
		//boolean upORdown = rp.nextBoolean();
		int suiji = r.nextInt(4);
		int a = r.nextInt(str.length);
		/*runIcon = new ImageIcon(getClass().getResource("/images/connect.gif"));*/
		im[a] = new ImageIcon(getClass().getResource(path[a]));
		
		shop.prices[0] = rp.nextInt(21)+40;//˿��
		shop.prices[1] = rp.nextInt(21)+80;//����
		shop.prices[2] = rp.nextInt(21)+20;//��Ҷ
		shop.prices[3] = rp.nextInt(31)+50;//��˿
		shop.prices[4] = rp.nextInt(61)+170;//��֬
		shop.prices[5] = rp.nextInt(201)+400;//��ƥ
		shop.prices[6] = rp.nextInt(201)+600;//����
		shop.prices[7] = rp.nextInt(81)+180;//��֦
		shop.prices[8] = rp.nextInt(101)+800;//��˹��
		shop.prices[9] = rp.nextInt(41)+80;//��ʳ
		shop.prices[10] = rp.nextInt(101)+950;//��Ƥ
		shop.prices[11] = rp.nextInt(101)+750;//����
		shop.prices[12] = rp.nextInt(101)+600;//¹��
		shop.prices[13] = rp.nextInt(401)+1300;//������
			
		shop.refresh();
		
		
		JOptionPane.showMessageDialog(MainScreen.main
				,"<html><font color="+"blue"+" face ="+"����"+" size="+"10"+">"+str[a]+"</font></html>"
				,"����������"
				,JOptionPane.PLAIN_MESSAGE,im[a]);
		
		switch(a) {
			case 0:{//�ֽ�͵
				player.money -= player.money*0.1;
				player.refresh();
				break;
			}
			case 1:{//�����,��Ҷ��˿�񡢴����Ǽ�
				shop.prices[5] -= shop.prices[5]*0.5;
				shop.prices[0] += shop.prices[0]*5.5;
				shop.prices[1] += shop.prices[1]*3.5;
				shop.prices[2] += shop.prices[2]*4.5;
				shop.refresh();
				break;
			}
			case 2:{//��֬�Ǽ�
				shop.prices[4] += shop.prices[4]*4;
				shop.refresh();
				break;
			}
			case 3:{//����̶����ã���Ҷ��˿�񡢴����Ǽ�
				shop.prices[0] += shop.prices[0]*4.5;
				shop.prices[1] += shop.prices[1]*2.5;
				shop.prices[2] += shop.prices[2]*3.5;
				shop.refresh();
				break;
			}
			case 4:{//��֦�Ǽ�
				shop.prices[7] += shop.prices[7]*3.5;
				shop.refresh();
				break;
			}
			case 5:{//��ެ�̶ӽ��룬��˿����֦��˿����
				shop.prices[3] += shop.prices[3]*3;
				shop.prices[0] += shop.prices[0]*4;
				shop.prices[7] += shop.prices[7]*2.5;
				shop.refresh();
				break;			
			}
			case 6:{//�����δ���
				shop.prices[13] += shop.prices[13]*5.5;
				shop.refresh();
				break;			
			}
			case 7:{//¹�״���
				shop.prices[12] += shop.prices[12]*3.5;
				shop.refresh();
				break;			
			}
			case 8:{//��Ҷ����˿����ǣ���˹���
				shop.prices[0] += shop.prices[0]*3;
				shop.prices[1] += shop.prices[1]*4;
				shop.prices[2] += shop.prices[2]*5;
				shop.prices[8] -= shop.prices[8]*0.75;
				shop.refresh();
				break;			
			}
			case 9:{//�����½�20��
				player.stamina -= 20;
				if(player.stamina<=50) {
					JOptionPane.showMessageDialog(MainScreen.main
							,"���ڳ�����ͷ�Ѿ�����һϢ����������50���������ĵġ�����������ȥҽ�ݲ��Ұ���渶��һ��ҽҩ�ѣ���ծ��200000����"
							,"����������"
							,JOptionPane.PLAIN_MESSAGE);
					player.stamina = 60;
					player.debt += 200000;
					
				}
				
				player.refresh();
				break;			
			}
			case 10:{//��Ƥ�����㱩������˿�Ǽ�
				shop.prices[10] -= shop.prices[10]*0.7;
				shop.prices[11] -= shop.prices[11]*0.7;
				shop.prices[0] += shop.prices[0]*5;
				shop.prices[1] += shop.prices[1]*4;
				shop.prices[2] += shop.prices[2]*5;
				shop.prices[3] += shop.prices[3]*4;
				shop.refresh();
				break;			
			}
			case 11:{//��������ƥ����
				shop.prices[5] += shop.prices[5]*4;
				shop.prices[6] += shop.prices[6]*4;
				shop.refresh();
				break;			
			}
			case 12:{//��ծ����
				player.debt += player.debt*0.5;
				if(player.debt<=1000) {
					player.debt += 25000;
				}
				player.refresh();
				break;			
			}
			case 13:{//14�ʹ��ٰ���䣬������Ʒ����
				/*player.money += player.money*0.03;
				player.refresh();*/
				for(int i=0;i<shop.prices.length;i++) {
					shop.prices[i] += shop.prices[i]*0.35;
				}
				shop.refresh();
				break;			
			}
			case 14:{//15�ֽ����
				
				player.money -= player.money*0.05;
				player.refresh();
				break;			
			}
			case 15:{//16��ʳ�Ǽ�
				shop.prices[9] += shop.prices[9]*5;
				shop.refresh();
				break;			
			}
			case 16:{//17��ʳ����
				shop.prices[9] -= shop.prices[9]*0.7;
				shop.refresh();
				break;			
			}			
			default:{
				break;
			}
		}
		addCount();
	
		if(count==50) {
			int total = player.getRich();
			String str = String.valueOf(total);
			String str1 = "������ʲ��ﵽ��  "+total+" ����ƾ���ɫ����ҵͷ�ԣ�\n���Ϊ��ҵ�޼֣�����¼�Ҳ�����˳����ǣ�\n�ܵ������ʵ۵��ټ������Ϊ�����ǵ�һ����ҵ���档";
			String str2 = "������ʲ��ﵽ��  "+total+" �����˺��������Խ��Խ��\n���ճ�����̩��Ǯׯ������Ϊ���������ĲƷ���";
			String str3 = "������ʲ��ﵽ��  "+total+" ����ծ�����Ժ󣬻���׬��һ�ʣ�\n����ٸ�������������Զ�ھ֡���\n�̶�Զ������";
			String str4 = "������ʲ��ﵽ��  "+total+" �����㻹����ծ�񣬲��һ�С׬��һ�ʣ�\nƾ�����Ǯ�����ڴ�����˷���\n������أ�Ȣ��ϱ����";
			String str5 = "�Ǻǣ�50���ȥ�ˣ���û�ܻ���Ƿ�\n��Ϊ�����ҵĳ�����\nĳ���㲻�����ܵ��������裬����ҹɫ͵͵���ߣ����ű���Ͷ��ȥ�ˡ�";
			String path1 = "/end1.jpg";
			String path2 = "/end2.jpg";
			String path3 = "/end3.jpg";
			String path4 = "/end4.jpg";
			String path5 = "/end5.jpg";
			Icon im1 = new ImageIcon(getClass().getResource(path1));
			Icon im2 = new ImageIcon(getClass().getResource(path2));
			Icon im3 = new ImageIcon(getClass().getResource(path3));
			Icon im4 = new ImageIcon(getClass().getResource(path4));
			Icon im5 = new ImageIcon(getClass().getResource(path5));
			JLabel lab = new JLabel();
			Font ft = new Font("",Font.BOLD,15);
			lab.setFont(ft);
			
			if(total>=100000000) {
			JOptionPane.showMessageDialog(MainScreen.main
						,str1
						,"����������"
						,JOptionPane.PLAIN_MESSAGE,im1);
						
			}else if(total<100000000&&total>=10000000) {
				JOptionPane.showMessageDialog(MainScreen.main
						,str2
						,"����������"
						,JOptionPane.PLAIN_MESSAGE,im2);
						
			}else if(total<10000000&&total>=1000000) {
				JOptionPane.showMessageDialog(MainScreen.main
						,str3
						,"����������"
						,JOptionPane.PLAIN_MESSAGE,im3);
						
			}else if(total<1000000&&total>0) {
				JOptionPane.showMessageDialog(MainScreen.main
						,str4
						,"����������"
						,JOptionPane.PLAIN_MESSAGE,im4);
						
			}else if(total<0){
				
				JOptionPane.showMessageDialog(MainScreen.main
						,str5
						,"����������"
						,JOptionPane.PLAIN_MESSAGE,im5);
			}
			
				End end = new End(player, rank);
			
		}
		

	}
	
}
