package Page.BasePage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//span[text()='Войти']")
    private WebElement logInButton;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLogInButton() {
        waitElementIsClickable(logInButton).click();
    }
}
