package InterviewQuestions;

public class ThreadTest extends Thread {

    public ThreadTest(Runnable r){
        super(r);
    }

    public static void main(String[] args) {


        Runner r= new Runner();
        //ThreadTest t = new ThreadTest(()->{ System.out.println("Hello"); });
        ThreadTest t = new ThreadTest(r::run);
        t.start();
        System.out.println("Hello");
    }

    static class Runner implements Runnable{
        @Override
        public void run() {
            System.out.println("Runner");
        }
    }

}
