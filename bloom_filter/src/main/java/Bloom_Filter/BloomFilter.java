package Bloom_Filter;

import Tools.Hash;

import java.util.AbstractList;

public abstract class BloomFilter {

    public void initFilter(boolean[] array) {}
    public void initFilter(AbstractList<Boolean> array) {}

    public abstract int getLength();

    public void add(int[] hashed, boolean[] filter_array) {}
    public void add(int[] hashed, AbstractList<Boolean> filter_array) {}

    public int contains(int[] hashed, boolean[] filter) { return 0; }
    public int contains(int[] hashed, AbstractList<Boolean> filter) { return 0; }

    public float errorPercentage(String[] randomWords, Hash function, boolean[] filter_list) { return 0; }
    public float errorPercentage(String[] randomWords, Hash function, AbstractList<Boolean> filter_list) { return 0; }

    public abstract String toString();

    public abstract void resetFilter();
}
