package com.payoneer.cloud.box.commons.factory;

import com.payoneer.cloud.box.commons.loaders.JsonLoader;
import com.payoneer.cloud.box.commons.logger.Log;

import java.util.Map;

public class DeviceMetricsFactory {

  public static Map<String, Map<String, String>> desktopBrowsers;
  // initialize to load data
  public static void loadBrowsers() {
    Log.info("Loading desktop configurations for browser");
    desktopBrowsers = JsonLoader.loadMapOfMapsFromFile("device-matrix/desktop_browsers");
  }
}