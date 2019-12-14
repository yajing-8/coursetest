package com.ren.test.workflow;

import org.junit.Test;

import java.util.Random;

/**
 *  * @program: coursetest
 *  * @Date: 2019/12/14 12:18
 *  * @Author: Mrs.Ren
 *  * @Description:
 *  
 */
public class TestXunHuan {

    /**
     * 随机生成一个 0 ～ 1000 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。
     *
     *  生成指定范围随机数的方法：
     *  ① rand.nextInt(MAX - MIN + 1) + MIN：生成[MIN,MAX]范围的随机数
     *    rand.nextInt（num）:生成[1,num)范围的随机数
     *  ② rand.nextInt(900)+ 100：随机生成三位数即[100,999]范围的数
     *
     *  Math.random():返回的数值是[0.0,1.0)
     */
    @Test
    public void testOne(){
        int num;
        while ((num = new Random().nextInt(1001) )% 30 != 0){
            System.out.println("1000以内不能被30整除的随机数比如："+num);
        }
    }

    @Test
    public void testTwo(){
        while (true){
            int num = new Random().nextInt(1001);
            if (num % 30 != 0)
                System.out.println("1000以内不能被30整除的随机数比如："+num);
            else
                break;
        }
    }

    /**
     * ：编写一个方法 int getMaxNumRem7(int n1, int n2) 找出 0 ~ n2 范围内除以 n1 余 7 的最大的数，找到则返回该数，如果找不到则返回 -1。
     */
    @Test
    public void testGetMaxNumRem7(){
        System.out.println("num为："+getMaxNumRem7(8,50));
    }

    int getMaxNumRem7(int n1, int n2){
        int num = -1;
        for (int i = 0; i < n2; i++) {
            if (i % n1 == 7){
                //因为获取最大数，所以不能直接return
                num = i;
            }
        }
        return num;
    }


}
