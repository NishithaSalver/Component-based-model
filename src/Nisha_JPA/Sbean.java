//Renu Nishitha Salber
package Nisha_JPA;

import java.io.IOException;     
import java.io.Serializable;
import java.util.*;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@SessionScoped
public class Sbean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	String fname;
	String lname;
	String city;
	String state;
	

	
	ArrayList<Student> studList;
	
	public ArrayList<Student> getStudList() {
		return studList;
	}
		
	public void setStudList(ArrayList<Student> studList) {
		this.studList = studList;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname=lname;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	//Action controller
	@SuppressWarnings("unchecked")
	public String searchStudSurvey(){
		
		EntityManager e=SaveData.getEntityManager();
		
		CriteriaBuilder builder = e.getCriteriaBuilder();
	    CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

	    Root<Student> student = criteria.from(Student.class);
	    
	    List<Predicate> predicates = new ArrayList<Predicate>();
	 
	    
	    if(!(fname.trim().equals("")))
	    {	System.out.println("fnames");
	    	predicates.add(builder.equal(student.get("fname"), getFname()));
	    }
	    
	    if(!(lname.trim().equals("")))
	    {	System.out.println("lnames");
	    	predicates.add(builder.equal(student.get("lname"), getLname()));
	    }
	     
	    if(!(city.trim().equals("")))
	    {	System.out.println("city");
	    	predicates.add(builder.equal(student.get("city"), getCity()));
	    }
	    if(!(state.trim().equals("")))
	    {	System.out.println("state");
	    	predicates.add(builder.equal(student.get("state"), getState()));
	    }
	      
	    criteria.select(student)
        .where(predicates.toArray(new Predicate[]{}));
	    studList= (ArrayList<Student>) e.createQuery(criteria).getResultList();
		for (Student stud : studList) {
			System.out.println(stud.getFname());
		}
	    
		return "ResultLists";
	}
  
	public void delRows(int sid){
		
		EntityManager e=SaveData.getEntityManager();
		
		Map<String,String> abc = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		  String action = abc.get("stud");
		Student student = e.find(Student.class, sid);
		System.out.println("begin");		 
		  e.getTransaction().begin();
		  e.remove(student);
		  e.getTransaction().commit();				 
		 System.out.println("sid"+sid);
		 

		
	}


}
