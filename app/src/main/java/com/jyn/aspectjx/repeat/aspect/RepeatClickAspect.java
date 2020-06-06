package com.jyn.aspectjx.repeat.aspect;

import android.util.Log;

import com.jyn.aspectjx.repeat.annotation.RepeatClick;
import com.jyn.aspectjx.utils.RepeatClickUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jiaoyaning on 2020/4/30.
 * 点击抖动
 */
@Aspect
public class RepeatClickAspect {

    @Pointcut("execution(@com.jyn.aspectjx.repeat.annotation.RepeatClick * *(..)) && @annotation(ann)")
    public void repeatClick(RepeatClick ann) {

    }

    @Around("repeatClick(ann)")
    public void click(ProceedingJoinPoint joinPoint, RepeatClick ann) throws Throwable {
        long interval = ann.interval();
        // 判断是否快速点击
        if (!RepeatClickUtil.isFastDoubleClick(interval)) {
            // 不是快速点击，执行原方法
            joinPoint.proceed();
        } else {
            Log.i("main", "点击太过频繁啦");
        }
    }
}
