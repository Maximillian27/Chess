import java.awt.GridLayout;

import javax.swing.JPanel;

public class Chess {
	
	public static void main(String[] args) {
		int rows = 8, columns = 8;
		ChessBoard board = new ChessBoard();
		board.setSize(800, 800);
		board.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(rows, columns));
		for (int i = 0; i < rows * columns; i++) {
			Tile button = new Tile("Button " + (i + 1));
            panel.add(button);
		}
		board.getContentPane().add(panel);
		board.setVisible(true);
	}
}
