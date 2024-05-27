package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FifoRhymerJUnitTest {
    @Test
    public void testCountOutEmpty() {
        FifoRhymer fifoRhymer = new FifoRhymer();
        int result = fifoRhymer.countOut();
        Assert.assertEquals(DefaultCountingOutRhymer.TOTAL, result);
    }

    @Test
    public void testCountOutWithOneElement() {
        FifoRhymer fifoRhymer = new FifoRhymer();

        fifoRhymer.countIn(5);
        int result = fifoRhymer.countOut();
        Assert.assertEquals(5, result);
        Assert.assertEquals(DefaultCountingOutRhymer.TOTAL, fifoRhymer.countOut());
    }

    @Test
    public void testCountOutWithMultipleElements() {
        FifoRhymer fifoRhymer = new FifoRhymer();

        fifoRhymer.countIn(1);
        fifoRhymer.countIn(2);
        fifoRhymer.countIn(3);

        int result1 = fifoRhymer.countOut();
        int result2 = fifoRhymer.countOut();
        int result3 = fifoRhymer.countOut();

        Assert.assertEquals(1, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(3, result3);
    }
}
