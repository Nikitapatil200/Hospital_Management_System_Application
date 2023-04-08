package com.ty.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Person;

public class PersonDaoImpl implements PersonDao
{

	public Person savePerson(int eid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null)
		{
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		else
		{
			return null;
		}
	}

	public Person getPersonById(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Person person=entityManager.find(Person.class, pid);
		return person;
	}

	public boolean deletePersonById(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, pid);
		if(person!=null)
		{
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}

	public Person updatePersonById(int pid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Person person1=entityManager.find(Person.class, pid);
		if(person1!=null)
		{
			person.setName(person1.getName());
			person.setAddress(person1.getAddress());
			person.setPhone(person1.getPhone());
			person.setAge(person1.getAge());
			person.setGender(person1.getGender());
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
			return person;
		}
		else
		{
			return null;
		}
	}

	public List<Person> getAllPerson() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		List<Person> person=query.getResultList();
		return person;

	}

	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select p from Person p where gender=?0");
		query.setParameter(0, gender);
		List<Person> person=query.getResultList();

		return person;
	}

	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select p from Person p where age=?0");
		query.setParameter(0, age);
		List<Person> person=query.getResultList();

		return person;
	}

	public List<Person> getPersonByPhone(long phone) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select p from Person p where phone=?0");
		query.setParameter(0, phone);
		List<Person> person=query.getResultList();

		return person;
	}

}
