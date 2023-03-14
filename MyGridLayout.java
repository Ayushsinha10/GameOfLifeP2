import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class MyGridLayout implements ActionListener {
    private List<JButton> buttonList;

    public static void main(String[] args) {
        MyGridLayout obj = new MyGridLayout();
        obj.createGrid();
    }

    public void createGrid() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 10));

        JButton[] buttons = new JButton[100];
        buttonList = new ArrayList<>();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                int index = row * 10 + col;
                buttons[index] = new JButton();
                buttons[index].putClientProperty("row", row);
                buttons[index].putClientProperty("col", col);
                buttons[index].addActionListener(this);
                buttonList.add(buttons[index]);
                frame.add(buttons[index]);
            }
        }

        // Access the button at row 2, column 3
        // Can find a specific button with given x and y values
        int x = 2;
        int y = 3;
        for (JButton button : buttonList) {
            int row = (int) button.getClientProperty("row");
            int col = (int) button.getClientProperty("col");
            if (row == x && col == y) {
                button.setBackground(Color.RED);
                break;
            }
        }
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.BLACK);
    }
}
