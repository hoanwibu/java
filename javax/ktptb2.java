package javax;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.awt.*;

public class ktptb2 {
    public void GUI() {
        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnBorder = new JPanel();
        pnBorder.setLayout(new BorderLayout());

        JPanel pnNorth = new JPanel();
        JLabel lblTitle = new JLabel();
        lblTitle.setText("Phuong trinh bac 2");
        pnNorth.setPreferredSize(new Dimension(0, 30));
        pnNorth.setBackground(Color.CYAN);
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth, BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.setPreferredSize(new Dimension(0, 100));

        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnBorder.add(pnCenter, BorderLayout.CENTER);
        Border centerborder = BorderFactory.createLineBorder(Color.RED);
        TitledBorder centerTitleBorder = new TitledBorder(centerborder, "nhap 3 so a,b,c");
        pnCenter.setBorder(centerTitleBorder);

        JPanel pna = new JPanel();
        JLabel lba = new JLabel("a");
        JTextField txa = new JTextField(10);
        pna.add(lba);
        pna.add(txa);
        pnCenter.add(pna);

        JPanel pnb = new JPanel();
        JLabel lbb = new JLabel("b");
        JTextField txb = new JTextField(10);
        pnb.add(lbb);
        pnb.add(txb);
        pnCenter.add(pnb);

        JPanel pnc = new JPanel();
        JLabel lbc = new JLabel("c");
        JTextField txc = new JTextField(10);
        pnc.add(lbc);
        pnc.add(txc);
        pnCenter.add(pnc);

        JPanel pnkq = new JPanel();
        JLabel lbkq = new JLabel("ket qua:");
        final JTextArea txkq = new JTextArea(2, 10);
        pnkq.add(lbkq);
        pnkq.add(txkq);
        pnCenter.add(pnkq);

        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
        pnBorder.add(pnSouth, BorderLayout.SOUTH);
        Border Southborder = BorderFactory.createLineBorder(Color.BLUE);
        TitledBorder SouthTitleBorder = new TitledBorder(Southborder, "Chon chuc nang");
        pnSouth.setBorder(SouthTitleBorder);

        JPanel pnBt = new JPanel();
        JButton bttinh = new JButton("Tinh");
        JButton btxoa = new JButton("Xoa");
        JButton btthoat = new JButton("Thoat");
        pnBt.add(bttinh);
        pnBt.add(btxoa);
        pnBt.add(btthoat);
        pnSouth.add(pnBt);
        pnBorder.add(pnSouth);

        txc.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String sa = txa.getText();
                    String sb = txb.getText();
                    String sc = txc.getText();
                    float a, c, b;
                    try {
                        a = Float.parseFloat(sa);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "a nhap sai dinh dang");
                        return;
                    }
                    try {
                        b = Float.parseFloat(sb);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "a nhap sai dinh dang");
                        return;
                    }
                    try {
                        c = Float.parseFloat(sc);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "a nhap sai dinh dang");
                        return;
                    }
                    float d;
                    d = b * b - 4 * a * c;
                    if (d < 0) {
                        txkq.setText("Phuong trinh vo nghiem");
                    } else if (d == 0) {
                        txkq.setText("pt co nghiem duy nhat");
                        txkq.setText(" " + -b / 2 * a);
                    } else if (d > 0) {
                        float x1 = (float) ((-b + Math.sqrt(d)) / (2 * a));
                        float x2 = (float) ((-b - Math.sqrt(d)) / (2 * a));
                        txkq.setText("x1 = " + x1 + "\nx2 = " + x2);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        btthoat.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                "ESCAPE");
        btthoat.getActionMap().put("ESCAPE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btthoat.doClick();
            }
        });
        btthoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát", "Thoát", JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        btxoa.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0),
                "DELETE");
        btxoa.getActionMap().put("DELETE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btxoa.doClick();
            }
        });
        btxoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txa.setText("");
                txb.setText("");
                txc.setText("");
                txkq.setText("");
            }
        });

        pnCenter.add(pnSouth);
        pnBorder.add(pnCenter);
        f.add(pnBorder);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new ktptb2().GUI();
    }
}