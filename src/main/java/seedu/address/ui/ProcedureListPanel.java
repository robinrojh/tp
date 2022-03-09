//package seedu.address.ui;
//
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.scene.layout.Region;
//import seedu.address.commons.core.LogsCenter;
//import seedu.address.model.person.Person;
//
//import java.util.logging.Logger;
//
//public class ProcedureListPanel extends UiPart<Region> {
//    private static final String FXML = "ProcedureListPanel.fxml";
//    private final Logger logger = LogsCenter.getLogger(ProcedureListPanel.class);
//
//    @javafx.fxml.FXML
//    private ListView<Procedure> procedureListView;
//
//    /**
//     * Creates a {@code ProcedureListPanel} with the given {@code ObservableList}.
//     */
//    public ProcedureListPanel(ObservableList<Procedure> procedureList) {
//        super(FXML);
//        procedureListView.setItems(procedureList);
//        procedureListView.setCellFactory(listView -> new ProcedureListPanel.ProcedureListViewCell());
//    }
//
//    /**
//     * Custom {@code ListCell} that displays the graphics of a {@code Procedure} using a {@code ProcedureCard}.
//     */
//    class ProcedureListViewCell extends ListCell<Person> {
//        @Override
//        protected void updateItem(Person person, boolean empty) {
//            super.updateItem(person, empty);
//
//            if (empty || person == null) {
//                setGraphic(null);
//                setText(null);
//            } else {
//                setGraphic(new PersonCard(person, getIndex() + 1).getRoot());
//            }
//        }
//    }
//}
