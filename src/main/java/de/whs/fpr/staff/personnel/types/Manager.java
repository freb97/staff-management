package de.whs.fpr.staff.personnel.types;

import de.whs.fpr.staff.personnel.interfaces.HasProjects;
import de.whs.fpr.staff.personnel.interfaces.HasSupervisors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Manager.
 *
 * Represents a staff member of type manager in the company.
 *
 * @author Frederik Bußmann
 */
public class Manager extends Staff implements HasSupervisors<Staff>, HasProjects {
    /**
     * The list of supervisors for this staff member.
     */
    private final List<Staff> supervisors;

    /**
     * The list of projects for this staff member.
     */
    private final List<String> projects;

    /**
     * Bonus of the manager staff member.
     */
    private double bonus;

    /**
     * Class constructor.
     *
     * @param name Name of the manager.
     * @param salary Salary of the manager.
     * @param hiringDate Hiring date of the manager.
     * @param staffId Staff id of the manager.
     */
    public Manager(String name, double salary, Date hiringDate, int staffId) {
        super(name, salary, hiringDate, staffId);

        this.supervisors = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    /**
     * Class constructor.
     *
     * @param name Name of the manager.
     * @param salary Salary of the manager.
     * @param hiringDate Hiring date of the manager.
     * @param staffId Staff id of the manager.
     * @param bonus Bonus salary of the manager.
     */
    public Manager(String name, double salary, Date hiringDate, int staffId, double bonus) {
        this(name, salary, hiringDate, staffId);

        this.bonus = bonus;
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
     * Gets the bonus of the manager.
     *
     * @return The bonus of the manager.
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Sets the bonus of the manager.
     *
     * @param bonus The bonus to set for the manager.
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * Gets a string representation of the staff member.
     *
     * @return The staff member as string.
     */
    public String toString() {
        return super.toString() +
                "Bonus: " + this.getBonus() + "\n";
    }

    /**
     * Checks if a given staff member is equal to this staff member.
     *
     * @return True if equal, false if not.
     */
    public boolean equals(Object otherStaff) {
        if (this == otherStaff) return true;

        if (otherStaff == null || getClass() != otherStaff.getClass()) return false;

        Manager staff = (Manager) otherStaff;

        return Objects.equals(this.getName(), staff.getName()) &&
                Objects.equals(this.getSalary(), staff.getSalary()) &&
                Objects.equals(this.getHiringDate(), staff.getHiringDate()) &&
                this.getStaffId() == staff.getStaffId() &&
                this.getBonus() == staff.getBonus();
    }
}
