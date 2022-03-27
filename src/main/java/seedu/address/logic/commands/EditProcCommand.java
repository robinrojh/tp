package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLIENTS;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.client.*;
import seedu.address.model.procedure.Completion;
import seedu.address.model.procedure.Cost;
import seedu.address.model.procedure.Date;
import seedu.address.model.procedure.Information;
import seedu.address.model.procedure.Procedure;
import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing Procedure belonging to an existing Client in the address book.
 */
public class EditProcCommand extends Command {

	public static final String COMMAND_WORD = "editProc";

	public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the Procedure "
		+ "identified by the index number used in the displayed Client list and the index number used "
		+ "in the displayed Procedure list.\n"
		+ "Existing values will be overwritten by the input values.\n"
		+ "Parameters: CLIENT_INDEX (must be a positive integer) "
		+ "PROCEDURE_INDEX (must be a positive integer) "
		+ "[" + PREFIX_INFORMATION + "NAME] "
		+ "[" + PREFIX_DATE + "PHONE] "
		+ "[" + PREFIX_COST + "EMAIL] ";

	public static final String MESSAGE_EDIT_PROCEDURE_SUCCESS = "Edited Procedure: %1$s, from Client %2$s";
	public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

	private final Index clientIndex;
	private final Index procedureIndex;
	private final EditProcedureDescriptor editProcedureDescriptor;

	/**
	 * @param clientIndex of the Client in the filtered client list to edit
	 * @param procedureIndex of the Procedure in the Client's procedure list to edit
	 * @param editProcedureDescriptor details to edit the Procedure with
	 */
	public EditProcCommand(Index clientIndex, Index procedureIndex,
	                       EditProcedureDescriptor editProcedureDescriptor) {
		requireNonNull(clientIndex);
		requireNonNull(procedureIndex);
		requireNonNull(editProcedureDescriptor);

		this.clientIndex = clientIndex;
		this.procedureIndex = procedureIndex;
		this.editProcedureDescriptor = new EditProcedureDescriptor(editProcedureDescriptor);
	}

	@Override
	public CommandResult execute(Model model) throws CommandException {
		requireNonNull(model);
		List<Client> lastShownList = model.getFilteredClientList();

		if (clientIndex.getOneBased() > lastShownList.size()) {
			throw new CommandException(Messages.MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX);
		}

		Client clientToEdit = lastShownList.get(clientIndex.getZeroBased());
		List<Procedure> procedureList = clientToEdit.getProcedures();

		if (procedureIndex.getOneBased() > procedureList.size()) {
			throw new CommandException(Messages.MESSAGE_INVALID_PROCEDURE_DISPLAYED_INDEX); //Customise later
		}

		Procedure procedureToEdit = clientToEdit.getProcedures().get(procedureIndex.getZeroBased());
		Procedure updatedProcedure = createEditedProcedure(procedureToEdit, editProcedureDescriptor);
		List<Procedure> updatedProcedureList = updateProcedureList(clientToEdit.getProcedures(), updatedProcedure, procedureIndex);
		Client editedClient = editClientProcedures(clientToEdit, updatedProcedureList);

		model.setClient(clientToEdit, editedClient);
		model.updateFilteredClientList(PREDICATE_SHOW_ALL_CLIENTS);
		return new CommandResult(String.format(MESSAGE_EDIT_PROCEDURE_SUCCESS,
			updatedProcedure, editedClient));
	}

	/**
	 * Creates and returns a {@code Client} with the procedures of {@code clientToEdit}
	 * edited with {@code newProcedureList}.
	 */
	private static Client editClientProcedures(Client clientToEdit, List<Procedure> newProcedureList) {
		assert clientToEdit != null;

		Name clientName = clientToEdit.getName();
		Phone clientPhone = clientToEdit.getPhone();
		Email clientEmail = clientToEdit.getEmail();
		Address clientAddress = clientToEdit.getAddress();
		Plan clientPlan = clientToEdit.getPlan();
		Set<Tag> clientTags = clientToEdit.getTags();
		List<Procedure> updatedProcedures = new ArrayList<>(newProcedureList);

		return new Client(clientName, clientPhone, clientEmail, clientAddress, clientPlan, clientTags,
			updatedProcedures);
	}

