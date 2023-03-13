import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import java.awt.Color;
import java.io.FileWriter;
public class Save{
    
    public Save(JButton[][] board){
          

            try {   
                File test = new File("./save.gol");
                FileOutputStream fileStream = new FileOutputStream(test);   
                FileWriter objectStream = new FileWriter(test);   
                
                for (int indexX = 0; indexX < board.length; indexX++) {
                    
                    for (int indexY = 0; indexY < board[0].length; indexY++) {
                        if (board[indexX][indexY].getBackground() == Color.BLACK) {
                            objectStream.write(".");
                        } else {
                            objectStream.write("o");
                        }
                    }
                    objectStream.write('\n');
                }
             
        
                objectStream.close();   
                fileStream.close();   
        
               
            } 
            catch(FileNotFoundException e){
                e.printStackTrace();

            }
            
            catch (IOException e) {   
                e.printStackTrace();
                   
            }   
        
    
    
    }

}