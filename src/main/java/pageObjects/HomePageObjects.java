package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class HomePageObjects{

	By sidebarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']");

	//Initialize  all page objects for given driver instances
		public HomePageObjects(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

}
