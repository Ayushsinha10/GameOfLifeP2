import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

public class GameLogic implements ActionListener {

    private JButton[][] board;
    private int rows;
    private int columns;
    
    public GameLogic(JButton[][] board) {
        this.board = board;
        this.rows = board.length;
        this.columns = board[0].length;
    }

    public void actionPerformed(ActionEvent e) {
        updateBoardState();
    }

    public void updateBoardState() {
        boolean[][] nextBoard = new boolean[rows][columns];
        int x = 2;
        int y = 3;
        int z = 3;

        // compute next board state based on current state
        for (int counterX = 0; counterX < rows; counterX++) {
            for (int counterY = 0; counterY < columns; counterY++) {
                int aliveNeighbors = countAliveNeighbors(counterX, counterY);
                if (board[counterX][counterY].getBackground() == Color.BLACK) {
                    // cell is alive (current state)
                    if (aliveNeighbors < x || aliveNeighbors > y) {
                        // A live cell with more than y live neighbours dies
                        // A live cell with fewer than x live neighbours dies
                        nextBoard[counterX][counterY] = false;
                    } else {
                        // A live cell with x to y live neighbours remains live
                        nextBoard[counterX][counterY] = true;
                    }
                } else {
                    // cell is dead (current state)
                    if (aliveNeighbors == z) {
                        // A dead cell with exactly z live neighbours becomes live
                        nextBoard[counterX][counterY] = true;
                    } else {
                        // cell stays dead
                        nextBoard[counterX][counterY] = false;
                    }
                }
            }
        }
        
        // update board state to next state
        for (int indexX = 0; indexX < rows; indexX++) {
            for (int indexY = 0; indexY < columns; indexY++) {
                if (nextBoard[indexX][indexY]) {
                    board[indexX][indexY].setBackground(Color.BLACK);
                } else {
                    board[indexX][indexY].setBackground(Color.WHITE);
                }
            }
        }
    }
    
    private int countAliveNeighbors(int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < columns) {
                    if (board[i][j].getBackground() == Color.BLACK && !(i == x && j == y)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public JButton[][] getBoard(){
        return this.board;
    }
    public void setBoard(JButton[][] board){
        this.board = board;
        
    }
}

