package com.ren.test.thread.content.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<Integer> {

    /**
     * 1、Callable 需要搭配 FutureTask一起使用：
     *    ① Callable接口是Java5新增的接口，而且它不是Runnable接口的子接口，所以Callable对象不能直接作为Thread的target；
     *    ② Callable接口有泛型限制，Callable接口里的泛型形参类型与call()方法返回值类型相同；
     *    ③ 而且call()方法还有一个返回值——call()方法并不是直接调用，它是作为线程执行体被调用的
     * 2、Callable 的call方法主要提供了线程的执行体：
     *    ① call()方法实质就是线程执行体，类似run()方法；
     *    ② 相比run()方法：1）可以有返回值；2）可以声明抛出异常
     * 3、FutureTask 主要提供了操作线程执行体的一些方法
     *    ① boolean cancel(boolean mayInterruptIfRunning)：试图取消该Future里关联的Callable任务。
     *    ② V get()：返回Callable任务里call()方法的返回值。调用该方法将导致程序阻塞，必须等到子线程结束后才会得到返回值。[插图]
     *    ③ V get(long timeout, TimeUnit unit)：返回Callable任务里call()方法的返回值。该方法让程序最多阻塞timeout和unit指定的时间，
     *                                           如果经过指定时间后Callable任务依然没有返回值，将会抛出TimeoutException异常。
     *    ④ boolean isCancelled()：如果在Callable任务正常完成前被取消，则返回true。
     *    ⑤ boolean isDone()：如果Callable任务已完成，则返回true。
     * 4、创建并启动有返回值的线程的步骤如下：
     *    ① 创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，且该call()方法有返回值。
     *    ② 创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值。
     *    ③ 使用FutureTask对象作为Thread对象的target创建并启动新线程。
     *    ④ 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值。
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 20; i++) {
            System.out.println("子线程：" + Thread.currentThread().getName() + ",循环第" + i + "次");
        }
        return i;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("当前线程：" + Thread.currentThread().getName() + ",循环第" + i + "次");
            if (i == 20) {
                //创建Callable对象
                CallableThread callable = new CallableThread();
                //使用FutureTask来包装Callable对象
                FutureTask<Integer> futureTask = new FutureTask<>(callable);
                //创建并启动线程
                new Thread(futureTask).start();
                try {
                    //通过FutureTask提供的方法来控制关联的callable任务
                    //
                    System.out.println("线程返回值："+futureTask.get());//线程返回值：20
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
