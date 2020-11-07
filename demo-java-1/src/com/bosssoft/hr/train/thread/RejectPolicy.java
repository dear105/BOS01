package com.bosssoft.hr.train.thread;

/**
 * @author lenovo
 */
public interface RejectPolicy {
    void reject(Runnable task, TestThreadPool myThreadPoolExecutor);
}
