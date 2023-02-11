import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorezationTest extends AbstractTest {
    @Test
    @Order(1)
    @DisplayName("Open site")
    void myActiontest() throws InterruptedException {
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://test-stand.gb.ru/login"));
        String URL = getWebDriver().getCurrentUrl(); //Проверяем урл главной страницы
        Assertions.assertEquals(URL, "https://test-stand.gb.ru/login");
    }

    @Test
    @Order(2)
    @DisplayName("Authorization")
        // @Description("Verification by a user with a valid login and password")
    void validAutorizationTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//a[text()='filolog999333']")).isDisplayed());
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickProfileLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickLogout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]")).isDisplayed());
    }

    @Test
    @Order(3)
    @DisplayName("Invalid credentials")
        //@Description("Authorization check with empty fields")
    void emptyFieldsTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h2[text()='401']")).isDisplayed());
    }

    @Test
    @Order(4)
    @DisplayName("Invalid credentials")
        //@Description("Authorization check with empty password field")
    void boundaryValuesTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h2[text()='401']")).isDisplayed());
    }


    @Test
    @Order(5)
    @DisplayName("Post page opens")
        //@Description("Check that after authorization a page with posts opens")
    void postsOpenAfterAuthorizationTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//div[@class='posts svelte-127jg4t']")).isDisplayed());
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickProfileLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickLogout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]")).isDisplayed());
    }
    @Test
    @Order(6)
    @DisplayName("Not valid login")
        //@Description("Login less than three characters expect the user is not authorized")
    void userMinLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername_ThoughtsLoginSize();
        loginPage.enterPassword_ThoughtsLoginSize();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h2[text()='401']")).isDisplayed());



        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickProfileLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickLogout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]")).isDisplayed());

    }
    @Test
    @Order(7)
    @DisplayName("Max Login Size")
        // @Description("Login more than twenty characters expect the user is not authorized")
    void userMaxLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername_MaxLoginSize();
        loginPage.enterPassword_MaxLoginSize();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h2[text()='401']")).isDisplayed());
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickProfileLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickLogout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]")).isDisplayed());
    }
    @Test
    @Order(8)
    @DisplayName("Login in Cyrillic")
        //@Description("Login is written in Cyrillic expect the user is not authorized")
    void cyrillicLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername_CyrillicLogin();
        loginPage.enterPassword_CyrillicLogin();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h2[text()='401']")).isDisplayed());
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickProfileLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickLogout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]")).isDisplayed());
    }
    @Test
    @Order(9)
    @DisplayName("Special characters in login")
        //@Description("There are special characters in login expect the user is not authorized")
    void specialCharactersTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername_SpecialCharactersLogin();
        loginPage.enterPassword_SpecialCharactersLogin();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h2[text()='401']")).isDisplayed());
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickProfileLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickLogout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]")).isDisplayed());
    }

}
