package com.jyn.aspectjx.utils;

/**
 * Created by jiaoyaning on 2020/4/30.
 * 防止重复点击
 */
public class RepeatClickUtil {
    private static long mLastClickTime;

    public static boolean isFastDoubleClick(long intervalMillis) {
        long time = System.currentTimeMillis();
        long timeInterval = Math.abs(time - mLastClickTime);
        mLastClickTime = time;
        if (timeInterval < intervalMillis) {
            return true;
        } else {
            return false;
        }
    }
}
