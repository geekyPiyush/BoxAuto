package com.payoneer.cloud.box.commons.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppState {
    private final Map<String, List<Object>> sharedListMap;
    private String folderName;
    private String fileName;
    private String fileExt;
    private String collectionName;

    public AppState() {
        sharedListMap = new HashMap<>();
    }

    public void setCollectionName(String cName) {
        this.collectionName = cName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setFolderName(String fName) {
        this.folderName = fName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFileName(String fName) {
        this.fileName = fName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileExt(String ext) {
        this.fileExt = ext;
    }

    public String getFileExt() {
        return fileExt;
    }

}