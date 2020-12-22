package Others;

import java.time.Duration;
import java.time.LocalDateTime;

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
    private final static double moneyPerHour = 40.0;


    public static void main(String[] args) {
        getMoney();

    }


    /**
     * 计算会议室收费
     *
     * @return double
     */
    private static double getMoney() {

        // 会议开始日期、时间
        LocalDateTime startTime = LocalDateTime.of(2020, 11, 9, 7, 30);
        // 会议结束日期、时间
        LocalDateTime endTime = LocalDateTime.of(2020, 11, 16, 22, 30);

        // 计算日期差
        Duration duration = Duration.between(startTime, endTime);
        long days = duration.toDays();

        if (duration.toMinutes() < 0) {
            System.err.println("会议结束时间不能早于开始时间");
            return 0.0;
        }

        // 开始 & 结束 时间的时间点（小时）
        int start = startTime.getHour();
        int end = endTime.getHour();

        int startMinute = startTime.getMinute();
        int endMinute = endTime.getMinute();

        // 时间转换
        double realStart = timeTransfer(start, startMinute);
        double realEnd = timeTransfer(end, endMinute);

        // 总时间合计（加上分钟）
        double totalHours = (realEnd - realStart) + days * (endHour - startHour);
        double totalMoney = totalHours * moneyPerHour;

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
     * @return
     */
    private static double timeTransfer(int time, int minute) {
        if (time < startHour) {
            return startHour;
        }
        if (time >= endHour) {
            return endHour;
        } else {
            return time + minute / 60.0;
        }
    }
}
