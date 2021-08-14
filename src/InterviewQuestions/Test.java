package InterviewQuestions;

import java.util.ArrayList;

class Test {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<LetterLog> letterLogs = new ArrayList();
        String result[] = new String[logs.length];
        int resultFill = result.length-1;
        for(int i=logs.length-1;i>=0;i--){
            String log = logs[i];
            char lastElem = log.charAt(log.length()-1);
            if((int)lastElem >= 95 && (int)lastElem <= 122){
                letterLogs.add(new LetterLog(log));
            }
            else {
                result[resultFill--]=log;
            }
        }
        letterLogs.sort(LetterLog::compareTo);
        for(int i=0;i<letterLogs.size();i++){
            result[i]=letterLogs.get(i).toString();
        }
        return result;
    }

    class LetterLog implements Comparable{
        String id;
        String content;

        LetterLog (String content){
            int index = content.indexOf(" ");
            this.id = content.substring(0,index);
            this.content = content.substring(index);
        }

        public int compareTo(Object o){
            if(this.content.equals(((LetterLog)o).content)){
                return this.id.compareTo(((LetterLog)o).id);
            } else return this.content.compareTo(((LetterLog)o).content);
        }

        public String toString(){
            return this.id + " " + this.content;
        }


    }

}
