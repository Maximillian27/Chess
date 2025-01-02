package main;
import javax.swing.JButton;

public class Tile extends JButton {
	private Piece piece;
	private int row;
	private int column;
	
	public Tile(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
		this.setIcon(piece.getIcon());
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void removePiece() {
		piece = null;
		this.setIcon(null);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
}
