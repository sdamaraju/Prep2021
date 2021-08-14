package LeetCodeProblems;

import java.util.Stack;

public class RemoveAdjacent {

    public static void main(String[] args) {
        RemoveAdjacent x = new RemoveAdjacent();
        /*System.out.println(x.removeAdjacent("deeedbbcccbdaa",3));*/
        System.out.println(x.removeAdjacent("wilddddddddddgooowwwwwwwwwwoooossssssssssoccccccchhhhhhhhhhcccccccccccccooryyyyyyyffffffffffyyynaicv",10));
    }

    private String removeAdjacent(String input, int counter) {
        if (counter == 1) return "";
        Stack<Character> characters = new Stack();
        Stack<Integer> tracker = new Stack();
        for (int i = 0; i < input.length(); i++) {
            if (characters.isEmpty()) {
                characters.push(input.charAt(i));
                tracker.push(1);
            } else {
                char nextChar = input.charAt(i);
                if (characters.peek() == nextChar) {
                    if (tracker.peek() == counter - 1) {
                            characters.pop();
                            tracker.pop();
                    } else {
                        tracker.push(tracker.pop() + 1);
                    }
                } else {
                    characters.push(nextChar);
                    tracker.push(1);
                }
            }
        }
        StringBuilder op = new StringBuilder();
        while(!characters.isEmpty()){
            int count = tracker.pop();
            for(int i=1;i<=count;i++){
                op.append(characters.pop());
            }
        }
        return op.reverse().toString();
    }
}
