package CoreJavaPreparation;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StaticTest {

    static final int abc = 123;
    static void print(){
        System.out.println("Helll 1");
    }

    public String toString(){
        return "asd";
    }

    static class statictest2 extends StaticTest{
        static void print(){
            System.out.println("Helll 1");
        }

        void print1(){
            System.out.println("Helll 4");
        }

        public static int compare(Object a, Object b){
            return (Integer)(b) - (Integer)a;
        }
    }

    public static void main(String[] args) {
        StaticTest a = new statictest2();
        a.print();
        System.out.println((int)('a'));//a.print1();
        StaticTest.print();
        statictest2.print();
        List<Integer> test = new ArrayList();
        test.add(5);
        test.add(6);
        test.add(4);
        test.add(3);
        test.add(10);
        Collections.sort(test,( c,  b)->{return (Integer)c - (Integer)b;});
        System.out.println(test);
        Collections.sort(test,statictest2::compare);
        System.out.println(test);
        final String s = "anc";
        s.concat("asda");


        List<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        for (Integer integer : integers) {
            integers.remove(1);
        }



        System.out.println(s);
        try{
            int ca = 10;
            //throw new ArrayStoreException();
        }
        finally {
            System.out.println("asdasd");
           // throw new NullPointerException();
        }
    }

}


