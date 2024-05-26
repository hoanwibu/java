import java.util.Scanner;

public class BaiNhapXuatMang {
    public static void main(String args[]) {
        System.out.print("Moi ban nhap so phan tu cua mang: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arrInt[] = new int[n];
        System.out.println();
        System.out.println("Nhap mang: ");
        int max, min;
        min = max = arrInt[0];
        for (int i = 0; i < n; i++) {
            System.out.print("This is arrInt[" + i + "]: ");
            arrInt[i] = sc.nextInt();
        }
        // Min Max
        for (int i = 0; i < n; i++) {
            if (arrInt[i] < min)
                min = arrInt[i];
            if (arrInt[i] > max)
                max = arrInt[i];
        }
        System.out.println();
        System.out.println("Xuat mang: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arrInt[i]);
        }
        System.out.println();
        System.out.println("Min: " + min + ", " + "Max: " + max);
        // Tổng chắn lẻ của mảng
        int S = 0, X = 0;
        for (int i = 0; i < n; i++) {
            if (arrInt[i] % 2 == 0) {
                S += arrInt[i];
            } else
                X += arrInt[i];
        }
        System.out.println();
        System.out.println("Tong chan la: " + S + ", " + "Tong le la: " + X);
        // Thuật toán sắp xêp Bubble Sort
        int t;
        System.out.println();
        System.out.println("Mang tang dan da sap xep lai la: ");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arrInt[j - 1] > arrInt[j]) {
                    t = arrInt[j - 1];
                    arrInt[j - 1] = arrInt[j];
                    arrInt[j] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(" " + arrInt[i]);
        }
        System.out.println();
        System.out.println("Mang giam dan da sap xep lai la: ");
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arrInt[j - 1] < arrInt[j]) {
                    t = arrInt[j - 1];
                    arrInt[j - 1] = arrInt[j];
                    arrInt[j] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(" " + arrInt[i]);
        }
        sc.close();
    }
}