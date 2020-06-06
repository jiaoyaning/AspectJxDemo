package com.jyn.aspectjx.trace.aspect;

import com.apkfuns.logutils.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jiaoyaning on 2020/6/5.
 */
@Aspect
public class TraceAspectJ {
    /**
     * 切面：onClick方法
     */
    private static final String TRACE_ONCLICK = "execution(* android.view.View.OnClickListener.onClick(..))";



    @Pointcut(TRACE_ONCLICK)
    public void aspectOnClick() {

    }

    @Around("aspectOnClick()")
    public Object beforeJoinAspectOnClick(ProceedingJoinPoint joinPoint) throws Throwable {
        LogUtils.tag("main").i("点击事件点击事件！！！");

        return joinPoint.proceed();
    }
}
