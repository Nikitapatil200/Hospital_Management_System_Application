package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.MedOrderDaoImpl;
import com.ty.hospital_app.dto.MedOrder;

public class MedOrderService 
{
	public void saveMedOrder(int bid,MedOrder medOrder)
	{
		MedOrderDaoImpl daoImpl=new MedOrderDaoImpl();
		MedOrder medOrder1=daoImpl.saveMedOrder(bid, medOrder);
		if(medOrder1!=null)
		{
			System.out.println("Data Saved Successfullt");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public MedOrder getMedOrderById(int mid)
	{
		MedOrderDaoImpl daoImpl=new MedOrderDaoImpl();
		MedOrder medOrder=daoImpl.getMedOrderById(mid);
		if(medOrder!=null)
		{
			return medOrder;
		}
		else
		{
			return null;
		}
	}
	public void deleteMedOrderById(int mid)
	{
		MedOrderDaoImpl daoImpl=new MedOrderDaoImpl();
		boolean flag=daoImpl.deleteMedOrderById(mid);
		if(flag)
		{
			System.out.println("Data Deleted Successfullt");
		}
		else
		{
			System.out.println("Failed to Delete Data");
		}
	}
	public MedOrder updateMedOrderById(int mid,MedOrder medOrder)
	{
		MedOrderDaoImpl daoImpl=new MedOrderDaoImpl();
		MedOrder medOrder1=daoImpl.updateMedOrderById(mid,medOrder);
		if(medOrder1!=null)
		{
			return medOrder1;
		}
		else
		{
			return null;
		}
	}
	public List<MedOrder> getAllMedOrder()
	{
		MedOrderDaoImpl daoImpl=new MedOrderDaoImpl();
		List<MedOrder> medOrder=daoImpl.getAllMedOrder();
		if(medOrder!=null)
		{
			return medOrder;
		}
		else
		{
			return null;
		}
	}
	public List<MedOrder> getAllMedOrderByDoctorName(String name)
	{
		MedOrderDaoImpl daoImpl=new MedOrderDaoImpl();
		List<MedOrder> medOrder=daoImpl.getAllMedOrderByDoctorName(name);
		if(medOrder!=null)
		{
			return medOrder;
		}
		else
		{
			return null;
		}
	}
	public List<MedOrder> getALLMedOrderByDate(String date)
	{
		MedOrderDaoImpl daoImpl=new MedOrderDaoImpl();
		List<MedOrder> medOrder=daoImpl.getAllMedOrderByDate(date);
		if(medOrder!=null)
		{
			return medOrder;
		}
		else
		{
			return null;
		}
	}

}
