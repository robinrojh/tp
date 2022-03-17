package seedu.address.model.procedure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COST_REPLACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_REPLACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_REPLACE;
import static seedu.address.testutil.TypicalProcedures.REPAIR;
import static seedu.address.testutil.TypicalProcedures.REPLACE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ProcedureBuilder;

class ProcedureTest {
    @Test
    public void equals() {
        // same values -> returns true
        Procedure repairCopy = new ProcedureBuilder(REPAIR).build();
        assertTrue(REPAIR.equals(repairCopy));

        // same object -> returns true
        assertTrue(REPAIR.equals(REPAIR));

        // null -> returns false
        assertFalse(REPAIR.equals(null));

        // different type -> returns false
        assertFalse(REPAIR.equals(5));

        // different procedure -> returns false
        assertFalse(REPAIR.equals(REPLACE));


        // different information -> returns false
        Procedure editedRepair = new ProcedureBuilder(REPAIR).withInfo(VALID_INFO_REPLACE).build();
        assertFalse(REPAIR.equals(editedRepair));

        // different cost -> returns false
        editedRepair = new ProcedureBuilder(REPAIR).withCost(VALID_COST_REPLACE).build();
        assertFalse(REPAIR.equals(editedRepair));

        // different date -> returns false
        editedRepair = new ProcedureBuilder(REPAIR).withDate(VALID_DATE_REPLACE).build();
        assertFalse(REPAIR.equals(editedRepair));
    }

}
