package chess;
import static java.lang.Math.abs;

public class Knight extends Piece{
    public Knight(PieceColour c){
        this.colour = c;
        if (c==PieceColour.WHITE) this.setSymbol("♘");
        else this.setSymbol("♞");
    }
    
    @Override
    public Boolean isLegitMove(int iIn, int jIn, int iOut, int jOut){
        
        if( !( (abs(iIn-iOut)==1 && abs(jIn-jOut)==2) ^ (abs(iIn-iOut)==2 && abs(jIn-jOut)==1) ) ) return false;

        if( Board.getPiece(iOut, jOut) == null ||
            this.colour==PieceColour.WHITE && Board.getPiece(iOut, jOut).getColour()==PieceColour.BLACK ||
            this.colour==PieceColour.BLACK && Board.getPiece(iOut, jOut).getColour()==PieceColour.WHITE) return true;

        return false;
    }
}
