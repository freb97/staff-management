package de.whs.fpr.staff.gui.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/**
 * Delete staff member dialog.
 *
 * Dialog to confirm staff member deletion.
 *
 * @author Frederik Bußmann
 */
public class DeleteStaffMemberDialog extends Alert {
    /**
     * Class constructor.
     */
    public DeleteStaffMemberDialog(String name) {
        super(AlertType.CONFIRMATION);

        setTitle("Delete staff member");
        setContentText("Do you really want to delete staff member \"" + name + "\"?");

        ButtonType cancelButton = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType confirmButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);

        getButtonTypes().setAll(cancelButton, confirmButton);
    }
}
