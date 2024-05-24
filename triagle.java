import java.util.Scanner;

public class triagle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap canh a , b , c");
        float a = sc.nextInt();
        float b = sc.nextInt();
        float c = sc.nextInt();
        if (a + b == c || a + c == b || b + c == a) {
            System.out.println("day khong phai tam giac");
        } else {
            if (a + b > c || a + c > b || b + c > a) {
                System.out.println("day la tam giac");
            }
            if (a * a == b * b + c * c) {
                System.out.println("day la tam giac vuong");
            }
            if (a == b && a == c && b == c) {
                System.out.println("day la tam giac deu");
            }
            if (a == b || a == c || b == c)
                System.out.println("day la tam giac can");
        }
        sc.close();
    }
}
