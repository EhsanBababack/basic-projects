import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyException extends Exception{
    public MyException(String message) {
        super(message);
        BufferedWriter bufferWritter = null;
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            String time = localDateTime.toString();
            String data = time +" // "+message;

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
