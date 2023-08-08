package com.xworkz.parking.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.parking.entity.UserinfoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserOtpRepoImpl implements UserOtpRepo {

	@Autowired
	private EntityManagerFactory factory1;

	@Override
	public boolean save(UserinfoEntity entity) {
		log.info("save method running sucessfully in UserOtpRepoImpl");
		EntityManager manager = factory1.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
		return false;
	}

//	@Override
//	public UserinfoEntity findByUserEmail(String email) {
//		EntityManager manager = factory1.createEntityManager();
//		Query query = manager.createNamedQuery("findByMail");
//		query.setParameter("email", email);
//		try {
//			Object object = query.getSingleResult();
//			return (UserinfoEntity) object;
//		} catch (Exception e) {
//			return null;
//		} finally {
//			manager.close();
//		}
//
//	}

	@Override
	public boolean userSignInUpdate(String emailOTP, String email) {
		EntityManager manager = factory1.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createNamedQuery("updateOTP");
		query.setParameter("sendmail", email);
		query.setParameter("onetimeotp", emailOTP);

		int i = query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

}