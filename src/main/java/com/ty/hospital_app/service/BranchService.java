package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.impl.BranchDaoImpl;
import com.ty.hospital_app.dto.Branch;

public class BranchService 
{
	public void saveBranch(int hid,Branch branch)
	{
		BranchDaoImpl daoImpl=new BranchDaoImpl();
		Branch branch1=daoImpl.saveBranch(hid, branch);
		if(branch1!=null)
		{
			System.out.println("Data Saved Successfully");
		}
		else
		{
			System.out.println("Failed to Save Data");
		}
	}
	public Branch getBranchById(int bid)
	{
		BranchDaoImpl daoImpl=new BranchDaoImpl();
		Branch branch=daoImpl.getBranchById(bid);
		if(branch!=null)
		{
			return branch;
		}
		else
		{
			return null;
		}
	}
	public void deleteBranchById(int bid)
	{
		BranchDaoImpl daoImpl=new BranchDaoImpl();
		boolean flag=daoImpl.deleteBranchById(bid);
		if(flag)
		{
			System.out.println("Data Deleted Successfully");
		}
		else
		{
			System.out.println("Failed to delete Data");
		}
	}
	public Branch updateBranchById(int bid,Branch branch)
	{
		BranchDaoImpl daoImpl=new BranchDaoImpl();
		Branch branch1=daoImpl.saveBranch(bid, branch);
		if(branch1!=null)
		{
			return branch1;
		}
		else
		{
			return null;
		}
	}
	public List<Branch> getAllBranch()
	{
		BranchDaoImpl daoImpl=new BranchDaoImpl();
		List<Branch> branch=daoImpl.getAllBranch();
		if(branch!=null)
		{
			return branch;
		}
		else
		{
			return null;
		}
	}

}
