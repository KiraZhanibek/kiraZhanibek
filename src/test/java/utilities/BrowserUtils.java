package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    // for handle drop downs, actions
    //for explicit wait
    // write once, run everywhere

        public static void hover(WebElement element, WebDriver driver) {

            Actions actions = new Actions(driver);
            actions.moveToElement(element);


        }

        public static String getText(WebElement element) {
            return element.getText();

        }

        public static List<String> getElements(List<WebElement> elements) {
            List<String> textList = new ArrayList<>();

            for (WebElement el : elements) {
                if (!el.getText().isEmpty()) {
                    textList.add(el.getText());
                }
            }
            return textList;

        }

        public static void visibilityOfElement(WebDriver driver, WebElement element, int time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until((ExpectedConditions.visibilityOf(element)));
        }

        public static void swithchToWindow(String targetTitle, WebDriver driver) {
            String origin = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            for (String windows : allWindows) {
                driver.switchTo().window(windows);
                if (driver.getTitle().equals(targetTitle)) {
                    return;
                }
            }
            driver.switchTo().window(origin);
        }
    }


