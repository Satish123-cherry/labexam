package com.klu.java_hibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.MutationQuery;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;



/**
* Hello world!
*
*/
public class Hcql 
{
  public static void main( String[] args )
  {
  	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
  	Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();

  	SessionFactory sf = md.getSessionFactoryBuilder().build();
  	Session s = sf.openSession();
  	//Transaction t;
  	        
  	       
  	        //HCQL
  	        //Creating Criteria Builder
  	        CriteriaBuilder builder=s.getCriteriaBuilder();
  	        CriteriaQuery<Employee> c=builder.createQuery(Employee.class);
  	        jakarta.persistence.criteria.Root<Employee> employeeRoot=c.from(Employee.class);
  	        c.select(employeeRoot);
  	        //Adding Where clause
  	        c.where(builder.equal(employeeRoot.get("Id"),"2"));
  	        List<Employee> l=s.createQuery(c).getResultList();
  	        System.out.println(l.get(0).getId());
  	        System.out.println(l.get(0).getFn());
  	        
  	            
  	        
  }
}
