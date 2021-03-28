package luk.fisz.journal.common.validation;

public class UserRegistrationProperties {

    public static final int USERNAME_SIZE_MIN = 6;
    public static final int USERNAME_SIZE_MAX = 16;
    public static final int PASSWORD_SIZE_MIN = 8;
    public static final int PASSWORD_SIZE_MAX = 50;
    public static final String EMAIL_PATTERN_REGEX = "^[A-Za-z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$";

}
