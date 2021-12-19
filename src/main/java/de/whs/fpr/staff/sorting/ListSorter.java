package de.whs.fpr.staff.sorting;

import java.util.List;

/**
 * List sorter.
 *
 * Sorts a given list of any type, given it implements the comparable interface.
 *
 * @author Frederik Bußmann
 */
public final class ListSorter {
    /**
     * Sorts a given list.
     *
     * @param list The list to sort.
     *
     * @param <T> The generic type to compare in the list.
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, false);
    }

    /**
     * Sorts a given list.
     *
     * @param list The list to sort.
     * @param descending If the list should be sorted in descending order.
     *
     * @param <T> The generic type to compare in the list.
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list, boolean descending) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int comparator = list.get(i).compareTo(list.get(j));

                if (!descending && comparator > 0 || descending && comparator < 0) {
                    T entry = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, entry);
                }
            }
        }
    }
}
