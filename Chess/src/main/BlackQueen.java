package main;

public class BlackQueen extends Queen {
	
	private String imageLocation = "../resources/BlackQueen.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "Black";
	}
}
