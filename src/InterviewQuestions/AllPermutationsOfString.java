package InterviewQuestions;

public class AllPermutationsOfString {

    public static void main(String[] args) {
        for(int i=0;i<3;i++) {
            printAllPermutations("ABC", i);
            System.out.println("======");
        }
    }

    private static void printAllPermutations(String str, int index) {
        if(index>=str.length() || index<0) return;
        char charX = str.charAt(index);
        System.out.println(charX);
        for(int i=0;i<str.length();i++){
            if(i==index) continue;
            else {
                String newStr = str.substring(0,index).concat(str.substring(index+1));
               // System.out.println(newStr);
                printAllPermutations(newStr,i-1);
            }
        }
    }
}
