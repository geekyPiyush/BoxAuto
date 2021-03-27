package com.payoneer.cloud.box.commons.helpers;

public class Utils {

    public static boolean isValidString(String string) {
        if (string != null && !string.isEmpty()) {
            return !string.trim().equals("-");
        } else {
            return false;
        }
    }
}