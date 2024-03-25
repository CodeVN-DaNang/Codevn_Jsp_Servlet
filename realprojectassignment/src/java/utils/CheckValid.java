package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValid {

    public static boolean PasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        if (!upperCaseMatcher.find()) {
            return false;
        }
        Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharacterMatcher = specialCharacterPattern.matcher(password);
        if (!specialCharacterMatcher.find()) {
            return false;
        }
        return true;
    }

    public static boolean isGmailAddress(String email) {
        String gmailRegex = "^[a-zA-Z0-9_]+@(gmail\\.com|fpt\\.edu\\.vn)$";
        Pattern pattern = Pattern.compile(gmailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidCCCD(String cccd) {
        String cccdRegex = "\\d{12}";
        Pattern pattern = Pattern.compile(cccdRegex);
        Matcher matcher = pattern.matcher(cccd);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\+?\\d{10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
