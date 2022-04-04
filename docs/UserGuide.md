---
layout: page
title: User Guide
---
* Table of Contents
{:toc}
--------------------------------------------------------------------------------------------------------------------

*Networkers* is a **desktop app for managing contacts for network technicians,
optimised for use via a Command Line Interface** (CLI)
while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, Networkers can get your contact management tasks
done faster than traditional GUI apps.

--------------------------------------------------------------------------------------------------------------------
## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `networkers.jar` from [here](https://github.com/AY2122S2-CS2103T-W13-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your networkers.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

  * **`list`** : Lists all contacts.

  * **`addClient`**`n/Apple p/91234561 e/apple@example.com a/311, Bedok Ave 3, #01-15 l/Plan 50GBps t/corporate` :
    Adds a client named `Apple` to the Networkers.
    
  * **`deleteClient`**`3` : Deletes the 3rd client shown in the current list.

  * **`listProc`**`1` : 
    Lists the procedures associated with the 1st client shown in the current list

  * **`clear`** : Deletes all client.

  * **`exit`** : Exits the app.
  
--------------------------------------------------------------------------------------------------------------------
## UI Guide

![UI Guide](images/UIGuide.png)

### Using the UI

In order to use our program, you need to type your commands into the command box as shown in the above image.
After typing, press enter: if the correct format is entered, it will execute the command, or else it will guide you 
in rectifying the error.

## Features

### Notes about command formats:

- Words in `UPPER_CASE` are the parameters to be supplied by the user.

  For example, in `addClient n/NAME`, `NAME` is a parameter which can be used as `addClient n/John Doe`.
- Items in square brackets are optional.

  For example, `find KEYWORD [MORE_KEYWORDS]` can be used as `find Apple Inc`.
- All indexes are integer based, as such the maximum value is 2147483647 (2<sup>31</sup> - 1).


### Add a Client: `addClient`

Add your Client to Networkers. The client will initially start off with an empty Procedure list.

**Format:** `addClient n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS l/PLAN t/[TAG]...`
- `addClient` refers to the command of adding a Client.
- There exists some fields that are mandatory for this function. These fields include their name, phone_number, address 
and a (subscription) plan.

**Example:** <br/>
In Command Line Interface (CLI):
- `addClient n/Apple p/91234561 e/apple@example.com a/311, Bedok Ave 3, #01-15 l/Plan 50GBps t/corporate`
  - This triggers the addition of a client into your Client list.
  - Result shows: `New client added: Apple; Phone: 91234561; Email: apple@example.com; Address: 311, Bedok Ave 3, #01-15; Plan: Plan 50GBps; Tags: [corporate]`

In Application: ![Ui](images/addClientGUI.png)

### Delete a Client: `deleteClient`

Deletes a specified Client in Networkers.

**Format:** `deleteClient <CLIENT INDEX>`
- Deletes an existing Client at the specified index in your Client list.
- `<CLIENT INDEX>` refers to the ordering number shown in your displayed Client list.
- The index **must be** a positive integer 1, 2, 3, …

**Example:** <br/>
In Command Line Interface (CLI):
- `deleteClient 1` 
  - This triggers the deletion of the first Client in your Client list.
  - Result shows: `Deleted Client: Apple; Phone: 91234561; Email: apple@example.com; Address: 311, Bedok Ave 3, #01-15; Plan: Plan 50GBps; Tags: [corporate]`

In Application: ![list](images/deleteClientGUI.png)

### Edit a Client: `edit`

Edit a Client in Networkers. The client will initially start off with an empty Procedure list.

