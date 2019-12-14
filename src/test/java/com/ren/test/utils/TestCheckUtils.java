package com.ren.test.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 *  * @program: coursetest
 *  * @Date: 2019/12/14 19:10
 *  * @Author: Mrs.Ren
 *  * @Description:字符串工具类的测试类
 *  
 */
public class TestCheckUtils {

    /**
     * 测试String... strings 为可变参数，如果 strings 中有任意一个字符串为空，则返回 false，否则返回 true。
     */
    @Test
    public void testIsAnyEmpty(){
        String str[] = {"a","6","","d"};
        String str1[] = {"a","6","null","d"};
        String str2[] = {"a","6",null,"d"};
        String str3[] = {"a","6","d"};
        Assert.assertEquals(false,CheckUtils.isAnyEmpty(str));
        Assert.assertEquals(false,CheckUtils.isAnyEmpty(str1));
        Assert.assertEquals(false,CheckUtils.isAnyEmpty(str2));
        Assert.assertEquals(true,CheckUtils.isAnyEmpty(str3));
    }

    /**
     * 判断引用类型数组是否为空，为空或 null 则返回 true，否则返回 false
     */
    @Test
    public void testIsEmpty(){
        String str[] = {"a","6","","d"};
        String str1[] = {};
        String str2[] = null;
        Assert.assertEquals(false,CheckUtils.isEmpty(str));
        Assert.assertEquals(true,CheckUtils.isEmpty(str1));
        Assert.assertEquals(true,CheckUtils.isEmpty(str2));
    }

    /**
     * 判断 str1 字符串是否相等，相等则返回 true，否则返回 false。当其中一个是 null 时返回 false。
     */
    @Test
    public void testEquals(){
        String str1 = null;
        String str2 = null;
        Assert.assertEquals(false,CheckUtils.equals(str1,str2));
        str1 = null;
        str2 = "zs";
        Assert.assertEquals(false,CheckUtils.equals(str1,str2));
        str1 = "zs";
        str2 = null;
        Assert.assertEquals(false,CheckUtils.equals(str1,str2));
        str1 = "zs";
        str2 = new String("zs");
        Assert.assertEquals(true,CheckUtils.equals(str1,str2));
    }

    /**
     * 判断 n1 和 n2 的值是否相等，相等则返回 true，否则返回 false。当其中一个是 null 时返回 false。
     */
    @Test
    public void testEqualsNum(){
        Integer num1 = null;
        Integer num2 = null;
        Assert.assertEquals(false,CheckUtils.equals(num1,num2));
        num1 = null;
        num2 = 1;
        Assert.assertEquals(false,CheckUtils.equals(num1,num2));
        num1 = 1;
        num2 = null;
        Assert.assertEquals(false,CheckUtils.equals(num1,num2));
        int num = 4;
        num1 = num;
        num2 = 4;
        Assert.assertEquals(true,CheckUtils.equals(num1,num2));
    }









}
