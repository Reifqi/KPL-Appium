
import java.net.MalformedURLException;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class calculatorTest extends base {
    
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        
        AndroidElement operator = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.EditText[2]");
        AndroidElement firstNumber = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.EditText[1]");
        AndroidElement secondNumber = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.EditText[3]");
        AndroidElement button = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button");
        //operasi tambah
        calculate(driver, operator, firstNumber, secondNumber, button, "+", "20", "10");
        
        //operasi kurang
        calculate(driver, operator, firstNumber, secondNumber, button, "-", "10", "5");
        
        //operasi kali
        calculate(driver, operator, firstNumber, secondNumber, button, "*", "25", "100");
        
        //Operasi pembagian
        calculate(driver, operator, firstNumber, secondNumber, button, "/", "100", "25");
        
        //desimal
        calculate(driver, operator, firstNumber, secondNumber, button, "/", "100", "29");
        
        //negatif
        calculate(driver, operator, firstNumber, secondNumber, button, "-", "25", "100");
        
        
        
        driver.quit();
    }
    
    public static void calculate(AndroidDriver<AndroidElement> driver, AndroidElement operator, AndroidElement firstNumber, AndroidElement secondNumber, AndroidElement button, String operation, String firstNum, String secondNum) {
        operator.click();
        operator.sendKeys(operation);
        
        firstNumber.click();
        firstNumber.sendKeys(firstNum);
        
        secondNumber.click();
        secondNumber.sendKeys(secondNum);
        
        button.click();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        operator.clear();
        firstNumber.clear();
        secondNumber.clear();
    }
    
}

