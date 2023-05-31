package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static Utils.CommonMethods.driver;

public class Task_20Page {
    public Task_20Page(){
        PageFactory.initElements(driver,this);
    }

    WebElement adminBtn = driver.findElement(By.id("menu_admin_viewAdminModule"));

    WebElement qualificationsBtn = driver.findElement(By.id("menu_admin_Qualifications"));

    WebElement languagesBtn = driver.findElement(By.id("menu_admin_viewLanguages"));

    WebElement actualText = driver.findElement(By.xpath("//h1[text()='Languages']"));


}
