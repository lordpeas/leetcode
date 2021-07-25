package array;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月26日 00:09
 */
public class Log {
    /**
     * 已知一天内用户登录登出的日志（数据量较大），求这一天用户在线的最大峰值和持续时间段
     * <p>
     * 日志包含字段（userid, login_time, logout_time）
     * <p>
     * 登录登出时间精确到秒
     */

    private LogInfo[] logs;

    private long[] online;

    private long top;

    private int total;

    public Log(LogInfo[] logs) {
        this.logs = logs;

        //获取 当日零时的秒

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        long ze = zero.getTime();

        long[] delta = new long[86400];

        for (int i = 0; i < logs.length; i++) {
            int login = (int) (logs[i].getLogin_time() - ze);
            delta[login] += 1;

            int logout = (int) (logs[i].getLogout_time() - ze);
            delta[logout] -= 1;
        }


        online = new long[86400];
        online[0] = delta[0];


        Map<Long, Integer> map = new HashMap<>();

        for (int i = 1; i < online.length; i++) {
            online[i] = online[i - 1] + delta[i];
            top = Math.max(online[i], top);
            map.put(top, map.getOrDefault(top, 0) + 1);
        }

        total = map.get(top);

    }


    public long getTop() {
        return top;

    }

    public int getContinued() {
        return total;
    }

    public static void main(String[] args) {

    }

}

class LogInfo {
    private long login_time;

    private long logout_time;

    private long userId;

    public long getLogin_time() {
        return login_time;
    }

    public void setLogin_time(long login_time) {
        this.login_time = login_time;
    }

    public long getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(long logout_time) {
        this.logout_time = logout_time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
