package BaseTests;

import BaseTests.BaseTest;
import Page.BasePage.LoginPage;
import Page.BasePage.StartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginPageTests extends BaseTest {

    private static StartPage startPage;
    private static LoginPage loginPage;

    @BeforeEach
    public void setBeforeEach() {
        WebDriver driver = driverInitialize.getDriver();
        driver.get("http://users.bugred.ru");
        startPage = new StartPage(driver);
        loginPage = new LoginPage(driver);
        startPage.clickLogInButton();
    }

    @Test
    @DisplayName("1 Регистрация нового пользователя")
    public void RegistrationNewUserTest() {
        loginPage.inputNameReg("Иван");
        loginPage.inputEmailReg("mailll2@gmail.com");
        loginPage.inputPasswordReg("111");
    }
}
