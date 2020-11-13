package Chapter4;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/29
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example1 {


    // 4.2 使用预定义类
    public static void main(String[] args) {
        Example1 e1 = new Example1();
        e1.dateTest();

        CalendarTest calendarTest = new CalendarTest();
        calendarTest.outTest();
    }

    /**
     * Date & LocalDate 测试
     *
     * @return void
     */
    public void dateTest() {
        // 时间点
        Date birthday = new Date();
        Date nowTime = birthday;
        System.out.printf("Now Time: %s.\n", nowTime);


        // 日期点
        LocalDate now = LocalDate.now();
        // 构造特定日期对象
        LocalDate setLocalDate = LocalDate.of(2020, 9, 29);
        // 当前日期加上 365 * 4 天
        // plusDay 方法会生成一个新的 LocalDate 对象
        LocalDate plusDays = now.plusDays(365 * 4);
        int year = plusDays.getYear();
        int month = plusDays.getMonthValue();
        int day = plusDays.getDayOfMonth();
        System.out.printf("Now LocalDate: %s, plus (365 * 4) days LocalDate: %s.\n", now, plusDays);

        /*
            static LocalDate now()  // 构造一个表示当前日期的对象
            static LocalDate of(int year, int month, int day)   // 构造一个表示给定日期的对象
            int getYear()
            int getMonthValue()
            int getDayOfMonth()     //得到当前日期的年、月、日
            DayOfWeek getDayOfWeek()    //得到当前日期是星期几,作为一个 DayOfWeek 的实例返回。调用 getValue
                来得到 1 ~ 7 的一个数，表示这是星期几,1 表示星期一,7 表示星期日
            LocalDate plusDays(int n)
            LocalDate minusDays(int n)  //生成当前日期之后或之前 n 天的日期
         */
    }
}
