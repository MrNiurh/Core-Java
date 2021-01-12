package Others;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/22
 * @Description 会议室计费
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class MoneyCount {

    // 会议室计费开启时间
    private final static int startHour = 7;
    // 会议室计费关闭时间
    // 只在此时间内计费
    private final static int endHour = 22;

    // 会议室价格/每小时
    private final static BigDecimal moneyPerHour = BigDecimal.valueOf(40.0);

    public static void main(String[] args) {
        getMoney();
    }


    /**
     * 计算会议室收费
     * BigDecimal 处理精度问题
     *
     * @return BigDecimal
     */
    private static BigDecimal getMoney() {

        // 会议开始日期、时间
        LocalDateTime startTime = LocalDateTime.of(2021, 1, 11, 21, 0);
        // 会议结束日期、时间
        LocalDateTime endTime = LocalDateTime.of(2021, 1, 12, 13, 0);

        LocalDate s = startTime.toLocalDate();
        LocalDate e = endTime.toLocalDate();
        // 计算日期差(天数，不在同一天即有差值)
        long days = s.until(e, ChronoUnit.DAYS);

        Duration duration = Duration.between(startTime, endTime);
        //long days = duration.toDays();


        if (duration.toMinutes() < 0) {
            System.err.println("会议结束时间不能早于开始时间");
            return null;
        }

        // 开始 & 结束 时间的时间点（小时）
        int start = startTime.getHour();
        int end = endTime.getHour();

        int startMinute = startTime.getMinute();
        int endMinute = endTime.getMinute();

        // 时间转换
        BigDecimal realStart = timeTransfer(start, startMinute);
        BigDecimal realEnd = timeTransfer(end, endMinute);

        /**
         * 总时间合计
         * (realEnd - realStart) + days * (endHour - startHour)
         */
        BigDecimal totalHours = realEnd.subtract(realStart)
                .add(BigDecimal.valueOf(days)
                        .multiply(BigDecimal.valueOf(endHour).subtract(BigDecimal.valueOf(startHour))));
        /**
         * 价格计算
         * totalHours * moneyPerHour
         */
        BigDecimal totalMoney = totalHours.multiply(moneyPerHour);

        // 将时间内的 T 去掉
        System.out.println("会议开始时间： " + startTime.toString().replace("T", " "));
        System.out.println("会议结束时间 " + endTime.toString().replace("T", " "));
        System.out.println("会议总耗时：" + totalHours + "h");
        System.out.println("会议室价格：" + moneyPerHour + "￥/h");
        System.out.println("总计：" + totalMoney + "元");
        // 返回价格
        return totalMoney;
    }

    /**
     * 将时间转换为正常范围
     * 小于计费开启时间记为开启时间
     * 大于计费关闭时间记为关闭时间
     *
     * @param time
     */
    private static BigDecimal timeTransfer(int time, int minute) {
        if (time < startHour) {
            return BigDecimal.valueOf(startHour);
        }
        if (time >= endHour) {
            return BigDecimal.valueOf(endHour);
        } else {
            /**
             * time + minute/60.0
             */
            return BigDecimal.valueOf(time).add(BigDecimal.valueOf(minute).divide(BigDecimal.valueOf(60.0)));
        }
    }
}
