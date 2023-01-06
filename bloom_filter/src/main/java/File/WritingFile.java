package File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WritingFile {

    /**
     * Initialize the file
     */
    public static void initFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("result.csv", true));
            out.println("Type,Length,Time,Error");
            out.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Write to the file
     * @param s the type of the filter
     * @param length the length of the filter
     * @param time the time to add the words
     * @param errorPercentage the error percentage
     */
    public static void WriteFile(String s, int length, int time, int errorPercentage) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("result.csv", true));
            out.println(s + "," + length + "," + time + "," + errorPercentage);
            out.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}