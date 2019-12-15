package com.ren.test.utils;

import java.util.Arrays;

/**
 *  * @program: coursetest
 *  * @Date: 2019/12/14 16:34
 *  * @Author: Mrs.Ren
 *  * @Description:数组工具类
 *  
 */
public class MyArrayUtils {

    /**
     * 冒泡排序：升序排序 （时间复杂度O(n^2)）
     * 比较相邻的两个元素，如果前面的比后面的大，则交换两个元素；
     * 对每每相邻的元素都进行这样的比较操作，从开始的一对到最后一对，则遍历完一次，最后的元素就是最大的元素
     * 重复以上步骤直至排序完成
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        long start = System.currentTimeMillis();
        //i控制需要比较几趟
        for (int i = 0; i < arr.length - 1; i++) {
            //j控制每趟进行比较的次数
            for (int j = 0; j < arr.length - 1 -i; j++) {
               if (arr[j] > arr[j + 1]){
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
               }
            }
            //System.out.println("比较第几趟："+i);
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡耗时："+ (end - start));
        return arr;
    }

    /**
     * 冒泡排序优化：其实在进行比较时当两个元素没有发生交换即说明排序结束
     * @param arr
     * @return
     */
    public static Integer[] bubbleSortBetter(Integer[] arr){
        long start = System.currentTimeMillis();
        //i控制需要比较几趟
        for (int i = 0; i < arr.length - 1; i++) {
            //用于标记某一趟是否有元素交换位置，默认没有
            boolean flag = false;
            //j控制每趟进行比较的次数
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            //System.out.println("比较第几趟："+i);
            //如果这一趟没有交换，则直接退出即可，说明已经排好序了
            if (!flag)
                break;
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡耗时："+ (end - start));
        return arr;
    }

    /**
     * 快排：时间复杂度：O(nlogn)
     *
     * 基本思想：取一个基准位置数字，用其他位置的数字和基准数进行对比
     *           如果比基准数大，则放到基准数的右边，如果比基准数小，则放到基准数的左边，
     *           然后再将两部分分别使用递归进行比较，直到排好序
     * @param arr 排序数组
     * @param left 最小数组索引：0
     * @param right 最大数组索引：arr.length - 1
     * @return
     */
    public static Integer[] quickSort(Integer[] arr,int left,int right){
        if (left < right){
            //移动的指向小于key元素的指针下标
            int low = left;
            //移动的指向大于key元素的指针下标
            int high = right;
            //基准元素
            int key = arr[left];

            while (low < high){
                //将high指针递减找小于基准元素key的值
                while (low < high && arr[high] >= key){
                    high--;
                }
                //找到小的值赋值给low指向的值
                arr[low] = arr[high];
                //接着移动low指针，进行递增找大于基准元素key的值
                while (low < high && arr[low] <= key){
                    low++;
                }
                //找到大于基准元素key的值赋值给high
                arr[high] = arr[low];
            }
            //直到退出循环，即low = high的时候，即为基准元素的位置
            arr[low] = key;
            //递归处理所有比标准数小的数字
            quickSort(arr,left,low);
            //递归处理所有比标准数大的数字
            quickSort(arr,low + 1,right);
        }
        return arr;
    }


    public static void main(String[] args) {
        Integer []nums = {1,6,2,8,9,20,54,23,20,56,35};
        System.out.print("遍历前数组：");
        Arrays.asList(nums).stream().forEach(num -> {
            System.out.print(num+" ");
        });
        System.out.println();
        System.out.println("冒泡排序后结果："+ Arrays.toString(bubbleSortBetter(nums)));
        System.out.println("快排后结果："+ Arrays.toString(quickSort(nums,0,nums.length-1)));
    }
}
