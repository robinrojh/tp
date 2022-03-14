package seedu.address.model.procedure;

import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


public class Completion {

	public static final String MESSAGE_CONSTRAINTS =
			"1. Completion should be a Boolean value, Boolean.TRUE or Boolean.FALSE";

	public static final String VALIDATION_REGEX = "^([Tt][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee])$";
	public final Boolean completion;

	/**
	 * Constructs a {@code Completion}.
	 *
	 * @param completion A valid Boolean value indicating completion of Procedure.
	 */
	public Completion(String completion) {
		requireNonNull(completion);
		checkArgument(isValidCompletion(completion), MESSAGE_CONSTRAINTS);
		this.completion = Boolean.getBoolean(completion);
	}

	/**
	 * Returns true if a given string is a valid boolean.
	 */
	public static boolean isValidCompletion(String test) {
		return test.matches(VALIDATION_REGEX);
	}

	public Boolean getCompletion() {
		return this.completion;
	}

	@Override
	public String toString() {
		return this.completion.toString();
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Completion // instanceof handles nulls
				&& this.completion.equals(((Completion) other).completion)); // state check
	}

	@Override
	public int hashCode() {
		return this.completion.hashCode();
	}
}
