import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFileExample {
    public static void main(String[] args) {
        BufferedWriter bufferWritter = null;
        try {
            String data = " This content will append to the end of the file";

            File file = new File("append-file.txt");

            //if file does not exist, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.newLine();
            bufferWritter.write(data);

            bufferWritter.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}