import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameover = false;
        Scanner input = new Scanner(System.in);
        while (!gameover) {
            printBoard(board);
            System.out.print("Player "  + player + " enters: ");
            int row = input.nextInt();
            int col = input.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameover = haveWon(board, player);
                if (gameover) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won.");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid input.Try again.");
            }
        }
    }
        public static void printBoard(char[][] board){
            for(int row=0;row< board.length;row++){
                for(int col=0;col<board[0].length;col++){
                    System.out.print(board[row][col]+" | ");
                }
                System.out.println();
            }
        }

        public static boolean haveWon(char[][] board,char player){
            //row check
            for(int row=0;row< board.length;row++){
                if(board[row][0]==player && board[row][1]==player && board[row][2]==player ){
                    return true;

                }
            }
            // col check
            for(int col=0;col< board.length;col++){
                if(board[0][col]==player && board[1][col]==player && board[2][col]==player ){
                    return true;

                }
            }
            // diagonal check
            if(board[0][0]==player && board[1][1]==player && board[2][2]==player ){
                return true;

            }
            if(board[0][2]==player && board[1][1]==player && board[2][0]==player ){
                return true;

            }
            return false;
        }


}
