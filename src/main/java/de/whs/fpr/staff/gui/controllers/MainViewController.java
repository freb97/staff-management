package de.whs.fpr.staff.gui.controllers;

import de.whs.fpr.staff.personnel.Employee;
import de.whs.fpr.staff.personnel.Manager;
import de.whs.fpr.staff.personnel.Staff;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Main view controller.
 *
 * Responsible for handling the main view of the application.
 *
 * @author Frederik Bußmann
 */
public class MainViewController {
    /**
     * The staff list.
     */
    private ArrayList<Staff> staff;

    /**
     * Initializes the main view.
     */
    @FXML
    protected void initialize() {
        staff = new ArrayList<>();

        Date date1 = Date.from(
                LocalDate.of(2021 , 11 , 25)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());

        Date date2 = Date.from(
                LocalDate.of(2021 , 11 , 22)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());

        Date date3 = Date.from(
                LocalDate.of(2021 , 11 , 20)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());

        addStaff(new Employee("Chris", 1250, date1, 20));
        addStaff(new Employee("Fred", 1000, date2, 5));
        addStaff(new Manager("Dominik", 1500, date3, 3, 200));
        addStaff(new Manager("Dominik", 1500, date3, 3, 200));

        Collections.sort(staff);

        System.out.println(staff);

        System.out.println(getStaffWithLowestSalary());
        System.out.println(getStaffWithHighestSalary());
    }

    /**
     * Sorts the staff list by salary (ascending).
     */
    private void sortStaffBySalary() {
        Comparator<Staff> staffComparator = Comparator.comparing(Staff::getSalary);

        staff.sort(staffComparator);
    }

    /**
     * Sorts the staff list by name (ascending).
     */
    private void sortStaffByName() {
        Comparator<Staff> staffComparator = Comparator.comparing(Staff::getName);

        staff.sort(staffComparator);
    }

    /**
     * Sorts the staff list by hiring date (ascending).
     */
    private void sortStaffByHiringDate() {
        Comparator<Staff> staffComparator = Comparator.comparing(Staff::getHiringDate);

        staff.sort(staffComparator);
    }

    /**
     * Adds a new member to the staff list if it does not exist yet.
     */
    private void addStaff(Object newStaff) {
        for (Staff staffMember : staff) {
            if (newStaff.equals(staffMember)) {
                return;
            }
        }

        staff.add((Staff) newStaff);
    }

    /**
     * Gets the staff member with the lowest salary.
     *
     * @return The staff member.
     */
    private Staff getStaffWithHighestSalary() {
        sortStaffBySalary();

        return staff.get(staff.size() - 1);
    }

    /**
     * Gets the staff member with the highest salary.
     *
     * @return The staff member.
     */
    private Staff getStaffWithLowestSalary() {
        sortStaffBySalary();

        return staff.get(0);
    }
}
