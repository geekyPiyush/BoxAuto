package com.payoneer.cloud.box.commons.factory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    public final static String PATH_MESSAGES_FILES = "files/";
    public static String[] supports = {};

    public static String getResources(String path) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(path);
        return url.getPath();
    }

    public static List<String> getRequestedDataFile(String ext){
        List<String> fileData = new ArrayList<>();
        String fileFolderPath = getResources("data/" + PATH_MESSAGES_FILES);
        supports = new File(fileFolderPath).list();
        for (String file : supports){
            if(file.endsWith(ext)) {
                fileData.add(System.getProperty("user.dir") + "/src/main/resources/data/" + PATH_MESSAGES_FILES + file);
                fileData.add(file);
            }
        }
        return fileData;
    }
}
