package seedu.address.logic.commands;

import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;


/**
 * Contains integration tests (interaction with the Model) and unit tests for EditCommand.
 */
public class DeleteProcCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    //Will do up more in due time!
    //@Test
    //public void execute_procedureWasDeletedFromClient_success() {
    //Client editedClient = new ClientBuilder().build();
    //DeleteProcCommand deleteCommand = new DeleteProcCommand(INDEX_FIRST_CLIENT, INDEX_FIRST_PROCEDURE);

    //String expectedMessage = String.format(DeleteProcCommand.MESSAGE_EDIT_CLIENT_SUCCESS,
    // editedClient.getProcedures());
    //Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
    //expectedModel.setClient(model.getFilteredClientList().get(0), editedClient);

    //assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    //}
}
