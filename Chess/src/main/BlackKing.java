package main;

public class BlackKing extends King {
	
	private String imageLocation = "../resources/BlackKing.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "Black";
	}
}
