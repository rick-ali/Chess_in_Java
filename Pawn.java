package chess;
import static java.lang.Math.abs;

public class Pawn extends Piece{	
	public Pawn(PieceColour c){
        this.colour = c;
        if (c==PieceColour.WHITE) this.setSymbol("♙");
        else this.setSymbol("♟︎");
        
    }

    @Override
    public Boolean isLegitMove(int iIn, int jIn, int iOut, int jOut){
        //Black pawns
        if (this.colour==PieceColour.BLACK && iOut > iIn){
            if(jIn==jOut){
                if(iOut==iIn+1 && Board.hasPiece(iOut, jOut)==false) return true;
                if(iOut==iIn+2 && iIn==1 && Board.hasPiece(iIn+1, jOut)==false && Board.hasPiece(iOut, jOut)==false) return true;
            }
            if(iOut==iIn+1 && abs(jIn-jOut)==1 && Board.hasPiece(iOut, jOut) && Board.getPiece(iOut, jOut).getColour()==PieceColour.WHITE) return true;
        }
        //White pawns
        if (this.colour==PieceColour.WHITE && iOut < iIn){
            if(jIn==jOut){
                if(iOut==iIn-1 && Board.hasPiece(iOut, jOut)==false) return true;
                if(iOut==iIn-2 && iIn==6 && Board.hasPiece(iIn-1, jOut)==false && Board.hasPiece(iOut, jOut)==false) return true;
            }
            if(iOut==iIn-1 && abs(jIn-jOut)==1 && Board.hasPiece(iOut, jOut) && Board.getPiece(iOut, jOut).getColour()==PieceColour.BLACK) return true;
        }

        return false;
    }


}
