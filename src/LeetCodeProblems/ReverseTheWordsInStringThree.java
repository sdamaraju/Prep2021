package LeetCodeProblems;

public class ReverseTheWordsInStringThree {

    public static void main(String[] args) {
        String sentence = "Hello sai how are you";
        System.out.println(reverseTheSentence(sentence));
    }

    private static String reverseTheSentence(String sentence) {
        StringBuilder reverse = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i <= sentence.length(); i++) {
            if (i < sentence.length() && sentence.charAt(i) != ' ') {
                word.append(sentence.charAt(i));
            } else {
                reverse.append(reverseWord(word.toString()) + " ");
                word = new StringBuilder();
            }
        }
        return reverse.toString();

    }

    private static String reverseWord(String word) {
        StringBuilder returnWord = new StringBuilder();
        for(int i=word.length()-1;i>=0;i--){
            returnWord.append(word.charAt(i));
        }
        return returnWord.toString();
    }

}
