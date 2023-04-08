package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.UserDaoImpl;
import com.ty.hospital_app.dto.User;

public class UserService 
{
	public void saveUser(User user)
	{
		UserDaoImpl daoImpl=new UserDaoImpl();
		User user1=daoImpl.saveUser(user);
		if(user1!=null)
		{
			System.out.println("Data Saved Successfully");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public User getUserById(int uid)
	{
		UserDaoImpl daoImpl=new UserDaoImpl();
		User user1=daoImpl.getUserById(uid);
		if(user1!=null)
		{
			return user1;
		}
		else
		{
			return null;
		}
	}
	public void deleteUserById(int uid)
	{
		UserDaoImpl daoImpl=new UserDaoImpl();
		boolean flag=daoImpl.deleteUserById(uid);
		if(flag)
		{
			System.out.println("Data Deleted Successfully");
		}
		else
		{
			System.out.println("Failed To delete Data");
		}
	}
	public User updateUserById(int uid,User user)
	{
		UserDaoImpl daoImpl=new UserDaoImpl();
		User user1=daoImpl.updateUserById(uid,user);
		if(user1!=null)
		{
			return user1;
		}
		else
		{
			return null;
		}
	}
	public List<User> getAllUser() 
	{
		UserDaoImpl daoImpl=new UserDaoImpl();
		List<User> user1=daoImpl.getAllUser();
		if(user1!=null)
		{
			return user1;
		}
		else
		{
			return null;
		}	
	}
	public List<User> getUserByRole(String role) 
	{
		UserDaoImpl daoImpl=new UserDaoImpl();
		List<User> user1=daoImpl.getUserByRole(role);
		if(user1!=null)
		{
			return user1;
		}
		else
		{
			return null;
		}	
	}
}
	
