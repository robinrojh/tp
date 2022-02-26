#User Guide
Networkers is a desktop app for managing contacts for networks, optimised for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Networkers can get your contact management tasks done faster than traditional GUI apps.

##Features (v1.2)
- Delete a procedure from the client
- Command Summary

##Features

###Delete a Procedure from the client: deleteProc
Deletes a procedure associated with the client. This is important as it allows the user to maintain and make changes to the database - creation and deletion.

Format: deleteProc <clientIndex> <Proc Index>
deleteProc refers to the command of adding a procedure to the client at the specified Index.
<Client Index> refers to the index number shown in the displayed client list. The index must be a positive integer 1, 2, 3, …​
<Procedure> refers to the tasks or problems that need to be addressed in the future visits to the client’s business sight.
Note that a client’s list of procedures is a numbered list. A new procedure will be added on to the existing numbered list (to the last index).

Example:

Non-GUI format:
User: deleteProc 1 3
Terminal returns: The procedure “Bring a new Singtel router to replace the old Apple one” has been successfully deleted! :)
User: deleteProc 3 500
Terminal returns: The procedure you listed does not exist, add more procedures.
User: deleteProc 3
Terminal returns: Do add in the procedure you would like to delete and try again :).

GUI Format:

##Command Summary

###Commands
Syntax
Example
Delete Procedure
deleteProc <CLIENT INDEX> <PROCEDURE INDEX>
deleteProc 1 3



