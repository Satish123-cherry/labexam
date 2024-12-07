package com.klu.java_hibernate;

//import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.MutationQuery;

//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;



/**
 * Hello world!
 *
 */
public class HibernateCrudOperations1 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();

    	SessionFactory sf = md.getSessionFactoryBuilder().build();
    	Session s = sf.openSession();
    	Transaction t;
    	//insert
    	Employee e1 =new Employee();
    	e1.setFn("Prabhas");
    	e1.setLn("Bahubali");
    	s.persist(e1);
    	t=s.beginTransaction();
    	t.commit();
    		
    	System.out.println( "Employee data Inserted succesfully" );
    	        
    	        
    	       //Retrieve
    	        Employee e2=s.find(Employee.class,1);
    	        System.out.println("Data Retrieved");
    	        //update
    	        e2.setFn("Tarak");
    	        e2.setLn("Nandamuri");
    	        s.update(e2);
    	        t=s.beginTransaction();
    	        t.commit();
    	        System.out.println("Data Updated");
    	        //delete
    	        s.delete(e2);
    	        t=s.beginTransaction();
    	        t.commit();
    	        System.out.println("Data deleted");
    	        System.out.println("Hello World");
    	            
    	            
    	        
    }
}
