package javax.CD;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class GiaoDienCD extends JFrame implements ActionListener, MouseListener {
    private static final String FILENAME = "DSCD";
    private JTextField tfMaSo;
    private JTextField tfTua;
    private JTextField tfCaSy;
    private JTextField tfSoBaiHat;
    private JTextField tfGiaThanh;
    private JButton btThem;
    private JButton btLuu;
    private JButton btXoa;
    private JButton btSua;
    private JButton btTim;
    private JTable table;
    private DefaultTableModel dfModel;
    private JButton btClear;
    private DSCD ds;

    public GiaoDienCD() {
        setTitle("Chương trình quản lý CD");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
        createDB();
    }

    private void createDB() {
        if (new File(FILENAME).exists())
            napDuLieu();
        else
            ds = new DSCD();
    }

    private void napDuLieu() {
        FileInputStream in = null;
        ObjectInputStream ois = null;
        try {
            in = new FileInputStream(FILENAME);
            ois = new ObjectInputStream(in);
            ds = (DSCD) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi IO");
            return;
        }
        napVaoBang();
    }

    private void buildGUI() {
        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();
        Box b4 = Box.createHorizontalBox();
        Box b5 = Box.createHorizontalBox();
        Box b6 = Box.createHorizontalBox();
        Box b7 = Box.createHorizontalBox();

        b1.add(new JLabel("THÔNG TIN CD", JLabel.CENTER));
        JLabel lbMaSo, lbTuaDe, lbCaSy, lbSoBaiHat, lbGia;
        b2.add(lbMaSo = new JLabel("Mã số: "));
        b2.add(tfMaSo = new JTextField(20));
        b3.add(lbTuaDe = new JLabel("Tựa đề: "));
        b3.add(tfTua = new JTextField(20));
        b4.add(lbCaSy = new JLabel("Ca sỹ: "));
        b4.add(tfCaSy = new JTextField(20));
        b5.add(lbSoBaiHat = new JLabel("Số bài hát: "));
        b5.add(tfSoBaiHat = new JTextField(20));
        b6.add(lbGia = new JLabel("Giá thành: "));
        b6.add(tfGiaThanh = new JTextField(20));
        lbCaSy.setPreferredSize(lbSoBaiHat.getPreferredSize());
        lbMaSo.setPreferredSize(lbSoBaiHat.getPreferredSize());
        lbTuaDe.setPreferredSize(lbSoBaiHat.getPreferredSize());
        lbGia.setPreferredSize(lbSoBaiHat.getPreferredSize());
        lbCaSy.setPreferredSize(lbSoBaiHat.getPreferredSize());
        b7.add(btThem = new JButton("Thêm"));
        btThem.setMnemonic('T');
        b7.add(btClear = new JButton("Clear"));
        btClear.setMnemonic('C');
        b7.add(btLuu = new JButton("Lưu"));
        btLuu.setMnemonic('L');
        b7.add(btXoa = new JButton("Xóa"));
        btXoa.setMnemonic('X');
        b7.add(btSua = new JButton("Sửa"));
        btSua.setMnemonic('S');
        b7.add(btTim = new JButton("Tìm"));
        btTim.setMnemonic('M');
        btThem.addActionListener(this);
        btLuu.addActionListener(this);
        btXoa.addActionListener(this);
        btSua.addActionListener(this);
        btTim.addActionListener(this);
        btClear.addActionListener(this);
        b.add(Box.createVerticalStrut(5));
        b.add(b1);
        b.add(Box.createVerticalStrut(5));
        b.add(b2);
        b.add(Box.createVerticalStrut(5));
        b.add(b3);
        b.add(Box.createVerticalStrut(5));
        b.add(b4);
        b.add(Box.createVerticalStrut(5));
        b.add(b5);
        b.add(Box.createVerticalStrut(5));
        b.add(b6);
        b.add(Box.createVerticalStrut(5));
        b.add(b7);
        b.add(Box.createVerticalStrut(5));
        JPanel pnl;
        b.add(pnl = new JPanel(new GridLayout(1, 1)));
        String[] headers = { "STT", "Mã CD", "Tựa CD", "Ca sỹ", "Số bài hát", "Đơn giá" };
        pnl.add(new JScrollPane(table = new JTable(dfModel = new DefaultTableModel(headers, 0))));
        table.addMouseListener(this);
        add(b);
    }

    public static void main(String[] args) {
        new GiaoDienCD().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tableAction();
    }

    private void tableAction() {
        int viTri = table.getSelectedRow();
        if (viTri >= 0 && viTri < ds.tongCD()) {
            CD cd = ds.getCD(viTri);
            napVaoCacONhapLieu(cd);
        }
    }

    private void napVaoCacONhapLieu(CD cd) {
        tfMaSo.setText(cd.getmaCD());
        tfTua.setText(cd.gettuaCD());
        tfCaSy.setText(cd.getCasy());
        tfSoBaiHat.setText(cd.getsoBAIHAT() + "");
        tfGiaThanh.setText(cd.getgiathanh() + "");
        tfMaSo.requestFocus();
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
        if (e.getSource().equals(btThem))
            themAction();
        else if (e.getSource().equals(btClear))
            clearAction();
        else if (e.getSource().equals(btLuu))
            luuAction();
        else if (e.getSource().equals(btTim))
            timAction();
        else if (e.getSource().equals(btSua))
            suaAction();
        else if (e.getSource().equals(btXoa))
            xoaAction();
    }

    private void xoaAction() {
        String maCD = JOptionPane.showInputDialog("Nhập mã CD cần xóa: ");
        if (maCD != null && !maCD.trim().equals("")) {
            CD cd = ds.timKiem(maCD);
            if (cd != null) {
                if (JOptionPane.showConfirmDialog(null, "Chắc chắn không? ",
                        "Thông báo",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    ds.xoaCD(maCD);
                    napVaoBang();
                    clearAction();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy");
                return;
            }
        }
    }

    private void suaAction() {
        String maCD, tuaCD, caSy;
        int soBaiHat;
        double giaThanh;
        try {
            maCD = tfMaSo.getText();
            tuaCD = tfTua.getText();
            caSy = tfCaSy.getText();
            soBaiHat = Integer.parseInt(tfSoBaiHat.getText());
            giaThanh = Double.parseDouble(tfGiaThanh.getText());
            if (!ds.capNhat(maCD, tuaCD, caSy, soBaiHat, giaThanh)) {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
                tfMaSo.selectAll();
                tfMaSo.requestFocus();
                return;
            } else
                napVaoBang();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
    }

    private void timAction() {
        String maCD = JOptionPane.showInputDialog("Nhập mã CD cần tìm: ");
        if (maCD != null && !maCD.trim().equals("")) {
            CD cd = ds.timKiem(maCD);
            if (cd != null) {
                napVaoCacONhapLieu(cd);
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy");
                return;
            }
        }
    }

    private void luuAction() {
        FileOutputStream out = null;
        ObjectOutputStream oos = null;
        try {
            out = new FileOutputStream(FILENAME);
            oos = new ObjectOutputStream(out);
            oos.writeObject(ds);
            oos.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi IO");
            return;
        }
    }

    private void themAction() {
        CD cd = null;
        String maCD, tuaCD, caSy;
        int soBaiHat;
        double giaThanh;
        try {
            maCD = tfMaSo.getText().toUpperCase();
            tuaCD = tfTua.getText();
            caSy = tfCaSy.getText();
            soBaiHat = Integer.parseInt(tfSoBaiHat.getText());
            giaThanh = Double.parseDouble(tfGiaThanh.getText());
            cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
            if (!ds.themCD(cd)) {
                JOptionPane.showMessageDialog(null, "Trùng mã CD");
                tfMaSo.selectAll();
                tfMaSo.requestFocus();
                return;
            } else
                napVaoBang();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
    }

    private void napVaoBang() {
        dfModel.setRowCount(0);
        for (int i = 0; i < ds.tongCD(); i++) {
            CD cd = ds.getCD(i);
            String[] row = { (i + 1) + "", cd.getmaCD(), cd.gettuaCD(), cd.getCasy(),
                    cd.getsoBAIHAT() + "",
                    new DecimalFormat("#,##0.00").format(cd.getgiathanh()) };
            dfModel.addRow(row);
        }
    }

    private void clearAction() {
        tfMaSo.setText("");
        tfTua.setText("");
        tfCaSy.setText("");
        tfSoBaiHat.setText("");
        tfGiaThanh.setText("");
        tfMaSo.requestFocus();
    }
}
