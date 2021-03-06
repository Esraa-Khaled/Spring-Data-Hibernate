package com.springdata.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Address;
import com.springdata.hibernate.model.Client;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();
		
////////////CRUD Operations/////////
		crudOperations(factory);
	
	}

	private static void crudOperations(SessionFactory factory) {
		// TODO Auto-generated method stub
		
		//Create
		saveObjects(factory);

		//Retrieve
		Client client = getClient(factory, 2);
		System.out.println(client.getFullName());
		
		//Update
		Client newClient = new Client("Ali","Ali Ahmed", 30, "aahmed@aaa.com");
		updateObject(factory, newClient, 3);
		
		//delete
		//deleteObject(factory, 1);
		
	}

	private static void updateObject(SessionFactory factory, Client newClient, long id) {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();

		try {
			session.beginTransaction();
			newClient.setId(id);
			session.update(newClient);
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			session.close();
			}
	}

	private static void deleteObject(SessionFactory factory, long id) {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		Client client = new Client();
		try {
			session.beginTransaction();
			client.setId(id);
			session.delete(client);
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			session.close();
			}
	}

	private static Client getClient(SessionFactory factory, long id) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Client client = new Client();
		
		try {
			session.beginTransaction();
			client = session.get(Client.class, id);
			session.getTransaction().commit();
		} catch(Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return client;
	}
	
	private static void saveObjects(SessionFactory factory) {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();

		Client client1 = new Client("ekhaled","Esraa Khaled", 24, "ekhaled@ntgclarity.com");
		Client client2 = new Client("nabdelmogeth","Noha Mostafa", 24, "nabdelmogeth@ntgclarity.com");
		Client client3 = new Client("namr","Noha Ezzat", 24, "namr@ntgclarity.com");

		Address officeAddress = new Address("Haram", "Cairo", "Giza", "54132");
		Address homeAddress = new Address("Haram2", "Cairo2", "Giza2", "11111");

		
		client1.setOfficeAddress(officeAddress);
		client1.setHomeAddress(homeAddress);
		client1.setJoinedDate(new Date());
		try {
			session.beginTransaction();
			session.save(client1);
			session.save(client2);
			session.save(client3);
			session.getTransaction().commit();
		} catch(Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

}