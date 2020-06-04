package com.jyn.aspectjx.permission.aspect;

import android.content.Context;

import com.jyn.aspectjx.permission.annotation.PermissionCheck;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jiaoyaning on 2020/4/30.
 */

@Aspect
public class PermissionCheckAspectJ {
    private static final String TAG = "PermissionCheck";

    Context context = null;

    @Pointcut("execution(@com.jyn.aspectjx.permission.annotation.PermissionCheck * *(..)) && @annotation(ann)")
    public void checkPermission(PermissionCheck ann) {

    }

    @Around("checkPermission(ann)")
    public Object check(ProceedingJoinPoint joinPoint, PermissionCheck ann) throws Throwable {
        if (ann != null) {
            context = (Context) joinPoint.getThis();
        }
        return joinPoint.proceed();
    }
}
