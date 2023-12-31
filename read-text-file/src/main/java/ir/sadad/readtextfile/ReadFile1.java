package ir.sadad.readtextfile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
public class ReadFile1 {
    public static void main(String args[]) {
        String fileName = "../sadad.txt";
//read file into stream, try-with-resources
        try (Stream<String> stream =
                     Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}