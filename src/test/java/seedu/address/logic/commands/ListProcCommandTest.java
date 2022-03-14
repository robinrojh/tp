package seedu.address.logic.commands;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import seedu.address.logic.parser.ListProcCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showClientAtIndex;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_CLIENT;

public class ListProcCommandTest {
    private Model model;
    private Model expectedModel;
    private ListProcCommandParser parser;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }


    @Test
    public void execute_listIsNotFiltered_showsSameList() throws ParseException {
        ListProcCommand resultCommand = parser.parse("listProc 1");
        assertCommandSuccess(resultCommand, model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
