package fun;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class Background extends JPanel{
	Background() {
		JLabel lab = new JLabel();
		String path = "/DATANG1.jpg";
		/*runIcon = new ImageIcon(getClass().getResource("/images/connect.gif"));*/
		ImageIcon ic = new ImageIcon(getClass().getResource(path));
		ic.setImage(ic.getImage().getScaledInstance(970,165,Image.SCALE_DEFAULT));
		
		lab.setBounds(0, 0, 970, 165);
		lab.setIcon(ic);
		this.add(lab);
		this.setBounds(0, 0, 970, 165);
		this.setVisible(true);
		
	}
}
