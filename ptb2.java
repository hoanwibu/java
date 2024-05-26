import java.util.Scanner;

public class ptb2 {
    public static void main(String[] args) {
        int d;
        Scanner input = new Scanner(System.in);
        System.out.print("nhap a: ");
        int a = input.nextInt();
        System.out.print("nhap b:");
        int b = input.nextInt();
        System.out.print("nhap c:");
        int c = input.nextInt();
        System.out.print("delta = ");
        System.out.println(d = (b * b) - 4 * a * c);
        if (d < 0) {
            System.out.print("pt vo ng");
        } else if (d == 0) {
            System.out.println("pt co ng duy nhat");
            System.out.print(-b / 2 * a);
        } else if (d > 0) {
            float x1 = (float) ((-b + Math.sqrt(d)) / (2 * a));
            float x2 = (float) ((-b - Math.sqrt(d)) / (2 * a));
            System.out.println("pt co 2 ng: " + x1 + " and " + x2);
        }
        input.close();
    }
}