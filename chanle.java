import java.util.Scanner;
public class chanle{
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a");
        int a = sc.nextInt();
        if(a%2==0){
            System.out.println("a la so chan");}
            else {
                System.out.println("a la so le");
            }
    sc.close();   
    }
}