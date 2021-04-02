package chess;

public class Square {
	private boolean hasPiece;
	private Piece p;
	
	public boolean hasPiece(){
		return hasPiece;
	}

	public void setPiece(Piece pIn){
		if(pIn!=null) hasPiece=true;
		p = pIn;
	}

	public Piece getPiece(){
		return p;
	}

	public void removePiece(){
		hasPiece = false;
		this.setPiece(null);
	}
}
