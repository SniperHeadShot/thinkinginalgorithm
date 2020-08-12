package com.bat.algorithm.util;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 初始随机数
 *
 * @author ZhengYu
 * @version 1.0 2020/8/12 14:14
 **/
public class InitialRandomNumberCreateUtil {

    private final static Random RANDOM = new Random(47);

    /**
     * 生成一个随机的无序数组
     *
     * @param length 长度
     * @author ZhengYu
     */
    public static int[] buildRandomLenIntArr(int length) {
        int[] result = new int[length];
        IntStream.range(0, length).forEach(index -> result[index] = RANDOM.nextInt(1000));
        return result;
    }

    /**
     * {@link #buildRandomLenIntArr(int)}
     *
     * @author ZhengYu
     */
    public static int[] buildRandomLenIntArr() {
        return buildRandomLenIntArr(10);
    }

    /**
     * 生成一个随机数
     *
     * @param interval 取值区间
     * @author ZhengYu
     */
    public static int getRandomIntValue(int interval) {
        return RANDOM.nextInt(interval);
    }

    /**
     * {@link #getRandomIntValue(int)}
     *
     * @author ZhengYu
     */
    public static int getRandomIntValue() {
        return getRandomIntValue(10);
    }
}
