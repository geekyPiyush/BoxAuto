package com.payoneer.cloud.box.pageobjects;

import com.payoneer.cloud.box.constants.BoxPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserDashboardPageObject {
    private WebDriver driver;

    public UserDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement userAvatar() {
        return driver.findElement(BoxPageLocators.userAvatar);
    }

    public WebElement profileButton() {
        return driver.findElement(BoxPageLocators.profileButton);
    }

    public WebElement logoutButton() {
        return driver.findElement(BoxPageLocators.logoutButton);
    }

    public WebElement newButton() {
        return driver.findElement(BoxPageLocators.newButton);
    }

    public WebElement new_FolderButton() {
        return driver.findElement(BoxPageLocators.new_FolderButton);
    }

    public WebElement newFolderName() {
        return driver.findElement(BoxPageLocators.newFolderName);
    }

    public WebElement newFolderModal() {
        return driver.findElement(BoxPageLocators.newFolderModal);
    }

    public WebElement folderPermissionDrpdown() {
        return driver.findElement(BoxPageLocators.folderPermissionDrpdown);
    }

    public WebElement newFolderCreateButton() {
        return driver.findElement(BoxPageLocators.newFolderCreateButton);
    }

    public WebElement newFolderCancelButton() {
        return driver.findElement(BoxPageLocators.newFolderCancelButton);
    }

    public WebElement newFolderTableListing(String folder) {
        return driver.findElement(BoxPageLocators.newFolderTableListing(folder));
    }

    public WebElement collectionFavoriteLink() {
        return driver.findElement(BoxPageLocators.collectionFav);
    }

    public WebElement renameFolderLink(String folder) {
        return driver.findElement(BoxPageLocators.renameFolderLink(folder));
    }

    public WebElement renameFolderInput() {
        return driver.findElement(BoxPageLocators.renameInputField);
    }

    public WebElement renameFolderSave() {
        return driver.findElement(BoxPageLocators.renameFolderSave);
    }

    public WebElement folderMoreActionsLink(String folder) {
        return driver.findElement(BoxPageLocators.folderMoreActionsLink(folder));
    }


    public WebElement trashButtonFolder() {
        return driver.findElement(BoxPageLocators.trashButton());
    }

    public WebElement deleteFolderOkayButton() {
        return driver.findElement(BoxPageLocators.deleteFolderOkayButton);
    }

    public List<WebElement> notificationText() {
        return driver.findElements(BoxPageLocators.notificationText);
    }

    public WebElement deleteNotificationText() {
        return driver.findElement(BoxPageLocators.deleteNotif);
    }

    public List<WebElement> uploadButton() {
        return driver.findElements(BoxPageLocators.uploadButton);
    }

    public WebElement uploadFileButton() {
        return driver.findElement(BoxPageLocators.upload_FileButton);
    }

    public WebElement renameFileLink(String fileName) {
        return driver.findElement(BoxPageLocators.renameFileLink(fileName));
    }

    public WebElement renameFileInput() {
        return driver.findElement(BoxPageLocators.renameFileInput);
    }

    public WebElement fileMoreActions(String file) {
        return driver.findElement(BoxPageLocators.fileMoreActions(file));
    }

    public WebElement allFilesMenu() {
        return driver.findElement(BoxPageLocators.allFilesMenu);
    }

    public WebElement uploadProgressBar() {
        return driver.findElement(BoxPageLocators.uploadProgressBar);
    }

    public WebElement folderTitle(String folderName) {
        return driver.findElement(BoxPageLocators.folderTitle(folderName));
    }

    public WebElement trashButtonWithinFolder() {
        return driver.findElement(BoxPageLocators.trashButtonWithinFolder);
    }

    public WebElement createCollectionLink() {
        return driver.findElement(BoxPageLocators.createCollectionLink);
    }

    public WebElement renameCollection() {
        return driver.findElement(BoxPageLocators.renameCollection);
    }

    public WebElement collectionNameInput() {
        return driver.findElement(BoxPageLocators.collectionNameInput);
    }

    public WebElement collectionListInNav(String collectionName) {
        return driver.findElement(BoxPageLocators.collectionListInNav(collectionName));
    }

    public WebElement collectionMoreActions() {
        return driver.findElement(BoxPageLocators.collectionMoreActions);
    }

    public WebElement renameCollectionNameInput() {
        return driver.findElement(BoxPageLocators.renameCollectionNameInput);
    }

    public WebElement deleteCollection() {
        return driver.findElement(BoxPageLocators.deleteCollection);
    }

    public WebElement myCollections() {
        return driver.findElement(BoxPageLocators.myCollections);
    }

    public WebElement folderCollectionLink() {
        return driver.findElement(BoxPageLocators.folderCollectionLink);
    }

    public WebElement folderSelectCollection(String collectionName) {
        return driver.findElement(BoxPageLocators.folderSelectCollection(collectionName));
    }


}