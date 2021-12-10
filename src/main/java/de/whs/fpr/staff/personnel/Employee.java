package de.whs.fpr.staff.personnel;

import de.whs.fpr.staff.personnel.interfaces.HasProjects;
import de.whs.fpr.staff.personnel.interfaces.HasSupervisors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Employee.
 *
 * Represents a staff member of type employee in the company.
 *
 * @author Frederik Bußmann
 */
public class Employee extends Staff implements HasSupervisors<Staff>, HasProjects {
    /**
     * The list of supervisors for this staff member.
     */
    private final List<Staff> supervisors;

    /**
     * The list of projects for this staff member.
     */
    private final List<String> projects;

    /**
     * Class constructor.
     *
     * @param name Name of the manager.
     * @param salary Salary of the manager.
     * @param hiringDate Hiring date of the manager.
     * @param staffId Staff id of the manager.
     */
    public Employee(String name, double salary, Date hiringDate, int staffId) {
        super(name, salary, hiringDate, staffId);

        this.supervisors = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    /**
     * Gets the list of supervisors for this staff member.
     *
     * @return The list of supervisors.
     */
    @Override
    public List<Staff> getSupervisors() {
        return supervisors;
    }

    /**
     * Gets the list of projects for this staff member.
     *
     * @return The list of projects.
     */
    @Override
    public List<String> getProjects() {
        return projects;
    }

    /**
     * Checks if a given staff member is equal to this staff member.
     *
     * @return True if equal, false if not.
     */
    @Override
    public boolean equals(Object otherStaff) {
        if (this == otherStaff) return true;

        if (otherStaff == null || getClass() != otherStaff.getClass()) return false;

        Staff staff = (Staff) otherStaff;

        return Objects.equals(this.getName(), staff.getName()) &&
                Objects.equals(this.getSalary(), staff.getSalary()) &&
                Objects.equals(this.getHiringDate(), staff.getHiringDate()) &&
                this.getStaffId() == staff.getStaffId();
    }
}
