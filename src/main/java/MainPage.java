import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {super(driver);}


    @FindBy(xpath = ".//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']")
    private WebElement userProfile;

    @FindBy(xpath = ".//span[text()='Logout']")
    private WebElement userLogout;

    @FindBy(xpath = ".//a[text()='Next Page']")
    private WebElement nextPage;

    @FindBy(xpath = ".//a[text()='Previous Page']")
    private WebElement previousPage;

    @FindBy(xpath = ".//span[text()='Home']")
    private WebElement home;

    @FindBy(xpath = ".//div[@class='posts svelte-127jg4t']")
    private WebElement blockPosts;


    @FindBy(xpath = "(.//i[@aria-hidden='true'])[2]")
    private WebElement filterOrder;

    @FindBy(xpath = ".//button[@role='switch']")
    private WebElement filterNotMyPosts;

    @FindBy(xpath = ".//a[@href='/posts/11398']")
    private WebElement post;

    @FindBy(xpath = ".//button[text()='delete']")
    private WebElement deletePosts;
    public MainPage clickNextPage() {
        nextPage.click();
        return this;
    }
    public MainPage clickPreviousPage() {
        previousPage.click();
        return this;
    }
    public MainPage clickHome() {
        home.click();
        return this;
    }
    public MainPage clickOrder() {
        filterOrder.click();
        return this;
    }
    public MainPage clickNotMyPosts() {
        filterNotMyPosts.click();
        return this;
    }

    public MainPage clickPosts() {
        post.click();
        return this;
    }
    public MainPage clickProfileLogin() {
        userProfile.click();
        return this;
    }

    public MainPage clickLogout() {
        userLogout.click();
        return this;
    }

    public MainPage clickDeletePosts() {
        deletePosts.click();
        return this;
    }
}