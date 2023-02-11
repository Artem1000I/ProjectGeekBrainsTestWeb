package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    public LoginPage(WebDriver driver) {super(driver);}

    @FindBy(xpath =".//input[@type='text']" )
    private WebElement username;

    @FindBy(xpath =".//input[@type='password']" )
    private WebElement password;

    @FindBy(xpath = "/html/body/div/main/div/div/div[1]/form/div[3]")
    private WebElement buttonLogin;

    public LoginPage enterUsername(){
        username.sendKeys("filolog999333");
        return this;
    }
    public LoginPage enterPassword(){
        password.sendKeys("9ac26560f8");
        return this;
    }

    public LoginPage clickLoginButton(){
        buttonLogin.click();
        return this;
    }
    //Пользователь без постов
    public LoginPage enterUsername_UserNoPosts(){
        username.sendKeys("User without postst");
        return this;
    }
    public LoginPage enterPassword_UserNoPosts(){
        password.sendKeys("a8b2455385");
        return this;
    }
    //Граничные значения
    public LoginPage enterUsername_ThoughtsLoginSize(){
        username.sendKeys("Gr");
        return this;
    }
    public LoginPage enterPassword_ThoughtsLoginSize(){
        password.sendKeys("27791fb46b");
        return this;
    }
    public LoginPage enterUsername_MaxLoginSize(){
        username.sendKeys("qwertyuiopasdfghjklzxcvbnm");
        return this;
    }
    public LoginPage enterPassword_MaxLoginSize(){
        password.sendKeys("e5daaa90c3");
        return this;
    }

    //Невалидные значения
    public LoginPage enterUsername_CyrillicLogin(){
        username.sendKeys("Френк");
        return this;
    }
    public LoginPage enterPassword_CyrillicLogin(){
        password.sendKeys("aa94e6cbee");
        return this;
    }
    public LoginPage enterUsername_SpecialCharactersLogin(){
        username.sendKeys("ARt&#@");
        return this;
    }
    public LoginPage enterPassword_SpecialCharactersLogin(){
        password.sendKeys("6bd4b6ed70");
        return this;
    }
}
