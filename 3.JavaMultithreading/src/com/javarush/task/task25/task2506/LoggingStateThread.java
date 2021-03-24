package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run()
    {
        State state = thread.getState();
        System.out.println(state);
        while(state != State.TERMINATED)
        {
            if (state != thread.getState())
            {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }

//    public void run() {
//        boolean stateRunnable = false;
//        boolean stateNew = false;
//        while (!thread.isInterrupted()) {
//            if (thread.getState() == State.NEW && !stateNew) {
//                stateNew = true;
//                System.out.println("NEW");
//            }
//            if (thread.getState() == State.RUNNABLE && !stateRunnable) {
//                stateRunnable = true;
//                System.out.println("RUNNABLE");
//            }
//            if (thread.getState() == State.TERMINATED) {
//                System.out.println("TERMINATED");
//                break;
//            }
//        }
//    }
}
