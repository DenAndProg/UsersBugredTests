package Page.BasePage;

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

    @FindBy(xpath = "//form[@action='/user/register/index.html']/p")
    private WebElement prompt;

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

    @Step("Получить текст поля 'Имя' в форме регистрации")
    public String getTextOfName() {
        return waitElementVisibility(nameInputReg).getAttribute("value");
    }

    @Step("Получить текст поля 'Email' в форме регистрации")
    public String getTextOfEmail() {
        return waitElementVisibility(emailInputReg).getAttribute("value");
    }

    @Step("Получить текст поля 'Пароль' в форме регистрации")
    public String getTextOfPassword() {
        return waitElementVisibility(passwordInputReg).getAttribute("value");
    }

    @Step("Получить текст подсказки в форме регистрации")
    public String getTextOfPromptReg() {
        return waitElementVisibility(prompt).getText();
    }
}
