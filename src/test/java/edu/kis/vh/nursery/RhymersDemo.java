package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

class RhymersDemo {

    private static final int RHYMERS_COUNT = 15;
    private static final int RHYMERS_LAST_INDEX = 3;
    private static final int MAX_RANGE = 20;

    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();


        testRhymers(factory);

    }

    private static void testRhymers(Rhymersfactory factory) {
        DefaultCountingOutRhymer[] rhymers = {factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};

        for (int i = 1; i < RHYMERS_COUNT; i++)
            for (int j = 0; j < RHYMERS_LAST_INDEX; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < RHYMERS_COUNT; i++)
            rhymers[RHYMERS_LAST_INDEX].countIn(rn.nextInt(MAX_RANGE));

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[RHYMERS_LAST_INDEX]).reportRejected());
    }

}