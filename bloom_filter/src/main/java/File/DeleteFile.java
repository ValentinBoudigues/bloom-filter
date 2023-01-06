package File;

import java.io.File;

public class DeleteFile {

    /**
     * Delete a file
     */
    public static void deleteFile() {
        File myObj = new File("result.csv");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
