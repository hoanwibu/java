package javax;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ctncUI extends JFrame {
    public ctncUI(String title) {
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
        JLabel lblTitle = new JLabel("cộng trừ nhân chia");
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth, BorderLayout.NORTH);
        lblTitle.setForeground(Color.CYAN);
        Font ft = new Font("arial", Font.BOLD, 25);
        lblTitle.setFont(ft);
        JPanel pnWest = new JPanel();
        pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
        JButton btnGiai = new JButton("Giai    ");
        JButton btnXoa = new JButton("Xoa    ");
        JButton btnThoat = new JButton("Thoat    ");
        pnWest.add(btnGiai);
        pnWest.add(Box.createVerticalStrut(10));
        pnWest.add(btnXoa);
        pnWest.add(Box.createVerticalStrut(10));
        pnWest.add(btnThoat);
        pnBorder.add(pnWest, BorderLayout.WEST);
        pnWest.setBackground(Color.LIGHT_GRAY);
        Border southborder = BorderFactory.createLineBorder(Color.RED);
        TitledBorder southTitleBorder = new TitledBorder(southborder, "chon tac vu");
        pnWest.setBorder(southTitleBorder);
        JPanel pnSouth = new JPanel();
        pnSouth.setPreferredSize(new Dimension(0, 30));
        pnSouth.setBackground(Color.PINK);
        JPanel pns1 = new JPanel();
        pns1.setBackground(Color.BLUE);
        pnSouth.add(pns1);
        JPanel pns2 = new JPanel();
        pns2.setBackground(Color.RED);
        pnSouth.add(pns2);
        JPanel pns3 = new JPanel();
        pns3.setBackground(Color.YELLOW);
        pnSouth.add(pns3);
        pnBorder.add(pnSouth, BorderLayout.SOUTH);
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnBorder.add(pnCenter, BorderLayout.CENTER);
        Border centerBorder = BorderFactory.createLineBorder(Color.RED);
        TitledBorder centerTitledBorder = new TitledBorder(centerBorder, "nhap 2 so a va b");
        pnCenter.setBorder(centerTitledBorder);
        JPanel pna = new JPanel();
        JLabel lbla = new JLabel("nhap a");
        final JTextField txta = new JTextField(15);
        pna.add(lbla);
        pna.add(txta);
        pnCenter.add(pna);
        JPanel pnb = new JPanel();
        JLabel lblb = new JLabel("nhap b");
        final JTextField txtb = new JTextField(15);
        // JTextArea text = new JTextArea();
        pnb.add(lblb);
        pnb.add(txtb);
        pnCenter.add(pnb);
        JPanel pnc = new JPanel();
        JPanel pnpheptoan = new JPanel();
        pnpheptoan.setLayout(new GridLayout(2, 5));
        pnpheptoan.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "chon phep toan"));
        final JRadioButton radCong = new JRadioButton("Cong");
        pnpheptoan.add(radCong);
        final JRadioButton radTru = new JRadioButton("Tru");
        pnpheptoan.add(radTru);
        final JRadioButton radNhan = new JRadioButton("Nhan");
        pnpheptoan.add(radNhan);
        final JRadioButton radChia = new JRadioButton("Chia");
        pnpheptoan.add(radChia);
        pnpheptoan.add(radChia);
        ButtonGroup group = new ButtonGroup();
        group.add(radCong);
        group.add(radTru);
        group.add(radNhan);
        group.add(radChia);
        pnc.add(pnpheptoan);
        pnCenter.add(pnc);
        JPanel pnkq = new JPanel();
        JLabel lblkq = new JLabel("ket qua");
        final JTextField txtkq = new JTextField(15);
        pnkq.add(lblkq);
        pnkq.add(txtkq);
        pnCenter.add(pnkq);
        lbla.setPreferredSize(lblkq.getPreferredSize());
        lblb.setPreferredSize(lblkq.getPreferredSize());

        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int ret = JOptionPane.showConfirmDialog(null, "ban co muon thoat", "thoat", JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_NO_OPTION)
                    System.exit(0);
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txta.setText(" ");
                txtb.setText(" ");
                txtkq.setText(" ");
                txta.requestFocus();
            }
        });
        btnGiai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sa = txta.getText();
                int a = 0, b = 0;
                try {
                    a = Integer.parseInt(sa);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "a nhap sai dinh dang");
                    txta.selectAll();
                    txta.requestFocus();
                    return;
                }
                String sb = txtb.getText();
                try {
                    b = Integer.parseInt(sb);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "b nhap sai dinh dang");
                    txtb.selectAll();
                    txtb.requestFocus();
                    return;
                }
                double kq = 0;
                if (radCong.isSelected()) {
                    kq = (a + b);
                } else if (radTru.isSelected()) {
                    kq = (a - b);
                } else if (radNhan.isSelected()) {
                    kq = (a * b);
                } else {
                    kq = a * 1.0 / b * 1.0;
                }
                txtkq.setText(kq + "  ");
            }
        });
        Container con = getContentPane();
        con.add(pnBorder);
    }

    public static void main(String[] args) {
        ctncUI ui = new ctncUI("cong - tru - nhan - chia");
        ui.doShow();
    }
}
