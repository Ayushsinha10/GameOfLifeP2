import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class MyGridLayout implements ActionListener {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 10));

        JButton[] buttons = new JButton[100];
        //ArrayList to store position of individual buttons
        List<JButton> buttonList = new ArrayList<>();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            MyGridLayout listener = new MyGridLayout();
            buttons[i].addActionListener(listener);
            buttonList.add(buttons[i]);
            frame.add(buttons[i]);
        }
        
        // Accessing individual buttons, TEST
        buttonList.get(0).setBackground(Color.RED);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.BLACK);
    }
}







