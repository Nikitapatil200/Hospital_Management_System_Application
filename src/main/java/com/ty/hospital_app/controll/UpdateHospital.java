package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class UpdateHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hospital hospital1=new Hospital();
		HospitalService service=new HospitalService();
		hospital1.setHospital_name("JayaDevKumar");
		hospital1.setHospital_website("www.jayadevkumar.com");
		service.updateHospitalById(2, hospital1);
	}

}
