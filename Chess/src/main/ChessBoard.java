package main;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ChessBoard extends JFrame {
	private Tile startingPlace = null;
	private final int rows = 8, columns = 8;
	private Tile[][] tiles = new Tile[rows][columns];
	private String turn = "White";
	private boolean flipped = false;
	public ChessBoard() {
		super();
		ChessBoard reference = this;
		this.setSize(800, 800);
		this.setResizable(false);
		CreateMenu();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(rows, columns));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Tile button = new Tile(i, j);
				tiles[i][j] = button;
				if ((i + j) % 2 == 1) {
					button.setBackground(Color.DARK_GRAY);
				}
				else {
					button.setBackground(Color.LIGHT_GRAY);
				}
				button.setBorderPainted(false);
				button.setOpaque(true);
		        button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                // Code to execute when the button is clicked
		            	if (startingPlace == null && isValidStart(button)) {
		            		startingPlace = button;
		            	}
		            	else if (startingPlace != null && isValidMove(startingPlace, button)) {
		                	if (button.getPiece() instanceof WhiteKing) {
		                		System.out.println("Black Wins");
		                		reference.dispose();
		                	}
		                	if (button.getPiece() instanceof BlackKing) {
		                		System.out.println("White Wins");
		                		reference.dispose();
		                	}
		                	button.setPiece(startingPlace.getPiece());
		                	startingPlace.removePiece();
		                	startingPlace = null;
		                	if (turn.equals("White")) {
		                		turn = "Black";
		                	}
		                	else {
		                		turn = "White";
		                	}
		                }
		            	else if (isValidStart(button)) {
		            		startingPlace = button;
		            	}
		            }
		        });
	            panel.add(button);
			}
		}
		for (int i = 0; i < columns; i++) {
			tiles[6][i].setPiece(new WhitePawn());
		}
		for (int i = 0; i < columns; i++) {
			tiles[1][i].setPiece(new BlackPawn());
		}
		tiles[0][0].setPiece(new BlackRook());
		tiles[0][1].setPiece(new BlackKnight());
		tiles[0][2].setPiece(new BlackBishop());
		tiles[0][3].setPiece(new BlackQueen());
		tiles[0][4].setPiece(new BlackKing());
		tiles[0][5].setPiece(new BlackBishop());
		tiles[0][6].setPiece(new BlackKnight());
		tiles[0][7].setPiece(new BlackRook());
		tiles[7][0].setPiece(new WhiteRook());
		tiles[7][1].setPiece(new WhiteKnight());
		tiles[7][2].setPiece(new WhiteBishop());
		tiles[7][3].setPiece(new WhiteQueen());
		tiles[7][4].setPiece(new WhiteKing());
		tiles[7][5].setPiece(new WhiteBishop());
		tiles[7][6].setPiece(new WhiteKnight());
		tiles[7][7].setPiece(new WhiteRook());
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
	
	private boolean isValidStart(Tile tile) {
		if (tile.getPiece() != null) {
			if (tile.getPiece().getColor().equals(turn)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidMove(Tile start, Tile end) {
		if (start == end) {
			return false;
		}
		if (start.getPiece() == null) {
			throw new IllegalArgumentException("start must have a piece");
		}
		if (end.getPiece() != null && start.getPiece().getColor().equals(end.getPiece().getColor())) {
			return false;
		}
		if (start.getPiece() instanceof Bishop || start.getPiece() instanceof Queen) {
			if (Math.abs(start.getRow() - end.getRow()) == Math.abs(start.getColumn() - end.getColumn())) {
				if (clearBetweenDiagonally(start, end, tiles)) {
					return true;
				}
			}
		}
		if (start.getPiece() instanceof Rook || start.getPiece() instanceof Queen) {
			if ((start.getRow() == end.getRow() && clearBetweenHorizontally(start, end, tiles)) || (start.getColumn() == end.getColumn() && clearBetweenVertically(start, end, tiles))) {
				return true;
			}
		}
		if (start.getPiece() instanceof Knight) {
			if (Math.abs(start.getRow() - end.getRow()) == 2 && Math.abs(start.getColumn() - end.getColumn()) == 1) {
				return true;
			}
			if (Math.abs(start.getRow() - end.getRow()) == 1 && Math.abs(start.getColumn() - end.getColumn()) == 2) {
				return true;
			}
		}
		
		if ((start.getPiece() instanceof BlackPawn && !flipped) || (start.getPiece() instanceof WhitePawn && flipped)) {
			if (start.getRow() - end.getRow() == -1 && start.getColumn() == end.getColumn() && end.getPiece() == null) {
				return true;
			}
			if (start.getRow() == 1 && end.getRow() == 3 && start.getColumn() == end.getColumn() && end.getPiece() == null) {
				if (tiles[2][start.getColumn()].getPiece() == null) {
					return true;
				}
			}
			if (start.getRow() - end.getRow() == -1 && Math.abs(start.getColumn() - end.getColumn()) == 1 && end.getPiece() != null) {
				return true;
			}
		}
		
		if ((start.getPiece() instanceof WhitePawn && !flipped) || (start.getPiece() instanceof BlackPawn && flipped)) {
			if (start.getRow() - end.getRow() == 1 && start.getColumn() == end.getColumn() && end.getPiece() == null) {
				return true;
			}
			if (start.getRow() == 6 && end.getRow() == 4 && start.getColumn() == end.getColumn() && end.getPiece() == null) {
				if (tiles[5][start.getColumn()].getPiece() == null) {
					return true;
				}
			}
			if (start.getRow() - end.getRow() == 1 && Math.abs(start.getColumn() - end.getColumn()) == 1 && end.getPiece() != null) {
				return true;
			}
		}
		
		if (start.getPiece() instanceof King) {
			if (Math.abs(start.getRow() - end.getRow()) <= 1 && Math.abs(start.getColumn() - end.getColumn()) <= 1) {
				return true;
			}
		}
		return false;
	}
	
	private boolean clearBetweenDiagonally(Tile start, Tile end, Tile[][] tiles) {
		int distance = Math.abs(start.getRow() - end.getRow());
		int row = 0;
		int column = 0;
		for (int i = 1; i < distance; i++) {
			if (end.getRow() > start.getRow()) {
				row = start.getRow() + i;
			}
			else {
				row = start.getRow() - i;
			}
			if (end.getColumn() > start.getColumn()) {
				column = start.getColumn() + i;
			}
			else {
				column = start.getColumn() - i;
			}
			if (tiles[row][column].getPiece() != null) {
				return false;
			}
		}
		return true;
	}
	
	private boolean clearBetweenHorizontally(Tile start, Tile end, Tile[][] tiles) {
		int distance = Math.abs(start.getColumn() - end.getColumn());
		int row = start.getRow();
		int column = 0;
		for (int i = 1; i < distance; i++) {
			if (end.getColumn() > start.getColumn()) {
				column = start.getColumn() + i;
			}
			else {
				column = start.getColumn() - i;
			}
			if (tiles[row][column].getPiece() != null) {
				return false;
			}
		}
		return true;
	}
	
	private boolean clearBetweenVertically(Tile start, Tile end, Tile[][] tiles) {
		int distance = Math.abs(start.getRow() - end.getRow());
		int row = 0;
		int column = start.getColumn();
		for (int i = 1; i < distance; i++) {
			if (end.getRow() > start.getRow()) {
				row = start.getRow() + i;
			}
			else {
				row = start.getRow() - i;
			}
			if (tiles[row][column].getPiece() != null) {
				return false;
			}
		}
		return true;
	}
	
	private void CreateMenu() {
		JMenuBar menu = new JMenuBar();
		JMenuItem flip = new JMenuItem("flip");
		flip.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	flipped = !flipped;
		            	for (int i = 0; i < rows/2; i++) {
		            		for (int j = 0; j < columns; j++) {
		            			swapPieces(tiles[i][j], tiles[rows-i-1][columns-j-1]);
		            		}
		            	}
		            }
		        });
		menu.add(flip);
		this.setJMenuBar(menu);
	}
	
	private void swapPieces(Tile first, Tile second) {
		Piece temp = first.getPiece();
		first.setPiece(second.getPiece());
		second.setPiece(temp);
	}
}
