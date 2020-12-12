import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        boolean winner = false;

        char player1 = 'X';
        char player2 = 'O';

        char turn = player1;

        char[] currPositions = {' ', ' ', ' ',
                                ' ', ' ', ' ',
                                ' ', ' ', ' '};
        showBoard(currPositions);

        Scanner input = new Scanner(System.in);

        while(!winner) {

            if (turn == player1) {
                System.out.println("Player ONE, enter coordinate:");
            } else {
                System.out.println("Player TWO, enter coordinate:");
            }

            int index = input.nextInt();

            currPositions[index-1] = turn;

            winner = checkWin(currPositions, turn);

            showBoard(currPositions);

            if (turn == player1) {
                turn = player2;
            } else
                turn = player1;
        }

    }

    public static void showBoard(char[] positions) {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {

            int row = i*3;

            System.out.println("| " + positions[row] + " | " + positions[row+1] + " | " + positions[row+2] + " |");
            System.out.println("-------------");
        }
    }

    public static boolean checkWin(char[] positions, char player) {

        boolean winner = false;

        // Check win horizontal
        for (int i = 0; i < 3; i++) {
            // i = 0
            // turn = player1
            int row = i*3;

            if (positions[row] == player && positions[row+1] == player && positions[row+2] == player) {
                winner = true;
                System.out.println("A player has won");
            }
        }

        // Check win vertical
        for (int i = 0; i < 3; i++) {

            if (positions[i] == player && positions[i+3] == player && positions[i+6] == player){
                winner = true;
                System.out.println("A player has won");
            }
        }

        // Check win diagonal
        if (positions[0] == player && positions[4] == player && positions[8] == player) {
            winner = true;
            System.out.println("A player has won");
        } else if (positions[2] == player && positions[4] == player && positions[6] == player) {
            winner = true;
            System.out.println("A player has won");
        }

        return winner;

    }
}
