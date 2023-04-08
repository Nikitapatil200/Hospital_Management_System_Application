package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.AddressDaoImpl;
import com.ty.hospital_app.dto.Address;

public class AddressService 
{
	public void saveAddress(int bid,Address address)
	{
		AddressDaoImpl daoImpl=new AddressDaoImpl();
		Address address1=daoImpl.saveAddress(bid, address);
		if(address1!=null)
		{
			System.out.println("Data Saved Successfully");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public Address getAddressById(int aid)
	{
		AddressDaoImpl daoImpl=new AddressDaoImpl();
		Address address=daoImpl.getAddressById(aid);
		if(address!=null)
		{
			return address;
		}
		else
		{
			return null;
		}
	}
	public void deleteAddressById(int aid)
	{
		AddressDaoImpl daoImpl=new AddressDaoImpl();
		boolean flag=daoImpl.deleteAddressById(aid);
		if(flag)
		{
			System.out.println("Data Deleted Successfully");
		}
		else
		{
			System.out.println("Failed to deleted Data");
		}
	}
	public Address updateAddressById(int aid,Address address)
	{
		AddressDaoImpl daoImpl=new AddressDaoImpl();
		Address address1=daoImpl.updateAddressById(aid, address);
		if(address1!=null)
		{
			return address1;
		}
		else
		{
			return null;
		}
	}
	public List<Address> getAllAddress() {
		AddressDaoImpl daoImpl=new AddressDaoImpl();
		List<Address> address1=daoImpl.getAllAddress();
		if(address1!=null)
		{
			return address1;
		}
		else
		{
			return null;
		}
	}
}
