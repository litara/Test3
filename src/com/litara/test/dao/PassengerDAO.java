package com.litara.test.dao;

import java.util.List;

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
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Passenger> results = session.createQuery(" from Passenger where id=:id").setParameter("id", id).list();
		if(results.isEmpty()) {
			session.getTransaction().commit();
			session.close();
			return null;
		}
		session.getTransaction().commit();
		session.close();
		return results.get(0);
	}
	@Override
	public void update(Passenger entity) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public void delete(Passenger entity) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}
	public boolean findByEmail(String email) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List results = session.createQuery(" from Passenger where email=:email").setParameter("email", email).list();
		if(results.isEmpty()) {
			session.getTransaction().commit();
			session.close();
			return false;
		}
		session.getTransaction().commit();
		session.close();
		return true;
	}
	public boolean findByEmailAndPassword(String email, String password) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println(e);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String sql="from Passenger where email="+"'"+email+"'"+" and password="+"'"+password+"'";
		List result = session.createQuery(sql).list();
		if(result.isEmpty()) {
			session.getTransaction().commit();
			session.close();
			return false;
		}
		session.getTransaction().commit();
		session.close();
		return true;
	}
	public Passenger findByEmailAndReturn(String email) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Passenger> result = session.createQuery(" from Passenger where email=:email").setParameter("email", email).list();
		session.getTransaction().commit();
		session.close();
		return result.get(0);
	}
	public List<Passenger> output(){
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Passenger> result = session.createQuery("from Passenger").list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
}
