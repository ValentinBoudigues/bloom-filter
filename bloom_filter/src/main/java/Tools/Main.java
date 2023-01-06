package Tools;

import File.*;

public class Main {
    public static void main(String[] args) {

        final int NUMBER_OF_REPEAT = 100;
        final int STARTING_LENGTH = 100000;

        Repeat boucle = new Repeat(NUMBER_OF_REPEAT, STARTING_LENGTH);

        DeleteFile.deleteFile();
        CreateFile.createFile();
        WritingFile.initFile();

        System.out.println();

        System.out.println("Array");
        boucle.launchArray();
        System.out.println("Array list");
        boucle.launchArrayList();
        System.out.println("Linked list");
        boucle.launchLinkedList();
        System.out.println("Hash set");
        boucle.launchSet();
    }
}
