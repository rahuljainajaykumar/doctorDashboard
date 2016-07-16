package com.doctorDetails;

import org.json.JSONArray;

public class GetDoctorDashboard {

	DoctorDashboardBean bean = new DoctorDashboardBean();
	DoctorDashboardDB db = new DoctorDashboardDB();
	JSONArray json = new JSONArray();
	
	public JSONArray getDoctorDetails(String name,String speciality,String area,String review,String gender,String insurance)
	{
		
		bean.setName(name);
		bean.setSpeciality(speciality);
		bean.setArea(area);
		bean.setReview(review);
		bean.setGender(gender);
		bean.setInsurance(insurance);
		
		json=db.getDoctorDetails(bean.getName(),bean.getSpeciality(),bean.getArea(),bean.getReview(),bean.getGender(),bean.getInsurance());
		
	return json;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GetDoctorDashboard docInfo = new GetDoctorDashboard();
		JSONArray json = new JSONArray();
		//get details order : name,speciality,area,review,gender,insurance
	json=docInfo.getDoctorDetails("neeshit", "eye", "san jose", "3","female","Blueshield");
		
		if(json.length()==0)
		{
			System.out.println("Input not found");
		}
		else
		{
		for(int i=0;i<json.length();i++)
		{
			System.out.println(json.get(i).toString());
		}
		}

	}

}
