import javax.swing.JOptionPane;

public class tSw {
    public static void main(String[] args) {
        char c;
        String str = JOptionPane.showInputDialog(null, "Nhap vao ky tu ? ");
        c = str.charAt(0);
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("ky tu nay la nguyen am");
                break;
            default:
                System.out.println("ky tu nay la phu am");
        }
        System.exit(0);
    }
}