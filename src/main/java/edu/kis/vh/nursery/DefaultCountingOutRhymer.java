package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int ARRAY_SIZE = 12;
    public static final int TOTAL = -1;
    private final int[] numbers = new int[ARRAY_SIZE];

    private int total = TOTAL;


    protected void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    protected boolean callCheck() {
        return total == TOTAL;
    }

    protected boolean isFull() {
        return total == ARRAY_SIZE - 1;
    }

    protected int peekaboo() {
        if (callCheck())
            return -1;
        return numbers[total];
    }

    protected int countOut() {
        if (callCheck())
            return -1;
        return numbers[total--];
    }

}