**Format:** `edit <CLIENT INDEX> (must be a positive integer) [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [l/PLAN] [t/TAG]...`
- `edit` refers to the command to edit a Client in Networker.
- `<CLIENT INDEX>` refers to the index number shown in the displayed Client list. The index **must be** a positive integer 1, 2, 3, …
- `[n/NAME]` refers to an optional field of editing your client's name.
- `[p/PHONE]` refers to an optional field of editing your client's contact number.
- `[e/EMAIL]` refers to an optional field of editing your client's email.
- `[a/ADDRESS]` refers to an optional field of editing your client's address.
- `[l/PLAN]` refers to an optional field of editing your client's subscription plan.
- `[t/TAG]` refers to an optional field of editing your client's tag.
- In order to trigger this command, at least one of the following fields must be edited: `name`, `phone`, `email`, 
`address`, `plan`, `tag`.

**Example:** <br/>
In Command Line Interface (CLI):
- `edit 4 n/Apple`
  - This triggers the editing of the indicated client.
  - Result shows: `Edited Client: Apple; Phone: 66595327; Email: optical88@example.com; Address: 3155 Commonwealth Ave W, #05-27; Plan: EXPRESS 200MBps; Tags: [family]`

In Application: ![Ui](images/editClient_After.png)

### Add a Procedure to a Client: `addProc`

Adds a specified Procedure to a specified Client in your display client list.

Note: After editing the Procedure, you have to type `listProc <CLIENT_INDEX>` for the change to be reflected on the GUI. This will be resolved in v1.4.

**Format:** `addProc <CLIENT INDEX> i/INFORMATION c/COST d/DATE_TIME`
- `addProc` refers to the command of adding a Procedure to the Client at the specified index.
- `<CLIENT INDEX>` refers to the index number shown in the displayed Client list. The index **must be** a positive integer 1, 2, 3, …
- `INFORMATION` refers to the tasks or problems that need to be addressed to the Client’s business site.
- `COST` is the cost required for the Procedure.
- `DATE_TIME` is the date and time that the Procedure takes place. It accepts inputs in the form of `dd/MM/YYYY HH:MM`, e.g. 20/03/2022 11:30.
- A new Procedure will be auto-sorted based on the date when the Procedure takes place, in ascending order.
- If the specified Client already has an identical Procedure, the application will inform you that the Procedure has already been added.
- Note that it is perfectly valid to add Procedures that fall on the exact date and time.
  - This is because some Procedures can be done concurrently through remote control.

**Example:** <br/>
In Command Line Interface (CLI):
- `addProc 1 i/Install modem c/10.5 d/20/03/2022 11:30`

In Application: ![addProc](images/addProcGUI.png)

### Delete a Procedure from the Client: `deleteProc`

Deletes a Procedure associated with your Client. This is important as it allows you to maintain and make changes to the database.

Note: After editting the Procedure, you have to type `listProc <CLIENT_INDEX>` for the change to be reflected on the GUI. This will be resolved in v1.4.

**Format:** `deleteProc <CLIENT INDEX> <PROCEDURE INDEX>`
- `deleteProc` refers to the command of deleting a Procedure from the Client at the specified index.
- `<CLIENT INDEX>` refers to the index number shown in the displayed Client list. The index **must be** a positive integer 1, 2, 3, ...
- `<PROCEDURE INDEX>` refers to the index number of a Procedure from a specified Client's list of Procedures. The index **must be** a positive integer 1, 2, 3, ...
- Note that a Client’s list of Procedures is also a numbered list.

**Example:** <br/>
In Command Line Interface (CLI):
- `deleteProc 1 1`
  - Result shows: `Current Procedure List: [Information: Install modem; Date: 20/03/2022 11:30; Cost: 10.5; Completed: false]`

Before Command:

![deleteProc](images/deleteProcCommand_Before.png)

After Command:

![deleteProc](images/deleteProcCommand_After.png)

### Edit a Procedure of your Client: `editProc`

Edits an existing Procedure that belongs to an existing Client. This feature allows you to edit the main details related to the Procedure.
The main details include the information, the date, and the cost of the Procedure.

Note: After editing the Procedure, you have to type `listProc <CLIENT_INDEX>` for the change to be reflected on the GUI. This will be resolved in v1.4.

