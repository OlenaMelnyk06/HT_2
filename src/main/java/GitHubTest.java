import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GitHubTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alyona\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chrome-driver\\4.6.0"); // Встановлюємо шлях до драйвера Chrome

        WebDriver driver = new ChromeDriver();// Ініціалізуємо драйвер Chrome

    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); // Встановлюємо таймаут на пошук елементів
    }
    @Test
    public void testGitHub() {
        driver.get("https://github.com/login"); // Відкриваємо посилання на сторінку логіну

        WebElement loginField = driver.findElement(By.id("login_field"));
        WebElement passwordField = driver.findElement(By.id("password"));

        loginField.sendKeys("OlenaMelnyk06");
        passwordField.sendKeys("Goodomens06");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        driver.get("https://github.com/search?q=HT_2&type=Repositories"); // Переходимо до проекту HT_2
        WebElement projectLink = driver.findElement(By.xpath("//a[@href='/OlenaMelnyk06/HT_2']"));
        projectLink.click();

        WebElement pomLink = driver.findElement(By.xpath("//a[@href='/OlenaMelnyk06/HT_2/blob/master/pom.xml']"));
        pomLink.click();

        WebElement pomContent = driver.findElement(By.cssSelector("#readme article"));
        String pomText = pomContent.getText();
        System.out.println(pomText); // Отримуємо версії бібліотек з файлу pom.xml та виводимо їх в консоль

        Assert.assertTrue(pomText.contains("<artifactId>testing</artifactId>\n    <version>7.4.0</version>"));
    }
    @AfterTest
    public void tearDown() {
        // Закриваємо браузер
        driver.quit();
    }
}

