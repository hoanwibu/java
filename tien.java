import java.util.Scanner;
public class tien{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so tien");
        int tien = sc.nextInt();
        int to10 = tien/10;
        System.out.println("co so to 10 la " + to10);
        int du = tien%10;
        System.out.println("du" +du);
        int to5 = du/5;
        System.out.println("so to 5 la "+to5);
        int du1 = du%5;
        System.out.println("du" +du1);
        int to1 = du1/1;
        System.out.println("so to 1 la "+to1);
        sc.close();
    } 
}