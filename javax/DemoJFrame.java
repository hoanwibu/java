package javax;

import javax.swing.JFrame;

public class DemoJFrame extends JFrame {
    public DemoJFrame() {
        setTitle("Demo JFrame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        new DemoJFrame().setVisible(true);
    }
}
