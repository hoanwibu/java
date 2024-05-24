import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class DayOfWeekFinder {
    public static void main(String[] args) {
        int yr,m,d;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap nam ");
        yr = sc.nextInt();
        System.out.println("nhap thang ");
        m = sc.nextInt();
        System.out.println("nhap ngay ");
        d = sc.nextInt();
        LocalDate date = LocalDate.of(yr,m, d);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekText = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("en", "VN"));
        
        System.out.println("Ngay " + date + " la " + dayOfWeekText + "");
        sc.close();
    }
}
