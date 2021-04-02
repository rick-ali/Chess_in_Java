package chess;

import static java.lang.Math.abs;

public class Bishop extends Piece{
    public Bishop(PieceColour c){
        this.colour = c;
        if (c==PieceColour.WHITE) this.setSymbol("♗");
        else this.setSymbol("♝");
    }

    @Override
    public Boolean isLegitMove(int iIn, int jIn, int iOut, int jOut){

        //Check diagonal movement only
        if( !(abs(jIn-jOut) == abs(iIn - iOut)) ) return false;

        //Check no pieces along the way
        int i=1;
        if(iIn<iOut && jIn<jOut){  //Right-Down
            while(iIn+i<iOut){
                if (Board.hasPiece(iIn+i, jIn+i) == true) return false;
                i++;
            }
        }
        else if(iIn<iOut && jIn>jOut){  //Right-Up
            while(iIn+i<iOut){
                if (Board.hasPiece(iIn+i, jIn-i) == true) return false;
                i++;
            }
        }
        else if(iIn>iOut && jIn<jOut){  //Left-Down
            while(iIn-i>iOut){
                if (Board.hasPiece(iIn-i, jIn+i) == true) return false;
                i++;
            }
        }
        else if(iIn>iOut && jIn>jOut){  //Left-Up
            while(iIn-i>iOut){
                if (Board.hasPiece(iIn-i, jIn-i) == true) return false;
                i++;
            }
        }

        //Capture
        if((Board.hasPiece(iOut, jOut) == false) || 
        (this.colour==PieceColour.BLACK && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.WHITE) ||
        this.colour==PieceColour.WHITE && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.BLACK) return true;
        
        return false;
    }

}
