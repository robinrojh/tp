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
    
  * **`delete`**`3` : Deletes the 3rd client shown in the current list.

  * **`listProc`**`1` : 
    Lists the procedures associated with the 1st client shown in the current list

  * **`clear`** : Deletes all client.

  * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

- **Features**
  1. Add a Client
  2. Delete a Client
  3. Add a Procedure to the Client
  4. Delete a Procedure from the Client
  5. Edit a Procedure of a Client
  6. View all Procedures scheduled on a specified date
  7. View all Clients and associated Procedures in the Client
  8. Calculate the cost of all Procedures on a specified date
  9. List all Procedures of a Client
  10. Clear all Clients from Networkers
  11. Find all Clients by keyword
  12. Exit the program
- **Command Summary**

--------------------------------------------------------------------------------------------------------------------
## UI Guide

![UI Guide](images/UIGuide.png)

### Using the UI

In order to use our program, you need to type your commands into the command box as shown in the above image.
After typing, press enter: either it will show an error in the result box or execute the command correctly.

## Features

### Notes about command formats:

- Words in `UPPER_CASE` are the parameters to be supplied by the user.

  For example, in `addClient n/NAME`, `NAME` is a parameter which can be used as `addClient n/John Doe`.
- Items in square brackets are optional.

  For example, `find KEYWORD [MORE_KEYWORDS]` can be used as `find Apple Inc`.
- Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.

  For example, if the command specifies `help 123`, it will be interpreted as `help`.
- All inputs must be in sequence as shown in the instruction.
- All indexes are integer based, as such the maximum value is 2147483647 (2<sup>31</sup> - 1).


### Add a Client: `addClient`

Adds a Client with an empty Procedure list to the Networkers.

**Format:** `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS l/PLAN t/TAG...`
- `addClient` refers to the command of adding a Client.
- Mandatory fields for a new Client include name, phone_number, address and a plan.

**Example:** <br/>
In Command Line Interface (CLI):
- `addClient n/Apple p/91234561 e/apple@example.com a/311, Bedok Ave 3, #01-15 l/Plan 50GBps t/corporate `
  - Result shows: `New client added: Apple; Phone: 91234561; Email: apple@example.com; Address: 311, Bedok Ave 3, #01-15; Plan: Plan 50GBps; Tags: [corporate]`

In Application: ![Ui](images/addClientGUI.png)

### Delete a Client: `deleteClient`

Deletes a specified Client from the Networkers.

**Format:** `deleteClient <CLIENT INDEX>`
- Deletes the Client at the specified index.
- `<CLIENT INDEX>` refers to the index number shown in the displayed Client list.
- The index **must be** a positive integer 1, 2, 3, …

**Example:** <br/>
In Command Line Interface (CLI):
- `deleteClient 1` 
  - This will trigger an attempt to delete the first Client in the Client list.

In Application: ![list](images/deleteClientGUI.png)

### Add a Procedure to a Client: `addProc`

Adds a specified Procedure to a specified Client.

**Format:** `addProc <CLIENT INDEX> i/INFORMATION c/COST d/DATE_TIME`
- `addProc` refers to the command of adding a Procedure to the Client at the specified index.
- `<CLIENT INDEX>` refers to the index number shown in the displayed Client list. The index **must be** a positive integer 1, 2, 3, …
- `INFORMATION` refers to the tasks or problems that need to be addressed to the Client’s business site.
- `COST` is the cost required for the Procedure.
- `DATE_TIME` is the date and time that the Procedure takes place. 
  - `DATE_TIME` accepts inputs in the form of `dd/MM/YYYY HH:MM`, e.g. 20/03/2022 11:30.
- A new Procedure will be auto-sorted based on the date when the Procedure takes place, in ascending order.
- If the specified Client already has an identical Procedure, the application will inform you that the Procedure has already been added.
- Note that it is perfectly valid to add Procedures that fall on the exact date and time.
  - This is because some Procedures can be done concurrently through remote control.

**Example:** <br/>
In Command Line Interface (CLI):
- `addProc 1 i/Install modem c/10.5 d/20/03/2022 11:30`

In Application: ![addProc](images/addProcGUI.png)

### Delete a Procedure from the Client: `deleteProc`

Deletes a Procedure associated with the Client. This is important as it allows you to maintain and make changes to the database - creation and deletion.

**Format:** `deleteProc <CLIENT INDEX> <PROCEDURE INDEX>`
- `deleteProc` refers to the command of deleting a Procedure from the Client at the specified index.
- `<CLIENT INDEX>` refers to the index number shown in the displayed Client list. The index **must be** a positive integer 1, 2, 3, ...
- `<PROCEDURE INDEX>` refers to the index number of a Procedure from a specified Client's list of Procedures. The index **must be** a positive integer 1, 2, 3, ...
- Note that a Client’s list of Procedures is also a numbered list.

