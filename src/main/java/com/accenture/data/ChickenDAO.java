package com.accenture.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.Chicken;

public class ChickenDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public Chicken getChicken(Long id) {
		Session session = sessionFactory.openSession();
		Chicken chicken = (Chicken) session.get(Chicken.class, id);
		session.close();
		return chicken;
	}

	public List<Chicken> chickenList()
	{
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Chicken> chickenList = session.createQuery("FROM Chicken").list();
		session.close();
		return chickenList;
	}
	
	@Transactional
	public void deleteChicken(Chicken chicken){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(chicken);
		tx.commit();
		session.close();
	}
	
}
