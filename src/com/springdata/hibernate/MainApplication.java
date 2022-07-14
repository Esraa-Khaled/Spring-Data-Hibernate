package com.springdata.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Client;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Client client1 = new Client("ekhaled","Esraa Khaled", 24, "ekhaled@ntgclarity.com");
		Client client2 = new Client("nabdelmogeth","Noha Mostafa", 24, "nabdelmogeth@ntgclarity.com");
		Client client3 = new Client("namr","Noha Ezzat", 24, "namr@ntgclarity.com");

		
		try {
			session.beginTransaction();
			session.save(client1);
			session.save(client2);
			session.save(client3);
			session.getTransaction().commit();
		} catch(Exception ex) {
			System.out.println(ex.toString());
		} finally {
			session.close();
		}
		
	}

}