package luk.fisz.journal.exception;

public class UserNotEntryOwnerException extends RuntimeException {

    public UserNotEntryOwnerException(String username, long id) {
        super("The user '"+username+"' is not the owner of the entry: "+id);
    }
}
