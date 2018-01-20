package fun;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Store extends JPanel{
	private Shop shop = null;
	
	int warehouse = 500;
	int currhouse = 0;
	int oldnumbers;
	private Player player ;
	String[] name = {"商品","买入价格","数量"};
	
	JLabel lab1 = new JLabel("商品",JLabel.CENTER);
	JLabel lab2 = new JLabel("买入价格",JLabel.CENTER);
	JLabel lab3 = new JLabel("数量",JLabel.CENTER);
	JLabel[] labs = new JLabel[12];
	
	DefaultTableModel model = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
		return false;
		}
	}; 
	JTable tbh = new JTable(model);
	List<Map<String,Integer>> mainlist = new ArrayList<Map<String,Integer>>();
	
	Vector names = new Vector();
	
	public void refresh() {
		
		tbh.removeAll();
		Vector data = new Vector();
		
		for(Map<String,Integer> m:mainlist) {
			Vector row = new Vector();
			
			row.add(Shop.GoodsNames[m.get("商品")]);
			row.add(m.get("买入价格"));
			row.add(m.get("数量"));
			data.add(row);
			
		}
		this.setBorder(new TitledBorder("货栈    "+currhouse+" / "+warehouse));
		model.setDataVector(data, names);
	}
	
	
	Store(Player p){
		
		player = p;
		Map<String,Integer> m = new HashMap<String,Integer>();
		/*m.put("商品",1);
		m.put("买入价格", 50);
		m.put("数量", 30);
		mainlist.add(m);*/
		m = new HashMap<String,Integer>();
		/*m.put("商品",2);
		m.put("买入价格", 30);
		m.put("数量", 20);
		mainlist.add(m);*/
		names.add("商品");
		names.add("买入价格");
		names.add("数量");
		model.setDataVector(new Vector(), names);
		this.setLayout(null);
		JPanel jp = new JPanel();
		jp.setBounds(1, 25, 330, 300);
		tbh.getTableHeader().setFont(new Font("",0,15));
		tbh.setFont(new Font("",0,13));
		tbh.setRowHeight(16);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		tbh.setDefaultRenderer(Object.class, r);
		JScrollPane ps = new JScrollPane(tbh);
		ps.setBounds(30, 40, 350, 249);
		JLabel lab = new JLabel("货栈当前容量: "+warehouse+" 单位",JLabel.CENTER);
		Font ft = new Font("",Font.BOLD,16);
		lab.setFont(ft);
		
		tbh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbh.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ee) {
				int selectedrow = tbh.getSelectedRow();
				int max;
				JSlider js = new JSlider();
				
				Object a = model.getValueAt(selectedrow, 0);
				Object b = model.getValueAt(selectedrow, 1);
				Object c = model.getValueAt(selectedrow, 2);
				Object d = model.getValueAt(selectedrow, 0);
				Object e = model.getValueAt(selectedrow, 0);
				Object f = model.getValueAt(selectedrow, 0);
				int presentPriceI = shop.getPrice(a.toString());
				String presentPrice = String.valueOf(presentPriceI);
				int totalPriceI = presentPriceI*Integer.valueOf(c.toString());
				String totalPrice = String.valueOf(totalPriceI);
				String[] abcdef = {a.toString(),b.toString(),c.toString(),"",presentPrice,""};
				String[] str = {"商品名称：  ","买入价格：  ","商品库存总量：","","当前价格：","卖出总价："};
				JFrame frm = new JFrame();
				frm.setLayout(new GridLayout(2,1));
				JPanel jp1 = new JPanel();
				jp1.setLayout(new GridLayout(2,3));
				JPanel jp2 = new JPanel();
				jp2.setLayout(new GridLayout(2,1));
				
				JLabel[] labs = new JLabel[6];
				JButton bt = new JButton("确定卖出");
				
				frm.setBounds(400, 400, 500, 400);
				class sell implements ActionListener{		

					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton but = (JButton) e.getSource();
						if(bt==but) {
							int sellnumber = js.getValue();
							
							Map<String,Integer> sellgoods = mainlist.get(selectedrow);
							int remain =sellgoods.get("数量") - sellnumber;
							if(remain==0) {
								mainlist.remove(selectedrow);
							}else {
							sellgoods.put("数量", remain);
							}
							
							player.money += sellnumber*presentPriceI;
							currhouse -= sellnumber;
							refresh();
							
							player.refresh();
							
							
							frm.dispose();
						}
						
					}
				}
				bt.addActionListener(new sell());
				
				for(int i=0;i<=5;i++) {
					labs[i] = new JLabel(""+str[i]+""+abcdef[i]+"",JLabel.CENTER);
					labs[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
					labs[i].setFont(ft);
					jp1.add(labs[i]);
				}
				js.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						int a = js.getValue();	
						labs[3].setText("目前选择量:"+a+" 个");
						labs[5].setText("卖出总价："+a*presentPriceI);
						
					}
				});
				
				max = Integer.parseInt(c.toString());
				
				js.setMaximum(max);
				
				js.setMinimum(0);
				js.setMajorTickSpacing(100);
				js.setMinorTickSpacing(1);
				//js.setPaintTicks(true);
				//js.setPaintLabels(true);
				js.setVisible(true);
				jp2.add(js);
				jp2.add(bt);
				frm.add(jp1);
				frm.add(jp2);
				frm.setVisible(true);
				frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		this.add(ps);
		this.setBackground(Color.orange);
		this.setBounds(550, 180, 400, 310);
		this.setBorder(new TitledBorder("货栈    "+currhouse+" / "+warehouse));
		this.setVisible(true);
		this.refresh();
	}
	void setStore(Shop sp) {
		shop = sp;
		
	}

	public boolean buy(String name,int p,int n) {
		if(currhouse+n>warehouse) {
			return false;
		}
		int index=0;
		for(int i=0;i<Shop.GoodsNames.length;i++) {
			if(Shop.GoodsNames[i].equals(name)) {
				index = i;
				break;
			}
		}
		Map<String,Integer> m1 = null;
		boolean isExist=true;
		for(Map<String,Integer> m:mainlist) {
			if(index==m.get("商品")) {
				m1=m;
				break;
			}
		}
		if(m1==null) {
			isExist = false;
			m1 = new HashMap<String, Integer>();
			
			m1.put("商品",index);
			m1.put("买入价格", 0);
			m1.put("数量", 0);
		}
		oldnumbers = m1.get("数量");
		m1.put("数量", oldnumbers+n);//old
		m1.put("买入价格", (m1.get("买入价格")*oldnumbers+p*n)/(n+oldnumbers));
		
		if(!isExist) {
			mainlist.add(m1);
		}
		currhouse += n;
		this.refresh();
		return true;
	}
	public void update() {
		if(tbh!=null) {
			
		}
		
	}
	public int getStock() {
		
		//Map<String,Integer> m1 = null;
		if(mainlist!=null) {
		for(Map<String,Integer> m:mainlist) {
			currhouse += m.get("数量");
			
			}
		}else if(mainlist==null) {
			currhouse = 0;
		}
		return currhouse;
	}
	
}
