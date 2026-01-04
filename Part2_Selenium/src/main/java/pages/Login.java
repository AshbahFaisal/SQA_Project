package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login {
public Login(WebDriver d) {
PageFactory.initElements(d, this);
}
@FindBy(id="username")
public WebElement usernameBlock;
@FindBy(id="password")
public WebElement passwordBlock;
@FindBy(id="submit")
public WebElement submitButton;
}