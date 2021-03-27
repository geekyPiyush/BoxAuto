package com.payoneer.cloud.box.commons.factory;

import com.payoneer.cloud.box.commons.helpers.Utils;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LoginFactory {

    public static String uName;
    public static String pWord;
    public static Map<String,String> userCredentialsMap;

    public static Map<String,String> getUserCredentials() {
        uName = System.getProperty("username");
        pWord = System.getProperty("password");
        userCredentialsMap = new HashMap<>();
        if (Utils.isValidString(uName) && Utils.isValidString(uName)) {
            userCredentialsMap.put("userName", uName);
            userCredentialsMap.put("password", pWord);
        } else {
            uName = EnvironmentFactory.envMap.get("username");
            String saltVal = EnvironmentFactory.envMap.get("salt");
            pWord = new String(Base64.decodeBase64(saltVal), StandardCharsets.UTF_8);
            userCredentialsMap.put("userName", uName);
            userCredentialsMap.put("password", pWord);
        }
        return userCredentialsMap;
    }

}
