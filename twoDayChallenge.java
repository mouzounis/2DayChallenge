import java.util.Scanner;

public class twoDayChallenge {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //create all the arrays that we need; one for storing the numbers whiteArmy_array and BlackArmy_array of 8
        //Other that is going to be the board that is of 16, wich in the begining are going to be 0 all of them
        //For a better understanding of what the player is playing we made two more that are going to filled with the numbers in the positions that the user marks but not mixed with the other player
        //this is going to help us also for the destroy part
        int[] whiteArmy_array = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] blackArmy_array = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] board = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] boardWhite = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] boardBlack = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        //we need to explain the rules of the game
        functions.rules();
        //then we need to choose who is starting playing
        functions.coinflip();
        //Then for 8 times we need the users to prompt the numbers of the army and the position so we can fill the board
        for (int i = 0; i < 8; i++) {
            System.out.println("White army turn");
            functions.deployement(whiteArmy_array, board, boardWhite);
            //for a better understanding of what is happening we need to show the boards
            System.out.print("White Army board: ");
            functions.print(boardWhite);
            System.out.print("Black army board: ");
            functions.print(boardBlack);
            System.out.println("The board with all the number looks like this: ");
            functions.print(board);
            
            //we repit the same but with the black army
            System.out.println("Black Army your turn");
            functions.deployement(blackArmy_array, board, boardBlack);
            //we need to show how the game is going so the next can plays better
            System.out.print("White Army board: ");
            functions.print(boardWhite);
            System.out.print("Black army board: ");
            functions.print(boardBlack);
            System.out.println("The board with all the number looks like this:");
            functions.print(board);
        }


        //Destoys part
        //do while we can still playing
        do {
            System.out.println("White Army plays: ");
            //the player chosses an the number that he wants to destroy ant the function decides if its a good promt or if it not it lets the user to choose again
            functions.choicefordestruction(board, boardBlack, boardWhite);
            //show the board after the destruction has pass
            functions.print(board);
            //do the same but changing to the other team
            System.out.println("Black army plays: ");
            functions.choicefordestruction(board, boardWhite, boardBlack);
            functions.print(board);
            //function check for know if the game is over or not
        } while(functions.check(board, boardWhite, boardBlack)==false || functions.check(board, boardBlack, boardWhite)==false);

        //See who has more armies left in the board
        functions.winner(boardWhite, boardBlack);
        
        scan.close();
    }

}