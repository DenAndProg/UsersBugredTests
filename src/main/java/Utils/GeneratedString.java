package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneratedString {

    public static String generatedString() {
        int length = 9;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
