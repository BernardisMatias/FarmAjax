package com.accenture.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.model.Egg;

public class EggDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public Egg getEgg(Long id) {
		Session session = sessionFactory.openSession();
		Egg egg = (Egg) session.get(Egg.class, id);
		session.close();
		return egg;
	}

	public List<Egg> eggList()
	{
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Egg> eggList = session.createQuery("FROM Egg").list();
		session.close();
		return eggList;
	}
	
	public List<Egg> eggListDeterminado(String id)
	{
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Egg> eggList = session.createQuery("FROM Egg where chickenId="+id).list();
		session.close();
		return eggList;
	}

	@Transactional
	public void addEgg(Egg egg){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(egg);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public void updateEgg(Egg egg) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(egg);
		tx.commit();
		session.close();		
	}
	
}
