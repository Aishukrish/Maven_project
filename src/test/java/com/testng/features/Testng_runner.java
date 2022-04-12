package com.testng.features;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Configuration.helper.File_Reader_Manager;
import com.Runner.Runner_Class;
import com.base.Base_Class;
import com.helper.Page_object_Manager_Adactin;

public class Testng_runner extends Base_Class{
	public static WebDriver driver=browser_Configuration("chrome");//---->null
	public static Page_object_Manager_Adactin pom1= new Page_object_Manager_Adactin(driver);
	public static Logger Log= Logger.getLogger(Runner_Class.class);
		@Test(priority = -2)
		private void logger_implementation() {
			PropertyConfigurator.configure("log4j.properties");
		}
		
		@Test(priority = -1)
		private void launch_url() throws Throwable {
			String url=File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_Url();
			getUrl(url);
			Log.info("Adactin Page Launch");
		}
		@Test(priority = 0)
		private void credentials() throws Throwable {
			inputValueElement(pom1.get_instance_Hp().getUsername(), File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_username());
			inputValueElement(pom1.get_instance_Hp().getPassword(),File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_Password());
			clickOnElement(pom1.get_instance_Hp().getLogin_btn());
			Log.info("Sign_in Successfully");
			

		}
		//search hotel
		@Test(priority = 1)
		private void search_hotel() 
		{
			dropdown("byText",pom1.get_instance_Hs().getLocation(), "London");
			dropdown("byText", pom1.get_instance_Hs().getHotel(),"Hotel Sunshine");
			dropdown("byValue", pom1.get_instance_Hs().getRoom(), "Super Deluxe");
			dropdown("byIndex", pom1.get_instance_Hs().getNo(), "2");
			dropdown("byText", pom1.get_instance_Hs().getAdult(), "2 - Two");
			dropdown("byIndex", pom1.get_instance_Hs().getChild(),"0");
			clickOnElement(pom1.get_instance_Hs().getSearch());
			Log.info("Hotel Searched");
			

		}
		@Test(priority = 2)
		private void select_hotel() {
			clickOnElement(pom1.get_instance_Hs1().getSel());
			clickOnElement(pom1.get_instance_Hs1().getCon());
			Log.info("Hotel Selected");
			
		}
		@Test(priority = 3)
		private void booking_details() throws IOException {
			inputValueElement(pom1.get_instance_Bp().getFname(), File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_firstname());
			inputValueElement(pom1.get_instance_Bp().getLname(), File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_lastname());
		    inputValueElement(pom1.get_instance_Bp().getAddress(),File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_address());	
		    inputValueElement(pom1.get_instance_Bp().getCard(),File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_ccnum());
		    dropdown("byText", pom1.get_instance_Bp().getType(), "Master Card");
		    dropdown("byIndex", pom1.get_instance_Bp().getExpiry(), "10");
		    dropdown("byValue",pom1.get_instance_Bp().getYear(), "2022");
		    inputValueElement(pom1.get_instance_Bp().getCvv(), File_Reader_Manager.get_Instance_frm().get_Instance_CR().get_Config_cvv());
		    clickOnElement(pom1.get_instance_Bp().getBook());
		    Log.info("Hotel Booked");


		}
		@Test(priority = 4)
		private void log_out() {
			clickOnElement(pom1.get_instance_lo().getLogout());
		    Log.info("Log Out Successfully");
			
		}
		
	
	
		


	}

