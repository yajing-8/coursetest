package com.ren.test.thread.base;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadUtil {

    /**
     * 6:Monitor Ctrl-Break：
     * 5:Attach Listener：线程的主要工作是串流程，流程步骤包括：接收客户端命令、解析命令、查找命令执行器、执行命令等等
     * 4:Signal Dispatcher：分发处理发送给JVM信号的线程
     * 3:Finalizer ：调用对象finalize方法的线程
     * 2:Reference Handler ：清除Reference的线程
     * 1:main ：用户程序入口
     * @param args
     */
    public static void main(String[] args) {
        //获取Java线程管理
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程信息和堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历线程信息：获取线程ID和线程名称
        for (int i = 0; i < threadInfos.length; i++) {
            System.out.println(threadInfos[i].getThreadId()+":"+threadInfos[i].getThreadName());
        }
    }
}
