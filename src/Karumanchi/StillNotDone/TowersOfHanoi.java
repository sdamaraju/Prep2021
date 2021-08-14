package Karumanchi.StillNotDone;

import java.util.Stack;


public class TowersOfHanoi {

    static int counter = 0;

    public static void main(String[] args) {
        Stack a = new Stack();
        Stack b = new Stack();
        Stack c = new Stack();
        a.push(7);
       a.push(6);
        a.push(5);
     /*   a.push(2);
        a.push(1);*/
        System.out.println(a);
        System.out.println(toh(a, b, c));
        System.out.println(counter);
    }

    static Stack toh(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        while (!a.isEmpty()) {
            int value = a.pop();
            if (b.isEmpty()) {
                b.push(value);
                counter++;
            } else if (c.isEmpty()) {
                c.push(value);
                counter++;
            } else if (b.peek() > c.peek()) {
                replaceStack(b, c);
                c.push(value);
                counter++;
            } else {
                replaceStack(c, b);
                b.push(value);
                counter++;
            }
        }
        if (b.isEmpty()) return c;
        if (c.isEmpty()) return b;
        else {
            if (b.peek() > c.peek()) {
                replaceStack(b, c);
                return b;
            } else {
                replaceStack(c, b);
                return c;
            }
        }
    }

    static void replaceStack(Stack<Integer> s1, Stack<Integer> s2) {
        int value = s2.pop();
        if (!s2.isEmpty()) replaceStack(s1, s2);
        s1.push(value);
        counter++;
    }
}
