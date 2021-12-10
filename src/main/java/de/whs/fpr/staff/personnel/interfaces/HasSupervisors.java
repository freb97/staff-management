package de.whs.fpr.staff.personnel.interfaces;

import java.util.List;

/**
 * Has supervisors interface.
 *
 * The has supervisor trait for the staff class.
 *
 * @param <T> The employee type to set as a supervisor.
 *
 * @author Frederik Bußmann
 */
public interface HasSupervisors<T> {
    /**
     * Gets the list of supervisors for this employee.
     *
     * @return The list of supervisors.
     */
    List<T> getSupervisors();

    /**
     * Adds a staff member as a supervisor for this employee.
     *
     * @param supervisor The staff to set as a supervisor.
     */
    default void addSupervisor(T supervisor) {
        getSupervisors().add(supervisor);
    }

    /**
     * Removes a staff member as a supervisor for this employee.
     *
     * @param supervisor The staff to remove as a supervisor.
     */
    default void removeSupervisor(T supervisor) {
        getSupervisors().remove(supervisor);
    }
}