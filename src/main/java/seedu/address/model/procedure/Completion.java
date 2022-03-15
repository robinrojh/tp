package seedu.address.model.procedure;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Completion {
    public static final String MESSAGE_CONSTRAINTS = "1. Completion should be a Boolean value, "
        + "Boolean.TRUE or Boolean.FALSE";

    public static final String VALIDATION_REGEX = "^([Tt][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee])$";
    public final Boolean hasCompleted;

    /**
     * Constructs a {@code Completion}.
     *
     * @param hasCompleted A valid Boolean value indicating hasCompleted of Procedure.
     */
    public Completion(String hasCompleted) {
        requireNonNull(hasCompleted);
        checkArgument(isValidCompletion(hasCompleted), MESSAGE_CONSTRAINTS);
        this.hasCompleted = Boolean.getBoolean(hasCompleted);
    }

    /**
     * Returns true if a given string is a valid boolean.
     *
     */
    public static boolean isValidCompletion(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public Boolean getCompletion() {
        return this.hasCompleted;
    }

    @Override
    public String toString() {
        return this.hasCompleted.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Completion // instanceof handles nulls
                && this.hasCompleted.equals(((Completion) other).hasCompleted)); // state check
    }

    @Override
    public int hashCode() {
        return this.hasCompleted.hashCode();
    }
}
