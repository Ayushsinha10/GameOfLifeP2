import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JPanel;

import javax.swing.UIManager;

public class MyGridLayout implements ActionListener {
    private List<JButton> buttonList = new ArrayList<>();

    public MyGridLayout() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {}

        JFrame frame = new JFrame();
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(50, 50));

        JButton[] buttons = new JButton[2500];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttonList.add(buttons[i]);
            frame.add(buttons[i]);
        }
        
        frame.setVisible(true);
        
        
       
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.BLACK);
    }
}








