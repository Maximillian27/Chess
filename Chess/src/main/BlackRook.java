package main;

public class BlackRook extends Rook {
	
	private String imageLocation = "../resources/BlackRook.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "Black";
	}
}
