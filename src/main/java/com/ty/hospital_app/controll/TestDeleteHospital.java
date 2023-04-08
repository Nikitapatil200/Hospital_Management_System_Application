package com.ty.hospital_app.controll;

import com.ty.hospital_app.service.HospitalService;

public class TestDeleteHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HospitalService service=new HospitalService();
		service.deleteHospitalById(3);
	}

}
