package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.COST_DESC_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.INFO_DESC_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COST_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_REPAIR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_REPAIR;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_CLIENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PROCEDURE;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditProcCommand;
import seedu.address.logic.commands.EditProcCommand.EditProcedureDescriptor;
import seedu.address.testutil.EditProcedureDescriptorBuilder;

public class EditProcCommandParserTest {
    private static final String PREAMBLE = "%1$s %2$s";
    private static final String VALID_PREAMBLE = String.format(PREAMBLE, INDEX_FIRST_CLIENT.getZeroBased(),
            INDEX_FIRST_PROCEDURE.getZeroBased());

    private EditProcCommandParser parser = new EditProcCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        EditProcedureDescriptor editProcedureDescriptor = new EditProcedureDescriptorBuilder()
            .withInfo(VALID_INFO_REPAIR).withCost(VALID_COST_REPAIR).withDate(VALID_DATE_REPAIR).build();

        Index targetClient = INDEX_FIRST_CLIENT;
        Index targetIndex = INDEX_FIRST_PROCEDURE;

        String userInput = targetClient.getOneBased() + " " + targetIndex.getOneBased()
                + INFO_DESC_REPAIR + COST_DESC_REPAIR + DATE_DESC_REPAIR;
        assertParseSuccess(parser, userInput,
                new EditProcCommand(targetClient, targetIndex, editProcedureDescriptor));
    }

    @Test
    public void parse_compulsoryFieldFlagsMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditProcCommand.MESSAGE_USAGE);

        Index targetClient = INDEX_FIRST_CLIENT;
        Index targetIndex = INDEX_FIRST_PROCEDURE;

        // missing INFO prefix
        assertParseFailure(parser, VALID_PREAMBLE + VALID_INFO_REPAIR + DATE_DESC_REPAIR
                + COST_DESC_REPAIR, expectedMessage);

        // missing DATE prefix
        assertParseFailure(parser, VALID_PREAMBLE + INFO_DESC_REPAIR + VALID_DATE_REPAIR
                + COST_DESC_REPAIR, expectedMessage);

        // missing COST prefix
        assertParseFailure(parser, VALID_PREAMBLE + INFO_DESC_REPAIR + DATE_DESC_REPAIR
                + VALID_COST_REPAIR, expectedMessage);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditProcCommand.MESSAGE_USAGE);

        // Negative client index
        assertParseFailure(parser, String.format(PREAMBLE, -5, 1) + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);

        // Zero-ed client index
        assertParseFailure(parser, String.format(PREAMBLE, 0, 1) + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);

        // Invalid arguments being parsed in client index as preamble
        assertParseFailure(parser, String.format(PREAMBLE, "1 some Strings", 1) + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);

        // invalid prefix being parsed as preamble for client index
        assertParseFailure(parser, String.format(PREAMBLE, "1 n/notification", 1) + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);

        // Negative procedure index
        assertParseFailure(parser, String.format(PREAMBLE, 1, -1) + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);

        // Zero-ed procedure index
        assertParseFailure(parser, String.format(PREAMBLE, 1, 0) + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);

        // Invalid arguments being parsed in procedure index as preamble
        assertParseFailure(parser, String.format(PREAMBLE, 1, "1 some Strings") + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);

        // invalid prefix being parsed as preamble for procedure index
        assertParseFailure(parser, String.format(PREAMBLE, 1, "1 n/notification") + INFO_DESC_REPAIR
                + DATE_DESC_REPAIR + COST_DESC_REPAIR, expectedMessage);
    }

}

// @Test
// public void parse_invalidValue_failure() {
//  assertParseFailure(parser, VALID_PREAMBLE + INVALID_INFO_DESC,
//  Information.MESSAGE_CONSTRAINTS); // invalid name
//  assertParseFailure(parser, VALID_PREAMBLE + INVALID_COST_DESC, Cost.MESSAGE_CONSTRAINTS); // invalid cost
//  assertParseFailure(parser, VALID_PREAMBLE + INVALID_DATE_DESC, Date.MESSAGE_CONSTRAINTS); // invalid date
//  // Valid information followed by invalid cost
//  assertParseFailure(parser, VALID_PREAMBLE + INFO_DESC_REPAIR + INVALID_COST_DESC, Cost.MESSAGE_CONSTRAINTS);
//  // Valid cost followed by invalid date
//  assertParseFailure(parser, VALID_PREAMBLE + COST_DESC_REPAIR + INVALID_DATE_DESC, Date.MESSAGE_CONSTRAINTS);
//  // Invalid information followed by valid date
//  assertParseFailure(parser, VALID_PREAMBLE + INVALID_INFO_DESC + DATE_DESC_REPAIR, Information.MESSAGE_CONSTRAINTS);
// }
