package Tools;

import java.util.Arrays;
import java.util.HashSet;

import Bloom_Filter.BloomFilter_Abstract;
import Bloom_Filter.BloomFilter_Array;
import File.WritingFile;

public class Repeat {
    private final int NUMBER_OF_REPEAT;
    private final int STARTING_LENGTH;
    private final int WORDS_LENGTH;

    /**
     * Constructor
     * @param NUMBER_OF_REPEAT number of repetition
     * @param STARTING_LENGTH starting length of the filter
     */
    public Repeat(int NUMBER_OF_REPEAT, int STARTING_LENGTH) {
        this.NUMBER_OF_REPEAT = NUMBER_OF_REPEAT;
        this.STARTING_LENGTH = STARTING_LENGTH;
        this.WORDS_LENGTH = STARTING_LENGTH / 10;
    }

    /**
     * Launch the benchmark for the array
     */
    public void launchArray() {
        for (int i = 1; i <= NUMBER_OF_REPEAT; i++) {
            BloomFilter_Array bloomFilter = new BloomFilter_Array((i * STARTING_LENGTH));
            String[] randomWords = GenerateRandomWords.generateRandomWords((i * WORDS_LENGTH), "abcdefghijklm");
            String[] notRandomWords = GenerateRandomWords.generateRandomWords((i * WORDS_LENGTH), "nopqrstuvwxyz");

            Hash arrayHash = new Hash(bloomFilter.getLength());

            System.out.println("Type : " + bloomFilter + " | Length : " + bloomFilter.getLength());

            for (String randomWord : randomWords) {
                bloomFilter.add(arrayHash.hashing(randomWord), bloomFilter.filter);
            }

            Benchmark benchmark = new Benchmark(bloomFilter);
            benchmark.startTime();

            for (String randomWord : randomWords) {
                bloomFilter.contains(arrayHash.hashing(randomWord), bloomFilter.filter);
            }

            benchmark.endTime();

            float errorPercentage = bloomFilter.errorPercentage(notRandomWords, arrayHash, bloomFilter.filter);
            System.out.println("Error percentage : " + errorPercentage + "%");

            benchmark.writeTime(errorPercentage);

            bloomFilter.resetFilter();
            Arrays.fill(randomWords, null);
            System.out.println();
        }
    }

    /**
     * Launch the benchmark for the array list
     */
    public void launchArrayList() {
        for (int i = 1; i <= NUMBER_OF_REPEAT; i++) {
            BloomFilter_Abstract bloomFilter = new BloomFilter_Abstract((i * STARTING_LENGTH), 1);
            String[] randomWords = GenerateRandomWords.generateRandomWords((i * WORDS_LENGTH), "abcdefghijklm");
            String[] notRandomWords = GenerateRandomWords.generateRandomWords((i * WORDS_LENGTH), "nopqrstuvwxyz");
            Hash arrayHash = new Hash(bloomFilter.getLength());

            System.out.println("Type : " + bloomFilter + " | Length : " + bloomFilter.getLength());

            for (String randomWord : randomWords) {
                bloomFilter.add(arrayHash.hashing(randomWord), bloomFilter.filter_list);
            }

            Benchmark benchmark = new Benchmark(bloomFilter);
            benchmark.startTime();

            for (String randomWord : randomWords) {
                bloomFilter.contains(arrayHash.hashing(randomWord), bloomFilter.filter_list);
            }

            benchmark.endTime();

            float errorPercentage = bloomFilter.errorPercentage(notRandomWords, arrayHash, bloomFilter.filter_list);
            System.out.println("Error percentage : " + errorPercentage + "%");

            benchmark.writeTime(errorPercentage);

            bloomFilter.resetFilter();
            Arrays.fill(randomWords, null);
            System.gc();
            System.out.println();
        }
    }

    /**
     * Launch the benchmark for the linked list
     */
    public void launchLinkedList() {
        for (int i = 1; i <= NUMBER_OF_REPEAT; i++) {
            BloomFilter_Abstract bloomFilter = new BloomFilter_Abstract((i * STARTING_LENGTH), 2);
            String[] randomWords = GenerateRandomWords.generateRandomWords((i * WORDS_LENGTH), "abcdefghijklm");
            String[] notRandomWords = GenerateRandomWords.generateRandomWords((i * WORDS_LENGTH), "nopqrstuvwxyz");
            Hash arrayHash = new Hash(bloomFilter.getLength());

            System.out.println("Type : " + bloomFilter + " | Length : " + bloomFilter.getLength());
            System.out.println("Length : " + (i * STARTING_LENGTH)/10);

            for (String randomWord : randomWords) {
                bloomFilter.add(arrayHash.hashing(randomWord), bloomFilter.filter_linked);
            }

            Benchmark benchmark = new Benchmark(bloomFilter);
            benchmark.startTime();

            for (String randomWord : randomWords) {
                bloomFilter.contains(arrayHash.hashing(randomWord), bloomFilter.filter_linked);
            }

            benchmark.endTime();

            float errorPercentage = bloomFilter.errorPercentage(notRandomWords, arrayHash, bloomFilter.filter_linked);
            System.out.println("Error percentage : " + errorPercentage + "%");

            benchmark.writeTime(errorPercentage);

            bloomFilter.resetFilter();
            Arrays.fill(randomWords, null);
            System.gc();
            System.out.println();
        }
    }

    /**
     * Launch the benchmark for the hash set
     */
    public void launchSet() {
        for (int i = 1; i <= NUMBER_OF_REPEAT; i++) {
            HashSet<Integer> hashSet = new HashSet<>((i * STARTING_LENGTH));
            String[] randomWords = GenerateRandomWords.generateRandomWords((i * WORDS_LENGTH), "abcdefghijklm");

            System.out.println("Type : HashSet | Length : " + (STARTING_LENGTH * i) / 10);

            Hash arrayHash = new Hash((STARTING_LENGTH * i));

            for (String randomWord : randomWords) {
                for (int hash : arrayHash.hashing(randomWord)) {
                    hashSet.add(hash);
                }
            }

            long startTime = System.currentTimeMillis();

            for (String randomWord : randomWords) {
                for (int hash : arrayHash.hashing(randomWord)) {
                    if (!hashSet.contains(hash))
                        System.out.println("---->>> not found : " + randomWord);
                }
            }

            long endTime = System.currentTimeMillis();

            int time = (int) (endTime - startTime);
            WritingFile.WriteFile("HashSet", (STARTING_LENGTH * i), time, 0);

            hashSet.clear();
            Arrays.fill(randomWords, null);
            System.gc();
            System.out.println();
        }
    }
}
