package com.doctorDetails;

import org.json.JSONArray;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DoctorDashboardTest {
	
	GetDoctorDashboard docInfo = new GetDoctorDashboard();
	JSONArray json = new JSONArray();
	
	
	
	@Test(dataProvider ="validInput")
	public void retrieveDoctorInfoUsingValidInput(String name,String speciality,String area,String review,String gender,String insurance,String ExpectedResult)
	{
		
		//get details order : name,speciality,area,review,gender,insurance
	json=docInfo.getDoctorDetails(name,speciality,area,review,gender,insurance);
	
		String obtainedResult=null;
		
		for(int i=0;i<json.length();i++)
		{
		obtainedResult=	json.get(i).toString();
		}
	
		Assert.assertTrue(obtainedResult.equals(ExpectedResult));
		
	}
	
	
	@Test(dataProvider ="invalidInput")
	public void retrieveDoctorInfoUsingInvalidInput(String name,String speciality,String area,String review,String gender,String insurance,String ExpectedResult)
	{
		
		//get details order : name,speciality,area,review,gender,insurance
	json=docInfo.getDoctorDetails(name,speciality,area,review,gender,insurance);
	
	String obtainedResult=null;
	
	
	
	obtainedResult=	json.toString();
	
	System.out.println(obtainedResult);
	
	

	Assert.assertTrue(obtainedResult.equals(ExpectedResult));
		
	}
	
	@Test(dataProvider ="doctorName")
	public void retrieveDoctorInfoUsingName(String doctorName,String ExpectedResult)
	{
		
		//get details order : name,speciality,area,review,gender,insurance
	json=docInfo.getDoctorDetails(doctorName, null, null, null,null,null);
	
		String obtainedResult=null;
		
		for(int i=0;i<json.length();i++)
		{
		obtainedResult=	json.get(i).toString();
		}
	
		Assert.assertTrue(obtainedResult.equals(ExpectedResult));
		
	}
	
	
	
	
	@DataProvider(name = "doctorName")
	   public static Object[][] doctorName() {
	      return new Object[][] {{"Neeshit Parkeen","{\"Area\":\"San Jose\",\"Speciality\":\"Eye Doctor\",\"Insurance\":\"BLUESHIELD\",\"Gender\":\"Female\",\"Name\":\"Neeshit Parkeen\",\"Ratings\":3}"}};
	   }

	@DataProvider(name = "validInput")
	   public static Object[][] validInput() {
	      return new Object[][] {{"Neeshit","eye", "san jose", "3","female","Blueshield","{\"Area\":\"San Jose\",\"Speciality\":\"Eye Doctor\",\"Insurance\":\"BLUESHIELD\",\"Gender\":\"Female\",\"Name\":\"Neeshit Parkeen\",\"Ratings\":3}"}};
	   }
	@DataProvider(name = "invalidInput")
	   public static Object[][] invalidInput() {
	      return new Object[][] {{"xxxxc",null,null,null,null,null,"[]"}};
	   }
}
