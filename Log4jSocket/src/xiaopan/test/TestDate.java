package xiaopan.test;

import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        // System.out.println(new Date(1420041600000l));
        // System.out.println(new Date(1428548400000l));
        // System.out.println(new Date(1428597300000l));
        // System.out.println(new Date(1428681600000l));
        // System.out.println(new Date(1428768000000l));
        // System.out.println(new Date(1429113600000l));
        // System.out.println(new Date(1429174800000l));
        // System.out.println(new Date(1429089000000l));
        // System.out.println(Math.ceil(5.0 / 3));
        // ArrayList set = new ArrayList();
        // set.add("as");
        // set.add("ab");
        // set.add("aw");
        // set.add("as111");
        // set.add("abc");
        // set.add("sb");
        // Collections.sort(set);
        // System.out.println(set);
        Calendar cal = Calendar.getInstance();
        cal.set(cal.DAY_OF_WEEK, 2);
        System.out.println(new Date(cal.getTimeInMillis()));
        System.out.println(cal.getTimeInMillis());
        // cal.add(cal.DAY_OF_MONTH, 0);
        // System.out.println(cal.getTimeInMillis());
        // System.out.println(new Date(cal.getTimeInMillis()));
        // System.out.println(cal.getActualMaximum(cal.DAY_OF_YEAR));
        // cal.set(cal.MONTH, 0);
        // cal.set(cal.DAY_OF_MONTH, 1);
        // cal.set(cal.HOUR_OF_DAY, 0);
        // cal.set(cal.MINUTE, 0);
        // cal.set(cal.SECOND, 0);
        // cal.set(cal.MILLISECOND, 0);
        // System.out.println(cal.getTimeInMillis());
        // System.out.println(new Date(cal.getTimeInMillis()));
    }
}
