package seedu.address.model.procedure;

import org.junit.jupiter.api.Test;
import seedu.address.model.procedure.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

class DateTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Date(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new Date(invalidDate));
    }

    @Test
    public void isValidDate() {
        // null Date
        assertThrows(NullPointerException.class, () -> Date.isValidDate(null));

        // invalid Date
        assertFalse(Date.isValidDate("")); // empty string
        assertFalse(Date.isValidDate(" ")); // spaces only
        assertFalse(Date.isValidDate("29-01-2000")); // dashes instead of slashes
        assertFalse(Date.isValidDate("32/01/2000")); // invalid date in correct format
        assertFalse(Date.isValidDate("32/01/10000")); // date > 9999 years
        assertFalse(Date.isValidDate("29/02/2019")); // leap year in an invalid leap year


//         valid Date
        assertTrue(Date.isValidDate("29/01/2000")); // proper date in specified format
        assertTrue(Date.isValidDate("29/02/2020")); // leap year in a valid leap year
    }

}