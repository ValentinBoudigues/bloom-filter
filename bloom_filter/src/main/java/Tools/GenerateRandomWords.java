package Tools;

import java.util.Random;

public class GenerateRandomWords {

    /**
     * Generate random words
     * @param len length of the array of words
     * @param alphabet alphabet to use
     * @return array of random words
     */
    public static String[] generateRandomWords(int len, String alphabet) {
        String[] tab = new String[len];

        for (int longueur = 0; longueur < len; longueur++) {

            StringBuilder randomString = new StringBuilder();
            int length = 5;

            Random rand = new Random();

            char[] text = new char[length];

            for (int i = 0; i < length; i++) {
                text[i] = alphabet.charAt(rand.nextInt(alphabet.length()));
            }

            for (char c : text) {
                randomString.append(c);
            }
            tab[longueur] = randomString.toString();
        }
        return tab;
    }
}
