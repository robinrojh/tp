package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.DESC_REPLACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COST_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HASCOMPLETED_TRUE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_CLIENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_CLIENT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.client.Client;
import seedu.address.model.procedure.Procedure;
import seedu.address.testutil.ClientBuilder;
import seedu.address.testutil.ProcedureBuilder;
import seedu.address.testutil.RandomProcedureBuilder;



/**
 * Contains integration tests (interaction with the Model) and unit tests for AddProcCommand.
 */
public class EditProcCommandTest {
    private static final int EXPECTED_LENGTH_OF_LIST = 3;
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    // new Model without any Clients
    private Model newModel = new ModelManager();
    private Procedure toBeAddedProcedure = new ProcedureBuilder().build();
}
