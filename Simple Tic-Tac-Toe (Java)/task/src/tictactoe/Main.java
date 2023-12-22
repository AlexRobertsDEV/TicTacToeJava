package tictactoe;

import java.util.Scanner;

public class Main {
    final static char[][] ticTacToeBoard = new char[3][3];
    final static Scanner scanner = new Scanner(System.in);
    static char currentPlayer = 'X'; // Start with player X

    public static void main(String[] args) {
        // Initialize the board with spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToeBoard[i][j] = ' ';
            }
        }

        printTicTacToeBoard();

        while (true) {
            makeMove();
            printTicTacToeBoard();
            if (checkWin(currentPlayer)) {
                System.out.println(currentPlayer + " wins");
                break;
            } else if (isBoardFull()) {
                System.out.println("Draw");
                break;
            }
            switchPlayer();
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static void makeMove() {
        while (true) {
            System.out.println("Enter the coordinates: ");
            String[] parts = scanner.nextLine().split(" ");

            try {
                int row = Integer.parseInt(parts[0]) - 1;
                int col = Integer.parseInt(parts[1]) - 1;

                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (ticTacToeBoard[row][col] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    ticTacToeBoard[row][col] = currentPlayer;
                    break;
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    private static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((ticTacToeBoard[i][0] == player && ticTacToeBoard[i][1] == player && ticTacToeBoard[i][2] == player) ||
                    (ticTacToeBoard[0][i] == player && ticTacToeBoard[1][i] == player && ticTacToeBoard[2][i] == player)) {
                return true;
            }
        }
        if ((ticTacToeBoard[0][0] == player && ticTacToeBoard[1][1] == player && ticTacToeBoard[2][2] == player) ||
                (ticTacToeBoard[0][2] == player && ticTacToeBoard[1][1] == player && ticTacToeBoard[2][0] == player)) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (char[] row : ticTacToeBoard) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printTicTacToeBoard() {
        System.out.println("---------");
        for (char[] row : ticTacToeBoard) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print((cell == ' ' ? '_' : cell) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
