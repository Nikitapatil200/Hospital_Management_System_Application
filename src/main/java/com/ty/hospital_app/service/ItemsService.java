package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.ItemsDaoImpl;
import com.ty.hospital_app.dto.Items;

public class ItemsService 
{
	public void saveItems(int mid,Items items)
	{
		ItemsDaoImpl daoImpl=new ItemsDaoImpl();
		Items items1=daoImpl.saveItems(mid, items);
		if(items1!=null)
		{
			System.out.println("Data Saved Successfullt");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public Items getItemsById(int iid)
	{
		ItemsDaoImpl daoImpl=new ItemsDaoImpl();
		Items items1=daoImpl.getItemsById(iid);
		if(items1!=null)
		{
			return items1;
		}
		else
		{
			return null;
		}
	}
	public void deleteItemsById(int iid)
	{
		ItemsDaoImpl daoImpl=new ItemsDaoImpl();
		boolean flag=daoImpl.deleteItemsById(iid);
		if(flag)
		{
			System.out.println("Data Deleted Successfully");
		}
		else
		{
			System.out.println("Failed To Delete Data");
		}
	}
	public Items updateItemsById(int iid,Items items)
	{
		ItemsDaoImpl daoImpl=new ItemsDaoImpl();
		Items items1=daoImpl.updateItemsById(iid,items);
		if(items1!=null)
		{
			return items1;
		}
		else
		{
			return null;
		}
	}
	public List<Items> getAllItems()
	{
		ItemsDaoImpl daoImpl=new ItemsDaoImpl();
		List<Items> items1=daoImpl.getAllItems();
		if(items1!=null)
		{
			return items1;
		}
		else
		{
			return null;
		}
	}

}
