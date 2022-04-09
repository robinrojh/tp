//package seedu.address.logic.parser;
//
//import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
//import static seedu.address.logic.commands.CommandTestUtil.COST_DESC_REPAIR;
//import static seedu.address.logic.commands.CommandTestUtil.COST_DESC_REPLACE;
//import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_REPAIR;
//import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_REPLACE;
//import static seedu.address.logic.commands.CommandTestUtil.INFO_DESC_REPAIR;
//import static seedu.address.logic.commands.CommandTestUtil.INFO_DESC_REPLACE;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_COST_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_DATE_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_INFO_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_COST_REPAIR;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_REPAIR;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_REPAIR;
//import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
//import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
//import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_CLIENT;
//
//import org.junit.jupiter.api.Test;
//
//import seedu.address.commons.core.index.Index;
//import seedu.address.logic.commands.AddProcCommand;
//import seedu.address.logic.commands.DeleteProcCommand;
//import seedu.address.logic.commands.EditProcCommand;
//import seedu.address.model.procedure.Cost;
//import seedu.address.model.procedure.Date;
//import seedu.address.model.procedure.Information;
//import seedu.address.model.procedure.Procedure;
//import seedu.address.testutil.ProcedureBuilder;
//
//public class DeleteProcCommandParserTest {
//    private static final String PREAMBLE = "%1$s %2$s";
//    private static final String MESSAGE_INVALID_FORMAT =
//        String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteProcCommand.MESSAGE_USAGE);
//
//    private DeleteProcCommandParser parser = new DeleteProcCommandParser();
//}
