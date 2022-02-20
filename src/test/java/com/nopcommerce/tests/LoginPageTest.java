package com.nopcommerce.tests;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.util.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @BeforeClass
    public void loginPageSetup(){
       loginPage= homePage.goToLoginPage();
    }

    @Test(priority = 1)
    public void verifyLoginPageNameTest(){
        Assert.assertEquals(loginPage.getLoginPageName(), Constants.LOGINPAGE_NAME);

    }
@Test(priority = 2)
    public void verifyRegisterButtonStatus(){
        Assert.assertTrue(loginPage.verifyRegisterButtonStatus());
    }
    @Test(priority = 3)
    public void validateUserLoginTest() throws InterruptedException {
        HomePage homePage=loginPage.doLogin(prop.getProperty("id"), prop.getProperty("pass") );
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verifyLogoutLink());
    }

}

