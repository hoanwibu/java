package javax;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJWindow extends JWindow {

    public MyJWindow() {
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        setSize(500, 300);

        getContentPane().add(closeButton);
        pack();
        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyJWindow window = new MyJWindow();
            window.setVisible(true);
        });
    }
}
