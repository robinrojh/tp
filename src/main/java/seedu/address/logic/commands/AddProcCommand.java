package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INFORMATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLIENTS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.client.Client;
import seedu.address.model.procedure.Procedure;

/**
 * Changes the remark of an existing person in the address book.
 */
public class AddProcCommand extends Command {

    public static final String COMMAND_WORD = "addProc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a Procedure to the identified Client "
            + "by the index number used in the displayed client list. \n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_INFORMATION + "INFORMATION "
            + PREFIX_COST + "COST "
            + PREFIX_DATE + "DATE \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_INFORMATION + "Install modem "
            + PREFIX_COST + "10.5 "
            + PREFIX_DATE + "20/03/2022 ";

    public static final String MESSAGE_SUCCESS = "New Procedure added: %1$s"; // Test needed
    public static final String MESSAGE_DUPLICATE_PROCEDURE = "This Procedure is already listed to the Client";

    private final Index index;
    private final Procedure procedure;

    /**
     * @param index of the Client in the filtered client list to add Procedure to
     * @param procedure Procedure to add to the Client
     */
    public AddProcCommand(Index index, Procedure procedure) {
        requireNonNull(index);
        requireNonNull(procedure);

        this.index = index;
        this.procedure = procedure;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Client> lastShownList = model.getFilteredClientList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX);
        }

        Client clientToAddProc = lastShownList.get(index.getZeroBased());
        model.addProcedure(clientToAddProc, procedure);

        if (model.hasProcedureInClient(procedure)) {
            throw new CommandException(MESSAGE_DUPLICATE_PROCEDURE);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, procedure));
    }
}
