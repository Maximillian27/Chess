package main;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Piece {
	public Icon getIcon() {
		try {
			Image img = ImageIO.read(getClass().getResource(this.getImageLocation()));
			img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(img);
			return icon;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	abstract String getImageLocation();
	
	abstract String getColor();
}
