import java.util.Scanner;

public class dtb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap diem toan");
        float a = sc.nextInt();
        System.out.println("nhap diem van");
        float b = sc.nextInt();
        System.out.println("Diem trung binh cua ban la: ");
        float c = (a * 2 + b) / 3;
        System.out.println(c);
        if (c >= 9) {
            System.out.println("Xep loai: xuat sac");
        } else if (9 > c && c >= 8) {
            System.out.println("Xep loai: gioi");
        } else if (8 > c && c >= 7) {
            System.out.println("Xep loai: kha");
        } else if (7 > c && c >= 6) {
            System.out.println("Xep loai: trung binh");
        } else {
            System.out.println("Xep loai: yeu");
        }
        sc.close();
    }
}