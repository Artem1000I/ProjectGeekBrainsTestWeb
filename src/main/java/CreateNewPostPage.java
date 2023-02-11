import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewPostPage extends AbstractPage{
    public CreateNewPostPage(WebDriver driver) {super(driver);}

    @FindBy(id = "create-btn")
    private WebElement createPost;

    @FindBy(xpath = ".//label[@class='mdc-text-field smui-text-field--standard']")
    private WebElement title;

    @FindBy(xpath = ".//textarea[@maxlength='100']")
    private WebElement description;

    @FindBy(xpath = ".//textarea[@aria-describedby='SMUI-textfield-helper-text-1']")
    private WebElement content;

    @FindBy(xpath = ".//input[@type='file']")
    private WebElement newImage;

    @FindBy(xpath = ".//span[text()='Save']")
    private WebElement save;

    public CreateNewPostPage createPost(){
        createPost.click();
        return this;
    }

    public CreateNewPostPage enterTitle(){
        title.sendKeys("Заголовок");
        return this;
    }
    public CreateNewPostPage enterDescriptions(){
        description.sendKeys("Описание");
        return this;
    }

    public CreateNewPostPage enterContents(){
        content.sendKeys("Содержание");
        return this;
    }

    public CreateNewPostPage imageUpload(){

        newImage.sendKeys("D:\\C ПЕРЕНОСНОГО ЖЁСТКОГО ДИСКА\\ВСЕ ФОТО\\Stancenation\\14038773770_3fe713ce17_o.jpg");
        return this;
    }

    public CreateNewPostPage savePost(){
        save.click();
        return this;
    }

}
