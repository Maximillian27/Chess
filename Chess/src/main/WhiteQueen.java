package main;

public class WhiteQueen extends Queen {
	
	private String imageLocation = "../resources/WhiteQueen.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "White";
	}
}
