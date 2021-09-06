import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;  
  
public class goibibo {
	public static void main(String[] args) throws InterruptedException 
    {  
        
    
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\shlovan\\Downloads\\chromedriver.exe");  
 
    WebDriver driver=new ChromeDriver();
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    
    driver.get("https://www.goibibo.com/");
    Thread.sleep(2000);
    
//SOURCE AND DESTINATION
WebElement from=driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
from.clear();
from.sendKeys("Delhi");
Thread.sleep(500);
from.sendKeys(Keys.ARROW_DOWN);
from.sendKeys(Keys.ENTER);

WebElement to=driver.findElement(By.xpath("//input[@id='gosuggest_inputDest' ]"));
to.clear();
to.sendKeys("Bengaluru");
Thread.sleep(500);
to.sendKeys(Keys.ARROW_DOWN);
to.sendKeys(Keys.ENTER);

    
//DATE
driver.findElement(By.xpath("//span[@role=\"button\" and @aria-label=\"Next Month\" ]")).click();
driver.findElement(By.xpath("//div[@id=\"fare_20210909\" ]")).click();
driver.findElement(By.xpath("//div[@id=\"pax_link_common\"]")).click();

//TRAVEL CLASS
WebElement tClass=driver.findElement(By.xpath("//select[@id='gi_class']"));
Select slt=new Select(tClass);
slt.selectByVisibleText("Business");


driver.findElement(By.xpath("//select[@class=\"custSelect width100 whiteBg padTB5 padLR10\" and @id=\"gi_class\"]")).click();
driver.findElement(By.xpath("//button[@id=\"gi_search_btn\"]")).click();

//FILTER DEPARTURE
driver.findElement(By.xpath("//span[text()='11am - 5pm']")).click();
driver.findElement(By.xpath("//span[text()='5pm - 9pm']")).click();

//PRICE
driver.findElement(By.xpath("//span[contains(text(),'PRICE')]")).click();

//VEIW FARES
List<WebElement> fares = driver.findElements(By.xpath("//button[@class='srp-card-uistyles__BookButton-sc-3flq99-21 gyWCJl dF justifyCenter alignItemsCenter']"));

//2ND HIGHEST PRICE
fares.get(1).click();

//FLIGHT NAME
String flights = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/span[1]")).getText();

System.out.println("Flight name :"+flights);
Thread.sleep(2000);

//OFFERS
List<WebElement> numOfOffers =driver.findElements(By.xpath("//span[@class='offersstyle__OfferValue-sc-4s1lmm-1 bNxOIc font12 drGrey fb']"));

System.out.println("Available Offers :"+numOfOffers.size());

}
}