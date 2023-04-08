package com.ty.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

public class BranchDaoImpl implements BranchDao
{

	public Branch saveBranch(int hid, Branch branch) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, hid);
		if(hospital!=null)
		{
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		}
		else
		{
			return null;
		}
	}

	public Branch getBranchById(int bid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Branch branch=entityManager.find(Branch.class, bid);
		return branch;
	}

	public boolean deleteBranchById(int bid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, bid);
		if(branch!=null)
		{
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}

	public Branch updateBranchById(int bid, Branch branch) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Branch branch1=entityManager.find(Branch.class, bid);
		if(branch1!=null)
		{
			branch.setBranch_name(branch1.getBranch_name());
			branch.setEmail(branch1.getEmail());
			branch.setPhone(branch1.getPhone());
			branch.setAddress(branch1.getAddress());
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
			return branch;
		}
		else
		{
			return null;
		}
	}

	public List<Branch> getAllBranch() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select b from Branch b");
		List<Branch> branch=query.getResultList();
		return branch;
	}

}
