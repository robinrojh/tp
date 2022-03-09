//package seedu.address.ui;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.layout.HBox;
//
//import java.util.Comparator;
//
//public class ProcedureCard {
//
//    private static final String FXML = "PersonListCard.fxml";
//
//    /**
//     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
//     * As a consequence, UI elements' variable names cannot be set to such keywords
//     * or an exception will be thrown by JavaFX during runtime.
//     *
//     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
//     */
//
//    public final Procedure procedure;
//
//    @javafx.fxml.FXML
//    private HBox cardPane;
//
//    @FXML
//    private Label id;
//    @FXML
//    private Label information;
//
//    @FXML
//    private Label cost;
//
//    @FXML
//    private Label date;
//    /**
//     * Creates a {@code ProcedureCard} with the given {@code Procedure} and index to display.
//     */
//    public ProcedureCard(Procedure procedure, int displayedIndex) {
//        super(FXML);
//        this.procedure = procedure;
//        id.setText(displayedIndex + ". ");
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        // short circuit if same object
//        if (other == this) {
//            return true;
//        }
//
//        // instanceof handles nulls
//        if (!(other instanceof ProcedureCard)) {
//            return false;
//        }
//
//        // state check
//        ProcedureCard card = (ProcedureCard) other;
//        return id.getText().equals(card.id.getText())
//                && person.equals(card.person);
//    }
//}
