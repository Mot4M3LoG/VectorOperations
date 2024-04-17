import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter{
    public static void writeResultToFile(String result) throws IOException  {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            writer.write(result);
            System.out.println("Result written to result.txt");
        }
    }
}
