package com.ren.test.thread.content.create;

import java.util.concurrent.TimeUnit;

/**
 * Daemon线程：
 * ① Daemon线程是一种支持型线程，因为它主要被用作程序中后台调度以及支持性工作；
 *    这意味着，当一个Java虚拟机中不存在非Daemon线程的时候，Java虚拟机将会退出；
 * ③ Daemon线程被用作完成支持性工作，但是在Java虚拟机退出时Daemon线程中的finally块并不一定会执行；
 */
public class DaemonThreadTest {


    public static void main(String[] args) {
        DaemonRunnable target = new DaemonRunnable();

        //非Daemon线程
        Thread noDaemonThread = new Thread(target, "Thread-Not-Daemon");
        noDaemonThread.start();

        //Daemon线程
        Thread daemonThread = new Thread(target, "Thread-Daemon");
        //Daemon属性需要在启动线程之前设置，不能在启动线程之后设置
        daemonThread.setDaemon(true);
        daemonThread.start();
      /*  Thread noDaemonThread = new Thread(target, "Thread-Not-Daemon");
        noDaemonThread.start();*/
    }


    static class DaemonRunnable implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("线程：" + Thread.currentThread().getName() + "正在执行。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程" + Thread.currentThread().getName() + "正在执行线程的finally块。。。");
            }
        }
    }
}
