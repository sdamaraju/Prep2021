package InterviewQuestions.ThreadPool;

public class TaskAndPriority implements Comparable{
    Runnable runnable;
    int priority;

    public TaskAndPriority(Runnable runnable, int priority){
        this.runnable = runnable;
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        return ((TaskAndPriority)o).priority-this.priority;
    }
}
