package ui;

import org.junit.AfterClass;
import ui.pages.DriverManager;

public class BaseTest {

    @AfterClass
    public static void close() {
        DriverManager.getInstance().quit();
    }
}
