package com.payoneer.cloud.box.constants;

import org.openqa.selenium.By;

public class BoxPageLocators {

    // Home page
    public static By boxLogo = By.className("box-logo");

    // Login page
    public static By loginButton = By.linkText("Log in");
    public static By loginContainer = By.cssSelector(".login-container");
    public static By userNameInput = By.id("login-email");
    public static By passwordInput = By.id("password-login");
    public static By loginSubmit = By.id("login-submit");
    public static By loginSubmitPassword = By.id("login-submit-password");
    public static By invalidCredMessage = By.xpath("//*[text()='  Invalid Login Credentials ok']");

    //User page
    public static By userAvatar = By.className("ProfileButton-avatar");
    public static By profileButton = By.cssSelector("[aria-label='Toggle account menu'");
    public static By logoutButton = By.cssSelector("[data-resin-target='logout'");
    public static By newButton = By.cssSelector("[data-resin-target='newmenubutton']");

    //Folder
    public static By new_FolderButton = By.cssSelector("[aria-label=\"Create a new Folder\"] span");
    public static By newFolderModal = By.cssSelector("[data-resin-feature='createfolder']");
    public static By newFolderName = By.name("folder-name");
    public static By folderPermissionDrpdown = By.name("invite-permission");
    public static By newFolderCreateButton = By.cssSelector("[data-resin-target='primarybutton']");
    public static By newFolderCancelButton = By.cssSelector("[data-resin-feature='cancel']");

    public static By openFolder(String folder) {
        return By.cssSelector("[data-resin-feature='cancel']");
    }

    public static By folderTitle(String folderTitle) {
        return By.xpath("//*[@data-testid='item-list-breadcrumb-list']//h1[contains(@class,'page-title') and text()='" + folderTitle + "']");
    }

    public static By folderSelectCollection(String collectionName) {
        return By.cssSelector("[title='" + collectionName + "'] input");
    }

    public static By folderCollectionLink = By.cssSelector("[aria-label=\"Collections\"]");


    //Table Listing
    public static By newFolderTableListing(String folderName) {
        return By.xpath("//*[@data-resin-target=\"openfolder\" and text()='" + folderName + "']");
    }

    public static By renameFolderLink(String folderName) {
        return By.xpath("//a[text()='" + folderName + "']/parent::div/following-sibling::button[@data-resin-target='rename']");
    }

    public static By collectionFav = By.xpath("//*[text()='Favorites']");


    // Rename folder
    public static By renameModal = By.cssSelector(".modal.RenameModal");
    public static By renameInputField = By.name("itemName");
    public static By renameFolderSave = By.cssSelector("[data-resin-target='primarybutton']");


    //More actions - Folder
    public static By folderMoreActionsLink(String folderName) {
        return By.xpath("(//a[text()='" + folderName + "']/parent::div/../../../../following-sibling::div[contains(@class,'file-list-actions')]//button)[1]");
    }

    public static By trashButton() {
        return By.cssSelector(".menu-item.TrashMenuItem span");
    }


    //Delete Folder actions
    public static By deleteFolderOkayButton = By.cssSelector("[data-resin-target='primarybutton']");

    //Notification toast
    public static By notificationText = By.xpath("//*[contains(@class,'notification-enter-done']");
    public static By deleteNotif = By.xpath("//*[text()='Item successfully moved to trash.']");

    public static By renameNotif(String renamedFolder) {
        return By.xpath("//*[text()='The folder has been renamed to " + renamedFolder + ".']");
    }

    //Upload file
    public static By uploadButton = By.cssSelector("[data-resin-target='uploadmenubutton']");
    public static By upload_FileButton = By.xpath("(//*[@class='menu-item UploadMenuItem']/span)[1]");

    public static By newFileTableListing(String fileName) {
        return By.xpath("//*[@data-resin-target='openfile' and text()='" + fileName + "']");
    }

    public static By uploadProgressBar = By.xpath("//span[text()='Completed']");

    //File operations
    public static By renameFileLink(String fileName) {
        return By.xpath("//a[text()='" + fileName + "']/parent::span/../following-sibling::button[@data-resin-target='rename']");
    }

    public static By renameFileInput = By.name("itemName");

    public static By fileMoreActions(String fileName) {
        return By.xpath("(//a[text()='" + fileName + "']/ancestor::div[@aria-describedby=\"table-header-name\"]//following-sibling::div[contains(@class,'file-list-actions')]//button)[1]");
    }

    public static By fileWithinFolder(String file, String folder) {
        return By.xpath("//h1[text()='" + folder + "']/ancestor::div[@role=\"presentation\"]/following-sibling::div//a[@data-resin-target=\"openfile\" and text()='" + file + "']");
    }

    public static By trashButtonWithinFolder = By.cssSelector("[aria-label='Trash']");

    //Menu
    public static By allFilesMenu = By.cssSelector("[data-resin-target='allfiles']");

    //Collection Operations
    public static By createCollectionLink = By.cssSelector("[data-resin-target='createcollection']");
    public static By createCollectionModal = By.cssSelector(".modal.CreateCollectionModal");
    public static By collectionNameInput = By.xpath("//span[text()='Create a Collection']/ancestor::div[@class='modal-header']/following-sibling::div//input");

    public static By collectionListInMenu(String collectionName) {
        return By.xpath("//*[@class='CollectionNavItem']//span[text()='" + collectionName + "']");
    }

    public static By collectionListInNav(String collectionName) {
        return By.xpath("//*[@data-testid=\"collections-page\"]//a[text()='" + collectionName + "']");
    }

    public static By collectionMoreActions = By.cssSelector("[aria-label=\"More Options\"]");
    public static By renameCollection = By.cssSelector("[data-testid=\"renamecollection\"]");
    public static By deleteCollection = By.cssSelector("[data-testid=\"deletecollection\"]");
    public static By renameCollectionNameInput = By.xpath("//span[contains(text(),'Rename')]/ancestor::div[@class='modal-header']/following-sibling::div//input");
    public static By myCollections = By.xpath("//span[@class='MyCollectionsNavItem-label']//ancestor::a");
}