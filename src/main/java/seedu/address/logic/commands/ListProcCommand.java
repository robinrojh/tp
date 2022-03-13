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
            + "Parameters: INDEX"
            + "Example: listProc 1";

    public static final String MESSAGE_SUCCESS = "Procedures successfully loaded.";

    private final Client target;

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.addClient(target);
        return new CommandResult(MESSAGE_SUCCESS);
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
