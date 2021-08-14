package InterviewQuestions.ThreadPool;

import java.util.concurrent.BlockingQueue;

public class MyThread extends Thread{
    BlockingQueue<TaskAndPriority> queue;

    public MyThread(BlockingQueue<TaskAndPriority> queue){
        super();
        this.queue = queue;
    }

    public void run(){
        Runnable task = null;

        while(true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        //
                    }
                } else {
                    TaskAndPriority currentTaskAndPriority = queue.poll();
                    notifyAll();
                    task = currentTaskAndPriority.runnable;
                    this.setPriority(currentTaskAndPriority.priority);
                }
            }

            if(task !=null){
                try {
                    task.run();
                }catch (RuntimeException ex){
                    System.out.println("Thread interrupted with exception.");
                }
                finally {
                    task = null;
                }
            }
        }
    }

}
