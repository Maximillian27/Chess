package main;

public class WhiteKing extends King {
	
	private String imageLocation = "../resources/WhiteKing.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "White";
	}
}
