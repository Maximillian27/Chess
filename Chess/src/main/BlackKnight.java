package main;

public class BlackKnight extends Knight {
	
	private String imageLocation = "../resources/BlackKnight.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "Black";
	}
}
