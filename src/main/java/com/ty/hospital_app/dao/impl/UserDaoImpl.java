package com.ty.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.UserDao;
import com.ty.hospital_app.dto.User;

public class UserDaoImpl implements UserDao
{

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;

	}

	public User getUserById(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User user=entityManager.find(User.class, uid);
		return user;
	}

	public boolean deleteUserById(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		User user=entityManager.find(User.class, uid);
		if(user!=null)
		{
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}

	public User updateUserById(int uid, User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		User user1=entityManager.find(User.class, uid);
		if(user1!=null)
		{
			user.setName(user1.getName());
			user.setEmail(user1.getEmail());
			user.setPassword(user1.getPassword());
			user.setPhone(user1.getPhone());
			user.setRole(user1.getRole());
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return user;
		}
		else
		{
			return null;
		}
	}

	public List<User> getAllUser() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select u from User u");
		List<User> user=query.getResultList();
		return user;
	}

	public List<User> getUserByRole(String role) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select u from User u where role=?0");
		query.setParameter(0, role);
		List<User> user=query.getResultList();
		return user;
	}

}
