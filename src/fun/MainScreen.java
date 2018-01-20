package fun;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MainScreen extends JFrame{
	static JPanel main = new JPanel();
	Player player = new Player();
	Store store = new Store(player);
	Shop shop = new Shop(player,store);
	City ct = new City(player,shop);
	Serv serv = new Serv(player,store);
	MainScreen(){
		
		main.setLayout(null);
		main.setBounds(0, 0, 1000, 920);
		this.setTitle("´óÌÆ¸¡Éú¼Ç 1.0");
		this.setLocation(400, 30);
		this.setSize(1000, 920);
		this.setLayout(null);
		main.add(new Background());
		main.add(ct);
		main.add(player);
		main.add(shop);
		main.add(store);
		main.add(serv);
		//main.add(Shop.sp1);
		this.add(main);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		store.setStore(shop);
		ct.setMain(this);
	}
	
	public void refreshPlayer() {
		
				
	}
}
