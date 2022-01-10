package de.whs.fpr.staff.gui.controllers;

import de.whs.fpr.staff.gui.dialogs.CreateStaffMemberDialog;
import de.whs.fpr.staff.gui.dialogs.DeleteStaffMemberDialog;
import de.whs.fpr.staff.personnel.Personnel;
import de.whs.fpr.staff.personnel.types.Manager;
import de.whs.fpr.staff.personnel.types.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.text.SimpleDateFormat;
import java.util.Optional;

/**
 * Main view controller.
 *
 * Responsible for handling the main view of the application.
 *
 * @author Frederik Bußmann
 */
public class MainViewController {
    /**
     * The staff list view instance.
     */
    @FXML
    protected ListView<String> staffListView;

    /**
     * The 'create new staff member' button.
     */
    @FXML
    protected Button createStaffButton;

    /**
     * The 'delete selected staff member' button.
     */
    @FXML
    protected Button deleteStaffButton;

    /**
     * The personnel data instance.
     */
    private final Personnel personnel;

    /**
     * Class constructor.
     */
    public MainViewController() {
        this.personnel = new Personnel();
    }

    /**
     * Initializes the main view.
     */
    @FXML
    protected void initialize() {
        staffListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        createStaffButton.setOnAction(event -> openCreateStaffMemberDialog());
        deleteStaffButton.setOnAction(event -> openDeleteStaffMemberDialog());
    }

    /**
     * Opens a create staff member dialog.
     */
    private void openCreateStaffMemberDialog() {
        CreateStaffMemberDialog dialog = new CreateStaffMemberDialog(personnel);

        Optional<Staff> result = dialog.showAndWait();

        result.ifPresent(staff -> {
            personnel.staff.add(staff);
            updateStaffListView();
        });
    }

    /**
     * Opens a delete staff member dialog.
     */
    private void openDeleteStaffMemberDialog() {
        int index = staffListView.getSelectionModel().getSelectedIndex();

        if (index < 0) return;

        Staff staff = personnel.staff.get(index);
        String name = staff.getName();

        DeleteStaffMemberDialog dialog = new DeleteStaffMemberDialog(name);

        dialog.showAndWait().ifPresent(response -> {
            if (response.getButtonData() == ButtonBar.ButtonData.YES) {
                personnel.removeStaff(staff);
                updateStaffListView();
            }
        });
    }

    /**
     * Updates the staff list view with the available personnel data.
     */
    private void updateStaffListView() {
        ObservableList<String> staffList = FXCollections.observableArrayList();

        personnel.sortStaffById();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        for (Staff staff : personnel.staff) {
            String staffType = staff.getClass().getSimpleName();
            String hiringDate = formatter.format(staff.getHiringDate());

            String output;

            if (staff.getClass() == Manager.class) {
                double bonus = ((Manager) staff).getBonus();

                output = String.format("[%s] Name: %s | Salary: %.2f€ | Hired on: %s | StaffId: %d | Bonus: %.2f€",
                        staffType,
                        staff.getName(),
                        staff.getSalary(),
                        hiringDate,
                        staff.getStaffId(),
                        bonus);
            } else {
                output = String.format("[%s] Name: %s | Salary: %.2f€ | Hired on: %s | StaffId: %d",
                        staffType,
                        staff.getName(),
                        staff.getSalary(),
                        hiringDate,
                        staff.getStaffId());
            }

            staffList.add(output);
        }

        staffListView.setItems(staffList);
    }
}
