import javax.swing.*;
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


    public Boardgame() {
        setTitle("Boardgame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel.setLayout(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < 15; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
        buttons[15] = new JButton(" ");
        buttons[15].addActionListener(this);
        panel.add(buttons[15]);

        add(panel,  BorderLayout.CENTER);


        //nedre panel
        panel1.add(newGame);
        newGame.addActionListener(this);
        add(panel1, BorderLayout.SOUTH);




        pack();
        setVisible(true);
        setLocationRelativeTo(null);
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
//                    FLYTTABRICKA
                    break;
                }
            }
        }
    }
    public void Shuffle(){
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            numbers.add(String.valueOf(i));
        }
        numbers.add(" ");
        Collections.shuffle(numbers);

        for (int i = 0; i < 16; i++) {
            buttons[i].setText(numbers.get(i));

        }

    }
    public static void main(String[] args) {
        Boardgame boardgame = new Boardgame();
    }

}
