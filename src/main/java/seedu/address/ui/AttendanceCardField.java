package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class AttendanceCardField extends UiPart<Region> {

    private static final String FXML = "AttendanceListCardField.fxml";

    @FXML
    private Label fieldType;
    @FXML
    private Label value;

    /**
     * Creates a {@code PersonCardField} with the given field type and value to display.
     * Displays {@code "---"} if the value is empty or absent.
     *
     * @param fieldType The label describing the field (e.g. "Phone", "Address").
     * @param value The value to display.
     */
    public AttendanceCardField(String fieldType, String value) {
        super(FXML);
        this.fieldType.setText(fieldType + ":");
        this.value.setText(formatValue(fieldType, value));
        if (value.equals("-")) {
            applyMissingFieldStyle();
        }
}
