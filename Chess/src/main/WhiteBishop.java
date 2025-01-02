package main;

public class WhiteBishop extends Bishop {
	
	private String imageLocation = "../resources/WhiteBishop.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "White";
	}
}
