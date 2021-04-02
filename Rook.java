package chess;

public class Rook extends Piece{
    public Rook(PieceColour c){
        this.colour = c;
        if (c==PieceColour.WHITE) this.setSymbol("♖");
        else this.setSymbol("♜");
    }
    
    @Override
    public Boolean isLegitMove(int iIn, int jIn, int iOut, int jOut){

        //Check straight movement only
        if( !(iIn==iOut ^ jIn==jOut)) return false;

        //Check no pieces along
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

        //Capture
        if((Board.hasPiece(iOut, jOut) == false) || 
        (this.colour==PieceColour.BLACK && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.WHITE) ||
        this.colour==PieceColour.WHITE && (Board.getPiece(iOut, jOut)).getColour() == PieceColour.BLACK) return true;
        
        return false;
    }
}
