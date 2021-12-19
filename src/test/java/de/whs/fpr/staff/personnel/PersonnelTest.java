package de.whs.fpr.staff.personnel;

import de.whs.fpr.staff.personnel.types.Employee;
import de.whs.fpr.staff.personnel.types.Manager;
import de.whs.fpr.staff.personnel.types.Staff;
import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Personnel test.
 *
 * Tests the personnel class.
 *
 * @author Frederik Bußmann
 */
public class PersonnelTest {
    /**
     * The personnel instance to test.
     */
    private Personnel personnel;

    /**
     * Sets up the test cases.
     */
    @BeforeEach
    public void setUp() {
        personnel = new Personnel();

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

        personnel.addStaff(chris);
        personnel.addStaff(dominik);
        personnel.addStaff(fred);
        personnel.addStaff(manuel);
        personnel.addStaff(leonhard);
        personnel.addStaff(linda);
    }

    /**
     * Tests the sort staff by salary method.
     */
    @Test
    public void testSortStaffBySalary() {
        personnel.sortStaffBySalary();

        assertEquals(1250, personnel.staff.get(0).getSalary());
        assertEquals(3000, personnel.staff.get(personnel.staff.size() - 1).getSalary());
    }

    /**
     * Tests the sort staff by name method.
     */
    @Test
    public void testSortStaffByName() {
        personnel.sortStaffByName();

        assertEquals("Chris", personnel.staff.get(0).getName());
        assertEquals("Manuel", personnel.staff.get(personnel.staff.size() - 1).getName());
    }

    /**
     * Tests the sort staff by hiring date method.
     */
    @Test
    public void testSortStaffByHiringDate() {
        personnel.sortStaffByHiringDate();

        Date date1 = Date.from(LocalDate.of(2021 , 11 , 18)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date date2 = Date.from(LocalDate.of(2021 , 11 , 25)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertEquals(date1, personnel.staff.get(0).getHiringDate());
        assertEquals(date2, personnel.staff.get(personnel.staff.size() - 1).getHiringDate());
    }

    /**
     * Tests the get staff with the lowest salary and get staff with the highest salary methods.
     */
    @Test
    public void testGetStaffWithLowestAndHighestSalary() {
        Staff lowestSalary = personnel.getStaffWithLowestSalary();
        Staff highestSalary = personnel.getStaffWithHighestSalary();

        Date date1 = Date.from(LocalDate.of(2021 , 11 , 18)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date date2 = Date.from(LocalDate.of(2021 , 11 , 22)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Employee chris = new Employee("Chris", 1250, date1, 20);
        Manager fred = new Manager("Fred", 3000, date2, 96, 800);

        assertEquals(chris, lowestSalary);
        assertEquals(fred, highestSalary);
    }

    /**
     * Tests the get lowest and highest bonus managers method.
     */
    @Test
    public void testGetLowestAndHighestBonusManagers() {
        Date date1 = Date.from(LocalDate.of(2021 , 11 , 18)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date date2 = Date.from(LocalDate.of(2021 , 11 , 22)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        Manager dominik = new Manager("Dominik", 2700, date1, 3, 400);
        Manager fred = new Manager("Fred", 3000, date2, 96, 800);

        Pair<Manager, Manager> managerPair = new Pair<>(dominik, fred);

        assertEquals(managerPair, personnel.getLowestAndHighestBonusManagers());
    }
}