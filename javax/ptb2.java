
package javax;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ptb2 {

    public void GUI() {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);

        JPanel pnBorder = new JPanel();
        pnBorder.setLayout(new BorderLayout());

        JPanel pnNorth = new JPanel();
        JLabel lblTitle = new JLabel("Phương Trình Bậc 2");
        pnNorth.setPreferredSize(new Dimension(0, 30));
        pnNorth.setBackground(Color.CYAN);
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth, BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.setPreferredSize(new Dimension(0, 100));

        JPanel pna = new JPanel();
        pna.setBackground(Color.RED);
        JLabel lblA = new JLabel("a");
        JTextField txtA = new JTextField(10);
        pna.add(lblA);
        pna.add(txtA);
        pnCenter.add(pna);

        JPanel pnb = new JPanel();
        JLabel lblB = new JLabel("b");
        pnb.setBackground(Color.BLUE);
        JTextField txtB = new JTextField(10);
        pnb.add(lblB);
        pnb.add(txtB);
        pnCenter.add(pnb);

        JPanel pnc = new JPanel();
        JLabel lblC = new JLabel("c");
        pnc.setBackground(Color.GREEN);
        JTextField txtC = new JTextField(10);
        pnc.add(lblC);
        pnc.add(txtC);
        pnCenter.add(pnc);

        JPanel pnkq = new JPanel();
        JLabel lblkq = new JLabel("ket qua");
        final JTextArea txtkq = new JTextArea(2, 10);
        pnkq.add(lblkq);
        pnkq.add(txtkq);
        pnCenter.add(pnkq);

        JPanel pnbt = new JPanel();
        JButton btnTinh = new JButton("Tính");
        JButton btnThoat = new JButton("Thoát");
        pnbt.add(btnTinh);
        pnbt.add(btnThoat);
        pnCenter.add(pnbt);

        pnBorder.add(pnCenter);

        f.add(pnBorder);
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
        f.setVisible(true);
    };

    public static void main(String[] args) {
        new ptb2().GUI();
    }
}