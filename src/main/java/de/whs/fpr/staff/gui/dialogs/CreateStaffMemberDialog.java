package de.whs.fpr.staff.gui.dialogs;

import de.whs.fpr.staff.gui.MainApplication;
import de.whs.fpr.staff.personnel.Personnel;
import de.whs.fpr.staff.personnel.types.Employee;
import de.whs.fpr.staff.personnel.types.Manager;
import de.whs.fpr.staff.personnel.types.Staff;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.time.LocalDate;
import java.sql.Date;

/**
 * Create staff member dialog.
 *
 * A modal to create a staff member.
 *
 * @author Frederik Bußmann
 */
public class CreateStaffMemberDialog extends Dialog<Staff> {
    /**
     * Personnel instance.
     */
    private final Personnel personnel;

    /**
     * Staff name input.
     */
    private TextField name;

    /**
     * Staff salary input.
     */
    private TextField salary;

    /**
     * Staff hiring date input.
     */
    private DatePicker hiringDate;

    /**
     * Staff manager status input.
     */
    private CheckBox isManager;

    /**
     * Staff bonus input.
     */
    private TextField bonus;

    /**
     * Class constructor.
     *
     * @param personnel The personnel instance.
     */
    public CreateStaffMemberDialog(Personnel personnel) {
        super();

        this.personnel = personnel;

        prepareDialog();
        prepareForm();
    }

    /**
     * Prepares the dialog window.
     */
    private void prepareDialog() {
        setTitle("Create staff member");

        setResizable(true);

        initOwner(MainApplication.stage);
        initStyle(StageStyle.UNIFIED);
        initModality(Modality.WINDOW_MODAL);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(1.3);
        dropShadow.setOffsetY(1.3);
        dropShadow.setColor(Color.DARKGRAY);
        getDialogPane().setEffect(dropShadow);

        ButtonType createButtonType = new ButtonType("Create staff member", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                String staffName = name.getText();
                double staffSalary = Double.parseDouble(salary.getText());
                Date staffHiringDate = Date.valueOf(hiringDate.getValue());
                int staffId = 0;
                boolean staffIsManager = isManager.isSelected();

                if (staffName.isEmpty() || salary.getText().isEmpty()) {
                    return null;
                }

                personnel.sortStaffById();

                for (int i = 0; i < personnel.staff.size(); i++) {
                    if (personnel.staff.get(i).getStaffId() > i + 1) {
                        staffId = i + 1;
                    }
                }

                if (staffId == 0) {
                    staffId = personnel.staff.size() + 1;
                }

                if (personnel.staff.size() == 0) {
                    staffId = 1;
                }

                if (!staffIsManager) {
                    return new Employee(staffName, staffSalary, staffHiringDate, staffId);
                }
                else {
                    double staffBonus = Double.parseDouble(bonus.getText());
                    return new Manager(staffName, staffSalary, staffHiringDate, staffId, staffBonus);
                }
            }

            return null;
        });
    }

    /**
     * Prepares the staff creation form.
     */
    private void prepareForm() {
        GridPane grid = new GridPane();

        name = new TextField();
        name.setPromptText("Name");

        salary = new TextField();
        salary.setPromptText("Salary");

        hiringDate = new DatePicker(LocalDate.now());

        Label bonusLabel = new Label("Bonus:");
        bonus = new TextField();

        isManager = new CheckBox();
        isManager.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                grid.add(bonusLabel, 0, 3);
                grid.add(bonus, 1, 3);
            } else {
                grid.getChildren().remove(bonusLabel);
                grid.getChildren().remove(bonus);
            }
        });

        grid.add(new Label("Manager:"), 2, 0);
        grid.add(isManager, 3, 0);

        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);

        grid.add(new Label("Salary:"), 0, 1);
        grid.add(salary, 1, 1);

        grid.add(new Label("Hiring date:"), 0, 2);
        grid.add(hiringDate, 1, 2);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        getDialogPane().setContent(grid);
    }
}
