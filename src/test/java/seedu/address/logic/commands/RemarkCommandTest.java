package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RemarkCommand.
 */
public class RemarkCommandTest {

    private static final String REMARK_STUB = "Some remark";

    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_addRemarkUnfilteredList_success() {
        Person person = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(person).withRemark(REMARK_STUB).build();
        Remark editedRemark = new Remark(editedPerson.getRemark().value);
        RemarkCommand remarkCommand = new RemarkCommand(INDEX_FIRST_PERSON, editedRemark);

        String expectedMessage = String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, editedPerson);
        AddressBook ab = new AddressBook(model.getAddressBook());
        UserPrefs userPrefs = new UserPrefs();
        Model expectedModel = new ModelManager(ab, userPrefs);
        expectedModel.setPerson(person, editedPerson);

        assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_deleteRemarkUnfilteredList_success() {
        Person person = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(person).withRemark("").build();

        Remark emptyRemark = new Remark(editedPerson.getRemark().toString());
        RemarkCommand remarkCommand = new RemarkCommand(INDEX_FIRST_PERSON, emptyRemark);

        String expectedMessage = String.format(RemarkCommand.MESSAGE_DELETE_REMARK_SUCCESS, editedPerson);
        AddressBook ab = new AddressBook(model.getAddressBook());
        UserPrefs userPrefs = new UserPrefs();
        Model expectedModel = new ModelManager(ab, userPrefs);
        expectedModel.setPerson(person, editedPerson);

        assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }
}