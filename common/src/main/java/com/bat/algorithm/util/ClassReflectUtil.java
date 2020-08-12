package com.bat.algorithm.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 反射工具类
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:50
 **/
public class ClassReflectUtil {

    /**
     * 获取接口的实现类
     *
     * @param target 目标接口
     * @author ZhengYu
     */
    public static <T> List<Class<T>> getInterfaceImplList(Class<T> target) {
        if (target == null || !target.isInterface()) {
            return Lists.newArrayList();
        }

        // TODO 暂未实现
        return Lists.newArrayList();
    }
}
