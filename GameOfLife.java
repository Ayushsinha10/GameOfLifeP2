import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout; 
import javax.swing.Timer;

// THIS IS WHERE MAIN GAME IS LOADED, CLASSPATH to start game: java GameOfLife
public class GameOfLife {
    public static void main(String[] args) {
        MyGridLayout gridLayout = new MyGridLayout();
        GameBoard gameBoard = new GameBoard(50, 50);
        List<JButton> buttonList = gridLayout.getButtonList();
        
        for (int counter = 0; counter < buttonList.size(); counter++) {
            int row = counter / 50;
            int column = counter % 50;
            gameBoard.setButton(row, column, buttonList.get(counter));
        }
        
        gameBoard.setInitialBoardState();

        JButton[][] board = gameBoard.getBoard();

        for (int counter = 0; counter < board.length; counter++) {
            int row = counter / 50;
            int col = counter % 50;
            board[row][col].setBackground(Color.RED);
        }
        
        GameLogic gameLogic = new GameLogic(board);
        Timer timer = new Timer(50, gameLogic);
        timer.start();
    }
}
