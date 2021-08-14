package InterviewQuestions;

public class NewThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {System.out.print("Hello");});
        t.start();

    }
}
