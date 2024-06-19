package javax.bai27;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class AccUI {
    JFrame myFrame = new JFrame("account");
    JTextField txtAccNumber;
    JTextField txtAccName;
    JTextField txtAccMoney;
    JTable tblAcc;
    DefaultTableModel tblModelAcc;
    JButton btnAdd, btnClear, btnExit;

    public AccUI() {
        JPanel pnAccNumber = new JPanel();
        pnAccNumber.setLayout(new BoxLayout(pnAccNumber, BoxLayout.X_AXIS));
        JLabel lblAccNumber = new JLabel("Account Number");
        pnAccNumber.add(lblAccNumber);
        txtAccNumber = new JTextField(15);
        pnAccNumber.add(txtAccNumber);

        JPanel pnAccName = new JPanel();
        pnAccName.setLayout(new BoxLayout(pnAccName, BoxLayout.X_AXIS));
        JLabel lblAccName = new JLabel("Account Name");
        pnAccName.add(lblAccName);
        txtAccName = new JTextField(15);
        pnAccName.add(txtAccName);

        JPanel pnAccMoney = new JPanel();
        pnAccMoney.setLayout(new BoxLayout(pnAccMoney, BoxLayout.X_AXIS));
        JLabel lblAccMoney = new JLabel("Account Money");
        pnAccMoney.add(lblAccMoney);
        txtAccMoney = new JTextField(15);
        pnAccMoney.add(txtAccMoney);
        Container con = myFrame.getContentPane();
        con.setLayout(new BorderLayout());
        JPanel plnfor = new JPanel();
        plnfor.setLayout(new BoxLayout(plnfor, BoxLayout.Y_AXIS));
        plnfor.add(pnAccNumber);
        plnfor.add(pnAccName);
        plnfor.add(pnAccMoney);
        con.add(plnfor, BorderLayout.NORTH);

        tblModelAcc = new DefaultTableModel();
        tblModelAcc.addColumn("Account Number");
        tblModelAcc.addColumn("Account Name");
        tblModelAcc.addColumn("Account Money");
        tblAcc = new JTable(tblModelAcc);
        JScrollPane sc = new JScrollPane(tblAcc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        con.add(sc, BorderLayout.CENTER);

        JPanel pnButton = new JPanel();
        btnAdd = new JButton("Add");
        btnAdd.setMnemonic('A');
        btnClear = new JButton("Clear");
        btnClear.setMnemonic('C');
        btnExit = new JButton("Exit");
        btnExit.setMnemonic('E');
        pnButton.add(btnAdd);
        pnButton.add(btnClear);
        pnButton.add(btnExit);
        con.add(pnButton, BorderLayout.SOUTH);
        lblAccName.setPreferredSize(lblAccNumber.getPreferredSize());
        lblAccMoney.setPreferredSize(lblAccNumber.getPreferredSize());
        addEvents();
    }

    public void addEvents() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String arr[] = { txtAccNumber.getText(),
                        txtAccName.getText(),
                        txtAccMoney.getText() };
                tblModelAcc.addRow(arr);
            };
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int ret = JOptionPane.showConfirmDialog(null, "Are you sure about that?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public void doShow() {
        myFrame.setSize(400, 300);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

}