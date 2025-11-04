import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Boardgame extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JButton[] buttons = new JButton[16];
    JButton newGame = new JButton("New Game");


    public Boardgame() {
        setTitle("Boardgame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panel.setLayout(new GridLayout(4, 4));
        add(panel);

        //nedre panel
        add(panel1);
        panel1.add(newGame);
        newGame.addActionListener(this);



        pack();
        setVisible(true);

    }

    public void Function() {
    }

    public static void main(String[] args) {
        Boardgame boardgame = new Boardgame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
