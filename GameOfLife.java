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
import java.awt.*;
import javax.swing.*;

// THIS IS WHERE MAIN GAME IS LOADED, CLASSPATH to start game: java GameOfLife
public class GameOfLife {
    public static void main(String[] args) {
        MyGridLayout gridLayout = new MyGridLayout();
        GameBoard gameBoard = new GameBoard(50, 50);
        List<JButton> buttonList = gridLayout.getButtonList();
                
        int index = 0;
        for (int row = 0; row < 50; row++) {
        for (int column = 0; column < 50; column++) {
        gameBoard.setButton(row, column, buttonList.get(index));
        index++;
    }
}
        
        gameBoard.setInitialBoardState();

        JButton[][] board = gameBoard.getBoard();
        for (int row = 0; row < 50; row++) {
        for (int column = 0; column < 50; column++) {
            board[row][column].setBackground(Color.white);
        }
    }

        
        GameLogic gameLogic = new GameLogic(board);
        Control controls = new Control(gameLogic, board, gameBoard);
        
       
       
       
        
      
    }
    
    
}
