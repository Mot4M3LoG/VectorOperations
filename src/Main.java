import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean VectorsCorrect = false;

        while (!VectorsCorrect) {
            VectorsCorrect = true;

            myScanner vectorScanner = new myScanner();

            int numberOfVectors = vectorScanner.askForNumberOfVectors();
            ArrayList<myVector> vectorList = populateVectorList(numberOfVectors, vectorScanner);

            try {
                myVector resultVector = AddVectors(vectorList);

                if (resultVector != null) {
                    writeResultToFile(resultVector);
                }

            } catch (DifferentVectorsLengthsException e) {
                System.out.println(e.getMessage());
                ArrayList<myVector> differentLengthVectors = e.getVectors();

                handleIncorrectVectors(differentLengthVectors);
                VectorsCorrect = false;
            }
            vectorScanner.closeScanner();
        }
    }
    private static myVector AddVectors(ArrayList<myVector> vectors) throws DifferentVectorsLengthsException {
        int length = vectors.get(0).getLength();
        for (myVector vector : vectors) {
            if (length != vector.getLength()) {
                throw new DifferentVectorsLengthsException("Vectors cannot be added. Lengths are not equal.", vectors);
            }
        }

        myVector result = vectors.get(0);

        for (int i = 1; i < vectors.size(); i++) {
            result = result.add(vectors.get(i));
        }

        return result;
    }

    private static void handleIncorrectVectors(ArrayList<myVector> vectorList) {
        for (myVector vector : vectorList) {
            System.out.println("\nVector Length: " + vector.getLength() + ", Contents: " + vector.getContents());
        }

        System.out.println("\nvectors need to be of the same length!\n");
    }

    private static void writeResultToFile(myVector vector){
        try{
            ResultWriter.writeResultToFile("Final vector: " + vector.getContents() + " of length: " + vector.getLength());
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Couldn't write resulting vector to file");
        }
    }

    private static ArrayList<myVector> populateVectorList(int numberOfVectors, myScanner vectorScanner){
        ArrayList<myVector> vectorList = new ArrayList<>();

        for (int i = 0; i < numberOfVectors; i++) {
            String line = vectorScanner.askForVectorInput();
            myVector aVector = new myVector(line);

            vectorList.add(aVector);
        }

        return vectorList;
    }
}

