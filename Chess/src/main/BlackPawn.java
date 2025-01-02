package main;

public class BlackPawn extends Pawn {
	
	private String imageLocation = "../resources/BlackPawn.png";
	
	@Override
	public String getImageLocation() {
		return imageLocation;
	}
	
	@Override
	public String getColor() {
		return "Black";
	}
}
