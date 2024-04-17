import java.util.ArrayList;

public class DifferentVectorsLengthsException extends Exception {
    private final ArrayList<myVector> vectors;

    public DifferentVectorsLengthsException(String message, ArrayList<myVector> vectors) {
        super(message);
        this.vectors = vectors;
    }

    public ArrayList<myVector> getVectors() {
        return vectors;
    }
}
