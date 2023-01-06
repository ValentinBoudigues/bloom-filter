package Tools;

public class Hash {
    private final int length;

    public Hash(int length) {
        this.length = length;
    }

    /**
     * Hash a word with 3 different hash functions
     * @param word the word to hash
     * @return the 3 hashes of the word in an array
     */
    public int[] hashing(String word) {
        return new int[]{prime_hash(word), xor_hash(word), power_hash(word)};
    }

    /**
     * Hash a word with the prime hash function
     * @param word the word to hash
     * @return the hash of the word
     */
    private int prime_hash(String word) {
        long hash = 7;

        for (int i = 0; i < word.length(); i++) {
            hash = hash*31 + (int) word.charAt(i);
        }

        hash = hash % length;
        return (int) hash;
    }

    /**
     * Hash a word with the xor hash function
     * @param word the word to hash
     * @return the hash of the word
     */
    private int xor_hash(String word) {
        int hash = 0;

        for (int i = 0; i < word.length(); i++) {
            hash = hash ^ (int) word.charAt(i);
        }

        hash = hash % length;
        return hash;
    }

    /**
     * Hash a word with the power hash function
     * @param word the word to hash
     * @return the hash of the word
     */
    private int power_hash(String word) {
        int hash = 0;

        for (int i = 0; i < word.length(); i++) {
            hash = hash + (int) Math.pow(2, i) * (int) word.charAt(i);
        }

        hash = hash % length;
        return hash;
    }
}
