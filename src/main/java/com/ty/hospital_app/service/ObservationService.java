package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.ObservationDaoImpl;
import com.ty.hospital_app.dto.Observation;

public class ObservationService 
{
	public void saveObservation(int bid,Observation observation)
	{
		ObservationDaoImpl daoImpl=new ObservationDaoImpl();
		Observation observation1=daoImpl.saveObservation(bid, observation);
		if(observation1!=null)
		{
			System.out.println("Data Saved Successfullt");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public Observation getObservationById(int oid)
	{
		ObservationDaoImpl daoImpl=new ObservationDaoImpl();
		Observation observation1=daoImpl.getObservationById(oid);
		if(observation1!=null)
		{
			return observation1;
		}
		else
		{
			return null;
		}
	}
	public void deleteObservationById(int oid)
	{
		ObservationDaoImpl daoImpl=new ObservationDaoImpl();
		boolean flag=daoImpl.deleteObservationById(oid);
		if(flag)
		{
			System.out.println("Data Deleted Succcessfully");
		}
		else
		{
			System.out.println("Failed To Delete Data");
		}
	}
	public Observation updateObservationById(int oid,Observation observation)
	{
		ObservationDaoImpl daoImpl=new ObservationDaoImpl();
		Observation observation1=daoImpl.updateObservationById(oid,observation);
		if(observation1!=null)
		{
			return observation1;
		}
		else
		{
			return null;
		}
	}
	public List<Observation> getAllObservation() 
	{
		ObservationDaoImpl daoImpl=new ObservationDaoImpl();
		List<Observation> observation1=daoImpl.getAllObservation();
		if(observation1!=null)
		{
			return observation1;
		}
		else
		{
			return null;
		}
	}
	public List<Observation> getObservationByDoctorName(String dname)
	{
		ObservationDaoImpl daoImpl=new ObservationDaoImpl();
		List<Observation> observation1=daoImpl.getObservationByDoctorName(dname);
		if(observation1!=null)
		{
			return observation1;
		}
		else
		{
			return null;
		}
	}
}
