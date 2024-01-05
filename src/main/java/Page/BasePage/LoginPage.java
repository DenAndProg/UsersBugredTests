package Page.BasePage;

import Page.BasePage.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name = 'name']")
    private WebElement nameInputReg;

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement emailInputReg;

    @FindBy(xpath = "//input[@name = 'email']/../../following-sibling::tr[1]//input")
    private WebElement passwordInputReg;

    @FindBy(xpath = "//input[@value='Зарегистрироваться']")
    private WebElement registrationButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        waitElementIsClickable(registrationButton).click();
    }

    @Step("Ввод текста в поле 'Имя' в форме регистрации")
    public void inputNameReg(String text) {
        waitElementVisibility(nameInputReg).sendKeys(text);
    }

    @Step("Ввод текста в поле 'Email' в форме регистрации")
    public void inputEmailReg(String text) {
        waitElementVisibility(emailInputReg).sendKeys(text);
    }

    @Step("Ввод текста в поле 'Пароль' в форме регистрации")
    public void inputPasswordReg(String text) {
        waitElementVisibility(passwordInputReg).sendKeys(text);
    }
}
