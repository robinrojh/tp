package seedu.address.testutil;

import seedu.address.model.procedure.Procedure;

public class TypicalProcedures {
    public static final Procedure REPAIR = new ProcedureBuilder().withInfo("Repair Router")
            .withDate("01/01/2000").withCost("13.50").withCompletion("true")
            .build();
    public static final Procedure REPLACE = new ProcedureBuilder().withInfo("Replace wires")
            .withDate("05/03/2005").withCost("23.00").withCompletion("true")
            .build();
    public static final Procedure TROUBLESHOOT = new ProcedureBuilder().withInfo("Troubleshoot network")
            .withDate("10/05/2015").withCost("5.05").withCompletion("true")
            .build();
}
