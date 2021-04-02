package chess;

import static java.lang.Math.abs;

public class Queen extends Piece{
    public Queen(PieceColour c){
        this.colour = c;
        if (c==PieceColour.WHITE) this.setSymbol("♕");
        else this.setSymbol("♛");
    }
    
    @Override
    public Boolean isLegitMove(int iIn, int jIn, int iOut, int jOut){

        //Diagonal or horizontal movement only, if not, return false
        if( !(abs(jIn-jOut) == abs(iIn - iOut)) &&
            !(iIn==iOut ^ jIn==jOut)){
                return false;
            } 

        //Diagonal movement (same as bishop)
        if((abs(jIn-jOut) == abs(iIn - iOut)) && !(iIn==iOut ^ jIn==jOut)){
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
        }

        //Horizontal movement (same as rook)
        if((iIn==iOut ^ jIn==jOut)){
            if(iIn==iOut){
                if(jIn<jOut){
                    for (int j=jIn+1; j<jOut;j++){
                        if(Board.hasPiece(iIn, j) == true) return false;
                    }
                } else{
                    for (int j=jIn-1; j>jOut;j--){
                        if(Board.hasPiece(iIn, j) == true) return false;
                    }
                }
            } else{
                if(iIn<iOut){
                    for (int i=iIn+1; i<iOut;i++){
                        if(Board.hasPiece(i, jIn) == true) return false;
                    }
                } else{
                    for (int i=iIn-1; i>iOut;i--){
                        if(Board.hasPiece(i, jIn) == true) return false;
                    }
                }
            }
        }

        //Capture
        if((Board.hasPiece(iOut, jOut) == false) || 
        (this.colour==PieceColour.BLACK && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.WHITE) ||
        (this.colour==PieceColour.WHITE && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.BLACK)) return true;

        return false;
    }
}
