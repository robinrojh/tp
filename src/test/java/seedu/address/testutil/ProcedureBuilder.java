package seedu.address.testutil;

import seedu.address.model.procedure.Cost;
import seedu.address.model.procedure.Date;
import seedu.address.model.procedure.Information;
import seedu.address.model.procedure.Procedure;

/**
 * A utility class to help with building Procedure objects.
 */
public class ProcedureBuilder {

    public static final String DEFAULT_INFO = "Fix Router";
    public static final String DEFAULT_DATE = "01/01/2000";
    public static final String DEFAULT_COST = "13.50";

    private Information info;
    private Date date;
    private Cost cost;

    /**
     * Creates a {@code ProcedureBuilder} with the default details.
     */
    public ProcedureBuilder() {
        info = new Information(DEFAULT_INFO);
        date = new Date(DEFAULT_DATE);
        cost = new Cost(DEFAULT_COST);
    }

    /**
     * Initializes the ProcedureBuilder with the data of {@code ProcedureToCopy}.
     */
    public ProcedureBuilder(Procedure procedureToCopy) {
        info = procedureToCopy.getInfo();
        date = procedureToCopy.getDate();
        cost = procedureToCopy.getCost();
    }

    /**
     * Sets the {@code Info} of the {@code Procedure} that we are building.
     */
    public seedu.address.testutil.ProcedureBuilder withInfo(String info) {
        this.info = new Information(info);
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Procedure} that we are building.
     */
    public seedu.address.testutil.ProcedureBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    /**
     * Sets the {@code Cost} of the {@code Procedure} that we are building.
     */
    public seedu.address.testutil.ProcedureBuilder withCost(String cost) {
        this.cost = new Cost(cost);
        return this;
    }

    public Procedure build() {
        return new Procedure(info, date, cost);
    }
}
