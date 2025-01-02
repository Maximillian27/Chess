package main;

public class BlackBishop extends Bishop {
	
	private String imageLocation = "../resources/BlackBishop.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "Black";
	}
}
