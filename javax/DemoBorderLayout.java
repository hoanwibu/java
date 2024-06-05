package javax;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoBorderLayout extends JFrame {
    private JButton bn = new JButton("North"), bs = new JButton("south"), be = new JButton("east"),
            bw = new JButton("west"), bc = new JButton("center");

    public DemoBorderLayout() {
        setTitle("border layout");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(BorderLayout.NORTH, bn);
        add(BorderLayout.SOUTH, bs);
        add(BorderLayout.EAST, be);
        add(BorderLayout.WEST, bw);
        add(BorderLayout.CENTER, bc);

        bn.setBackground(Color.red);
        bn.setForeground(Color.white);
        be.setBackground(Color.blue);
        be.setForeground(Color.white);
        bs.setBackground(Color.cyan);
        bs.setForeground(Color.white);
        bw.setBackground(Color.green);
        bw.setForeground(Color.white);
        bc.setBackground(Color.pink);
        bc.setForeground(Color.white);
    }

    public static void main(String[] args) {
        new DemoBorderLayout().setVisible(true);
    }
}