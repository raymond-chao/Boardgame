import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public class Boardgame extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JButton[] buttons = new JButton[16];
    JButton newGame = new JButton("New Game");

    int moves = 0;
    JLabel moveLabel = new JLabel("Moves: 0");


    public Boardgame() {
        setTitle("Boardgame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Color backgroundColor = Color.black;
        Color buttonColor = Color.GRAY;

        panel.setBackground(backgroundColor);


        panel.setLayout(new GridLayout(4, 4, 3, 3));
        for (int i = 0; i < 15; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
        buttons[15] = new JButton(" ");
        buttons[15].addActionListener(this);
        panel.add(buttons[15]);

        add(panel,  BorderLayout.CENTER);
        for (JButton button : buttons) {
            button.setBackground(buttonColor);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 15));
        }


        //nedre panel
        panel1.add(newGame);
        panel1.add(moveLabel);
        newGame.addActionListener(this);
        add(panel1, BorderLayout.SOUTH);




        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        Shuffle();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            System.out.println("Nytt spel!");
            Shuffle();

        } else{
            for (JButton button : buttons) {
                if (button == e.getSource()) {
                    System.out.println("Klickade på knapp: " + button.getText());
                    int clicked = -1;
                    int empty = -1;

                    for (int i = 0; i < buttons.length; i++) {
                        if (buttons[i] == e.getSource()) clicked = i;
                        if (buttons[i].getText().equals(" ")) empty = i;

                    }
                    if (isNextTo(clicked, empty)) {
                        String temp = buttons[clicked].getText();
                        buttons[clicked].setText(" ");
                        buttons[empty].setText(temp);
                        moves++;
                        moveLabel.setText("Moves: " + moves);
                    }
                    if (isWinner()) {
                        JOptionPane.showMessageDialog(this, "Du vann!");
                    }

                    break;
                }
            }
        }
    }
    public void Shuffle(){
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            numbers.add(String.valueOf(i + 1));
        }
        numbers.add(" ");
        Collections.shuffle(numbers);

        for (int i = 0; i < 16; i++) {
            buttons[i].setText(numbers.get(i));

        }
        moves = 0;
        moveLabel.setText("Moves: 0");

    }
    private boolean isNextTo(int i, int j) {
        int row1 = i / 4;
        int col1 = i % 4;
        int row2 = j / 4;
        int col2 = j % 4;

        return (Math.abs(row1 - row2) == 1 && col1 == col2) ||
                (Math.abs(col1 - col2) == 1 && row1 == row2);
    }
    private boolean isWinner() {
        for (int i = 0; i < 15; i++) {
            if (!buttons[i].getText().equals(String.valueOf(i + 1))) {
                return false;
            }
        }
        return buttons[15].getText().equals(" ");
    }
    public static void main(String[] args) {
        Boardgame boardgame = new Boardgame();
    }

}
