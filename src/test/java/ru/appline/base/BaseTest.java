package ru.appline.base;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.TestPropManager;


import static ru.appline.framework.utils.PropConst.BASE_URL;


public class BaseTest {

     // Менеджер страничек
    protected PageManager app = PageManager.getPageManager();
    private static final TestPropManager props = TestPropManager.getTestPropManager();

    // Менеджер WebDriver
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(props.getProperty(BASE_URL));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
