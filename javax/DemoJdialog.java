package javax;

import javax.swing.JDialog;

public class DemoJdialog extends JDialog {
    public DemoJdialog() {
        setTitle("Demo JDialog");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
    }

    public static void main(String[] args) {
        new DemoJdialog().setVisible(true);
    }
}