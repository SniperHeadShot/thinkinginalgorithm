package com.bat.algorithm.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 *
 * @author ZhengYu
 * @version 1.0 2020/8/13 2:50
 **/
public class ClassReflectUtil {

    /**
     * 获取指定包下的类集合
     * 参考: https://www.cnblogs.com/wangzhen-fly/p/11002814.html
     *
     * @param packageName 包名
     * @author ZhengYu
     */
    public static List<Class<?>> getInterfaceImplList(String packageName) {
        if (StringUtils.isBlank(packageName)) {
            return Lists.newArrayList();
        }

        // 获取包绝对路径
        String packagePath = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(packagePath);
        if (url == null) {
            return Lists.newArrayList();
        }

        // 读取包文件
        File file = new File(url.getPath());
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return Lists.newArrayList();
        }

        // 包装结果集
        List<Class<?>> result = new ArrayList<>(listFiles.length);
        for (File childFile : listFiles) {
            try {
                result.add(Class.forName(packageName + "." + childFile.getName().substring(0, childFile.getName().indexOf(".class"))));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
