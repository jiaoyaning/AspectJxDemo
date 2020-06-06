package com.jyn.aspectjx.permission.aspect;

import android.content.Context;

import com.apkfuns.logutils.LogUtils;
import com.jyn.aspectjx.permission.annotation.PermissionCheck;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jiaoyaning on 2020/4/30.
 * 权限申请
 */

@Aspect
public class PermissionCheckAspectJ {

    private Context context = null;

    private static final String PERMISSION_CHECK = "execution(@com.jyn.aspectjx.permission.annotation.PermissionCheck * *(..))";

    @Pointcut(PERMISSION_CHECK + " && @annotation(args)")
    public void checkPermission(PermissionCheck args) {

    }

    @Around("checkPermission(args)")
    public Object check(ProceedingJoinPoint joinPoint, PermissionCheck args) throws Throwable {
        String[] permissions = args.permissions();
        int requestCode = args.requestCode();
        LogUtils.tag("main").i(permissions);
        LogUtils.tag("main").i(requestCode);
        if (joinPoint != null) {
            context = (Context) joinPoint.getThis();
        }
        return joinPoint.proceed();
    }
}
