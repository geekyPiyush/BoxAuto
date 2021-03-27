package com.payoneer.cloud.box.commons.helpers;


import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.SystemUtils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadItem {

    public static void uploadItemToApplication(String fileWithPath){
        try {
            String newFilePath = separatorsToSystem(fileWithPath);
            StringSelection ss = new StringSelection(newFilePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            //Perform native keystorkes
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch(AWTException awe){
            awe.printStackTrace();
        }
    }

   public static String separatorsToSystem(String res) {
        if(SystemUtils.IS_OS_WINDOWS)
            return FilenameUtils.separatorsToWindows(res);
        else
            return FilenameUtils.separatorsToUnix(res);
    }
}