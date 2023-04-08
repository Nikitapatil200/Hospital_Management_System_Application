package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class GetHospitalById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HospitalService service=new HospitalService();
		Hospital hospital=service.getHospitalById(1);
		System.out.println("Hospital Id:"+hospital.getHid());
		System.out.println("Hospital Name:"+hospital.getHospital_name());
		System.out.println("Hospital Website:"+hospital.getHospital_website());
	}

}
