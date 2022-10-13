package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TaskPageObjects {

	By btn_addTask = By.xpath("//button[text()='Add Task']");
	By field_Search = By.id("search_menu");
	By txt_Search = By.xpath("//*[@id='search_menu']//input[@name='search[keywords]']");
	By btn_Search = By.xpath("//*[@id='search_menu']//input[@type='submit']");
	By dd_SelectProjectForNewTaskCreation = By.id("form_projects_id");
	By dd_taskType = By.id("tasks_tasks_type_id");
	By txt_taskName = By.id("tasks_name");
	By dd_taskStatus = By.id("tasks_tasks_status_id");
	By dd_taskPriority = By.id("tasks_tasks_priority_id");
	By dd_taskLabel = By.id("tasks_tasks_label_id");
	By dd_taskCreatedBy = By.id("tasks_created_by");
	By btn_save = By.xpath("//button[@type='submit' and text()='Save']");
	
	
	//Initialize  all page objects for given driver instances
			public TaskPageObjects(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

}