**Format:** `editProc <CLIENT INDEX> <PROCEDURE INDEX> [i/INFORMATION] [d/DATE] [c/COST]`
- `editProc` refers to the command to edit a Procedure belonging to your Client.
- `<CLIENT INDEX>` refers to the ordering number of the Client displayed on the Client screen. The index **must be** a positive integer 1, 2, 3, ...
- `<PROCEDURE INDEX>` refers to the ordering number of the Procedure displayed on the Procedure screen (that is associated with a Client). The index **must be** a positive integer 1, 2, 3, ...
- `[i/INFORMATION]` refers to the informational detail of the Procedures in subsequent servicing trips. 
- `[d/DATE]` refers to the date of the subsequent servicing trip of your client.
- `[c/COST]` refers to the cost incurred from executing the Procedure that will be charged to your client.
- The information field, the date field, or the cost field **must be** filled up for this feature to run.

**Example:** <br/>
In Command Line Interface (CLI):
- `editProc 1 2 i/Fix Router d/31/03/2022 09:50 c/67.25`
  - Result shows: `Edited Procedure: Information: Fix Router; Date: 31/03/2022 09:50; Cost: 67.25; Completed: false, from Client MINISO; Email: miniso@example.com`

Before Command: 

![editProc](images/editProcCommand_Before.png)

After Command: After editting the Procedure, you have to type listProc for the change to be reflected. This will be resolved in v1.4.

![editProc](images/editProcCommand_After.png)

### View All Clients: `list`

Lists out all the Clients saved in your database. This feature will be used to display all the Clients added onto the application. 
No secondary information is required. You can use this feature after using `find` command to see all clients.

**Format:** `list`
- `list` refers to the command to list all clients saved in your database.

**Example:** <br/>
In Command Line Interface (CLI):
- `list`
  - Result shows: `Listed all clients.`

In Application: ![list](images/listGUI.png)

### View All Procedures of a Client: `listProc`

Lists out all the Procedures related to a Client.

**Format:** `listProc <CLIENT INDEX>`
- `listProc` refers to the command to list all the Procedures related to an existing client. 
- `<CLIENT INDEX>` refers to the ordering number of the Client displayed on the Client screen. The index **must be** a positive integer 1, 2, 3, ...

**Example:**
- `listProc 1`
  - Result shows: `Procedures successfully loaded.`

In Application: ![listProc](images/ListProcCommandExample1.PNG)

### View all Procedures scheduled on a specified date: `listProcOn`

Lists out all Procedures, including the associated Client as per Procedure, that are scheduled on a specified date.

**Format:** `listProcOn <DATE>`
- `listProcOn` refers to the command of listing out all Procedures on a specified date.
- `DATE` is in the format of dd/MM/YYYY, e.g. 26/03/2022.
  - Error will be thrown if the date is invalid.

**Example:** <br/>
In Command Line Interface (CLI):
- `listProcOn 26/03/2022`
  - Result shows: 
```
  Listing Procedures on requested date:
  1. Information: configure internet settings; Date: 26/03/2022 11:30; Cost: 10.50; Completed: false
   MINISO, located at 3155 Commonwealth Ave W, #03-56-58
  2. Information: configure POS connections; Date: 26/03/2022 12:00; Cost: 23.50; Completed: false
   Master Fix Services, located at 3155 Commonwealth Ave W, #B1-10
```

In Application: ![listProcOn](images/listProcOn.png)

### Calculate the cost of all Procedures on a specified date: `calculate`

Calculates the cost of all Procedures that happen any time on a specified date.

**Format:** `calculate <DATE>`
- `calculate` refers to the command of calculating cost of all Procedures on a specified date.
- `DATE` is in the format of dd/MM/YYYY, e.g. 23/03/2022. 
  - Error will be thrown if the date is invalid.

