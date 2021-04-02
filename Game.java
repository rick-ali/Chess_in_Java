package chess;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class Game {
	private static boolean gameEnd=false;

	public static void play(){
		Boolean whiteTurn = true;
		CheckInput checker = new CheckInput();
		Console console = System.console();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String turn = "";
		String victory = "";
		map.put('a', 0);
		map.put('b', 1);
		map.put('c', 2);
		map.put('d', 3);
		map.put('e', 4);
		map.put('f', 5);
		map.put('g', 6);
		map.put('h', 7);
			do{
				if(whiteTurn) turn = "White player";
				else turn = "Black player";
				System.out.println(turn + " move: ");
				String input = console.readLine("Select a piece: ");
				String input2 = console.readLine("Move your piece: ");
				if (input.equals("END") || input2.equals("END")){
					if(whiteTurn) victory = "Black"; //White resigns
					else victory = "White"; //Black resigns
					gameEnd=true;
					break;
				} 
				if(checker.checkCoordinateValidity(input) && checker.checkCoordinateValidity(input2) && !input.equals(input2)){  //Input is well formatted
					int iIn = Character.getNumericValue(input.charAt(0)) - 1;
					int jIn = map.get(input.charAt(1));
					int iOut = Character.getNumericValue(input2.charAt(0)) - 1;
					int jOut = map.get(input2.charAt(1));

					Piece currentPiece = Board.getPiece(iIn, jIn);
					if(currentPiece!=null){
						//Selecting piece of your own colour?
						if(whiteTurn && currentPiece.getColour()==PieceColour.BLACK || !whiteTurn && currentPiece.getColour()==PieceColour.WHITE){
							System.out.println("You can't select this piece!");  
						}

						//Check if invalid move. If not, perform it
						else if(!currentPiece.isLegitMove(iIn, jIn, iOut, jOut)) System.out.println("Invalid Move! Retry");  
						else{
							Boolean checkmate = Board.movePiece(iIn, jIn, iOut, jOut, currentPiece);
							Board.printBoard();
							if(checkmate){
								System.out.println("Checkmate!");
								gameEnd = true;
								if(whiteTurn) victory="White";
								else victory="Black";
							} 
							whiteTurn = !whiteTurn;
						}
					}
					else System.out.println("No piece to select!");

				}
				else System.out.println("Invalid input!");  //Input is not well formatted

			}while(!gameEnd);

			System.out.println("\n" + victory + " player wins!");

		}

	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}
