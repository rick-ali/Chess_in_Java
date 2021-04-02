package chess;

public abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	public void setSymbol(String s){
		symbol = s;
	}

	public PieceColour getColour(){
		return this.colour;
	}

	public String getSymbol() {
		return this.symbol;
	}	

	public abstract Boolean isLegitMove(int iIn, int jIn, int iOut, int jOut);
}
