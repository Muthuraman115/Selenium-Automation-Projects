package JQuery_components_testing;

import org.testng.annotations.Test;

import JQuery_components_testing_basetest.BaseTest_Data_Management;

public class Main_testing {
	
	@Test
	public void FileManager() throws InterruptedException
	{
		BaseTest_Data_Management file_manager=new BaseTest_Data_Management();
		file_manager.gotofilemanager();
	}
}
