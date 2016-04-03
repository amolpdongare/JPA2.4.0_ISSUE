package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.jpa.Z_University;
import com.jpa.Z_University_;

public class MainTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-Query");
		EntityManager em = emf.createEntityManager();	
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Z_University> cq = cb.createQuery(Z_University.class).distinct(true);
		
		em.getTransaction().begin();
		
		final Root<Z_University> group = cq.from(Z_University.class);
		final List<Predicate> requiredCriteria = new ArrayList<>();
		//requiredCriteria.add(cb.isNull(group.<String>get("name")));
		//requiredCriteria.add(cb.isNull(group.<String>get("city")));
		
		requiredCriteria.add(cb.isNull(group.get(Z_University_.name)));
		requiredCriteria.add(cb.isNull(group.get(Z_University_.city)));
		
		final List<Predicate> requiredCriteria1 = new ArrayList<Predicate>();
		//requiredCriteria1.add(cb.isNull(group.<String>get("state")));
		requiredCriteria1.add(cb.isNull(group.get(Z_University_.state)));
		//requiredCriteria1.add(cb.or((cb.isNull(group.<Set<String>>get("students")))));
		//requiredCriteria1.add(cb.or(cb.isNull(group.<Set<String>>get("professors"))));
		requiredCriteria1.add(cb.or(cb.isNull(group.get(Z_University_.students))));
		requiredCriteria1.add(cb.or(cb.isNull(group.get(Z_University_.professors))));
		
		final TypedQuery<Z_University> query = 
				em.createQuery(cq.where(cb.and(requiredCriteria.toArray(new Predicate[requiredCriteria.size()])),
						cb.or(requiredCriteria1.toArray(new Predicate[requiredCriteria1.size()]))));
		
		List<Z_University> uni = (List<Z_University>) query.getResultList();
		System.out.println(uni.size());

		em.getTransaction().commit();
		
	}

}
