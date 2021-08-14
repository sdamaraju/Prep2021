import java.io.*;
import java.util.*;

public class CSVParser {

    static class Transaction {
        int tid;
        int cid;
        Double amount;
        String desc;
        String date;

        public Transaction(int tid, int cid, Double amount, String desc, String date) {
            this.tid = tid;
            this.cid = cid;
            this.amount = amount;
            this.desc = desc;
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Transaction that = (Transaction) o;
            return tid == that.tid;
        }

        @Override
        public int hashCode() {
            return Objects.hash(tid);
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "tid=" + tid +
                    ", cid=" + cid +
                    ", amount=" + amount +
                    ", desc='" + desc + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        HashSet<Transaction> transactions = new HashSet();
        HashMap<Integer, List<Transaction>> customerTransactions = new HashMap<>();
        CSVParser parser = new CSVParser();
        FileReader f = new FileReader(new File("/Users/sdamaraju/Desktop/Book1.csv"));
        BufferedReader br = new BufferedReader(f);
        String line = br.readLine();
        while (line != null) {
            if(!Character.isDigit(line.charAt(0))) line = line.substring(1);
            String[] values = parser.parseLine(line, args[0]);
            if (parser.isValid(values)) { // do something,, {
                Transaction t = new Transaction(Integer.parseInt(values[0].trim()), Integer.parseInt(values[1].trim()), Double.parseDouble(values[2].trim()), values[3].trim(), values[4].trim());
                if (transactions.add(t)) {
                    if (customerTransactions.get(t.cid) == null) {
                        List<Transaction> customerSpecificTransactions = new ArrayList<>();
                        customerSpecificTransactions.add(t);
                        customerTransactions.put(t.cid, customerSpecificTransactions);
                    } else {
                        customerTransactions.get(t.cid).add(t);
                    }
                } else {
                    //increment duplicate count
                }
            } else {
                // incrememnt error count..
                //do something.
            }
            line = br.readLine();
        }
        for(Map.Entry<Integer,List<Transaction>> entry: customerTransactions.entrySet()){
            System.out.println("Customer ID : " + entry.getKey());
            System.out.println("Transactions : " + entry.getValue());
            Double sum = 0.0;
            for(Transaction t: entry.getValue()){
                sum = sum + (t.amount);
            }
            System.out.println("Total amount spend = " + sum);
        }

    }

    private boolean isValid(String[] values) {
        return true;
    }

    public String[] parseLine(String line, String delimiter) {
        return line.split(delimiter);
    }
}
