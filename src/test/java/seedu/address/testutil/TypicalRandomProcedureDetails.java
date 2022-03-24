package seedu.address.testutil;

import seedu.address.model.procedure.Completion;
import seedu.address.model.procedure.Cost;
import seedu.address.model.procedure.Date;
import seedu.address.model.procedure.Information;
import java.util.Random;

/**
 * This class holds typical details that can make up a Procedure. There are 3 respective details for
 * Information and Cost. Since this class was designed for the testing of the autosort feature, the Date field
 * has 3 additional separate components. They are sorted by time periods. For example, the first index contains 3 dates
 * that are earlier than the dates in the second index. This is true for the second index with respect to the third
 * index.
 */

public class TypicalRandomProcedureDetails {

    public static final Information[] EXAMPLE_INFORMATION = {
            new Information("Apple Inc."), new Information("Google Inc."), new Information("Singtel Inc.")
    };
    public static final Cost[] EXAMPLE_COST = {
            new Cost("10.00"), new Cost("23.23"), new Cost("76.10")
    };
    public static final Date[][] EXAMPLE_DATE_SEPARATED_BY_PERIOD = {
            {
                new Date("01/01/2011 10:00"), new Date("10/10/2015 13:45"), new Date("02/03/2013 09:00")
            },
            {
                new Date("25/12/2015 16:00"), new Date("01/02/2016 17:12"), new Date("03/11/2018 12:00")
            },
            {
                new Date("12/12/2018 09:00"), new Date("03/05/2021 11:10"), new Date("03/03/2022 11:01")
            }
    };

    public static Random rand = new Random();

    public TypicalRandomProcedureDetails() {

    }

    Information getInfo() {
        int randInt = rand.nextInt(3);
        return EXAMPLE_INFORMATION[randInt];
    }

    Cost getCost() {
        int randInt = rand.nextInt(3);
        return EXAMPLE_COST[randInt];
    }

    /**
     * In order to ensure that the autosort test works properly, a pre-sorted list of dates is required. Hence,
     * getDates() will select the dates randomly, but they are however selected by their time periods and ordered
     * respectively.
     *
     * @return Date array containing random dates for Procedure generation.
     */

    Date[] getDates() {
        Date earlyDate = EXAMPLE_DATE_SEPARATED_BY_PERIOD[0][rand.nextInt(3)];
        Date neutralDate = EXAMPLE_DATE_SEPARATED_BY_PERIOD[1][rand.nextInt(3)];
        Date futureDate = EXAMPLE_DATE_SEPARATED_BY_PERIOD[2][rand.nextInt(3)];
        Date dateArray[] = new Date[3];
        dateArray[0] = earlyDate;
        dateArray[1] = neutralDate;
        dateArray[2] = futureDate;
        return dateArray;
    }
}
