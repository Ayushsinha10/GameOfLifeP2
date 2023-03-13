import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.Random;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;



public class GameBoard {
    
    private JButton[][] board;

    // New Gameboard where board size is passed in
    public GameBoard(int rows, int columns) {
        board = new JButton[rows][columns];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                board[x][y] = new JButton();
            }
        }
    }

    // Getter
    public JButton[][] getBoard() {
        return board;
    }

    // Setter
    public void setButton(int row, int col, JButton button) {
        board[row][col] = button;
    }

    //
    public JButton getButton(int row, int col) {
        return board[row][col];

    
    
    }
    public void setInitialBoardState() {
        Random randomBoardState = new Random();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (randomBoardState.nextBoolean()) {
                    board[x][y].setBackground(Color.BLACK);
                } else {
                    board[x][y].setBackground(Color.WHITE);
                }
            }
        }
    }

}