package com.xworkz.parking.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.parking.entity.ParkingEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ParkingRepoImpl implements ParkingRepo {

	@Autowired
	private EntityManagerFactory factory1;

	@Override
	public boolean updateLoginTime(ParkingEntity entity) {
		log.info("Excecuting updateLoginTime method()");
		EntityManager manager = factory1.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		transaction.commit();
		manager.close();

		return false;

	}

	@Override
	public ParkingEntity findByEmail(String email) {
		log.info("running findByEmail");
		EntityManager manager = factory1.createEntityManager();
		Query query = manager.createNamedQuery("findByEmail");
		query.setParameter("km", email);
		Object ref = query.getSingleResult();
		ParkingEntity entity = (ParkingEntity) ref;
		return entity;
	}

}
