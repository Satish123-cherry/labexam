package com.klu.java_hibernate;

//import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.MutationQuery;

//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;



/**
 * Hello world!
 *
 */
public class Hql 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();

    	SessionFactory sf = md.getSessionFactoryBuilder().build();
    	Session s = sf.openSession();
    	Transaction t;
    	t=s.beginTransaction();
    	//HQL Query
    	MutationQuery q= s.createMutationQuery("update Employee set fn=:fn where id=:id");
    	q.setParameter("fn","Manju");
    	q.setParameter("id", 2);
    	q.executeUpdate();
    	t.commit();
    	s.close();
    
    	
    	  	        
    }
}
