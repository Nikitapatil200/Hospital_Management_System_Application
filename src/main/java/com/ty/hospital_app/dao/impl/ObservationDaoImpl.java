
package com.ty.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.ObservationDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Observation;

public class ObservationDaoImpl implements ObservationDao
{

	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null)
		{
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation;
		}
		else
		{
			return null;
		}
	}

	public Observation getObservationById(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Observation observation=entityManager.find(Observation.class, oid);
		return observation;
	}

	public boolean deleteObservationById(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Observation observation=entityManager.find(Observation.class, oid);
		if(observation!=null)
		{
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}

	public Observation updateObservationById(int oid, Observation observation) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Observation observation1=entityManager.find(Observation.class, oid);
		if(observation1!=null)
		{
			observation.setDoctor_name(observation1.getDoctor_name());
			observation.setReason_observation(observation1.getReason_observation());
			entityTransaction.begin();
			entityManager.merge(observation);
			entityTransaction.commit();
			return observation;
		}
		else
		{
			return null;
		}
	}

	public List<Observation> getAllObservation() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select o from Observation o");
		List<Observation> observation=query.getResultList();
		return observation;
	}

	public List<Observation> getObservationByDoctorName(String dname) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select o from Observation o where doctor_name=?0");
		query.setParameter(0, dname);
		List<Observation> observation=query.getResultList();
		return observation;
	}

}
