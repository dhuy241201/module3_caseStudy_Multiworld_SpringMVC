package ulti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUlti {
    private static final String USER_REGEX = "^[a-z0-9._]{3,15}$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@])[A-Za-z\\d@]{8,}$";
    private static final String NAME_REGEX = "^[A-Za-z0-9_.]{3,15}$";
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

//    private static ValidateRepository validateRepository = null;
//    public static ValidateRepository getInstance(){
//        if (validateRepository == null){
//            validateRepository = new ValidateRepository();
//        }
//        return validateRepository;
//    }
    private static Pattern pattern;
    public static boolean validate(String input, String regexPattern){
        switch (regexPattern){
            case "USERNAME":
                pattern = Pattern.compile(USER_REGEX);
                break;
            case "PASSWORD":
                pattern = Pattern.compile(PASSWORD_REGEX);
                break;
            case "NAME":
                pattern = Pattern.compile(NAME_REGEX);
                break;
            case "EMAIL":
                pattern = Pattern.compile(EMAIL_REGEX);
                break;
        }
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
