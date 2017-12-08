package other;

/**
 * Created by user on 2017/6/19.
 */
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;
class Time {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sf.setTimeZone(TimeZone.getTimeZone("Asia/shanghai"));
        String str3 = "1927-12-31 23:54:07";
        String str4 = "1927-12-31 23:54:08";
        Date sDt3 = sf.parse(str3);
        Date sDt4 = sf.parse(str4);
        long ld3 = sDt3.getTime() /1000;
        long ld4 = sDt4.getTime() /1000;
        System.out.println(ld3);
        System.out.println(ld4);
        System.out.println(ld4-ld3);

        Date dt =new Date();
        System.out.println(dt); //格式： Wed Jul 06 09:28:19 CST 2016

        long lTime = dt.getTime() / 1000;
        System.out.println(lTime);

        long ltime2 = 1464710394;
        // int ltime2 = 1464710394; // 溢出

        SimpleDateFormat lsdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lDate = new Date(ltime2*1000);
        String lStrDate = lsdFormat.format(lDate);
        System.out.println(lStrDate);
    }
}