**Example:** <br/>
In Command Line Interface (CLI):
- `deleteProc 1 3`
  - Result shows: `Current Procedure List: [Information: Install modem; Date: 20/03/2022 11:30; Cost: 10.5; Completed: false]`
- `deleteProc 3 500`
  - Result shows: `The procedure index provided is invalid`

Before Command:

![deleteProc](images/deleteProcCommand_Before.png)

After Command:

![deleteProc](images/deleteProcCommand_After.png)

### Edit a Procedure of a Client: `editProc`

Edits an existing Procedure that belongs to an existing Client. This feature allows you to edit the main details related to the Procedure.
The main details include the information, the cost, and the date of the Procedure.

**Format:** `editProc <CLIENT INDEX> <PROCEDURE INDEX>`
- `editProc` refers to the command to edit a Procedure belonging to a Client.
- `<CLIENT INDEX>` refers to the ordering number of the Client displayed on the Client screen. The index **must be** a positive integer 1, 2, 3, ...
- `<PROCEDURE INDEX>` refers to the ordering number of the Procedure displayed on the Procedure screen (that is associated with a Client). The index **must be** a positive integer 1, 2, 3, ...

**Example:** <br/>
In Command Line Interface (CLI):
- `editProc 1 2 i/Fix Router d/31/03/2022 09:50 c/67.25`
  - Result shows: `Edited Procedure: Information: Fix Router; Date: 31/03/2022 09:50; Cost: 67.25; Completed: false, from Client MINISO; Email: miniso@example.com`

Before Command:

![editProc](images/editProcCommand_Before.png)

After Command:

![editProc](images/editProcCommand_After.png)

### View All Clients: `list`

Lists out all the Clients saved. This feature will be used to show Clients on the application. 
No secondary information is required. You can use this feature after using `find` command to see all clients.

**Example:** <br/>
In Command Line Interface (CLI):
- `list`
  - Result shows: <br/>
  ```
  1. Apple, 9XXXXXXX, Apple Road` <br/>
  2. Singtel, 8XXXXXXX, Singtel Road`
  ```

In Application: ![list](images/listGUI.png)

### View All Procedures of a Client: `listProc`

Lists out all the Procedures related to a Client.

**Example:**
- `listProc 1`
  - Result shows:

  ```
  1. John, VALUE 50Mbps, 91028936, Singtel Road, singtel@singtel.com
      1. set up router system in office, 04/04/2022 12:12, 900
  ```

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

In Application: ![list](images/listProcOn.png)

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

**Note: If all Clients have been deleted and Networkers is closed, Networkers will start up with a new template list of Clients. This is a feature intended to introduce new users to Networker's interface.**

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

| Command | Syntax                                                    | Example                                                 |
| --- |-----------------------------------------------------------|---------------------------------------------------------|
| Add Client | `addClient n/<NAME> p/<PHONE_NUMBER> a/<ADDRESS> l/<PLAN>` | `addClient n/Apple Inc p/9XXXXXXX a/apple road l/50MBps` |
| Delete Client | `deleteClient <INDEX>`                                    | `deleteClient 1`                                        |
| Add Procedure | `addProc <CLIENT INDEX> i/INFORMATION c/COST d/DATE_TIME` | `addProc 1 i/Install modem c/10.5 d/20/03/2022 11:30`    |
| Delete Procedure | `deleteProc <CLIENT INDEX> <PROCEDURE INDEX>`             | `deleteProc 1 3`                                        |
| List All Clients | `list`                                                    | `list`                                                  |
| List All Procedures | `listProc <CLIENT INDEX>`                                 | `listProc 1`                                            | 
| Calculate Cost of Procedures (on specific date) | `calculate <DATE>`                                        |`calculate 23/02/2022` |
| Clear All Clients | `clear`                                                   | `clear` |
 | Find Clients by Keyword | `find KEYWORD [MORE_KEYWORDS]`                            | `find Apple Inc` |

## FAQ

### Why is The Command Not Working?

There are several cases in which you might face errors when entering a command:

- Typing in the command word wrongly (e.g. typing `lisst` instead of `list`)
- Typing in wrong number of inputs (e.g. typing `deleteClient` or `deleteClient 5 2` instead of `deleteClient 2`)
- Typing in letters for numbers or vice verse (e.g. typing `listProc hello` instead of `listProc 1`)
- You entered the correct command but wrong inputs (e.g. typing `deleteProc 1 10` when there is no 10th client)

The corresponding error messages will be displayed in the result box, so do take a look at them.
