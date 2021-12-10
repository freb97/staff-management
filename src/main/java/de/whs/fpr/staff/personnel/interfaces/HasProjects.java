package de.whs.fpr.staff.personnel.interfaces;

import java.util.List;

/**
 * Has projects interface.
 *
 * The has projects trait for employees.
 *
 * @author Frederik Bußmann
 */
public interface HasProjects {
    /**
     * Gets the list of projects for this employee.
     *
     * @return The list of projects.
     */
    List<String> getProjects();

    /**
     * Adds a project for this employee.
     *
     * @param project The project to add.
     */
    default void addProject(String project) {
        getProjects().add(project);
    }

    /**
     * Removes a project from an employee.
     *
     * @param project The project to remove.
     */
    default void removeProject(String project) {
        getProjects().remove(project);
    }
}
