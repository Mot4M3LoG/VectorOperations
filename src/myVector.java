import java.util.ArrayList;

public class myVector {
    public ArrayList<Integer> vector;
    public int length;

    public myVector(String vectorLine){
        ArrayList<Integer> parsedVector = VectorParser.parseVector(vectorLine);

        this.vector = new ArrayList<>();
        this.vector.addAll(parsedVector);

        this.length = this.vector.size();
    }

    public myVector(ArrayList<Integer> vector){
        this.vector = vector;
        this.length = this.vector.size();
    }

    public int getLength() {
        return this.length;
    }

    public String getContents() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < vector.size(); i++) {
            result.append(vector.get(i));

            if (i < vector.size() - 1) {
                result.append(", ");
            }
        }
        return "[" + result + "]";
    }

    public myVector add(myVector other){
        ArrayList<Integer> resultVector = new ArrayList<>();

        for (int i = 0; i < length; i++){
            int sum = this.vector.get(i);
            sum += other.vector.get(i);

            resultVector.add(sum);
        }

        return new myVector(resultVector);
    }
}
