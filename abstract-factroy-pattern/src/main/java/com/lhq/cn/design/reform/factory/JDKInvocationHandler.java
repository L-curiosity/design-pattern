package com.lhq.cn.design.reform.factory;

import com.lhq.cn.design.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {
    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Java 反射的 getMethod 要求参数类型精确匹配方法签名，不会自动把实现类提升为接口类型，也不会自动做装箱/拆箱
        //ClassLoaderUtils.getClazzByArgs(args)的作用，把实际传入的参数对象数组，转换成“用于反射查找方法”的参数类型数组
        //在我们的案例中是根据CacheServiceImpl实现类中的参数对象找到ICacheAdapter接口中的方法
        //因此，我们需要把CacheServiceImpl实现类中的参数对象转换成ICacheAdapter接口中的参数对象，如：ArrayList 转换成 List
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}
