package Chapter4;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/29
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class CalendarTest {


    /**
     * 本月日历输出,本日加上 *
     *
     * @return void
     */
    public void outTest() {

        //获取当前日期
        LocalDate date = LocalDate.now();
        // 当前月份
        int month = date.getMonthValue();
        // 当前天
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);// set to start month,到当月第一天
        DayOfWeek weekday = date.getDayOfWeek();// 查看周日期
        int value = weekday.getValue();// 1 = Monday, . . . , 7 = Sunday


        System.out.println("\n当月的日历:");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        // 在月首日的前面插入空格
        // 如果月首日是周三，插入 (4 * 2) 个空格
        for (int i = 1; i < value; i++) {
            System.out.printf("    ");
        }


        while (date.getMonthValue() == month) { // 在本月循环
            System.out.printf("%3d", date.getDayOfMonth());// 格式化输出天数
            if (date.getDayOfMonth() == today) {// 是今天就加 *
                System.out.printf("*");
            } else {
                System.out.printf(" ");// 不是今天加一个空格
            }

            date = date.plusDays(1);// 日期加一
            if (date.getDayOfWeek().getValue() == 1) {// 到新的一周换行
                System.out.println();
            }
        }

        // 如果月份的最后一天不是周日(加一不是周一),输出换行(周日在上面已换行)
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
