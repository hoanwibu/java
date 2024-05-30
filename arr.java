import java.util.Scanner;

public class arr {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("nhap so pt cua mang");
        n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("nhap pt thu " + i + " cua mang");
            a[i] = sc.nextInt();
        }
        // tong chan le
        int S = 0, X = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                S += a[i];
            } else {
                X += a[i];
            }
        }
        System.out.println("tong chan la " + S);
        System.out.println("tong le la " + X);
        // sap xep be den lon
        int t;
        System.out.println();
        System.out.println("Mang tang dan da sap xep lai la: ");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    t = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a[i]);

        }
        // tong mang
        int tong = 0;
        for (int i = 0; i < n; i++) {
            tong += a[i];
        }
        System.out.println(tong);

    }

}
