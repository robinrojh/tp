#deleteProc feature

##Proposed Implementation
The proposed deleteProc mechanism is facilitated by the `DeleteProcCommandParser`.
The deleteProc mechanism allows deletion of a `Procedure` from an existing `Client` in the address book.
The deleteProc is permanently erased and the remaining `Procedure` are stored locally after.
It implements the following operations:

* `DeleteProcCommand#editClientProcedure(Client clientToEdit)` &mdash; Edit an attribute of an existing `Client` and return a new `Client`.
* `DeleteProcCommand#deleteProcedure(List<Procedure> procedureList)` &mdash; Remove a `Procedure` from the list of `Procedure`
* `Model#setClient(clientToEdit, editedClient)` &mdash; Replace the existing `Client` with its editted variant.
* `Model#updateFilteredClientList(Predicate<Client> predicate)` &mdash; Replace the existing `Client` with its editted variant in the `ObservableList`, that helps to update the UI.

The `editClientProcedure(Client clientToEdit)` operation is exposed in the `Model` interface as `Model#setProcedure()`.

Given below is an example usage scenario and how the deleteProc mechanism behaves at each step.

Step 1. The user finds the `Procedure` that the client has using `findProc <Index>` 
The UI lists all the `Procedure` associated to the client and would like to delete one.

![DeleteProcState0](images/DeleteProcState0.png)

Step 2. The user executes `deleteProc 1 1` to delete the 1st `Procedure` associated with the 1st client in the address book.
The `deleteProc 1 1` command calls `DeleteProcCommand#(Client clientToEdit)`, which calls the `deleteProcedure(List<Procedure procedureList)` method to remove the `Procedure` from the list.
This newly-created `Client` is saved locally through the `Model#setClient`, and displayed by updating the `UpdateFilteredClientList`.
With the `Client` saved, the address book is saved at a new state.

![DeleteProcState1](images/DeleteProcState1.png)

The following sequence diagram shows how this operation works.

![DeleteProcSequenceDiagram](images/DeleteProcSequenceDiagram.png)