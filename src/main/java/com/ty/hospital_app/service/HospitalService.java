package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.impl.HospitalDaoImpl;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService 
{
	public void saveHospital(Hospital hospital)
	{
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		Hospital hospital1=daoImpl.saveHospital(hospital);
		if(hospital1!=null)
		{
			System.out.println("Data Saved Successfully");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public Hospital getHospitalById(int hid)
	{
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		Hospital hospital=daoImpl.getHospitalById(hid);
		if(hospital!=null)
		{
			return hospital;
		}
		else
		{
			return null;
		}
	}
	public void deleteHospitalById(int hid)
	{
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		boolean flag=daoImpl.deleteHospitalById(hid);
		if(flag)
		{
			System.out.println("Data Deleted Successfully");
		}
		else
		{
			System.out.println("Failed to Delete Data");
		}
	}
	public Hospital updateHospitalById(int hid,Hospital hospital)
	{
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		Hospital hospital1=daoImpl.updateHospitalById(hid, hospital);
		if(hospital1!=null)
		{
			//System.out.println("Data updated Successfully");
			return hospital1;
		}
		else
		{
			//System.out.println("Failed to update Data");
			return null;
		}
	}
}
