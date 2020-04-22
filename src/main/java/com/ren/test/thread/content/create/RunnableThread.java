package com.ren.test.thread.content.create;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 方式二： 实现Runnable接口创建线程类
 *  ① Runnable对象仅仅作为Thread对象的target，Runnable实现类里包含的run()方法仅作为线程执行体；
 *  ② 实际的线程对象依然是Thread实例，只是该Thread线程负责执行其target的run()方法；
 *  ③ 多个线程可以共享同一个target，所以多个线程可以共享同一个线程类（实际上应该是线程的target类）的实例属性
 */
public class RunnableThread implements Runnable{

    //实例变量会被多个线程共享
    //private int i;

    /**
     * run()方法的方法体是该线程的线程执行体
     */
    @Override
    public void run() {
        //这里是局部变量i，属于每个线程私有变量，所以不会被共享
        for (int i = 0; i < 20; i++) {
            //获得当前线程对象，必须使用Thread.currentThread()方法,不能通过this获取，因为当前对象不是Thread实例
            System.out.println("子线程名："+Thread.currentThread().getName()+"，循环第"+i+"次");
        }
    }


    public static void main(String[] args) {
        //这里两个线程可以共享同一个target，所以可以共享同一个线程类（实际上应该是线程的target类）的实例属性
        RunnableThread target = new RunnableThread();

        for (int i = 0; i < 100; i++) {
            //当前线程
            System.out.println("当前线程："+Thread.currentThread().getName()+"，循环第"+i+"次");

            if (i == 20){

                //创建并启动线程一：
                new Thread(target).start();

                //创建并启动线程二：
                new Thread(target).start();
            }
        }
    }
}
