package Tools;

import java.lang.Math;

import Bloom_Filter.BloomFilter;
import File.WritingFile;

public class Benchmark {
    private final BloomFilter filter;
    private long startTime;
    private long endTime;

    /**
     * Constructor
     * @param bloom_filter the filter to benchmark
     */
    public Benchmark(BloomFilter bloom_filter) {this.filter = bloom_filter;}

    /**
     * Start the timer
     */
    public void startTime() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Stop the timer
     */
    public void endTime() {
        this.endTime = System.currentTimeMillis();
    }

    /**
     * Get the time elapsed
     */
    public void writeTime(float errorPercentage) {
        int time = (int) (this.endTime - this.startTime);
        WritingFile.WriteFile(filter.toString(), filter.getLength(), time, Math.round(errorPercentage));
    }
}