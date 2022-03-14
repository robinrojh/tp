package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLIENTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.client.Address;
import seedu.address.model.client.Client;
import seedu.address.model.client.Email;
import seedu.address.model.client.Name;
import seedu.address.model.client.Phone;
import seedu.address.model.client.Plan;
import seedu.address.model.procedure.Procedure;
import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing client in the address book.
 */
public class DeleteProcCommand extends Command {

    public static final String COMMAND_WORD = "deleteProc";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Delete the Procedure under a Client"
            + "by the index numbers used in the displayed client list and the displayed procedure list. "
            + "Existing Procedures indicated (by the input value) will be deleted.\n"
            + "Parameters: INDEX (must be a positive integer and an existing Client) "
            + "INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1 2";

    public static final String MESSAGE_EDIT_CLIENT_SUCCESS = "Current Procedure List: %1$s";
    public static final String MESSAGE_NOT_DELETED = "At least two fields must be provided.";
    public static final String MESSAGE_NONEXISTING_CLIENT = "This client does not exist in the address book.";

    private final Index clientIndex;
    private final Index procedureIndex;

    /**
     * @param clientIndex of the client in the filtered client list to edit
     * @param procedureIndex of the procedure in the filtered procedure list to delete
     */
    public DeleteProcCommand(Index clientIndex, Index procedureIndex) {
        requireNonNull(clientIndex);
        requireNonNull(procedureIndex);

        this.clientIndex = clientIndex;
        this.procedureIndex = procedureIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Client> lastShownList = model.getFilteredClientList();

        if (clientIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX);
        }

        Client clientToEdit = lastShownList.get(clientIndex.getZeroBased());
        Client editedClient = null;

        try {
            editedClient = editClientProcedure(clientToEdit);
        } catch (CommandException err) {
            throw new CommandException(Messages.MESSAGE_INVALID_PROCEDURE_DISPLAYED_INDEX);
        }

        model.setClient(clientToEdit, editedClient);
        model.updateFilteredClientList(PREDICATE_SHOW_ALL_CLIENTS);
        //Might want to consider making it nicer by creating an editedClient.displayPrdeleteocedures().
        return new CommandResult(String.format(MESSAGE_EDIT_CLIENT_SUCCESS, editedClient.getProcedures()));
    }

    /**
     * Creates and returns a {@code Client} with the details of {@code clientToEdit}
     * edited with {@code editProcedureDescriptor}.
     */
    private Client editClientProcedure(Client clientToEdit) throws CommandException {
        assert clientToEdit != null;

        Name updatedName = clientToEdit.getName();
        Phone updatedPhone = clientToEdit.getPhone();
        Email updatedEmail = clientToEdit.getEmail();
        Plan updatedPlan = clientToEdit.getPlan();
        Address updatedAddress = clientToEdit.getAddress();
        Set<Tag> updatedTags = clientToEdit.getTags();
        List<Procedure> updatedProcedures = new ArrayList<>();
        try {
            updatedProcedures.addAll(deleteProcedure(clientToEdit.getProcedures()));
        } catch (CommandException err) {
            throw new CommandException(Messages.MESSAGE_INVALID_PROCEDURE_DISPLAYED_INDEX);
        }

        return new Client(updatedName, updatedPhone, updatedEmail, updatedAddress, updatedPlan,
                updatedTags, updatedProcedures);
    }

    private List<Procedure> deleteProcedure(List<Procedure> procedureList) throws CommandException {
        if (procedureIndex.getOneBased() > procedureList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PROCEDURE_DISPLAYED_INDEX);
        }

        List<Procedure> updatedProcedureList = new ArrayList<>();
        for (int i = 0; i < procedureList.size(); i++) {
            if (i == procedureIndex.getZeroBased()) {
                continue;
            }
            updatedProcedureList.add(procedureList.get(i));
        }
        return updatedProcedureList;
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteProcCommand)) {
            return false;
        }

        // state check
        DeleteProcCommand e = (DeleteProcCommand) other;
        return clientIndex.equals(e.clientIndex)
                && procedureIndex.equals(e.procedureIndex);
    }
}
