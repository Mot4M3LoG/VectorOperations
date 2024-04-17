import java.util.ArrayList;

public class VectorParser {
    public static ArrayList<Integer> parseVector(String input) {
        String[] elements = input.split("\\s+");
        ArrayList<Integer> vector = new ArrayList<>();

        for (String element : elements) {
            try {
                int number = Integer.parseInt(element);
                vector.add(number);
            } catch (NumberFormatException ignored) {
                return null;
            }
        }
        return vector;
    }
}
