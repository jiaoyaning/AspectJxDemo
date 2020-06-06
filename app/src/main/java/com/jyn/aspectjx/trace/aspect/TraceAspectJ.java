package com.jyn.aspectjx.trace.aspect;

import android.view.View;

import com.apkfuns.logutils.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jiaoyaning on 2020/6/5.
 * 无痕埋点
 */
@Aspect
public class TraceAspectJ {
    /**
     * 定义onClick方法切面规则
     */
    private static final String TRACE_ON_CLICK = "execution(* android.view.View.OnClickListener.onClick(..))";

    /**
     * 定义onCreate方法切面 +代表子类
     */
//    private static final String TRACE_ON_CREATE = "execution(* android.app.Activity+.onCreate(..))";
    private static final String TRACE_ON_CREATE = "execution(* androidx.appcompat.app.AppCompatActivity+.onCreate(..))";

    /**
     * 根据规则创建切面
     */
    @Pointcut(TRACE_ON_CLICK)
    public void aspectOnClick() {

    }

    @Pointcut(TRACE_ON_CREATE)
    public void aspectOnCreate() {

    }

    /**
     * 根据切面进行切入
     */
    @Around("aspectOnClick()")
    public void beforeJoinAspectOnClick(ProceedingJoinPoint joinPoint) throws Throwable {
        LogUtils.tag("main").i("+++点击事件开始");
        View view = (View) joinPoint.getArgs()[0]; //获取切入方法的形参列表
        if (view != null) {
            String resourceName = view.getContext().getResources().getResourceName(view.getId());
            LogUtils.tag("main").i("resourceName:" + resourceName);
        }
        joinPoint.proceed();
        LogUtils.tag("main").i("---点击事件结束");
    }

    @Around("aspectOnCreate()")
    public void afterJoinAspectOnCreate(ProceedingJoinPoint joinPoint) throws Throwable {
//        LogUtils.tag("main").i("+++onCreate方法开始");
        if (joinPoint != null) {
            joinPoint.proceed();
        }
        LogUtils.tag("main").i("---onCreate方法结束");
    }
}
