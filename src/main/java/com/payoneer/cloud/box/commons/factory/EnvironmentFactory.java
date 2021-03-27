package com.payoneer.cloud.box.commons.factory;
import com.payoneer.cloud.box.commons.loaders.JsonLoader;
import com.payoneer.cloud.box.commons.logger.Log;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentFactory {
  // collection which holds static data
  public static String env;
  public static Map<String, String> envMap;

  public static void loadEnvResource() {
    envMap = new HashMap<>();
    Map<String, String> specifics = JsonLoader.loadMapFromFile("env-properties/live");
    Log.info("Loaded " + specifics.size() + " environment properties.");
    envMap.putAll(specifics);
  }

  public static String get(String key) {
    return envMap.get(key);
  }

  public static String getUrl() {
    return envMap.get("homeUrl");
  }

}