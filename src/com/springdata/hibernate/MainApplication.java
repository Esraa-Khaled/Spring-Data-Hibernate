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
		
	}

}