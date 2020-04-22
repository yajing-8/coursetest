package com.ren.test.thread.content.create;
/**
 * 线程的创建方式一：通过继承Thread类实现
 * ① 使用继承Thread类的方法来创建线程类时，多个线程之间无法共享线程类的实例变量
 */
public class FirstThread extends Thread{
    //实例变量不能被多个实例共享
    int i = 0;

    /**
     * run()方法里的代码执行流就是该线程所需要完成的任务
     */
    @Override
    public void run() {
        for (; i < 20; i++) {
            //默认情况下：用户启动的多个线程的名字依次为Thread-0、Thread-1、Thread-2、…、Thread-n等
            System.out.println("子线程名称："+getName()+",循环第"+i+"次");
        }
    }

    /**
     * main()方法的方法体是主线程的线程执行体
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            //在默认情况下，主线程的名字为main
            System.out.println("当前线程："+Thread.currentThread().getName()+",循环第"+i+"次");
            if (i == 20){
                //启动子线程一
                new FirstThread().start();

                //启动子线程二
                new FirstThread().start();
            }
        }
    }
}
