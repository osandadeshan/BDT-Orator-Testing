package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Osanda on 5/14/2017.
 */

public class OratorPage {

    @FindBy(how= How.ID, using="maxsoft.osanda.com.oratortextreader:id/txtText")
    WebElement txtField;
    @FindBy(how= How.ID, using="maxsoft.osanda.com.oratortextreader:id/btnSpeak")
    WebElement speakButton;

    public void speakTest(String text){
        txtField.sendKeys(text);
        speakButton.click();
    }

}
