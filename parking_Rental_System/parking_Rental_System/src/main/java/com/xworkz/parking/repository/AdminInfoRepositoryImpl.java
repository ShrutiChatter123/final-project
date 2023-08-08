package com.xworkz.parking.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.parking.entity.AdminInfoEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AdminInfoRepositoryImpl implements AdminInfoRepo {

	@Autowired
	private EntityManagerFactory factory1;

	public AdminInfoRepositoryImpl() {
		log.info("constctr" + getClass().getSimpleName());
	}

	@Override
	public boolean save(AdminInfoEntity entity) {
		EntityManager manager = factory1.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		log.info("save method running sucessfully");
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public List<AdminInfoEntity> findBylocation(String location) {
		log.info("findBylocation running in repo impl");
		EntityManager entityManager = factory1.createEntityManager();
		Query query = entityManager.createNamedQuery("findByLocation");
		query.setParameter("nm", location);
		List<AdminInfoEntity> result = query.getResultList();
		log.info("getting result:" + result);
		entityManager.close();
		return result;
	}

	@Override
	public AdminInfoEntity findByLocationVtypeVclassificationTerms(String location, String vehicaltype,
			String vehicalClassifications, String terms) {
		System.out.println("Location " + location);
		System.out.println("VehicalType " + vehicaltype);
		System.out.println("VehicalClassifications " + vehicalClassifications);
		System.out.println("Terms " + terms);
		EntityManager manager = factory1.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByAll");
			query.setParameter("loc", location);
			query.setParameter("vtype", vehicaltype);
			query.setParameter("Vcls", vehicalClassifications);
			query.setParameter("ts", terms);
			Object object = query.getSingleResult();
			AdminInfoEntity admin = (AdminInfoEntity) object;
			System.out.println("===============================entity found "+admin);
			return admin;

		} catch (Exception e) {
			log.info("no entity found");
			return null;
		} finally {
			manager.close();
		}

	}

}
