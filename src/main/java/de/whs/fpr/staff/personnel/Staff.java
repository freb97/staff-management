package de.whs.fpr.staff.personnel;

import java.util.Date;

/**
 * Staff.
 *
 * Represents a staff member in the company.
 *
 * @author Frederik Bußmann
 */
public abstract class Staff implements Comparable<Staff> {
    /**
     * Name of the staff member.
     */
    private String name;

    /**
     * Current salary of the staff member.
     */
    private Double salary;

    /**
     * Hiring date of the staff member.
     */
    private Date hiringDate;

    /**
     * ID of the staff member.
     */
    private int staffId;

    /**
     * Class constructor.
     *
     * @param name Name of the staff member.
     * @param salary Salary of the staff member.
     * @param hiringDate Hiring date of the staff member.
     * @param staffId ID of the staff member.
     */
    public Staff(String name, double salary, Date hiringDate, int staffId) {
        this.name = name;
        this.salary = salary;
        this.hiringDate = hiringDate;
        this.staffId = staffId;
    }

    /**
     * Gets the name of the staff member.
     *
     * @return The name of the staff member.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the staff member.
     *
     * @param name The name to set for the staff member.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the salary of the staff member.
     *
     * @return The salary of the staff member.
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the staff member.
     *
     * @param salary The salary to set for the staff member.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Gets the hiring date of the staff member.
     *
     * @return The hiring date of the staff member.
     */
    public Date getHiringDate() {
        return hiringDate;
    }

    /**
     * Sets the hiring date of the staff member.
     *
     * @param hiringDate The hiring date to set for the staff member.
     */
    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    /**
     * Gets the ID of the staff member.
     *
     * @return The ID of the staff member.
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * Sets the ID of the staff member.
     *
     * @param staffId The ID to set for the staff member.
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    /**
     * Increases the salary of the staff member by a given percentage.
     *
     * @param percent The percentage to increase the salary by.
     */
    public void increaseSalaryByPercent(final double percent) {
        salary = salary * (1 + (percent / 100));
    }

    /**
     * Gets a string representation of the staff member.
     *
     * @return The staff member as string.
     */
    public String toString() {
        return "Staff member " + this.getStaffId() + ":\n" +
                "Type: " + this.getClass().getSimpleName() + "\n" +
                "Name: " + this.getName() + "\n" +
                "Salary: " + this.getSalary() + "\n" +
                "Hiring date: " + this.getHiringDate() + "\n";
    }

    /**
     * Compares the staff member to another given staff member by staff id.
     *
     * @param otherStaff The staff member to compare to.
     */
    @Override
    public int compareTo(Staff otherStaff) {
        return Integer.compare(this.getStaffId(), otherStaff.getStaffId());
    }
}
