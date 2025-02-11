import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		//daclare scanner  
		Scanner scanner = new Scanner(System.in);
		//Make the gamegameBoard 
		char[][] gameBoard = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printBoard(gameBoard);
		
		while (true) {
			playerTurn(gameBoard, scanner);
			if (isGameFinished(gameBoard)){
				break;
			}
			printBoard(gameBoard);
			
			computerTurn(gameBoard);
			if (isGameFinished(gameBoard)){
				break;
			}
			printBoard(gameBoard);
		}
		scanner.close();
	}

    //checks to see if the game is over (player/cpu wins or tie game)
	private static boolean isGameFinished(char[][]gameBoard) {
		
        // if the player/cpu completes the win condition, update the board 
		if (winCondition(gameBoard, 'X')) {	
			printBoard(gameBoard);
			System.out.println("The player has achieved the impossible!");
			return true;
		}
		
		if (winCondition(gameBoard, 'O')) {	
			printBoard(gameBoard);
			System.out.println("The Computer remaians unbeatable!");
			return true;
		}
		
        // this nested for loop will check every row/colum inside the char[][] gameBoard
		for (int i = 0; i <gameBoard.length; i++) {
			for (int j = 0; j <gameBoard[i].length; j++) {
				if (gameBoard[i][j] == ' ') {
					return false;
				}
			}
		}
        //in case of a tie game, the board will print on last time and print the code below
		printBoard(gameBoard);
		System.out.println("The game has ended with no winner in sight...");
		return true;
	}

    //win condition for the player/cpu to win
	private static boolean winCondition(char[][]gameBoard, char symbol) {
		if ((gameBoard[0][0] == symbol && gameBoard [0][1] == symbol && gameBoard [0][2] == symbol) ||
			(gameBoard[1][0] == symbol && gameBoard [1][1] == symbol && gameBoard [1][2] == symbol) ||
			(gameBoard[2][0] == symbol && gameBoard [2][1] == symbol && gameBoard [2][2] == symbol) ||
			
			(gameBoard[0][0] == symbol && gameBoard [1][0] == symbol && gameBoard [2][0] == symbol) ||
			(gameBoard[0][1] == symbol && gameBoard [1][1] == symbol && gameBoard [2][1] == symbol) ||
			(gameBoard[0][2] == symbol && gameBoard [1][2] == symbol && gameBoard [2][2] == symbol) ||
			
			(gameBoard[0][0] == symbol && gameBoard [1][1] == symbol && gameBoard [2][2] == symbol) ||
			(gameBoard[0][2] == symbol && gameBoard [1][1] == symbol && gameBoard [2][0] == symbol) ) {
			return true;
		}
		return false;
	}

    //use the random class and the isValidMove method to generate where the cpu will move
	private static void computerTurn(char[][]gameBoard) {
		Random rand = new Random();
		int computerMove;
        //while isValidMove true, continue to generate numbersfor cpu's move
		while (true) {

        //while 
			computerMove = rand.nextInt(9) + 1;
			if (isValidMove(gameBoard, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + computerMove);
		placeMove(gameBoard, Integer.toString(computerMove), 'O');
	}

    // checks if a move is valid or not. 
	private static boolean isValidMove (char[][]gameBoard, String position) {
		switch(position) {
			case "1":
				return gameBoard[0][0] == ' ';
			case "2":
				return gameBoard[0][1] == ' ';
			case "3":
				return gameBoard[0][2] == ' ';
			case "4":
				return gameBoard[1][0] == ' ';
			case "5":
				return gameBoard[1][1] == ' ';
			case "6":
				return gameBoard[1][2] == ' ';
			case "7":
				return gameBoard[2][0] == ' ';
			case "8":
				return gameBoard[2][1] == ' ';
			case "9":
				return gameBoard[2][2] == ' ';
			default:
				return false;
		}
	}
    // use the scanner for user input and the isValidMove method to generate player moves 
	private static void playerTurn(char[][]gameBoard, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if (isValidMove(gameBoard, userInput)){
				break;
			} else {
				System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(gameBoard, userInput, 'X');
	}

    //updates thegameBoard 
	private static void placeMove(char[][]gameBoard, String position, char symbol) {
		switch(position) {
			case "1":
			gameBoard[0][0] = symbol;
				break;
			case "2":
			gameBoard[0][1] = symbol;
				break;
			case "3":
			gameBoard[0][2] = symbol;
				break;
			case "4":
			gameBoard[1][0] = symbol;
				break;
			case "5":
			gameBoard[1][1] = symbol;
				break;
			case "6":
			gameBoard[1][2] = symbol;
				break;
			case "7":
			gameBoard[2][0] = symbol;
				break;
			case "8":
			gameBoard[2][1] = symbol;
				break;
			case "9":
			gameBoard[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	
	//prints thegameBoard 
	private static void printBoard(char[][] gameBoard) {
		System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2] );
		System.out.println("-+-+-");
		System.out.println(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2] );
		System.out.println("-+-+-");
		System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2] );
	}
	
}