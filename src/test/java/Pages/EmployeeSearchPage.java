package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeSearchPage extends CommonMethods {

    public EmployeeSearchPage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="empsearch_id")
    public WebElement enpIdTextBox;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="empsearch_job_title")
    public WebElement jobTitleDdl;
}
