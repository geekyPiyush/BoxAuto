package com.payoneer.cloud.box.steps;

import com.payoneer.cloud.box.commons.drivers.DriverManager;
import com.payoneer.cloud.box.commons.factory.DataFactory;
import com.payoneer.cloud.box.commons.helpers.*;
import com.payoneer.cloud.box.commons.state.AppState;
import com.payoneer.cloud.box.constants.BoxPageLocators;
import com.payoneer.cloud.box.pageobjects.SignInPageObject;
import com.payoneer.cloud.box.pageobjects.UserDashboardPageObject;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class UserDashboardPageStepDefs {

    private WebDriver driver;
    private SignInPageObject signInPageObject;
    private UserDashboardPageObject userDashboardPageObject;
    private AppState appState;

    public UserDashboardPageStepDefs(AppState sharedState) {
        DriverManager.addDriverIfNull();
        // gets the web driver
        driver = DriverManager.getDriver();
        signInPageObject = new SignInPageObject(driver);
        userDashboardPageObject = new UserDashboardPageObject(driver);
        appState = new AppState();
    }

    @And("I click on Logout button$")
    public void i_click_logout_button() {
        driver.manage().deleteAllCookies();
        userDashboardPageObject.profileButton().click();
        userDashboardPageObject.logoutButton().click();
    }

    @And("I go to All Files$")
    public void i_goto_all_files() {
        Button.safeClick(driver,userDashboardPageObject.allFilesMenu());
    }

    @And("I verify user is logged out of system$")
    public void i_verify_user_logged_out() {
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.loginContainer), "-- Login page should be present --");
    }

    @And("I create a new folder$")
    public void i_create_a_new_folder(){
        String folderName = RandomGen.generateRandomAlphanumericString(10);
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionFavoriteLink(),10);

        Button.safeClick(driver, userDashboardPageObject.newButton());
        Button.safeClick(driver, userDashboardPageObject.new_FolderButton());
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.newFolderModal), "-- New folder popup to be displayed --");
        InputTextHelper.sendKeys(driver, userDashboardPageObject.newFolderName(), folderName);

        //Store folder name for further actions
        appState.setFolderName(folderName);

        //Set folder permission
        Select select = new Select(userDashboardPageObject.folderPermissionDrpdown());
        select.selectByVisibleText("Editor");

        //Create folder
        Button.safeClick(driver, userDashboardPageObject.newFolderCreateButton());
    }

    @And("I rename an existing folder$")
    public void i_rename_folder(){
        String folderName = appState.getFolderName();
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionFavoriteLink(),10);

        Button.safeClick(driver, userDashboardPageObject.renameFolderLink(folderName));
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.renameModal), "-- Rename folder popup to be displayed --");

        String renameFolderName = RandomGen.generateRandomAlphanumericString(8);
        InputTextHelper.sendKeys(driver, userDashboardPageObject.renameFolderInput(), renameFolderName);

        Button.safeClick(driver,userDashboardPageObject.renameFolderSave());

        //Store folder name for further actions
        appState.setFolderName(renameFolderName);
    }

    @And("I delete an existing ([^\"]*)$")
    public void i_delete_folder_from_application(String dataType){
        String data;
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionFavoriteLink(),10);
        if(dataType.equalsIgnoreCase("folder")) {
            data = appState.getFolderName();
            Button.safeClick(driver, userDashboardPageObject.folderMoreActionsLink(data));
        }else{
            data = appState.getFileName();
            Button.safeClick(driver, userDashboardPageObject.fileMoreActions(data));
        }

        Button.safeClick(driver,userDashboardPageObject.trashButtonFolder());
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.deleteFolderOkayButton), "-- Delete " + dataType + " popup to be displayed --");

        Button.safeClick(driver,userDashboardPageObject.deleteFolderOkayButton());
    }

    @And("I should see created/updated folder listed in table list$")
    public void i_verify_folder_listed() {
        String folder = appState.getFolderName();
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.newFolderTableListing(folder)), "-- Folder should be listed --");
    }

    @And("I should see ([^\"]*) deleted from table list$")
    public void i_verify_folder_deleted_from_list(String dataType){
        String data;
        if(dataType.equalsIgnoreCase("folder")) {
            data = appState.getFolderName();
        }else
            data = appState.getFileName();
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.deleteNotificationText(),10);
        Assert.assertFalse(ElementVisibility.isElementPresent(driver, BoxPageLocators.newFolderTableListing(data)), "-- " + dataType + " should not be listed --");
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(BoxPageLocators.deleteNotif));
    }

    @And("I upload a new file with ([^\"]*) extension$")
    public void i_upload_a_new_file(String extension) throws InterruptedException {
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionFavoriteLink(),10);

        List<WebElement> uploads = userDashboardPageObject.uploadButton();
        Button.safeClick(driver, uploads.get(0));
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.uploadFileButton(),2);
        userDashboardPageObject.uploadFileButton().click();

        Thread.sleep(2000);
        List<String> fileData = DataFactory.getRequestedDataFile(extension);
        UploadItem.uploadItemToApplication(fileData.get(0));

        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.uploadProgressBar(),20);

        //Set file name for further actions
        appState.setFileName(fileData.get(1));
        appState.setFileExt(extension);
    }

    @And("I open the new folder$")
    public void i_open_new_folder() {
        String folderName= appState.getFolderName();
        userDashboardPageObject.newFolderTableListing(folderName).click();
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.folderTitle(folderName),3);
    }

    @And("I should see uploaded/updated file listed in table list$")
    public void i_verify_file_listed() {
        String fileName = appState.getFileName();
        Assert.assertTrue(ElementVisibility.isElementPresent(driver,BoxPageLocators.newFileTableListing(fileName)),"-- File should be uploaded -- ");
    }

    @And("I rename an existing file$")
    public void i_rename_file(){
        String fileName = appState.getFileName();

        Button.safeClick(driver, userDashboardPageObject.renameFileLink(fileName));
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.renameModal), "-- Rename file popup to be displayed --");

        String renameFileName = fileName + RandomGen.generateRandomAlphanumericString(8);
        InputTextHelper.sendKeys(driver, userDashboardPageObject.renameFileInput(), renameFileName);

        Button.safeClick(driver,userDashboardPageObject.renameFolderSave());

        //Store folder name for further actions
        appState.setFileName(renameFileName + "." + appState.getFileExt());
    }

    @And("I should ([^\"]*) uploaded file in folder$")
    public void i_see_notsee_uploaded_file_in_folder(String visible) throws InterruptedException {
        String fileName = appState.getFileName();
        String folderName = appState.getFolderName();

        Thread.sleep(5000);
        userDashboardPageObject.allFilesMenu().click();
        i_open_new_folder();
        if(visible.equalsIgnoreCase("see"))
            Assert.assertTrue(ElementVisibility.isElementPresent(driver,BoxPageLocators.fileWithinFolder(fileName,folderName)));
        else
            Assert.assertFalse(ElementVisibility.isElementPresent(driver,BoxPageLocators.fileWithinFolder(fileName,folderName)));
    }

    @And("I delete a ([^\"]*) from folder$")
    public void i_delete_from_folder_some_data(String dataType) {
        String data;
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionFavoriteLink(),10);
        if(dataType.equalsIgnoreCase("folder")) {
            data = appState.getFolderName();
        }else{
            data = appState.getFileName();
        }

        Button.safeClick(driver,userDashboardPageObject.trashButtonWithinFolder());
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.deleteFolderOkayButton), "-- Delete " + dataType + " popup to be displayed --");

        Button.safeClick(driver,userDashboardPageObject.deleteFolderOkayButton());
    }

    @And("I create a new collection$")
    public void i_create_a_new_collection() throws InterruptedException {
        String collectionName = "Collection_" + RandomGen.generateRandomAlphanumericString(5);
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionFavoriteLink(),10);

        Button.safeClick(driver, userDashboardPageObject.createCollectionLink());

        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.createCollectionModal), "-- New collection popup to be displayed --");
        InputTextHelper.sendKeys(driver, userDashboardPageObject.collectionNameInput(), collectionName);

        //Store collection name for further actions
        appState.setCollectionName(collectionName);

        //Create collection button
        Button.safeClick(driver,userDashboardPageObject.newFolderCreateButton());
    }

    @And("I verify added/updated collection visible in nav list$")
    public void i_verify_collection_in_nav() {
        String collectionName = appState.getCollectionName();
        Assert.assertTrue(ElementVisibility.isElementPresent(driver,BoxPageLocators.collectionListInMenu(collectionName)),"-- Collection should be created -- ");
    }

    @And("I rename an existing collection")
    public void i_rename_collection() throws InterruptedException {
        String collectionName = appState.getCollectionName();

        Thread.sleep(2000);
        Button.safeClick(driver,userDashboardPageObject.myCollections());
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionListInNav(collectionName),5);

        Button.safeClick(driver, userDashboardPageObject.collectionListInNav(collectionName));
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionMoreActions(),5);

        Button.safeClick(driver,userDashboardPageObject.collectionMoreActions());

        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.renameCollection(),5);
        Button.safeClick(driver,userDashboardPageObject.renameCollection());

        //Assert.assertTrue(ElementVisibility.isElementPresent(driver,BoxPageLocators.renameModal),"-- Rename Collection should be displayed -- ");

        String renameCollectionName = collectionName + RandomGen.generateRandomAlphanumericString(8);
        InputTextHelper.clearAndSendKeys(driver, userDashboardPageObject.renameCollectionNameInput(), renameCollectionName);

        Button.safeClick(driver,userDashboardPageObject.renameFolderSave());

        //Store folder name for further actions
        appState.setCollectionName(renameCollectionName);
    }

    @And("I delete an added collection$")
    public void i_delete_a_collection(){
        String collectionName = appState.getCollectionName();

        Button.safeClick(driver,userDashboardPageObject.myCollections());
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionListInNav(collectionName),5);

        Button.safeClick(driver,userDashboardPageObject.collectionListInNav(collectionName));
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionMoreActions(),5);

        Button.safeClick(driver,userDashboardPageObject.collectionMoreActions());
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.deleteCollection(),5);

        Button.safeClick(driver,userDashboardPageObject.deleteCollection());
        Assert.assertTrue(ElementVisibility.isElementPresent(driver, BoxPageLocators.deleteFolderOkayButton), "-- Delete collection popup to be displayed --");

        Button.safeClick(driver,userDashboardPageObject.deleteFolderOkayButton());
    }

    @And("I verify collection deleted from nav$")
    public void i_verify_collection_deleted(){
        String collectionName = appState.getCollectionName();
        Assert.assertFalse(ElementVisibility.isElementPresent(driver,BoxPageLocators.collectionListInNav(collectionName)),"-- Collection should be not present -- ");
    }

    @And("I add folder to an existing collection$")
    public void i_add_folder_to_collection() throws InterruptedException {
        String collectionName = appState.getCollectionName();
        String folderName = appState.getFolderName();
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.folderTitle(folderName),5);

        userDashboardPageObject.folderCollectionLink().click();
        userDashboardPageObject.folderSelectCollection(collectionName).click();
    }

    @And("I verify folder added to collection$")
    public void i_verify_folder_added_to_collection(){
        String collectionName = appState.getCollectionName();
        String folderName = appState.getFolderName();

        Button.safeClick(driver,userDashboardPageObject.myCollections());
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionListInNav(collectionName),5);

        Button.safeClick(driver, userDashboardPageObject.collectionListInNav(collectionName));
        ElementVisibility.waitUntilElementIsDisplayed(driver,userDashboardPageObject.collectionMoreActions(),5);

        Assert.assertTrue(ElementVisibility.isElementPresent(driver,BoxPageLocators.newFolderTableListing(folderName)),"-- Folder should be added to collection -- ");
    }
}