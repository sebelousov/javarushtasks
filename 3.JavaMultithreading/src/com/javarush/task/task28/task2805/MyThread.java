package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(0);

    public MyThread() {
        setPriorityInThread();
    }

    public void setPriorityInThread() {
        if (priority.get() == Thread.MAX_PRIORITY) priority.set(0);
        this.setPriority(priority.incrementAndGet());
        // || priority.get() == Thread.currentThread().getThreadGroup().getMaxPriority()
    }

    public MyThread(Runnable target) {
        super(target);
        setPriorityInThread();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriorityInThread();
    }

    public MyThread(String name) {
        super(name);
        setPriorityInThread();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriorityInThread();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriorityInThread();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriorityInThread();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriorityInThread();
    }

//    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
//        super(group, target, name, stackSize, inheritThreadLocals);
//        setPriorityInThread();
//    }
}
