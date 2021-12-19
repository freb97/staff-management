package de.whs.fpr.staff.personnel;

import de.whs.fpr.staff.personnel.types.Manager;
import de.whs.fpr.staff.personnel.types.Staff;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Personnel.
 *
 * Stores all personnel and provides helper functions.
 *
 * @author Frederik Bußmann
 */
public class Personnel {
    /**
     * The staff list.
     */
    public final ArrayList<Staff> staff;

    /**
     * Class constructor.
     */
    public Personnel() {
        this.staff = new ArrayList<>();
    }

    /**
     * Adds a new member to the staff list if it does not exist yet.
     *
     * @param newStaff The new staff member to add.
     */
    public void addStaff(Object newStaff) {
        for (Staff staffMember : staff) {
            if (newStaff.equals(staffMember)) {
                return;
            }
        }

        staff.add((Staff) newStaff);
    }

    /**
     * Gets a staff member from the staff list by id.
     *
     * @param staffId The id of the staff member to retrieve.
     *
     * @return The staff member or null if not exists.
     */
    public Staff getStaff(int staffId) {
        for (Staff staffMember : staff) {
            if (staffMember.getStaffId() == staffId) {
                return staffMember;
            }
        }

        return null;
    }

    /**
     * Sorts the staff list by salary (ascending).
     */
    public void sortStaffBySalary() {
        Comparator<Staff> staffComparator = Comparator.comparing(Staff::getSalary);

        staff.sort(staffComparator);
    }

    /**
     * Sorts the staff list by name (ascending).
     */
    public void sortStaffByName() {
        Comparator<Staff> staffComparator = Comparator.comparing(Staff::getName);

        staff.sort(staffComparator);
    }

    /**
     * Sorts the staff list by hiring date (ascending).
     */
    public void sortStaffByHiringDate() {
        Comparator<Staff> staffComparator = Comparator.comparing(Staff::getHiringDate);

        staff.sort(staffComparator);
    }

    /**
     * Gets the staff member with the lowest salary.
     *
     * @return The staff member.
     */
    public Staff getStaffWithHighestSalary() {
        sortStaffBySalary();

        return staff.get(staff.size() - 1);
    }

    /**
     * Gets the staff member with the highest salary.
     *
     * @return The staff member.
     */
    public Staff getStaffWithLowestSalary() {
        sortStaffBySalary();

        return staff.get(0);
    }

    /**
     * Gets the managers with the lowest and the highest bonus.
     *
     * @return The pair of managers.
     */
    public Pair<Manager, Manager> getLowestAndHighestBonusManagers() {
        ArrayList<Manager> managers = new ArrayList<>();

        staff.forEach(staff -> {
            if (staff.getClass() == Manager.class) {
                managers.add((Manager) staff);
            }
        });

        managers.sort(Comparator.comparing(Manager::getBonus));

        return new Pair<>(managers.get(0), managers.get(managers.size() - 1));
    }
}
