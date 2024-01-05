package DriverAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverInitialize {   // Класс который служит для инициализации драйвера
                                  // Используем паттерн Singleton
    private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>(); //ThreadLocal нужен для обеспечения потокабезопасности
    private static DriverInitialize instance;

    private DriverInitialize() {}  // Private - чтобы запретить создавать объекты не через метод

    public static DriverInitialize getInstance() {  // Метод в котором происходит создание объекта
        if(instance == null)
            instance = new DriverInitialize();
        return instance;
    }

    public WebDriver getDriver() {
        if(localDriver.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);             //подтвердить небезопасное подключение
            options.addArguments("--remote-allow-origins=*");
            localDriver.set(new ChromeDriver(options));
        }
        WebDriver driver = localDriver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return driver;
    }

    public void quitDriver() {
        if(localDriver.get() != null) {
           localDriver.get().quit();
        }
        localDriver.remove();
    }
}
