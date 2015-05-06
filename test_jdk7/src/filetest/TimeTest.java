package filetest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
    final public static String SYSLOG_TIMESTAMP_FORMAT_RFC5424_2 = "yyyy-MM-dd'T'HH:mm:ss.SZ";
    final public static String SYSLOG_TIMESTAMP_FORMAT_RFC5424_1 = "yyyy-MM-ddHH:mm:ss.S";
    final public static String SYSLOG_TIMESTAMP_FORMAT_RFC5424_3 = "yyyy-MM-dd'T'HH:mm:ssZ";
    final public static String SYSLOG_TIMESTAMP_FORMAT_RFC5424_4 = "yyyy-MM-dd'T'HH:mm:ss";
    final public static String SYSLOG_TIMESTAMP_FORMAT_RFC3164_1 = "yyyyMMM d HH:mm:ss";

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("2.662244E7");
        System.out.println(24754170 / 3600 / 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat(SYSLOG_TIMESTAMP_FORMAT_RFC5424_1);
        try {
            System.out.println(dateFormat.parse("2015-03-0310:43:04.547+08:00"));
            long time = dateFormat.parse("2015-03-0310:43:04.547289+08:00").getTime();
            System.out.println(time);
            Date date = new Date(time);
            System.out.println(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
