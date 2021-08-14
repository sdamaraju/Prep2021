package InterviewQuestions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {

    private static int runner (){
        System.out.println("By thread");
        return 5;
    }
    private  String myupper (String a){
        return a;
    }

    private int runner1 (){
        System.out.println("By thread22");
        return 5;
    }

    private boolean test (User a){
        return a.getName().length()>3;
    }

    private char test1 (String a){
        return a.charAt(0);
    }

    public static void main(String[] args) throws IOException {
        Java8Test x = new Java8Test();
        List<User> users = new ArrayList();
        users.add(new User("Sai",1,100,"CS"));
        users.add(new User("test",1,200,"CS"));
        users.add(new User("abcd",3,300,"MS"));
        users.add(new User("defg",4,400,"MS"));
        users.add(new User("mmmkl",5,600,"JA"));
        String reduced = users.stream().map(User::getName).reduce("rere",(a,b)->a.concat(b));
        System.out.println(reduced);

        Map filtered = users.stream().filter(user -> !user.getDep().equals("JA")).collect(Collectors.groupingBy(User::getDep));
        System.out.println(filtered.get("CS"));

        Stream<String> allLines = Files.lines(Paths.get("/Users/sdamaraju/Desktop/test.txt"));

        List set = allLines.map(line -> line.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println("########" + set);

       // Set<User> filtered = users.stream().filter(user -> !user.getName().isEmpty()).collect(Collectors.toSet());
        List<String> strings = new ArrayList();
        strings.add("Sai");
        strings.add("Sai");
        strings.add("SaiKr");
        Set<Character> mapped = strings.stream().map((str) -> {return str.charAt(0);}).collect(Collectors.toSet());


        Set<User> filteredNames = users.stream().filter(x::test).collect(Collectors.toSet());

        Set<Integer> mappedUser = users.stream().map(user -> user.getId()).collect(Collectors.toSet());
        System.out.println(filteredNames);
        Thread t = new Thread(x::runner1);
        t.start();

        List numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((j) -> (int) j).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParams);

        String[] strings1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        System.out.println("-------\nRunning sequential\n-------");
       // run(Arrays.stream(strings1).sequential());
        System.out.println("-------\nRunning parallel\n-------");
      //  run(Arrays.stream(strings1).parallel());
        Integer events[][] = new Integer[][]{{1,2},{2,3},{3,4}};

        List op = Arrays.stream(events).map(j -> Arrays.asList(j)).collect(Collectors.toList());
        List starts = (List)op.stream().map(a-> ((List)a).get(0)).collect(Collectors.toList());
        List ends = (List)op.stream().map(a-> ((List)a).get(1)).collect(Collectors.toList());
        System.out.println(starts + "" + ends);
        //System.out.println(((int[])eventsList.get(0))[0]);


                //.stream().map(j -> Arrays.asList(j)).collect(Collectors.toList());
        //System.out.println(eventsList.get(0) + " " + eventsList.get(1));
        //List starts = eventsList.stream().map(a-> a.get(0)).collect(Collectors.toList());
        //List ends = eventsList.stream().map(a-> a.get(1)).collect(Collectors.toList());
        //System.out.print(starts);
        //System.out.print(ends);
    }

    public static void run (Stream<String> stream) {

        stream.forEach(s -> {
            System.out.println(LocalTime.now() + " - value: " + s +
                    " - thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }





}
