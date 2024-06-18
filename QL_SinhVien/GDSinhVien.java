package QL_SinhVien;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class GDSinhVien extends JFrame implements ActionListener, MouseListener {
    private static final long serialVersionUID = 1L;
    private JTextField tfMaso;
    private JComboBox<String> cbomalop;
    private JTextField tfdiemLT;
    private JTextField tfdiemTH;
    private JTextField tfdiemTB;
    private JTextField tfKQ;
    private JButton bttKQ;
    private JButton bttThem;
    private DefaultTableModel dfModel;
    private JTable table;
    private JTextField tfHoten;
    private DSSinhVien ds;
    private JButton bttClear;
    private JButton bttLuu;
    private JButton bttXoa;
    private JButton bttSua;
    private JButton bttTim;
    private final String FILENAME = "DATA_SINHVIEN.DAT";

    public GDSinhVien() {
        setTitle("Chương trình quản lý sinh viên");
        setSize(1920, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
        napDSSinhVien(FILENAME);
    }

    private void napDSSinhVien(String file) {
        if (new File(file).exists()) {
            try {
                FileInputStream in = new FileInputStream(FILENAME);
                ObjectInputStream oos = new ObjectInputStream(in);
                ds = (DSSinhVien) oos.readObject();
                napVaoBang();
                oos.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "IO Error!");
                return;
            }
        } else
            ds = new DSSinhVien();
    }

    private void napVaoBang() {

        for (int i = 0; i < ds.tongSinhVien(); i++) {
            SinhVien sv = ds.getSinhVien(i);
            String[] dataRow = { sv.getMasv(), sv.getHoten(), sv.getMalop(), sv.getDiemLT() + "", sv.getDiemTH() + "",
                    sv.diemTB() + "", sv.KQ() };
            dfModel.addRow(dataRow);
        }
    }

    private void buildGUI() {
        JPanel pnlLeft = new JPanel(new GridLayout(0, 1));
        pnlLeft.add(new JLabel("Thong tin sinh vien", JLabel.CENTER));
        pnlLeft.add(new JLabel("ma sinh vien:  "));
        pnlLeft.add(tfMaso = new JTextField(20));
        pnlLeft.add(new JLabel("Ho Va Ten:  "));
        pnlLeft.add(tfHoten = new JTextField(20));
        pnlLeft.add(new JLabel("Ma Lop"));
        pnlLeft.add(cbomalop = new JComboBox<String>());
        String[] dslop = { "DHTHA", "DHTHB", "DHTHC", "DHTHD", "DHTHK" };
        for (int i = 0; i < dslop.length; i++) {
            cbomalop.addItem(dslop[i]);
        }
        pnlLeft.add(new JLabel("diem ly thuyet  "));
        pnlLeft.add(tfdiemLT = new JTextField(20));
        pnlLeft.add(new JLabel("diem thuc hanh"));
        pnlLeft.add(tfdiemTH = new JTextField(20));
        pnlLeft.add(new JLabel("diem trung binh"));
        pnlLeft.add(tfdiemTB = new JTextField(20));
        tfdiemTB.setEditable(false);
        pnlLeft.add(new JLabel("ket qua"));
        pnlLeft.add(tfKQ = new JTextField(20));
        tfKQ.setEditable(false);

        JPanel pnlLeftBottom;
        pnlLeft.add(pnlLeftBottom = new JPanel());
        pnlLeftBottom.add(bttKQ = new JButton("ket qua"));
        pnlLeftBottom.add(bttThem = new JButton("them"));
        pnlLeftBottom.add(bttClear = new JButton("clear"));

        JPanel pnlLeftBottom2;
        pnlLeft.add(pnlLeftBottom2 = new JPanel());
        pnlLeftBottom2.add(bttLuu = new JButton("luu"));
        pnlLeftBottom2.add(bttXoa = new JButton("xoa"));
        pnlLeftBottom2.add(bttSua = new JButton("sua"));
        pnlLeftBottom2.add(bttTim = new JButton("tim"));

        JPanel pnlRight = new JPanel(new GridLayout(1, 1));
        String[] headers = { "masv", "hoten", "lop", "Ly thuyet", "Thuc hanh", "Trung Binh", "Ket Qua" };
        pnlRight.add(new JScrollPane(table = new JTable(dfModel = new DefaultTableModel(headers, 0))));
        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlLeft, pnlRight));

        bttClear.addActionListener(this);
        bttKQ.addActionListener(this);
        bttThem.addActionListener(this);
        bttLuu.addActionListener(this);
        bttSua.addActionListener(this);
        bttTim.addActionListener(this);
        bttXoa.addActionListener(this);

        table.addMouseListener(this);
    }

    public static void main(String[] args) {
        new GDSinhVien().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int vitri = table.getSelectedRow();
        SinhVien sv = ds.getSinhVien(vitri);
    }

    private void napLaiThongTin(SinhVien sv) {
        tfMaso.setText(sv.getMasv());
        tfHoten.setText(sv.getHoten());
        cbomalop.setSelectedItem(sv.getMalop());
        tfdiemLT.setText(sv.getDiemLT() + " ");
        tfdiemTH.setText(sv.getDiemTH() + " ");
        tfdiemTB.setText(sv.diemTB() + " ");
        tfKQ.setText(sv.KQ());
        tfMaso.requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bttSua)) {
            try {
                SinhVien svVersion2 = new SinhVien(tfMaso.getText(), tfHoten.getText(),
                        cbomalop.getSelectedItem().toString(), Double.parseDouble(tfdiemLT.getText()),
                        Double.parseDouble(tfdiemTH.getText()));
                if (!ds.suaTTSinhVien(tfMaso.getText(), svVersion2)) {
                    JOptionPane.showMessageDialog(null, "khong ton tai sinh vien co ma so: " + tfMaso.getText());
                    return;
                } else
                    napVaoBang();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "loi");
                return;
            }
        } else if (e.getSource().equals(bttTim)) {
            try {
                String masv = JOptionPane.showInputDialog("nhap ma so sinh vien can tim:  ");
                if (masv != null && masv.trim().equals(" ")) {
                    SinhVien sv = ds.timkiem(masv);
                    if (sv != null)
                        napLaiThongTin(sv);
                    else {
                        JOptionPane.showMessageDialog(null, "khong ton tai sinh vien co ma so : " + masv);
                        return;
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "loi");
                return;
            }
        } else if (e.getSource().equals(bttXoa)) {
            try {
                String masv = JOptionPane.showInputDialog("nhap ma so sv can xoa: ");
                if (masv != null && masv.trim().equals(" ")) {
                    SinhVien sv = ds.timkiem(masv);
                    if (sv != null) {
                        if (JOptionPane.showConfirmDialog(null, "cos chac chan muon xoa sv khong", "thong bao",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            ds.xoaSinhVien(masv);
                            napVaoBang();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "khong ton tai sv " + masv);
                        return;
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "loi");
                return;
            }
        } else if (e.getSource().equals(bttLuu)) {
            try {
                FileOutputStream out = new FileOutputStream(FILENAME);
                ObjectOutputStream oss = new ObjectOutputStream(out);
                oss.writeObject(ds);
                oss.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "IO Errir!");
                return;
            }
        } else if (e.getSource().equals(bttClear)) {
            tfMaso.setText("  ");
            tfHoten.setText("  ");
            tfdiemLT.setText("  ");
            tfdiemTB.setText("  ");
            tfdiemTH.setText("  ");
            tfMaso.requestFocus();
        } else {
            String masv = "", hoten = "", malop = "";
            double DiemLT = 0.0, DiemTH = 0.0;
            SinhVien sv = null;

            try {
                masv = tfMaso.getText();
                hoten = tfHoten.getText();
                malop = cbomalop.getSelectedItem().toString();
                DiemLT = Double.parseDouble(tfdiemLT.getText());
                DiemTH = Double.parseDouble(tfdiemTH.getText());
                sv = new SinhVien(masv, hoten, malop, DiemLT, DiemTH);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "loi" + ex.getMessage());
                return;
            }
            if (e.getSource().equals(bttThem)) {
                if (!ds.themsv(sv)) {
                    JOptionPane.showMessageDialog(null, "trung ma so");
                    return;
                }
            }
            String[] dataRow = { sv.getMasv(),
                    sv.getHoten(), sv.getMalop(),
                    Double.toString(sv.getDiemLT()), sv.getDiemTH() + " ", sv.diemTB() + "", sv.KQ() };
            dfModel.addRow(dataRow);
            if (e.getSource().equals(bttKQ)) {
                tfdiemTB.setText(sv.diemTB() + " ");
                tfKQ.setText(sv.KQ());
            }
        }
    }
}