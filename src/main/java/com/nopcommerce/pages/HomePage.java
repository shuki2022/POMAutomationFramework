package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    //1.Capture elements on the page by its locators- Object Repository

/*@FindBy(xpath ="//img[@alt='nopCommerce demo store']")
    WebElement logo;

@FindBy(linkText = "Register")   //directly provided locator
    WebElement RegisterLink;

public HomePage(){
    PageFactory.initElements(driver, this);
}

 */

    private By logo = By.xpath("//img[@alt='nopCommerce demo store']");
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Log in");
    private By wishListLink = By.linkText("Wishlist;");
    private By ShoppingCart = By.linkText("Shopping cart");
    private By searchField = By.id("small-searchterms");
    private By searchBtn = By.xpath("//button[text()='Search']");
    private By myAccountLink =By.linkText("My account");
    private By logoutLink =By.linkText("Log out");

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
       elementUtil= new ElementUtil(driver);
    }

    //2. method that performs action on the element
    public boolean verifyLogo() {
       // return driver.findElement(logo).isDisplayed();
        return elementUtil.doIsDisplayed(logo);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean verifyRegisterLink() {
       // return driver.findElement(registerLink).isDisplayed();
return elementUtil.doIsDisplayed(registerLink);
    }

    public RegisterPage goToRegisterPage() {
        //driver.findElement(registerLink).click();
        elementUtil.doClick(registerLink);
        return new RegisterPage(driver);
    }

    public boolean verifyLoginLink() {
       // return driver.findElement(loginLink).isDisplayed();
        return elementUtil.doIsDisplayed(loginLink);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public boolean verifyMyAccountLink(){
        return driver.findElement(myAccountLink).isDisplayed();
    }

    public boolean verifyLogoutLink(){
       // return driver.findElement(logoutLink).isDisplayed();
        return elementUtil.doIsDisplayed(logoutLink);
     }

     public SearchPage doSearch(String key){
        elementUtil.doSendKeys(searchField,key);
        elementUtil.doClick(searchBtn);
        return new SearchPage(driver);
     }

}

