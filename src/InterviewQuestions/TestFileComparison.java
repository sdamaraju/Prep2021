package InterviewQuestions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFileComparison {
    public static void main(String[] args) throws IOException {
        Stream<String> st1 = Files.lines(Paths.get("/Users/sdamaraju/IdeaProjects/Prep2021/src/InterviewQuestions/Text1.txt"));
        Stream<String> st2 = Files.lines(Paths.get("/Users/sdamaraju/IdeaProjects/Prep2021/src/InterviewQuestions/Text2.txt"));
        Set<String> dest = st2.map(line -> line.split(",")).map(arr -> arr[0]).collect(Collectors.toSet());
        Set<String> result = st1.map(line -> line.split(",")).map(arr -> arr[0]).distinct().filter(dest::contains).collect(Collectors.toSet());
        System.out.println(result);
    }
}
