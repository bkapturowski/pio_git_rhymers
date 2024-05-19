package edu.kis.vh.nursery;

public class FifoRhymer extends DefaultCountingOutRhymer {

    private DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    @Override
    protected int countOut() {
        while (!callCheck())

            temp.countIn(super.countOut());

        final int ret = temp.countOut();

        while (!temp.callCheck())

            countIn(temp.countOut());

        return ret;
    }
}
