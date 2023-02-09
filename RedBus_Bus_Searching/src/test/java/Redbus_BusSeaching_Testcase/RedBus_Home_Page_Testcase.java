package Redbus_BusSeaching_Testcase;

import org.testng.annotations.Test;

import RedBus.TestCompontents.RedBus_BaseTest;

public class RedBus_Home_Page_Testcase {

	@Test
	public static void Home_page()
	{
		RedBus_BaseTest base=new RedBus_BaseTest();
		base.gotoHome();
	}
}
