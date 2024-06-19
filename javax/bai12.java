package javax;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.*;

public class bai12 extends JFrame {
    int counter = 0;

    public bai12() {
        setTitle("Push counter");
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton jb = new JButton("Push me!");
        add(jb);
        JLabel Ct = new JLabel("countes: " + counter);
        add(Ct);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ct.setText("countes: " + counter);
                counter++;
                add(Ct);
            }
        });

    }

    public static void main(String[] args) {
        new bai12().setVisible(true);
    }
}