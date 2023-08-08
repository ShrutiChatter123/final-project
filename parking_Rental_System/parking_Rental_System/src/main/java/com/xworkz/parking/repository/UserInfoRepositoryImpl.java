package com.xworkz.parking.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.parking.entity.UserParkingEntity;
import com.xworkz.parking.entity.UserinfoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

	@Autowired
	private EntityManagerFactory factory1;
	
	public UserInfoRepositoryImpl() {
		log.info("Executing UserInfoRepositoryImpl constructor");
	}

	@Override
	public boolean save(UserinfoEntity entity1) {
		log.info("Save method running sucessfully...");
		EntityManager manager = factory1.createEntityManager();
		try {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity1);
		transaction.commit();
		return true;
	}catch (PersistenceException e) {
		e.printStackTrace();
	}
		return false;
	}
	
	
	@Override
	public boolean userParkingsave(UserParkingEntity entity2) {

		log.info("Save method running sucessfully in entity2");
		EntityManager manager = factory1.createEntityManager();
		try {
		EntityTransaction transaction = manager.getTransaction();		
		transaction.begin();
		manager.persist(entity2);
		transaction.commit();
		return true;
	}catch (PersistenceException e) {
		e.printStackTrace();
	}
		return false;
	}
	@Override
	public UserinfoEntity findByEmail(String email) {
		EntityManager manager = factory1.createEntityManager();
		Query query = manager.createNamedQuery("findByMail");
		query.setParameter("mail", email);
		try {
			Object obj = query.getSingleResult();
			return (UserinfoEntity)obj;

		} catch (Exception e) {
			return null;
		}finally {
			manager.close();
		}
	}

}
