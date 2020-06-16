package com.ren.test.thread.content.create;

/**
 * 线程生命周期测试
 */
public class ThreadLifeTest {

    public static void main(String[] args) {
        RunThread thread = new RunThread();
        //Thread[Thread-0,5,main]：[线程对象名称，线程优先级，线程所属组的名称]
     /*   System.out.println(thread);*/
        //直接调用run方法，该run方法就是一个普通方法；还是顺序执行线程，不会启动线程
        thread.run();
        thread.start();
    }

    static class RunThread extends Thread{
        @Override
        public void run() {
            //这里始终获取的是当前线程的名称
            System.out.println("Thread.currentThread().getName()返回："+Thread.currentThread().getName());
            //如果直接调用run方法，这里获取的是当前对象的名称
            System.out.println("this.getName()返回："+this.getName());
        }
    }
}
