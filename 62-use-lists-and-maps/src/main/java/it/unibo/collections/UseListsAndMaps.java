package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        final int first = 0;
        final int start = 1000;
        final int end = 2000;
        final int ELEM_5 = 100000;
        final int ELEM_6 = 1000;

        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> newArList = new ArrayList<>();

        for (int i = start; i < end; i++) {
            newArList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> newLiList = new LinkedList<>(newArList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer temp = newArList.get(first);
        newArList.set(first, newArList.get(start));
        newArList.set(start, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer elem : newArList) {
            System.out.print("" + elem + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        newArList.clear();
        long timeArList = System.nanoTime();

        for (int i = 0; i < ELEM_5; i++) {
            newArList.add(i);
        }

        timeArList = System.nanoTime() - timeArList;
        var millisArList = TimeUnit.NANOSECONDS.toMillis(timeArList);

        newLiList.clear();
        long timeLiList = System.nanoTime();

        for (int i = 0; i < ELEM_5; i++) {
            newLiList.add(i);
        }

        timeLiList = System.nanoTime() - timeLiList;
        var millisLiList = TimeUnit.NANOSECONDS.toMillis(timeLiList);

        System.out.println(
            "Time for inserting 100.000 element in: " +
            "[ArrayList: "+millisArList+"ms]" + " [LinkedList: "+millisLiList+"ms]"
            );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        temp = ELEM_5 / 2;
        int readValue;

        timeArList = System.nanoTime();

        for (int i = temp; i < (temp + ELEM_6); i++) {
            readValue = newArList.get(i);
        } 

        timeArList = System.nanoTime() - timeArList;
        var millisArList2 = TimeUnit.NANOSECONDS.toMillis(timeArList);

        timeLiList = System.nanoTime();

        for (int i = temp; i < (temp + ELEM_6); i++) {
            readValue = newLiList.get(i);
        }

        timeLiList = System.nanoTime() - timeLiList;
        var millisLiList2 = TimeUnit.NANOSECONDS.toMillis(timeLiList);

        System.out.println(
            "Time for reading 1000 element in: " +
            "[ArrayList: "+millisArList2+"ms]" + " [LinkedList: "+millisLiList2+"ms]"
            );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> newMap = new HashMap<>();
        newMap.put("Africa", 1110635000L);
        newMap.put("Americas", 972005000L);
        newMap.put("Antartica", 0L);
        newMap.put("Asia", 4298723000L);
        newMap.put("Europe", 742452000L);
        newMap.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        long population = 0L;
        Collection<Long> mapValues = newMap.values();

        for (Long elem : mapValues) {
            population = population + elem;
        }

        System.out.println("The World Population is: " + population);
    }
}
