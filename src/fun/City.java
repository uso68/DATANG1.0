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
	//String str132 = "40天后，你还清了债务，还赚了一大笔钱"+player.totalRich+",凭着这一大笔钱你成为了长安一霸。。。。。。";
	int b;
	String[] str = 
		{
			"遭地痞勒索，开元通宝损失10%。"//0
			,"回纥商队到访长安，市面上到处都是马匹出售。"//1
			,"皇帝面向民间选妃，民众争相参加，胭脂价格暴涨。"//2
			,"东瀛商人来长安收购茶叶。"//3
			,"宫中贵妃想吃荔枝了。"//4
			,"吐蕃商队进入长安,丝绸、荔枝、蚕丝价格上涨。"//5
			,"外头疯传高丽参大补。"//6
			,"坊间流传补肾妙方，鹿茸抢手。"//7
			,"波斯商人到访长安，丝绸、瓷器、茶叶走俏（波斯枣暴跌）。"//8
			,"遭地痞围殴，体力下降20点。"//9
			,"大量靺鞨商人来访长安（貂皮，麝香暴跌、蚕丝暴涨）"//10
			,"唐军与突厥军队发生激战，急购武器与马匹。"//11
			,"地主派人和你说，你家又找他们家借了粮，负债增加。"//12
			,"皇宫举办庆典，置办物资，市场商品普涨。"//13
			,"逛市场被人撞了一下，开元通宝损失5%。"//14
			,"黄河决堤，大量难民涌入长安（粮食涨价）。"//15
			,"粮食丰收了"//16
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
				"开远门","皇城大门","兴庆宫",
				"东市","朱雀街","西市",
				"金光门","驿馆","大慈恩寺",
				"延平门","明德门","曲江池",};
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
		this.setBorder(new TitledBorder("长安  第"+count+"天"));
		this.setVisible(true);
	}
	void setMain(MainScreen m) {
		main = m;
	}
	
	void addCount() {
		player.debt *= 1.2;
		player.refresh();
		count++;
		this.setBorder(new TitledBorder("长安  第"+count+"天"));

		
		
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
		
		shop.prices[0] = rp.nextInt(21)+40;//丝绸
		shop.prices[1] = rp.nextInt(21)+80;//瓷器
		shop.prices[2] = rp.nextInt(21)+20;//茶叶
		shop.prices[3] = rp.nextInt(31)+50;//蚕丝
		shop.prices[4] = rp.nextInt(61)+170;//胭脂
		shop.prices[5] = rp.nextInt(201)+400;//马匹
		shop.prices[6] = rp.nextInt(201)+600;//宝剑
		shop.prices[7] = rp.nextInt(81)+180;//荔枝
		shop.prices[8] = rp.nextInt(101)+800;//波斯枣
		shop.prices[9] = rp.nextInt(41)+80;//粮食
		shop.prices[10] = rp.nextInt(101)+950;//貂皮
		shop.prices[11] = rp.nextInt(101)+750;//麝香
		shop.prices[12] = rp.nextInt(101)+600;//鹿茸
		shop.prices[13] = rp.nextInt(401)+1300;//高丽参
			
		shop.refresh();
		
		
		JOptionPane.showMessageDialog(MainScreen.main
				,"<html><font color="+"blue"+" face ="+"宋体"+" size="+"10"+">"+str[a]+"</font></html>"
				,"大唐新闻网"
				,JOptionPane.PLAIN_MESSAGE,im[a]);
		
		switch(a) {
			case 0:{//现金被偷
				player.money -= player.money*0.1;
				player.refresh();
				break;
			}
			case 1:{//马跌价,茶叶、丝绸、瓷器涨价
				shop.prices[5] -= shop.prices[5]*0.5;
				shop.prices[0] += shop.prices[0]*5.5;
				shop.prices[1] += shop.prices[1]*3.5;
				shop.prices[2] += shop.prices[2]*4.5;
				shop.refresh();
				break;
			}
			case 2:{//胭脂涨价
				shop.prices[4] += shop.prices[4]*4;
				shop.refresh();
				break;
			}
			case 3:{//东瀛商队来访，茶叶、丝绸、瓷器涨价
				shop.prices[0] += shop.prices[0]*4.5;
				shop.prices[1] += shop.prices[1]*2.5;
				shop.prices[2] += shop.prices[2]*3.5;
				shop.refresh();
				break;
			}
			case 4:{//荔枝涨价
				shop.prices[7] += shop.prices[7]*3.5;
				shop.refresh();
				break;
			}
			case 5:{//吐蕃商队进入，蚕丝、荔枝、丝绸涨
				shop.prices[3] += shop.prices[3]*3;
				shop.prices[0] += shop.prices[0]*4;
				shop.prices[7] += shop.prices[7]*2.5;
				shop.refresh();
				break;			
			}
			case 6:{//高丽参大涨
				shop.prices[13] += shop.prices[13]*5.5;
				shop.refresh();
				break;			
			}
			case 7:{//鹿茸大涨
				shop.prices[12] += shop.prices[12]*3.5;
				shop.refresh();
				break;			
			}
			case 8:{//茶叶瓷器丝绸大涨，波斯枣跌
				shop.prices[0] += shop.prices[0]*3;
				shop.prices[1] += shop.prices[1]*4;
				shop.prices[2] += shop.prices[2]*5;
				shop.prices[8] -= shop.prices[8]*0.75;
				shop.refresh();
				break;			
			}
			case 9:{//体力下降20点
				player.stamina -= 20;
				if(player.stamina<=50) {
					JOptionPane.showMessageDialog(MainScreen.main
							,"你在长安街头已经奄奄一息（体力低于50），“好心的”地主把你送去医馆并且帮你垫付了一笔医药费（负债加200000铢）"
							,"大唐新闻网"
							,JOptionPane.PLAIN_MESSAGE);
					player.stamina = 60;
					player.debt += 200000;
					
				}
				
				player.refresh();
				break;			
			}
			case 10:{//貂皮，麝香暴跌，蚕丝涨价
				shop.prices[10] -= shop.prices[10]*0.7;
				shop.prices[11] -= shop.prices[11]*0.7;
				shop.prices[0] += shop.prices[0]*5;
				shop.prices[1] += shop.prices[1]*4;
				shop.prices[2] += shop.prices[2]*5;
				shop.prices[3] += shop.prices[3]*4;
				shop.refresh();
				break;			
			}
			case 11:{//武器、马匹大涨
				shop.prices[5] += shop.prices[5]*4;
				shop.prices[6] += shop.prices[6]*4;
				shop.refresh();
				break;			
			}
			case 12:{//负债增加
				player.debt += player.debt*0.5;
				if(player.debt<=1000) {
					player.debt += 25000;
				}
				player.refresh();
				break;			
			}
			case 13:{//14皇宫举办庆典，所有商品普涨
				/*player.money += player.money*0.03;
				player.refresh();*/
				for(int i=0;i<shop.prices.length;i++) {
					shop.prices[i] += shop.prices[i]*0.35;
				}
				shop.refresh();
				break;			
			}
			case 14:{//15现金减少
				
				player.money -= player.money*0.05;
				player.refresh();
				break;			
			}
			case 15:{//16粮食涨价
				shop.prices[9] += shop.prices[9]*5;
				shop.refresh();
				break;			
			}
			case 16:{//17粮食丰收
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
			String str1 = "你的总资产达到：  "+total+" 铢，凭借出色的商业头脑，\n你成为商业巨贾，你的事迹也传遍了长安城，\n受到当朝皇帝的召见，你成为长安城的一代商业传奇。";
			String str2 = "你的总资产达到：  "+total+" 铢，此后，你的生意越做越大，\n最终成立“泰丰钱庄”，成为长安城最大的财阀。";
			String str3 = "你的总资产达到：  "+total+" 铢，债务还清以后，还大赚了一笔，\n并与官府合作成立“龙远镖局”，\n商队远达西域。";
			String str4 = "你的总资产达到：  "+total+" 铢，你还清了债务，并且还小赚了一笔，\n凭着这笔钱，你在村里盖了房，\n置了田地，娶了媳妇。";
			String str5 = "呵呵，50天过去了，你没能还清欠款，\n沦为地主家的长工，\n某天你不堪忍受地主的欺凌，趁着夜色偷偷溜走，奔着边塞投军去了。";
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
						,"大唐新闻网"
						,JOptionPane.PLAIN_MESSAGE,im1);
						
			}else if(total<100000000&&total>=10000000) {
				JOptionPane.showMessageDialog(MainScreen.main
						,str2
						,"大唐新闻网"
						,JOptionPane.PLAIN_MESSAGE,im2);
						
			}else if(total<10000000&&total>=1000000) {
				JOptionPane.showMessageDialog(MainScreen.main
						,str3
						,"大唐新闻网"
						,JOptionPane.PLAIN_MESSAGE,im3);
						
			}else if(total<1000000&&total>0) {
				JOptionPane.showMessageDialog(MainScreen.main
						,str4
						,"大唐新闻网"
						,JOptionPane.PLAIN_MESSAGE,im4);
						
			}else if(total<0){
				
				JOptionPane.showMessageDialog(MainScreen.main
						,str5
						,"大唐新闻网"
						,JOptionPane.PLAIN_MESSAGE,im5);
			}
			
				End end = new End(player, rank);
			
		}
		

	}
	
}
