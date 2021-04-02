package chess;
import static java.lang.Math.abs;

public class King extends Piece{
    public King(PieceColour c){
        this.colour = c;
        if (c==PieceColour.WHITE) this.setSymbol("♔");
        else this.setSymbol("♚");
    }

	@Override
    public Boolean isLegitMove(int iIn, int jIn, int iOut, int jOut){

        if( !( (abs(iIn-iOut) == 0 || abs(iIn-iOut) == 1) &&
               (abs(jIn-jOut) == 0 || abs(jIn-jOut) == 1)   ) ) return false;

        if((Board.hasPiece(iOut, jOut) == false) || 
        (this.colour==PieceColour.BLACK && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.WHITE) ||
        this.colour==PieceColour.WHITE && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.BLACK) return true;

        return false;
    }

}
