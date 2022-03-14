package seedu.address.model.procedure;

import seedu.address.model.client.Client;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class ProcClient {

	public static final String MESSAGE_CONSTRAINTS =
			"1. ProcClient should be tagged to an existing Client value";

	public final Client client;

	/**
	 * Constructs a {@code ProcClient}.
	 *
	 * @param client A valid Client value indicating the client whom this Procedure belongs to.
	 */
	public ProcClient(Client client) {
		requireNonNull(client);
		checkArgument(isValidClient(client), MESSAGE_CONSTRAINTS);
		this.client = client;
	}

	/**
	 * Returns true if a given string is a valid boolean.
	 */
	public static boolean isValidClient(Object test) {
		return test instanceof Client;
	}

	public Client getClient() {
		return this.client;
	}

	@Override
	public String toString() {
		return this.client.toString();
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof ProcClient // instanceof handles nulls
				&& this.client.equals(((ProcClient) other).client)); // state check
	}

	@Override
	public int hashCode() {
		return this.client.hashCode();
	}
}
