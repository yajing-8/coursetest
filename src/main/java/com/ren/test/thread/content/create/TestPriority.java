package com.ren.test.thread.content.create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 多线程优先级练习
 */
public class TestPriority {

    public static volatile boolean notStart = true;
    public static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;

            Job job = new Job(priority);
            Thread thread = new Thread(job, "Thread：" + i);
            thread.setPriority(priority);
            thread.start();
            jobs.add(job);
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job:jobs) {
            System.out.println("Job Priority:"+job.priority+"Job Count:"+job.jobCount);
        }
    }

    static class Job implements Runnable {
        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
              /*  System.out.println("线程优先级"+priority+"执行notStart啦。。。");*/
            }
            while (notEnd) {
                Thread.yield();
              /*  System.out.println("线程优先级"+priority+"执行notEnd啦。。。");*/
                jobCount++;
            }
        }
    }
}