**Example:** <br/>
In Command Line Interface (CLI):
- `calculate 23/03/2022`
  - Result shows: `Total Cost: 31.5`

In Application: ![list](images/calculate.png)

### Clear All Clients: `clear`

Clears all Clients and their respective Procedures currently recorded in Networkers. New Clients can be added normally via all stated commands.

**Format:** `clear`
- `clear` refers to the command of clearing all Clients and their respective Procedures in the application.
  - Result shows: `Address book has been cleared!`

In Application: ![clear](images/ClearCommand_After.png)

### Locating Clients by Name: `find`

Finds Clients whose names contain any of the given keywords.

**Format:** `find KEYWORD [MORE_KEYWORDS]`
- The search is case-insensitive. e.g `apple inc` will match `Apple Inc`
- The order of the keywords does not matter. e.g. `Inc Apple` will match `Apple Inc`
- Only the name is searched.
- Only full words will be matched e.g. `App` will not match `Apple Inc`
- Persons matching at least one keyword will be returned. e.g. `Inc` will return `Apple Inc`, `Google Inc`

Example:
- `find Fix` returns `Master Fix Services`

In Application: ![list](images/findCommandExample.png)

### Exiting the program: `exit`

Exits the program.

**Format**: `exit`

## Command Summary

| Command                                         | Syntax                                                                                                          | Example                                                  |
|-------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|----------------------------------------------------------|
| Add Client                                      | `addClient n/<NAME> p/<PHONE_NUMBER> a/<ADDRESS> l/<PLAN>`                                                      | `addClient n/Apple Inc p/9XXXXXXX a/apple road l/50MBps` |
| Delete Client                                   | `deleteClient <INDEX>`                                                                                          | `deleteClient 1`                                         |
| Edit Client                                     | `edit <CLIENT INDEX> (must be a positive integer) [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [l/PLAN] [t/TAG]...` | `edit 1 n/Apple`                                         |
| Add Procedure                                   | `addProc <CLIENT INDEX> i/INFORMATION c/COST d/DATE_TIME`                                                       | `addProc 1 i/Install modem c/10.5 d/20/03/2022 11:30`    |
| Delete Procedure                                | `deleteProc <CLIENT INDEX> <PROCEDURE INDEX>`                                                                   | `deleteProc 1 3`                                         |
| Edit Procedure                                  | `editProc <CLIENT INDEX> <PROCEDURE INDEX> [i/INFORMATION] [d/DATE] [c/COST]`                                   | `editProc 1 2 i/Fix Router d/31/03/2022 09:50 c/67.25`   |
| List All Clients                                | `list`                                                                                                          | `list`                                                   |
| List All Procedures                             | `listProc <CLIENT INDEX>`                                                                                       | `listProc 1`                                             |
| List All Procedures on Specified Date           | `listProcOn <DATE>`                                                                                             | `listProcOn 23/05/2022`                                  | 
| Calculate Cost of Procedures (on specific date) | `calculate <DATE>`                                                                                              | `calculate 23/02/2022`                                   |
| Clear All Clients                               | `clear`                                                                                                         | `clear`                                                  |
 | Find Clients by Keyword                         | `find KEYWORD [MORE_KEYWORDS]`                                                                                  | `find Apple Inc`                                         |
| Exit program                                    | `exit`                                                                                                          | `exit`                                                   |
## FAQ

### Why is The Command Not Working?

There are several cases in which you might face errors when entering a command:

- Typing in the command word wrongly (e.g. typing `lisst` instead of `list`)
- Typing in wrong number of inputs (e.g. typing `deleteClient` or `deleteClient 5 2` instead of `deleteClient 2`)
- Typing in letters for numbers or vice verse (e.g. typing `listProc hello` instead of `listProc 1`)
- You entered the correct command but wrong inputs (e.g. typing `deleteProc 1 10` when there is no 10th client)

The corresponding error messages will be displayed in the result box, so do take a look at them.
