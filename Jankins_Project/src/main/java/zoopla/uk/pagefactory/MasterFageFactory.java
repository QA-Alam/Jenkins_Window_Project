package zoopla.uk.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zoopla.uk.baseclass.SuperClass;

public class MasterFageFactory extends SuperClass {

	public MasterFageFactory() {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//*[@id='cookie-consent-form']/div/div/div/button[2]")
	private WebElement accepetCookis;
	
	public WebElement getAccepetCookis() {
		return accepetCookis;
	}
	
	@FindBy(xpath = "//*[@id='bhome']/div[2]/div/div/div/header/div/div/div[1]/div/ul/li[4]/a")
	private WebElement clickOnsigninbutton;
	
	public WebElement getclickOnsigninbutton() {
		return clickOnsigninbutton;
	}
	
	
	
}
