package javax;

import javax.swing.JOptionPane;

public class EvOdd {
    public static void main(String[] args) {
        int qes;
        do {
            String numStr = JOptionPane.showInputDialog("Nhap 1 so nguyen: ");
            if (numStr != null && !numStr.trim().equals("")) {
                try {
                    int num = Integer.parseInt(numStr);
                    String result = "so vua nhap la so" + ((num % 2 == 0) ? " chan" : " le");
                    JOptionPane.showMessageDialog(null, result, "Output", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Nhap sai dinh dang", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            qes = JOptionPane.showConfirmDialog(null, "tiep tuc khong?", "Question", JOptionPane.YES_NO_OPTION);
        } while (qes == JOptionPane.YES_OPTION);
    }
}