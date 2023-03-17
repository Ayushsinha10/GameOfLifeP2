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
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;
public class Control{
    private GameBoard gamebor;
    private int timedelay = 50;
    private GameLogic gamelog;
    private Timer time;
    private JButton[][] board;
    private JButton[][] board2;

    public Control(GameLogic gamelog, JButton[][] board, GameBoard gamebor){
        this.gamebor = gamebor;
        this.gamelog = gamelog;
        this.board = board;
        
        this.time = new Timer(this.timedelay, gamelog);
       
        JFrame frame2 = new JFrame();
        JButton Save = new JButton("Save");
        JButton Load = new JButton("Load");
        JButton Play = new JButton("Play");
        JButton Pause = new JButton("Pause");
        JButton Exit = new JButton("Exit");
        JButton Slow = new JButton("Slower");
        JButton Fast = new JButton("Faster");
        JButton Random = new JButton("Random");
        JButton Clear = new JButton("Clear");
        JButton Step = new JButton("Step");
        JButton Normal = new JButton("Normal");
        Load.setBounds(150,100,100,50);
        Save.setBounds(15,100,100,50);
        Play.setBounds(150, 200, 100 ,50);
        Pause.setBounds(150, 0, 100, 50);
        Exit.setBounds(300, 100 , 100 , 50);
        Slow.setBounds(15, 0, 100, 50);
        Fast.setBounds(300, 0, 100,50);
        Random.setBounds(15,200,100,50);
        Clear.setBounds(300,200,100,50);
        Step.setBounds(300,150,100,50);
        Normal.setBounds(150, 150, 100, 50);
        
        Load.addActionListener(e ->{Load filed = new Load(board);});
        Save.addActionListener(e ->{Save file = new Save(gamelog.getBoard());});
        Play.addActionListener(e ->{this.ExecuteTimer();});
        Pause.addActionListener(e ->{this.EndTimer();});
        Slow.addActionListener(e ->{this.slowTime();});
        Fast.addActionListener(e ->{this.fastTime();});
        Random.addActionListener(e ->{this.random();
        gamelog.setBoard(this.board2);
        time.addActionListener(gamelog);});
        Clear.addActionListener(e ->{this.clear();
        gamelog.setBoard(this.board2);
        time.addActionListener(gamelog);});
        Step.addActionListener(e ->{gamelog.updateBoardState();
        time.addActionListener(gamelog);});
        Normal.addActionListener(e ->{time.setDelay(50);});
        Exit.addActionListener(e ->{System.exit(0);});
        Load.setPreferredSize(new Dimension(40,40));
        frame2.add(Normal);
        frame2.add(Step);
        frame2.add(Clear);
        frame2.add(Random);
        frame2.add(Load);
        frame2.add(Save);
        frame2.add(Play);
        frame2.add(Pause);
        frame2.add(Exit);
        frame2.add(Slow);
        frame2.add(Fast);
        
        
       
       
        frame2.setSize(400, 300);
        

        frame2.setLayout(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        


    }
    public void ExecuteTimer(){
        this.time.start();
        
    }
      public void EndTimer(){
        this.time.stop();
        
    }
      public void restartTimer(){
        this.time.stop();
        this.time.start();
        
    }
    public void slowTime(){
        this.timedelay +=10;
        
        time.setDelay(this.timedelay);
       
    }
     public void fastTime(){
        if (timedelay < 20){
            this.time.stop();
            return;
        }
        this.timedelay -=10;
        
        time.setDelay(this.timedelay);
       
    }
     
     public void random(){
        this.gamebor.setRandomState();
        this.board2 = this.gamebor.getBoard();
        
        
    }
    public void clear(){
        this.gamebor.setInitialBoardState();
        this.board2 = this.gamebor.getBoard();

    }
    



}