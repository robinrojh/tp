package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showClientAtIndex;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.*;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.client.Client;
import seedu.address.testutil.ClientBuilder;
import seedu.address.testutil.EditClientDescriptorBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for EditCommand.
 */
public class DeleteProcCommandTest {

	private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
	//Will do up more in due time!
//	@Test
//	public void execute_procedureWasDeletedFromClient_success() {
//		Client editedClient = new ClientBuilder().build();
//		DeleteProcCommand deleteCommand = new DeleteProcCommand(INDEX_FIRST_CLIENT, INDEX_FIRST_PROCEDURE);
//
//		String expectedMessage = String.format(DeleteProcCommand.MESSAGE_EDIT_CLIENT_SUCCESS,
//				editedClient.getProcedures());
//
//		Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
//		expectedModel.setClient(model.getFilteredClientList().get(0), editedClient);
//
//		assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
//	}

}
