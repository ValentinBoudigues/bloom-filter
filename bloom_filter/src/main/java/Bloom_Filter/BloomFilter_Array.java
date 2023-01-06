package Bloom_Filter;

import Tools.Hash;

public class BloomFilter_Array extends BloomFilter {
    private final int filterLength;
    public boolean[] filter;

    /**
     * Constructor
     * @param length length of the filter
     */
    public BloomFilter_Array(int length) {
        filter = new boolean[length];
        filterLength = length;
        initFilter(filter);
    }

    /**
     * Initialize the filter
     * @param array the filter to initialize
     */
    public void initFilter(boolean[] array) {
        for (int i = 0; i < filterLength; i++) {
            array[i] = Boolean.FALSE;
        }
    }

    /**
     * Get the length of the filter
     */
    @Override
    public void resetFilter() {
        filter = new boolean[filterLength];
    }

    /**
     * Get the length of the filter
     * @return the length of the filter
     */
    public int getLength() {return filterLength;}

    /**
     * Add a word to the filter
     * @param hashed the hashed word
     * @param filter the filter
     */
    public void add(int[] hashed, boolean[] filter) {
        for (int hash : hashed) {
            filter[hash] = Boolean.TRUE;
        }
    }

    /**
     * Check if a word is in the filter
     * @param hashed the hashed word
     * @param filter the filter
     * @return 0 if the word is in the filter, 1 otherwise
     */
    public int contains(int[] hashed, boolean[] filter) {
        for (int hash : hashed) {
            if (filter[hash] != Boolean.TRUE) {
                /* System.out.println(" --->> Word is not in filter"); */
                return 1;
            }
        }
        /* System.out.println("Word is in filter"); */
        return 0;
    }

    /**
     * Calculate the error percentage
     * @param randomWords the random words
     * @param function the hash function
     * @param filter the filter
     * @return the error percentage
     */
    public float errorPercentage(String[] randomWords, Hash function, boolean[] filter) {
        int errorCount = 0;

        for (String randomWord : randomWords) {
            if (contains(function.hashing(randomWord), filter) == 0) {
                errorCount++;
            }
        }

        float percentage = (float) errorCount / (float) randomWords.length;

        return percentage * 100;
    }

    /**
     * Print the type of the filter
     * @return the filter
     */
    @Override
    public String toString() {
        return "Array";
    }

}
