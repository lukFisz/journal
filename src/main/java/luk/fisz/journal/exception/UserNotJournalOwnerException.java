package luk.fisz.journal.exception;

public class UserNotJournalOwnerException extends RuntimeException {

    public UserNotJournalOwnerException(String username, long id) {
        super("The user '"+username+"' is not the owner of the journal: "+id);
    }

}
