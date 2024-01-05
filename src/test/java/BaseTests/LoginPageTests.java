package BaseTests;

import BaseTests.BaseTest;
import Page.BasePage.LoginPage;
import Page.BasePage.StartPage;
import Utils.GeneratedString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTests extends BaseTest {

    private static StartPage startPage;
    private static LoginPage loginPage;
    private static String name = GeneratedString.generatedString();
    private static String email = GeneratedString.generatedString() + "@gmail.com";

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
        loginPage.inputNameReg(name);
        loginPage.inputEmailReg(email);
        loginPage.inputPasswordReg("111");
        assertAll("Проверка введеных данных в полях",
                () -> assertEquals(loginPage.getTextOfName(), name,
                        "Неверно заполнено поле 'Имя'"),
                () -> assertEquals(loginPage.getTextOfEmail(), email,
                        "Неверно заполнено поле 'Email'"),
                () -> assertEquals(loginPage.getTextOfPassword(), "111",
                        "Неверно заполнено поле 'Пароль'")
        );
        loginPage.clickRegistrationButton();
        assertEquals(loginPage.getUrlOnPage(), "http://users.bugred.ru/user/login/index.html");
    }

    @Test
    @DisplayName("4 Регистрация существующего пользователя")
    public void AuthorizationTest() {
        loginPage.inputNameReg(name);
        loginPage.inputEmailReg(email);
        loginPage.inputPasswordReg("111");
        assertEquals(loginPage.getTextOfName(), name,
                "Неверно заполнено поле 'Имя'");
        assertEquals(loginPage.getTextOfEmail(), email,
                "Неверно заполнено поле 'Email'");
        assertEquals(loginPage.getTextOfPassword(), "111",
                "Неверно заполнено поле 'Пароль'");
        loginPage.clickRegistrationButton();
        assertEquals(loginPage.getTextOfPromptReg(), "Занят (name)",
                "Неверный текст подсказки");
        loginPage.inputNameReg(GeneratedString.generatedString());
        assertEquals(loginPage.getTextOfName(), name,
                "Неверно заполнено поле 'Имя'");
        loginPage.clickRegistrationButton();
    }
}
