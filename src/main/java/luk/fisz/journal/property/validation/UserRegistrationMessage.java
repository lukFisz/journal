package luk.fisz.journal.property.validation;

public class UserRegistrationMessage {

    public static final String usernameNotBlankMsg = "Username is mandatory";
    public static final int usernameSizeMin = 6;
    public static final int usernameSizeMax = 16;
    public static final String usernameSizeMsg
            = "Username must be beetwen " + usernameSizeMin + " and " + usernameSizeMax + " characters";

    public static final String passwordNotBlankMsg = "Password is mandatory";
    public static final int passwordSizeMin = 8;
    public static final int passwordSizeMax = 100;
    public static final String passwordSizeMsg
            = "Password should be greater then " + passwordSizeMin;

    public static final String emailNotBlankMsg = "E-mail is mandatory";
    public static final String emailPatternMsg = "E-mail is not valid";
    public static final String emailPatternRegex = "^[A-Za-z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$";

}
