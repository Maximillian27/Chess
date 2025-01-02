package main;

public class WhitePawn extends Pawn {
	
	private String imageLocation = "../resources/WhitePawn.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "White";
	}
}
