import PageObject.CreateNewPostPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MainTest extends AbstractTest{
    @Test
    @DisplayName("Page transitions")
  //  @Description("Checking the page forward and backward buttons")
    void pageNavigationTest ()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickNextPage();
        mainPage.clickNextPage();
        mainPage.clickPreviousPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String URL1 = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(URL1, "https://test-stand.gb.ru/?page=2" );
    }

    //Проверка возвращения на первую страницу при нажатии кнопки home
    @Test
    @DisplayName("Home button")
    //@Description("Check that when you click on the home button, you return to the first page")
    void buttonHomeTest ()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickNextPage();
        mainPage.clickNextPage();
        mainPage.clickNextPage();
        mainPage.clickHome();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//h2[text()='Пост 15']")).isDisplayed());
    }


    @Test
    @DisplayName("Order button")
   // @Description("Check that when you click the Order button on the page, the first crated post will be displayed")
            void filterOrderTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickOrder();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//img[@src='http://test-stand.gb.ru/files/public/image/45886eac2fb535403b1283f7aea670a8.jpg']")).isDisplayed());
    }

    @Test
    @DisplayName("Button Not my Posts")
   // @Description("Check that when you click the Not my Posts button on the page, other people`s posts will be displayed  ")
    void filterNotMyPostsTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickNotMyPosts();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//img[@src='http://test-stand.gb.ru/files/public/image/db35ea9efad77a1aebdb51417125ce60.png']")).isDisplayed());
    }



    @Test
    @DisplayName("Post content")
    //@Description("Check post content for title description content and image")
    void postTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div[1]/a[1]/div")).isDisplayed());
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.clickPosts();
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h1[text()='Пост 15']")).isDisplayed());
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//div[text()='Содержание поста 15']")).isDisplayed());
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//img")).isDisplayed());
    }

    @Test
    @DisplayName("User without Posts")
   // @Description("Check user without posts on the page displays No items for your filter")
    void userNotPostsTest ()throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername_UserNoPosts();
        loginPage.enterPassword_UserNoPosts();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//p[text()='No items for your filter']")).isDisplayed());
    }
    //Проверить что у пользователя без постов созданный пост отображается на странице и пост можно удалить
    @Test
    @DisplayName("Creating a post")
    //@Description("We check that the created posts and it can be deleted0")
    void userNoPostsTest_createNewPost ()throws InterruptedException {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername_UserNoPosts();
        loginPage.enterPassword_UserNoPosts();
        loginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CreateNewPostPage createNewPostPage = new CreateNewPostPage(getWebDriver());
        createNewPostPage.createPost();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createNewPostPage.enterTitle();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createNewPostPage.enterDescriptions();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createNewPostPage.enterContents();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createNewPostPage.imageUpload();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createNewPostPage.savePost();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//h1[text()='Заголовок']")).isDisplayed());
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//div[text()='Содержание']")).isDisplayed());
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//img")).isDisplayed());
        MainPage mainPage= new MainPage(getWebDriver());
        mainPage.clickDeletePosts();
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//p[text()='No items for your filter']")).isDisplayed());
    }










}
