package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_CLIENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PROCEDURE;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.client.Client;
import seedu.address.model.procedure.Procedure;
import seedu.address.testutil.ClientBuilder;
import seedu.address.testutil.ProcedureBuilder;

import java.util.ArrayList;


/**
 * Contains integration tests (interaction with the Model) and unit tests for EditCommand.
 */
public class DeleteProcCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_procedureDeletedFromExistingClient_success() {

        Procedure validProcedure = new ProcedureBuilder().build();
        ArrayList<Procedure> validProcedureList = new ArrayList<>();
        validProcedureList.add(validProcedure);

        Client validClient = new ClientBuilder().withProcedures(validProcedureList).build();
        //Client clientToDeleteProc = model.getFilteredClientList().get(0);
        DeleteProcCommand deleteProcCommand = new DeleteProcCommand(INDEX_FIRST_CLIENT, INDEX_FIRST_PROCEDURE);

        String expectedMessage = String.format(DeleteProcCommand
                .MESSAGE_DELETE_PROCEDURE_SUCCESS, validProcedure);

        ModelManager expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());

        assertCommandSuccess(deleteProcCommand, model, expectedMessage, expectedModel);
    }
}
