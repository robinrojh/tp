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

- **Features**
  1. Add a Client
  2. Delete a Client
  3. Add a Procedure to the Client
  4. Delete a Procedure from the Client
  5. View all Clients and associated Procedures in the Client
  6. Calculate the cost of all Procedures on a specified date
  7. List all Procedures of a Client
  8. Clear all Clients from Networkers
  9. Find all Clients by keyword
- **Command Summary**

--------------------------------------------------------------------------------------------------------------------

## Features

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
- `<CLIENT INDEX>` refers to the index number shown in the displayed Client list. The index **must be** a positive integer 1, 2, 3, …​
- `INFORMATION` refers to the tasks or problems that need to be addressed in the future visits to the Client’s business site.
- `COST` is the cost required for the Procedure.
- `DATE_TIME` is the date and time that the Procedure takes place. 
  - `DATE_TIME` accepts inputs in the form of `dd_MM_YYYY HH:MM`.
- Note that a Client’s list of Procedures is a numbered list. A new Procedure will be auto-sorted based on the date of operation.

**Example:** <br/>
In Command Line Interface (CLI):
- `addProc 1 i/Install modem c/10.5 d/20/03/2022 11:30`
  - If the first Client already has an identical Procedure, the application will inform you that the Procedure has already been added.

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

![deleteProc](images/deleteProcGUIBefore.png)

After Command:

![deleteProc](images/deleteProcGUIAfter.png)

### View All Clients: `list`

Lists out all the Clients saved. This feature will be used to show Clients on the application. No secondary information is required.

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

### Calculate the cost of all Procedures on a specified date: `calculate`

Calculates the cost of all Procedures that happen any time on a specified date.

**Format:** `calculate <DATE>`
- `calculate` refers to the command of calculating cost of all Procedures on a specified date.
- `DATE` is in the format of dd/MM/YYYY, eg. 23/03/2022. 
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

## Command Summary

| Command | Syntax                                                     | Example                                                 |
| --- |------------------------------------------------------------|---------------------------------------------------------|
| Add Client | `addClient n/<NAME> p/<PHONE_NUMBER> a/<ADDRESS> l/<PLAN>` | `addClient n/Apple Inc p/9XXXXXXX a/apple road l/50MBps` |
| Delete Client | `deleteClient <INDEX>`                                     | `deleteClient 1`                                        |
| Add Procedure | `addProc <Client INDEX> i/INFORMATION c/COST d/DATE_TIME`  | `addProc 1 i/Install modem c/10.5 d/20/03/2022 11:30`    |
| Delete Procedure | `deleteProc <CLIENT INDEX> <PROCEDURE INDEX>`              | `deleteProc 1 3`                                        |
| List All Clients | `list`                                                     | `list`                                                  |
| List All Procedures | `listProc <CLIENT INDEX>`                                  | `listProc 1`                                            | 
| Calculate Cost of Procedures (on specific date) | `calculate <DATE>`                                         |`calculate 23/02/2022` |
| Clear All Clients | `clear`                                                    | `clear` |
 | Find Clients by Keyword | `find KEYWORD [MORE_KEYWORDS]`                             | `find Apple Inc` |

