import com.tictactoe.*;

public class testingclass {
    public static void main(String[] args) {
        com.tictactoe.Board board = new com.tictactoe.Board((byte) 3);
        byte [] [] board1 = board.getBoard();
        for (int i = 0; i < board1.length; i++){
            for (int j = 0; j < board1[i].length; j++){
                System.out.print(board1[i][j] + " ");
            }System.out.println();
        }
    }
}
