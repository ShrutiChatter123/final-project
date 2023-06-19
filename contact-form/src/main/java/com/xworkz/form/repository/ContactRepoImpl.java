package com.xworkz.form.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.form.contactEntity.ContactEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ContactRepoImpl implements ContactRepo {

	@Autowired
	private EntityManagerFactory factory;

	public ContactRepoImpl() {
		System.out.println("No-org constructor for repoimpl");
	}

	@Override
	public boolean save(ContactEntity entity) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		log.info("Excecuting save method sucessfully");
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public List<ContactEntity> findByName(String name) {
		log.info("Find by name in repository impl");
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNamedQuery("findByName");
		query.setParameter("nm", "%" + name + "%");
		List<ContactEntity> result = query.getResultList();
		log.info("result from info" + result);
		entityManager.close();
		return result;
	}

}
