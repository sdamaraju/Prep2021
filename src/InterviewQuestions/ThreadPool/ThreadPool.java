package InterviewQuestions.ThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadPool {
    private PriorityBlockingQueue<TaskAndPriority> queue;
    private int threadPoolSize;
    static private ThreadPool pool = null;


    private ThreadPool(int threadPoolSize){
        this.queue = new PriorityBlockingQueue();
        this.threadPoolSize = threadPoolSize;
    }

    private void start(){
        for(int i=1;i<=threadPoolSize;i++){
            MyThread t = new MyThread(queue);
            t.start();
        }
    }

    public void addTask(Runnable r, int priority){
        queue.add(new TaskAndPriority(r,priority));
        queue.notifyAll();
    }

    static ThreadPool getInstance(int threadPoolSize){
        if(pool != null){
            return pool;
        }
        synchronized (pool) {
            if (pool != null) return pool;
            else {
                pool = new ThreadPool(threadPoolSize);
                pool.start();
                return pool;
            }
        }
    }
}
