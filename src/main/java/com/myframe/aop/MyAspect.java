package com.myframe.aop;

import com.myframe.annotation.Aop;
import thin.framework.aop.annotation.Aspect;
import thin.framework.aop.proxy.AspectProxy;

/**
 * Created by yangyu on 2017/2/10.
 */
@Aspect(Aop.class)
public class MyAspect extends AspectProxy{

    @Override
    public void begin() {
        System.out.println("this is my thin aop begin");
    }

    @Override
    public void end() {
        System.out.println("this is my thin aop end");
    }
}
