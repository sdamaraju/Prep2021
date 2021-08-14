package CoreJavaPreparation;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        countWordOccurrences("My name is My, teja");
    }

    private static boolean isEscapeCharacter(char x){
        return x != '!' && x != '?' && x!= ',' && x != '.' && x!= ' ';
    }

    public static String countWordOccurrences (String text) {
        HashMap<String,Integer> map = new HashMap();
        StringBuilder wordBuilder = new StringBuilder();
        for (int i=0;i<text.length();i++){
            if (isEscapeCharacter(text.charAt(i))){
                if(wordBuilder.length()>0){
                    String word = wordBuilder.toString().toLowerCase();
                    if(map.get(word)==null){
                        map.put(word,1);
                    }else{
                        int count = map.get(word);
                        map.put(word,++count);
                    }
                    wordBuilder = new StringBuilder();
                }
                continue;
            }else{
                wordBuilder.append(text.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        result.append("\"");
        for (Map.Entry entry : map.entrySet()){
            result.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        result.append("\"");
        return result.toString();
    }
}
