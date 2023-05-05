import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GitHubTest { private WebDriver driver;

    @BeforeTest
    public void setUp(){
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Встановлюємо шлях до драйвера Chrome

    driver = new ChromeDriver(); // Ініціалізуємо драйвер Chrome

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
    }
}

