package stepImpl;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.support.PageFactory;
import pages.OratorPage;
import java.util.List;
import static stepImpl.AndroidSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class TestSpec {

    @Step("Validate that the application can read the text <table>")
    public void oratorSpeakTest(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            OratorPage oratorPage = PageFactory.initElements(driver, OratorPage.class);
            oratorPage.speakTest(row.getCell(columnNames.get(0)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Step("Closing the driver")
    public void after(){
        driver.quit();
    }

}
