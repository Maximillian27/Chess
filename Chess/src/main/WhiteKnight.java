package main;

public class WhiteKnight extends Knight {
	
	private String imageLocation = "../resources/WhiteKnight.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "White";
	}
}
