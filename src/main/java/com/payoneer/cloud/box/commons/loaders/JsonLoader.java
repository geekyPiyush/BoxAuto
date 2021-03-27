package com.payoneer.cloud.box.commons.loaders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class JsonLoader {

    public static final String RESOURCES = "/config/";

    public static Map<String, Map<String, String>> loadMapOfMapsFromFile(String fileName) {
        String path = RESOURCES + fileName + ".json";
        Map readMap = null;
        InputStream inputStream = JsonLoader.class.getResourceAsStream(path);
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream in = inputStream; BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            readMap = mapper.readValue(br, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readMap;
    }

    public static Map<String, String> loadMapFromFile(String fileName) {
        String path = RESOURCES + fileName + ".json";
        InputStream inputStream = JsonLoader.class.getResourceAsStream(path);
        Map readMap = null;
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream in = inputStream; BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            readMap = mapper.readValue(br, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readMap;
    }

}