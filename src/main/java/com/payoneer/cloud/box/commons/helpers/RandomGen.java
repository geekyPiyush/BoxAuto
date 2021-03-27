package com.payoneer.cloud.box.commons.helpers;

import org.apache.commons.lang.RandomStringUtils;
import java.util.Random;

public class RandomGen {

    // generate a random integer
    public static int generateRandomInteger(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    // generate a random alphanumericString
    public static String generateRandomAlphanumericString(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
