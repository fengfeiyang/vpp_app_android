package com.baotianqi.custom.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化的工具
 */
public class TimeUtil {
    public static final String DETAIL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getTimeFormMillis(long mill, String yMdHms) {
        Date date = new Date(mill);
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(yMdHms);
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    public static String getTimeFormMillis(String mill, String yMdHms) {
        if (mill == null || mill.trim().equals("") || mill.equals("0")) {
            return "";
        }
        long mills = Long.parseLong(mill);
        Date date = new Date(mills);
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(yMdHms);
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    public static long getMillisFormTime(String mill, String yMdHms) {
        if (mill == null || mill.trim().equals("") || mill.equals("0")) {
            return 0;
        }
        long time = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(yMdHms);
            Date parse = sdf.parse(mill);
            time = parse.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String getNowTime(long l, String yMdHms) {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(yMdHms);
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    /**
     * 显示时间间隔
     *
     * @param time
     */

    public static String showTimeDistance(long time) {
        long nowTime = System.currentTimeMillis();
        if (nowTime - time > 24 * 60 * 60 * 1000l) {
            return getTimeFormMillis(time, "yyyy-MM-dd");
        } else if (nowTime - time > 60 * 60 * 1000l) {
            int hours = (int) ((nowTime - time) / 1000 / 60 / 60);
            return hours + "个小时前";
        }else if (nowTime - time > 60 * 1000l){
            int min = (int) ((nowTime - time) / 1000 / 60);
            return min + "分钟前";
        }else {
            return "1分钟前";
        }
    }
}
