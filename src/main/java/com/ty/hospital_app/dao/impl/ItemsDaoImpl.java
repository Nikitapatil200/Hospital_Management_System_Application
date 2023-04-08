package com.ty.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.ItemsDao;
import com.ty.hospital_app.dto.Items;
import com.ty.hospital_app.dto.MedOrder;

public class ItemsDaoImpl implements ItemsDao
{

	public Items saveItems(int mid, Items items) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		MedOrder medOrder=entityManager.find(MedOrder.class, mid);
		if(medOrder!=null)
		{
			entityTransaction.begin();
			entityManager.persist(items);
			entityTransaction.commit();
			return items;
		}
		else
		{
			return null;
		}
	}

	public Items getItemsById(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Items items=entityManager.find(Items.class, iid);
		return items;
	}

	public boolean deleteItemsById(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Items items=entityManager.find(Items.class, iid);
		if(items!=null)
		{
			entityTransaction.begin();
			entityManager.remove(items);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}

	public Items updateItemsById(int iid, Items items) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Items items1=entityManager.find(Items.class, iid);
		if(items1!=null)
		{
			items.setName(items1.getName());
			items.setCost(items1.getCost());
			items.setQuantity(items1.getQuantity());
			entityTransaction.begin();
			entityManager.merge(items);
			entityTransaction.commit();
			return items;
		}
		else
		{
			return null;
		}
	}

	public List<Items> getAllItems() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select i from Items i");
		List<Items> items=query.getResultList();
		return items;
	}

}
