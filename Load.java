import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import java.awt.Color;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Load {
    private JButton[][] tboard;
    private String line;
    public Load(JButton[][] board){
       
        try{
        File save = new File("./save.gol");
        Scanner reader = new Scanner(save);
        for (int indexX = 0; indexX < board.length; indexX++) {
            if (reader.hasNext()){
            String line = reader.nextLine();
            this.line = line;
            
            }
            else{
                return;
            }

                    
            for (int indexY = 0; indexY < board[0].length; indexY++) {
                char ch = line.charAt(indexY);
                char test = '.';
                if (ch == test) {
                    board[indexX][indexY].setBackground(Color.WHITE);
                } else {
                    board[indexX][indexY].setBackground(Color.BLACK);
                }
            }
            this.tboard = board;
        }

        
        
     
        
        }
        catch(FileNotFoundException e){
            System.out.println("No Save Avaliable!");
        }
        
        
       
       

    }
    public JButton[][] getBoard(){
        return this.tboard;
            
    }
    
}
