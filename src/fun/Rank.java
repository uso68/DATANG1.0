package fun;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Rank extends JFrame implements Comparator<Entry<String,Integer>>{
	List<Entry<String, Integer>> ranklist = new ArrayList<Entry<String, Integer>>();
	JFrame frm = new JFrame("长安富豪榜");
	JLabel[] lab1 = new JLabel[11];
	JLabel[] lab2 = new JLabel[11];
	JLabel[] lab3 = new JLabel[11];
	Font ft = new Font("",Font.BOLD,20);
	
	Rank(){

		JPanel jp = new JPanel(new GridLayout(11,3));
		
		frm.setBounds(600, 100, 400, 900);
		jp.setBounds(0, 0, 400, 900);	
		
		lab1[0] = new JLabel("名次", JLabel.CENTER);
		lab2[0] = new JLabel("长安富豪", JLabel.CENTER);
		lab3[0] = new JLabel("资产总值", JLabel.CENTER);
		lab1[0].setFont(ft);
		lab2[0].setFont(ft);
		lab3[0].setFont(ft);
		lab1[0].setBorder(BorderFactory.createLineBorder(Color.black));
		lab2[0].setBorder(BorderFactory.createLineBorder(Color.black));
		lab3[0].setBorder(BorderFactory.createLineBorder(Color.black));
		jp.add(lab1[0]);jp.add(lab2[0]);jp.add(lab3[0]);
		for(int i=1;i<=lab1.length-1;i++) {
			lab1[i] = new JLabel(""+i+"", JLabel.CENTER);
			lab2[i] = new JLabel("", JLabel.CENTER);
			lab3[i] = new JLabel("", JLabel.CENTER);
			lab1[i].setBorder(BorderFactory.createLineBorder(Color.black));
			lab2[i].setBorder(BorderFactory.createLineBorder(Color.black));
			lab3[i].setBorder(BorderFactory.createLineBorder(Color.black));
			lab1[i].setFont(ft);
			lab2[i].setFont(ft);
			lab3[i].setFont(ft);
			jp.add(lab1[i]);jp.add(lab2[i]);jp.add(lab3[i]);
		}
		frm.add(jp);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {    
        return o2.getValue().compareTo(o1.getValue());  
    }

	public void addEndShow(String name,int rich) throws IOException {
		if (ranklist.size() == 0) {
			File file = new File(".\\saveDate.txt");
			HashMap<String,Integer> rankNames = new HashMap<String,Integer>();
			if (!file.exists()) {
				String[] names = {"张三","李四","王五","李白","杜甫","二狗","诸葛亮","瓦里安","希尔瓦娜斯","阿土仔"};
				int[] richList = {5000000,5250000,15000000,65000000,32000000,100000000,85000000,-1100000,3700000,9000000};
				
				for(int i=0;i<names.length;i++) {
					rankNames.put(names[i], richList[i]);
				}
			
			}
			else {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String str = null;
				while((str = reader.readLine())!=null) {
					sb.append(str);
				}
				reader.close();
				Gson gs = new Gson();
				JsonArray jsarr = gs.fromJson(sb.toString(), JsonArray.class);
				
				
				for (int i=0;i<jsarr.size();i++) {
					JsonObject jso = jsarr.get(i).getAsJsonObject(); 
					String k = jso.keySet().toArray()[0].toString();
					rankNames.put(k, jso.get(k).getAsInt());
				}
				
			}
			ranklist = new ArrayList<Entry<String, Integer>>(rankNames.entrySet()); 
			Collections.sort(ranklist, this);  
			/*for (Entry<String, Integer> entry : ranklist) {  
		        System.out.println(entry.getKey() + ":" + entry.getValue());  
		    }*/
		}
		
		Entry<String, Integer> entry = new AbstractMap.SimpleEntry<String, Integer>(name, rich);
		ranklist.add(entry);
		Collections.sort(ranklist, this);
		if(ranklist.size()>10) {
			ranklist.remove(10);
			
		}
		refresh();
		frm.setVisible(true);
	}
	
	public void refresh() throws IOException {
		String date = new String(); 
		JsonArray jsarr = new JsonArray();
		for(int i=1;i<=lab1.length-1;i++) {
			JsonObject jsobj = new JsonObject();
			
			lab1[i].setText(null);
			lab2[i].setText(null);
			lab3[i].setText(null);
			lab1[i].setText(""+i+"");
			lab2[i].setText(""+ranklist.get(i-1).getKey());
			lab3[i].setText(""+ranklist.get(i-1).getValue());
			lab1[i].setFont(ft);
			lab2[i].setFont(ft);
			lab3[i].setFont(ft);
			jsobj.addProperty(ranklist.get(i-1).getKey(), String.valueOf(ranklist.get(i-1).getValue()));
			
			jsarr.add(jsobj);
			
		}
		File file =  new File(".\\saveDate.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		date = jsarr.toString();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.append(jsarr.toString());
		writer.newLine();
		writer.close();
		
	}
	
}

	
	


	

