package Bloom_Filter;

import Tools.Hash;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class BloomFilter_Abstract extends BloomFilter {
    private final int listLength;

    public ArrayList<Boolean> filter_list = null;
    public LinkedList<Boolean> filter_linked = null;

    /**
     * Constructor
     *
     * @param length length of the filter
     * @param type  type of the filter
     */
    public BloomFilter_Abstract(int length, int type) {
        listLength = length;

        switch (type) {
            case 1 -> {
                filter_list = new ArrayList<>(length);
                initFilter(filter_list);
            }
            case 2 -> {
                filter_linked = new LinkedList<>();
                initFilter(filter_linked);
            }
        }
    }

    /**
     * Initialize the filter
     * @param list list to initialize
     */
    public void initFilter(AbstractList<Boolean> list) {
        for (int i = 0; i < listLength; i++) {
            list.add(i, Boolean.FALSE);
        }
    }

    /**
     * Get the length of the filter
     */
    public void resetFilter() {
        filter_list = new ArrayList<>(listLength);
        filter_linked = new LinkedList<>();
    }

    /**
     * Get the length of the filter
     * @return length of the filter
     */
    public int getLength() {
        return listLength;
    }

    /**
     * Add a word to the filter
     * @param hashed array of hashed values
     * @param filter_array filter to add the word to
     */
    public void add(int[] hashed, AbstractList<Boolean> filter_array) {
        for (int hash : hashed) {
            filter_array.set(hash, Boolean.TRUE);
        }
    }

    /**
     * Check if a word is in the filter
     * @param hashed array of hashed values
     * @param filter filter to check
     * @return 1 if the word is in the filter, 0 otherwise
     */
    public int contains(int[] hashed, AbstractList<Boolean> filter) {
        for (int hash : hashed) {
            if (filter.get(hash) != Boolean.TRUE) {
                /* System.out.println(" --->> Word is not in filter"); */
                return 1;
            }
        }
        /* System.out.println("Word is in filter"); */
        return 0;
    }

    /**
     * Calculate the error percentage
     * @param randomWords array of random words
     * @param function hash function
     * @param filter filter to check
     * @return error percentage
     */

    public float errorPercentage(String[] randomWords, Hash function, AbstractList<Boolean> filter) {
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
     * @return string of the filter
     */
    @Override
    public String toString() {
        if (filter_list == null) {
            return "LinkedList";
        } else {
            return "ArrayList";
        }
    }
}
