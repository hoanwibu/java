import java.util.Scanner;

public class tong{
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("nhap a");
        int a = input.nextInt();
        System.out.println("nhap b");
        int b = input.nextInt();
        int tong = a+b;
        System.out.print("tong = " +tong );
        
        }
}