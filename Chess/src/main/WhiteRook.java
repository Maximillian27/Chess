package main;

public class WhiteRook extends Rook {
	
	private String imageLocation = "../resources/WhiteRook.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "White";
	}
}
