package CoreJavaPreparation;

public class StringPool {
    public static void main(String[] args) {
        String st1 = new String("Hello");
        String st2 = new String("Hello");
        System.out.println(st1==st2);
        String st3 = "Hello";
        String st4 = "Hello";
        System.out.println(st3==st4);
        System.out.println(st2==st3);
        System.out.println(st1.intern()==st3);
        System.out.println(st1==st3);
        String st5 = new String("Hello").intern();
        System.out.println(st5 == st3);
    }
}
