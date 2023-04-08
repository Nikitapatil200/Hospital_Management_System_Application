package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.EncounterDaoImpl;
import com.ty.hospital_app.dto.Encounter;

public class EncounterService 
{

	public void saveEncounter(int bid,Encounter encounter)
	{
		EncounterDaoImpl daoImpl=new EncounterDaoImpl();
		Encounter encounter1=daoImpl.saveEncounter(bid, encounter);
		if(encounter1!=null)
		{
			System.out.println("Data Saved Successfully");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public Encounter getEncounterById(int eid)
	{
		EncounterDaoImpl daoImpl=new EncounterDaoImpl();
		Encounter encounter1=daoImpl.getEncounterById(eid);
		if(encounter1!=null)
		{
			return encounter1;
		}
		else
		{
			return null;
		}
	}
	public void deleteEncounterById(int eid)
	{
		EncounterDaoImpl daoImpl=new EncounterDaoImpl();
		boolean flag=daoImpl.deleteEncounterById(eid);
		if(flag)
		{
			System.out.println("Data Deleted Successfully");
		}
		else
		{
			System.out.println("Failed to Delete Data");
		}
	}
	public Encounter updateEncounterById(int eid,Encounter encounter)
	{
		EncounterDaoImpl daoImpl=new EncounterDaoImpl();
		Encounter encounter1=daoImpl.updateEncounterById(eid,encounter);
		if(encounter1!=null)
		{
			return encounter1;
		}
		else
		{
			return null;
		}
	}
	public List<Encounter> getAllEncounter() 
	{
		EncounterDaoImpl daoImpl=new EncounterDaoImpl();
		List<Encounter> encounter=daoImpl.getAllEncounter();
		if(encounter!=null)
		{
			return encounter;
		}
		else
		{
			return null;
		}

	}
}
