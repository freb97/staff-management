package de.whs.fpr.staff.sorting;

import de.whs.fpr.staff.personnel.types.Employee;
import de.whs.fpr.staff.personnel.types.Manager;
import de.whs.fpr.staff.personnel.types.Staff;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * List sorter test.
 *
 * Tests the list sorter class.
 *
 * @author Frederik Bußmann
 */
public class ListSorterTest {
    /**
     * Tests the sort method with a list of strings.
     */
    @Test
    public void testSortListOfStrings() {
        List<String> list = new ArrayList<>();

        list.add("def");
        list.add("mno");
        list.add("ghi");
        list.add("abc");
        list.add("jkl");

        // Test ascending order
        ListSorter.sort(list);
        assertEquals("abc", list.get(0));
        assertEquals("mno", list.get(list.size() - 1));

        // Test descending order
        ListSorter.sort(list, true);
        assertEquals("mno", list.get(0));
        assertEquals("abc", list.get(list.size() - 1));
    }

    /**
     * Tests the sort method with a list of integers.
     */
    @Test
    public void testSortListOfIntegers() {
        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);

        // Test ascending order
        ListSorter.sort(list);
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(list.size() - 1));

        // Test descending order
        ListSorter.sort(list, true);
        assertEquals(5, list.get(0));
        assertEquals(1, list.get(list.size() - 1));
    }

    /**
     * Tests the sort method with a list of integers.
     */
    @Test
    public void testSortListOfStaff() {
        List<Staff> list = new ArrayList<>();

        Date date1 = Date.from(LocalDate.of(2021 , 11 , 18)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date date2 = Date.from(LocalDate.of(2021 , 11 , 22)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date date3 = Date.from(LocalDate.of(2021 , 11 , 25)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Employee chris = new Employee("Chris", 1250, date1, 20);
        Manager dominik = new Manager("Dominik", 2700, date1, 3, 400);
        Manager fred = new Manager("Fred", 3000, date2, 96, 800);
        Manager manuel = new Manager("Manuel", 2500, date2, 5, 600);
        Employee leonhard = new Employee("Leonhard", 2000, date3, 12);
        Employee linda = new Employee("Linda", 1500, date3, 1);

        list.add(chris);
        list.add(dominik);
        list.add(fred);
        list.add(manuel);
        list.add(leonhard);
        list.add(linda);

        // Test ascending order
        ListSorter.sort(list);
        assertEquals(linda, list.get(0));
        assertEquals(fred, list.get(list.size() - 1));

        // Test descending order
        ListSorter.sort(list, true);
        assertEquals(fred, list.get(0));
        assertEquals(linda, list.get(list.size() - 1));
    }
}
