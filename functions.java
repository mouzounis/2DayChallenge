import java.util.Scanner;

public class functions {
    // we need to open a new scan for scan all the variables that we want the user
    // to prompt.
    static Scanner scan = new Scanner(System.in);

    // We need a function that prints the array so the user can see what he is doing
    // in the game, for that we are going to use a for loop
    // and its going to repit the number of times of the array lenght; the array is
    // declare in main depending in what we want to show
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();
    }

    // We need a function where the user prompts the number that he wants to destroy
    // and that takes out the number if necesary; the necesary is when the sum of
    // the positions lateral of the
    // array is bigger than the actual number, for this we created two boards that
    // only have the part of that player, so it just sum the laterals of the oposite
    // block.
    // and wee need a do while for repiting the function in case that the sum of the
    // laterals is equal to the proper array.
    public static void choicefordestruction(int[] board, int[] otherplayerBoard, int[] playerboard) {
        boolean move = false;
        do {
            System.out.println("Please enter the number that you want to destroy: ");
            int choice = scan.nextInt(); // until here we just declare a boolean that we would use later and asign a
                                         // choice.

            for (int i = 0; i < otherplayerBoard.length; i++) {
                if (choice == otherplayerBoard[i]) {
                    int sum = playerboard[i - 1] + playerboard[i + 1];
                    if (sum > board[i]) {
                        board[i] = 0;
                    } else if (sum == board[i]) {
                        System.out.println("Invalid move try again please");
                        move = true;
                    }
                }
            } // This loop is used for knowing the position in the board of the oponent; so we
              // can sum the right and the left position of the oposite board
              // and if it bigger; it will just desaperar, so the space would be empty. its
              // doing that until move is false. that is why we are using a the boolean move.
        } while (move);
    }

    // We need a function that checks if the game can continue playing for that we
    // just need to know if there is any chance that the player can prompt a number
    // that can play
    // for that we are doing a scan; first with the firs position that is not 0
    // looks if we can run the function choicefordestruction, for that the sum need
    // to me diferent from 0; if not it will check the next that is not 0 and do the
    // same; until all the posibilities of sum= 0
    // and for that we are using a boolean; that if all the sums are 0 the funtion
    // will retun false and end.
    public static boolean check(int[] board, int[] playerboard, int[] otherplayerBoard) {
        for (int i = 0; i < playerboard.length; i++) {
            if (playerboard[i] != 0) {
                int sum = otherplayerBoard[i - 1] + otherplayerBoard[i + 1];
                if (sum != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // We need a function that we are going to call winner because its going to
    // asing who is the winner, for that we will create two variables
    // counterW and cunterB for each of the players; and then we will do other scan;
    // counting how many positions are not fill with 0.
    // This is done for both of them so later we can compare results; and then we
    // need to create an if else statement for asing the winner; whoever is the one
    // with more positions not fill with 0
    public static void winner(int[] playerboard, int[] otherplayerBoard) {
        int counterW = 0;
        int counterB = 0;
        for (int i = 0; i < playerboard.length; i++) {
            if (playerboard[i] != 0) {
                counterW++;
            }
        }
        for (int y = 0; y < otherplayerBoard.length; y++) {
            if (otherplayerBoard[y] != 0) {
                counterB++;
            }
        }
        if (counterW > counterB) {
            System.out.println("Congratulations; White army wins! \n Black army loose; next time would be");
        } else {
            System.out.println("Congratulations Black army wins! \n White army looses next time would be");
        }
        System.out.println(
                "Thank you for playing this game developed by students of City College 1 Stage of Computer Science; We hope that you ejoyed it");
    }

    // We need to create a function where the user prompts the value of what army is
    // he going to play and the value of wich position he wants the army.
    // For that we need use the scanner to scan the int that he is choosing; and
    // because we know that the user might not put the correct value we create a
    // while loop
    // the While loop is runnig while the number that the user prompts is bigger
    // than 8 or smaller than 1; so the user will need to put again the army.
    // We need to do the same with the position but intead of bigger than 8 is
    // bigger than 16 and the smaller remains the same.
    // Later we asign the army to the correspondent position; the position in the
    // board is going always to be one less than the oone that the user prompts;
    // For filling the boardWhite or the boardBlack we just need to do the same but
    // inside that array.
    public static void deployement(int[] array, int[] board, int[] secBoard) {
        int number = 0;
        System.out.println("Please choose army number between 1 to 8: ");
        while (number < 1 || number > 8) {
            number = scan.nextInt();
            isThere(array, number);
            if (number < 1 || number > 8) {
                System.out.println("Invalid number. Please choose between 1 to 8.");
            }
        }
        int position = 0;
        System.out.println("Please choose a position between 1 to 16: ");
        while (position < 1 || position > 16) {
            position = scan.nextInt();
            isTherePosition(array, position);
            if (position < 1 || position > 16) {
                System.out.println("Invalid position. Please choose between 1 to 16.");
            }
        }

        board[position - 1] = number;
        secBoard[position - 1] = number;
    }

    public static void isThere(int[] playerboard, int choice) {
        for (int i = 0; i < playerboard.length; i++) {
            if (choice == playerboard[i]) {
                System.out.println("Try other number.");
            } else {
                break;
            }
        }
    }

    public static void isTherePosition(int[] board, int position) {
        for (int i = 0; i < board.length; i++) {
            if (position != 0) {
                System.out.println("Try other position.");
            }
        }
    }

    // We need a function with all the rules of the game so we just just
    // System.out.println() and put inside the rules
    public static void rules() {
        // RULES
        System.out.println("Hello Summoners! And welcome to the game.");
        System.out.println("Please play fair and follow the rules of the game.");
        System.out.println("Firstly you need to choose a valid/available number.");
        System.out.println("Now that you have chosen the number it is time to choose any available empty square.");
        System.out.println(
                "After the end of deployment, the destruction phase begins in which the order of play is preserved.");
        System.out.println(
                "Destruction of a number only exists if in the surroundings squares the player has numbers whose sum exceeds!");
        System.out.println(
                "If a player cannot play anymore, the game continues with the other player destroying as many numbers as possible.");
        System.out.println("When no-one can play anymore, the game ends.");
        System.out.println("The winner is the player who has more armies that the other player left on the board.");
        System.out.println(
                "If they both have the same number of armies, the winner is the one whose sum of armies is greater than the other's");
        System.out.println("Otherwise it's a draw.");
        System.out.println("Show no mercy, we dont like draws. We need a winner!");
        System.out.println("Thank you for playing!!");
        System.out.println("Now that you know the rules lets flip a coin");
    }

    // The beggining of the game starts with a coin flip;
    // We give the 1 player to choose what he wants heads or tails; he choose and
    // then we asign the different choices in a swich statement
    // after that we have our users with the beat already done.
    // then we do the if statement and puting the option random for not knowing what
    // is going to be chossen.
    // then the coin is flipped and we need to create more if statements for the two
    // options that we have; if heads goes; whoever that is heads starts and same
    // for tails
    // in this point when we know who is playing first we asign them the teams that
    // they are black or white
    public static void coinflip() {
        int player2choice = 0;
        System.out.println("Player one please chose 1 if you want heads; and choose 2 if you want tails: ");
        int player1choice = scan.nextInt();
        switch (player1choice) {
            case 1:
                player2choice = 2;
                System.out.println("Player 2 you are tails");
                break;
            case 2:
                player2choice = 1;
                System.out.println("Player 2 you are heads");
                break;
        }
        System.out.println("Lets flip the coin");

        if (Math.random() < 0.5) {
            System.out.println("Heads");
            if (player2choice == 1) {
                System.out.println("Player 2 starts; you are White army");
            } else {
                System.out.println("Player 1 Starts; you are White army");
            }
        } else {
            System.out.println("Tails");
            if (player2choice == 2) {
                System.out.println("Player 2 starts; you are White army");
            } else {
                System.out.println("Player 1 starts; you are White army");
                ;
            }
        }
    }
}
