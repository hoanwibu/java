import java.util.Date;
public class tif{
    @SuppressWarnings("deprecation")
    public static void main (String [] args){
        Date today = new Date();
        //if (today.getDay()==0 )
        switch (today.getDay()) {
            case 1:
            System.out.println("hom nay khong phai la t3");
            break;
            case 2:
            System.out.println("hom nay la t3");            
            break;
            default:
            break;
        }
    }
}