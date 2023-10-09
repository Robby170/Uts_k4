import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            printBoard();
            int row, col;
            do {
                System.out.print("Pemain " + currentPlayer + ", pilih baris dan kolom (baris[1-3] kolom[1-3]): ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ');

            board[row][col] = currentPlayer;

            if (checkWin(row, col)) {
                gameWon = true;
                printBoard();
                System.out.println("Pemain " + currentPlayer + " Menang! selamat!");
            } else if (isBoardFull()) {
                gameWon = true;
                printBoard();
                System.out.println("GG!, SERI COY!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean checkWin(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
                (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
                (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}