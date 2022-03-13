package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.client.Client;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

public class ListProcCommand extends Command {

    public static final String COMMAND_WORD = "listProc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists the procedures of a client in the index. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney";

    public static final String MESSAGE_SUCCESS = "New client added: %1$s";
    public static final String MESSAGE_DUPLICATE_CLIENT = "This client already exists in the address book";

    private final Client target;

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasClient(target)) {
            throw new CommandException(MESSAGE_DUPLICATE_CLIENT);
        }

        model.addClient(target);
        return new CommandResult(String.format(MESSAGE_SUCCESS, target));
    }

    /**
     * Creates an ListProcCommand to add the specified {@code Client}
     */
    public ListProcCommand(Client target) {
        requireNonNull(target);
        this.target = target;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListProcCommand // instanceof handles nulls
                && target.equals(((ListProcCommand) other).target));
    }
}
