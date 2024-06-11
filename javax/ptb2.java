package javax;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ptb2 extends JFrame {
    public ptb2(String title) {
        setTitle(title);
    }

    public void doShow() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addControl();
        setResizable(true);
        setVisible(true);
    }

    public void addControl() {
        JPanel pnBorder = new JPanel();
        pnBorder.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTitle = new JLabel("Phương Trình Bậc 2");
        pnNorth.add(lblTitle);
        add(pnNorth);
        JPanel pnCenter = new JPanel();
        JLabel lblA = new JLabel("a");
        JLabel lblB = new JLabel("b");
        JLabel lblC = new JLabel("c");
        JTextField txtA = new JTextField(3);
        JTextField txtB = new JTextField(3);
        JTextField txtC = new JTextField(3);
        pnCenter.add(lblA);
        pnCenter.add(txtA);
        pnCenter.add(lblB);
        pnCenter.add(txtB);
        pnCenter.add(lblC);
        pnCenter.add(txtC);
        JButton btnTinh = new JButton("Tính");
        JButton btnThoat = new JButton("Thoát");
        pnCenter.add(btnTinh);
        pnCenter.add(btnThoat);
        JPanel pnkq = new JPanel();
        JLabel lblkq = new JLabel("ket qua");
        final JTextArea txtkq = new JTextArea(5, 10);
        pnkq.add(lblkq);
        pnkq.add(txtkq);
        pnCenter.add(pnkq);
        add(pnCenter, BorderLayout.CENTER);
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát", "Thoát", JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        btnTinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sa = txtA.getText();
                String sb = txtB.getText();
                String sc = txtC.getText();
                float a, b, c;
                try {
                    a = Float.parseFloat(sa);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "a nhap sai dinh dang");
                    return;
                }
                try {
                    b = Float.parseFloat(sb);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "b nhap sai dinh dang");
                    return;
                }
                try {
                    c = Float.parseFloat(sc);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "c nhap sai dinh dang");
                    return;
                }
                float d;
                d = b * b - 4 * a * c;
                if (d < 0) {
                    txtkq.setText("pt vo ng");
                } else if (d == 0) {
                    txtkq.setText("pt co ng duy nhat\n");
                    txtkq.setText(" " + -b / 2 * a);
                } else if (d > 0) {
                    float x1 = (float) ((-b + Math.sqrt(d)) / (2 * a)); 
                    float x2 = (float) ((-b - Math.sqrt(d)) / (2 * a));
                    txtkq.setText("x1 = " + x1 + "\nx2 = " + x2);
                }

            }

        });
    };

    public static void main(String[] args) {
        ptb2 ui = new ptb2("Phương Trình Bậc 2");
        ui.doShow();
    }
}