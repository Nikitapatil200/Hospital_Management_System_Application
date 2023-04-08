package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestSaveHospital 
{
	public static void main(String[] args) {
		Hospital hospital1=new Hospital();
		HospitalService service=new HospitalService();
		hospital1.setHospital_name("Narayana");
		hospital1.setHospital_website("www.narayana.com");
		service.saveHospital(hospital1);
	}
}