	/**
	 * Creates and returns a list of {@code Procedure} with the {@code Procedure} at
	 * {@code procedureIndex} in the {@code procedureList} updated with {@code edittedProcedure}.
	 */
	private static List<Procedure> updateProcedureList(List<Procedure> procedureList,
	        Procedure edittedProcedure, Index procedureIndex) throws CommandException {
		assert procedureList.size() > 0;
		assert edittedProcedure != null;
		assert procedureIndex != null;

		if (procedureIndex.getOneBased() > procedureList.size()) {
			throw new CommandException("Procedure index input exceeds the amount of procedure in the Client");
		} // do for negative

		List<Procedure> newProcedureList = new ArrayList<>(procedureList);
		newProcedureList.set(procedureIndex.getZeroBased(), edittedProcedure);

		return newProcedureList;
	}

	/**
	 * Creates and returns a {@code Procedure} with the details of {@code procedureToEdit}
	 * edited with {@code editProcedureDescriptor}.
	 */
	private static Procedure createEditedProcedure(Procedure procedureToEdit,
	        EditProcedureDescriptor editProcedureDescriptor) {
		assert procedureToEdit != null;
		Information updatedInfo = editProcedureDescriptor.getInfo()
			.orElse(procedureToEdit.getInfo());
		Date updatedDate = editProcedureDescriptor.getDate()
			.orElse(procedureToEdit.getDate());
		Cost updatedCost = editProcedureDescriptor.getCost()
			.orElse(procedureToEdit.getCost());
		Completion hasCompleted = (procedureToEdit.getHasCompleted());

		return new Procedure(updatedInfo, updatedDate, updatedCost, hasCompleted);
	}

	@Override
	public boolean equals(Object other) {
		// short circuit if same object
		if (other == this) {
			return true;
		}

		// instanceof handles nulls
		if (!(other instanceof EditProcCommand)) {
			return false;
		}

		// state check
		EditProcCommand e = (EditProcCommand) other;
		return clientIndex.equals(e.clientIndex)
			&& procedureIndex.equals(e.procedureIndex)
			&& editProcedureDescriptor.equals(e.editProcedureDescriptor);
	}

	/**
	 * Stores the details to edit the {@code Procedure} with. Each non-empty field value will replace the
	 * corresponding field value of the client.
	 */
	public static class EditProcedureDescriptor {
		private Information info;
		private Cost cost;
		private Date date;

		public EditProcedureDescriptor() {}

		/**
		 * Copy constructor.
		 */
		public EditProcedureDescriptor(EditProcedureDescriptor toCopy) {
			setInfo(toCopy.info);
			setDate(toCopy.date);
			setCost(toCopy.cost);
		}

		/**
		 * Returns true if at least one field is edited.
		 */
		public boolean isFieldEdited() {
			return CollectionUtil.isAnyNonNull(info, cost, date);
		}

		public void setInfo(Information info) {
			this.info = info;
		}

		public Optional<Information> getInfo() {
			return Optional.ofNullable(info);
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Optional<Date> getDate() {
			return Optional.ofNullable(date);
		}

		public void setCost(Cost cost) {
			this.cost = cost;
		}

		public Optional<Cost> getCost() {
			return Optional.ofNullable(cost);
		}

		@Override
		public boolean equals(Object other) {
			// short circuit if same object
			if (other == this) {
				return true;
			}

			// instanceof handles nulls
			if (!(other instanceof EditProcedureDescriptor)) {
				return false;
			}

			// state check
			EditProcedureDescriptor e = (EditProcedureDescriptor) other;
			return getInfo().equals(e.getInfo())
				&& getCost().equals(e.getCost())
				&& getDate().equals(e.getDate());
		}
	}
}
