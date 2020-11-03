package mandatory_assignments.assignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Utility {

    public double calculateNLogN(int n) {
        return n * log(n, 2);
    }

    public double log(int x, int base) {
        return (Math.log(x) / Math.log(base));
    }

    public int[] randomNumbers(int size) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            array.add(i);
        }
        Collections.shuffle(array);
        int[] a = new int[size];
        for (int i = 0; i < array.size(); i++) {
            a[i] = array.get(i);
        }
        return a;
    }

    public void writeCSVInt(String fileName, TreeMap<Integer, Integer> dataxy) {
        String eol = System.getProperty("line.separator");
        try (FileWriter writer = new FileWriter(fileName + ".csv");) {
            for (Map.Entry<Integer, Integer> entry : dataxy.entrySet()) {
                writer.append(String.valueOf(entry.getKey()))
                        .append(',')
                        .append(String.valueOf(entry.getValue()))
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    public void writeCSVDouble(String fileName, TreeMap<Integer, Double> dataxy) {
        String eol = System.getProperty("line.separator");
        try (FileWriter writer = new FileWriter(fileName + ".csv");) {
            for (Map.Entry<Integer, Double> entry : dataxy.entrySet()) {
                writer.append(String.valueOf(entry.getKey()))
                        .append(',')
                        .append(String.valueOf(entry.getValue()))
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

}
