package com.ren.test.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  * @program: suanfatest
 *  * @Date: 2019/12/15 22:12
 *  * @Author: Mrs.Ren
 *  * @Description:数组工具类
 *  
 */
public class MyArrayUtils {

    /**
     * 将 int[] 数组转为对应的包装类型数组:导包org.apache.commons commons-lang3
     * @param arr 参数为null时结果返回null
     * @return
     */
    public static Integer[] transforIntArray (int[] arr){
        return ArrayUtils.toObject(arr);
    }

    /**
     * J将 int[] 数组转为对应的包装类型集合:JDK8
     * @param arr
     * @return
     */
    public static List<Integer> transforIntArrayToList (int[] arr){
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    /**
     * 将 int[] 数组转为对应的包装类型集合
     * @param arr
     * @return
     */
    public static List<Integer> transforIntArrayToListT (int[] arr){
        Integer[] integers = transforIntArray(arr);
        return Arrays.asList(integers);
    }

    /**
     * 将 char[] 数组转为对应的包装类型数组
     * @param arr 参数为null时结果返回null
     * @return
     */
    public static Character[] transforCharArray (char[] arr){
        return ArrayUtils.toObject(arr);
    }

    /**
     * 将字符串转为Character类型数组:JDK8
     * @param str
     * @return
     */
    public static Character[] transforStrToCharacterArray (String str){
        return str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
    }








}
