package InterviewQuestions;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    int x;
    TreeSetTest(){}
    TreeSetTest(int a){
        this.x = a;
    }

    public static void main(String[] args) {
        int a = 10;
        TreeSet set = new TreeSet((o1,o2) -> { return (Integer)o1 - (Integer)o2;});
        Thread t = new Thread(()->{ System.out.println("asdasd"); });
       testFInterface x = new testFInterface((j,b) -> {return 45+67;});
        System.out.println(x.a.add(10,20));
       // set.add(null);
        set.add(3);
        set.add(1);
        set.add(4);
        set.add(4);

        Iterator it = set.iterator();
        while(it.hasNext()){
            it.next();
            //System.out.println();
            set.add(6);
        }
        System.out.println("asdasd"+set);
        TreeSetTest test = new TreeSetTest();
        TreeSetTest test1 = new TreeSetTest(10);
        test.test("asd");
        test.test(6);
        test.test(new Object());
    }

    public void test (String a){
        System.out.println("1");
    }

    public void test (Integer a){
        System.out.println("2");
    }

    public void test (Object a){
        System.out.println("3");
    }

    public static class testFInterface {
        FInterface a;
        testFInterface(FInterface a){
            this.a = a;
        }
    }

}
