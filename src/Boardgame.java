import javax.swing.*;
import java.awt.*;

public class Boardgame extends JFrame {
    JPanel panel = new JPanel();
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton ten = new JButton("10");
    JButton eleven = new JButton("11");
    JButton twelve = new JButton("12");
    JButton thirteen = new JButton("13");
    JButton fourteen = new JButton("14");
    JButton fifteen = new JButton("15");
    JButton sixteen = new JButton(" ");


    public Boardgame() {
        setTitle("Boardgame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(panel);
        panel.setLayout(new GridLayout(4, 4));

        //add button
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(ten);
        panel.add(eleven);
        panel.add(twelve);
        panel.add(thirteen);
        panel.add(fourteen);
        panel.add(fifteen);
        panel.add(sixteen);



        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        Boardgame boardgame = new Boardgame();
    }
}
