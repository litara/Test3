package com.litara.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.litara.test.entities.Passenger;
public class PassengerDAO extends DAOFactory<Passenger>{
	private SessionFactory sessionFactory;
	@Override
	public void create(Passenger entity) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Passenger findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Passenger entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Passenger entity) {
		// TODO Auto-generated method stub
		
	}
	public boolean findByEmailAndPassword(String email, String password) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.createQuery("from passenger where email="+email);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	
}
