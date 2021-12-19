package de.whs.fpr.staff.gui.controllers;

import de.whs.fpr.staff.personnel.Personnel;
import javafx.fxml.FXML;

/**
 * Main view controller.
 *
 * Responsible for handling the main view of the application.
 *
 * @author Frederik Bußmann
 */
public class MainViewController {
    /**
     * Initializes the main view.
     */
    @FXML
    protected void initialize() {
        Personnel personnel = new Personnel();
    }
}
