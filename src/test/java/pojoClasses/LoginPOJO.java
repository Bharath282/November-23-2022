package pojoClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.test.BaseClass;

public class LoginPOJO extends BaseClass{
	//Non parametrized construction
public LoginPOJO() {
	PageFactory.initElements(driver, this);
}

//Private Webelements 
// WebElement email = driver.findElement(By.id("attribute value"));

@CacheLookup
@FindBy(id="email")
private WebElement emailTxt;


@CacheLookup
@FindBy(name="pass")
private WebElement passTxt;

@CacheLookup
@FindBy(name ="login")
private WebElement loginBtn;

public WebElement getEmailTxt() {
	return emailTxt;
}

public WebElement getPassTxt() {
	return passTxt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

}
