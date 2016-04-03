package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Z_University;

public class InsertJPA {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-Query");
		EntityManager em = emf.createEntityManager();
		
		for(int i=1;i<1000;i++){
			Z_University uni = new Z_University();
			em.getTransaction().begin();
			uni.setUni_id(""+i);
			em.persist(uni);
			em.getTransaction().commit();
		}
	}
	

}
