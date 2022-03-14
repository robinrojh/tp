package seedu.address.model.procedure;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


public class Completion {

	public static final String MESSAGE_CONSTRAINTS =
			"1. Completion should be a Boolean value, Boolean.TRUE or Boolean.FALSE";

	public final Boolean completion;

	/**
	 * Constructs a {@code Completion}.
	 *
	 * @param completion A valid Boolean value indicating completion of Procedure.
	 */
	public Completion(Boolean completion) {
		requireNonNull(completion);
		checkArgument(isValidCompletion(completion), MESSAGE_CONSTRAINTS);
		this.completion = completion;
	}

	/**
	 * Returns true if a given string is a valid boolean.
	 */
	public static boolean isValidCompletion(Boolean test) {
		return test == ( Boolean.TRUE || Boolean.FALSE );
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
