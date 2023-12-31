package ir.sadad.readtextfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class ReadFile2 {
    public static void main(String args[]) {
        String fileName = "../sadad.txt";
        List<String> list = new ArrayList<>();
        try (Stream<String> stream =
                     Files.lines(Paths.get(fileName))) {
//1. filter line 3
//2. convert all content to upper case
//3. convert it into a List
            list = stream
                    .filter(line ->
                            !line.startsWith("Ehsan"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }
}