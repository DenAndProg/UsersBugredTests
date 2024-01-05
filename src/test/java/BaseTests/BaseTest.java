package BaseTests;

import DriverAction.DriverInitialize;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {

    protected static DriverInitialize driverInitialize;

    @BeforeAll
    public static void setBeforeAll() {
        driverInitialize = DriverInitialize.getInstance();
    }

    /*@AfterAll
    public static void setAfterAll() {
        driverInitialize.quitDriver();
    }*/
}
