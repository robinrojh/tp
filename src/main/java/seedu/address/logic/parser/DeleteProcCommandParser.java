package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteProcCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class DeleteProcCommandParser implements Parser<DeleteProcCommand> {

	/**
	 * Parses the given {@code String} of arguments in the context of the DeleteProcCommand
	 * and returns an EditCommand object for execution.
	 * @throws ParseException if the user input does not conform the expected format
	 */
	public DeleteProcCommand parse(String args) throws ParseException {
		requireNonNull(args);
		ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);
		List<Index> indexes = new ArrayList<>();

		try {
			indexes.addAll(ParserUtil.parseIndexes(argMultimap.getPreamble()));
		} catch (ParseException pe) {
			throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
					DeleteProcCommand.MESSAGE_USAGE), pe);
		}

		if (indexes.size() != 2) {
			throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
					DeleteProcCommand.MESSAGE_USAGE));
		}

		return new DeleteProcCommand(indexes.get(0), indexes.get(1));
	}
}
