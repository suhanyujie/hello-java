package Object;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class TestCanlendar {
    public static void main(String[] args) {
        calendarTransferDatetime();
    }

    public static void calendarTransferDatetime(){
        Calendar c1 = new GregorianCalendar();
        c1.add(Calendar.DATE, -10);
        Date d1 = c1.getTime();
        System.out.println(d1);
        Calendar c2 = new GregorianCalendar();
        c2.setTime(d1);
        System.out.println(c2.getTime());
    }

    // 日历类的简单使用
    public static void simpleExample(){
        Calendar c1 = new GregorianCalendar(2019,11,21,22,10,21);
        int year = c1.get(Calendar.YEAR);
        int weekDay = c1.get(Calendar.DAY_OF_WEEK);
        System.out.println(year);
        System.out.println(weekDay);// 1是星期日  7是指星期天！
        System.out.println(c1.get(Calendar.MONTH));// 0-11

        Calendar c2 = new GregorianCalendar();
        System.out.println(c2);
        System.out.println(c2.get(Calendar.DAY_OF_MONTH));
        System.out.println(c2.get(Calendar.DATE));
        // 10年前
        c2.add(Calendar.YEAR, -10);
        System.out.println(c2.get(Calendar.YEAR));
    }

}
