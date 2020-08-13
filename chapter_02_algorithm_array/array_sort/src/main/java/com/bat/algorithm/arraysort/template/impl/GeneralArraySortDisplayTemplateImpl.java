package com.bat.algorithm.arraysort.template.impl;

import com.bat.algorithm.arraysort.strategy.ArraySortStrategy;
import com.bat.algorithm.arraysort.template.ArraySortDisplayTemplate;
import com.bat.algorithm.util.ClassReflectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板模式 - 数组排序展示模板 - 利用反射加载策略实现
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:40
 **/
public class GeneralArraySortDisplayTemplateImpl extends ArraySortDisplayTemplate {

    /**
     * 加载排序策略
     *
     * @author ZhengYu
     */
    @Override
    protected List<ArraySortStrategy> loadArraySortStrategyList() {
        List<Class<?>> strategyImplList = ClassReflectUtil.getInterfaceImplList("com.bat.algorithm.arraysort.strategy.impl");
        if (strategyImplList.isEmpty()) {
            return null;
        }
        List<ArraySortStrategy> result = new ArrayList<>(strategyImplList.size());
        strategyImplList.stream()
                .filter(ArraySortStrategy.class::isAssignableFrom)
                .forEach(strategyImplClass -> {
                    try {
                        result.add((ArraySortStrategy) strategyImplClass.newInstance());
                    } catch (Exception e) {
                        System.out.println(String.format("实例化策略 [%s] 失败, 原因: [%s]", strategyImplClass.getName(), e.getMessage()));
                        e.printStackTrace();
                    }
                });
        return result;
    }
}
