package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class TutInfoField extends UiPart<Region> {

    private static final String FXML = "TutInfoField.fxml";

    @FXML
    private Label courseName;
    @FXML
    private Label tutName;

    /**
     * Creates a {@code TutInfoField} with the given course name and tut name to display.
     *
     * @param courseName The label describing the field (e.g. "Phone", "Address").
     * @param tutName The value to display.
     */
    public TutInfoField(String courseName, String tutName) {
        super(FXML);
        this.courseName.setText(courseName);
        this.tutName.setText(tutName);
    }
}
