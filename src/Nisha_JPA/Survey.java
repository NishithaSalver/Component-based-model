//Renu Nishitha Salver; Goo941178

package Nisha_JPA;

import java.io.Serializable;     
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@ManagedBean
public class Survey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	Sbean s=new Sbean();
	
	public Sbean getS() {
		return s;
	}

	public void setS(Sbean s) {
		this.s = s;
	}

	
	Student stud=new Student();
	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}
	
	WinningResult wr=new WinningResult();
	public WinningResult getWr() {
		return wr;
	}

	public void setWr(WinningResult wr) {
		this.wr = wr;
	}
	
	StudentService s1=new StudentService();
	public StudentService getS1() {
		return s1;
	}

	public void setS1(StudentService s1) {
		this.s1 = s1;
	}
	
	
	public String choice="VeryLikely,Likely,UnLikely";
	public String[] choicearray=choice.split(","); 
	public List<String> display(String choices) {
		List<String> abc = new ArrayList<String>(); 
		for(String i: choicearray) {
		if(i.toUpperCase() .startsWith(choices.toUpperCase())) {
		        abc.add(i);
		      }
		}
		    return(abc);
		  }
	
	
	String ack[] = { "Acknowledgement" };

	ArrayList<Student> sarray = new ArrayList<Student>();
	public ArrayList<Student> getSarray() {
		return sarray;
	}

	public void setsarray(ArrayList<Student> sarray) {
		this.sarray = sarray;
	}

	
	public String[] getack() {
		return ack;
	}

	public void setack(String[] ack) {
		this.ack = ack;
	}	
	
public void renderStateCity(){
		
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/test/webresources/zips/");
        WebTarget resourceWebTarget;
        resourceWebTarget = target.path(new String(this.stud.getZip()+""));
       
       
        Invocation.Builder invocationBuilder;
        invocationBuilder = resourceWebTarget.request(MediaType.TEXT_PLAIN);
        System.out.println(resourceWebTarget.getUri());
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());
       
        String s = response.readEntity(String.class);
        System.out.println("City"+s.split("-")[0]);
        System.out.println("State"+s.split("-")[1]);
        
        stud.setCity(s.split(",")[0]);
        stud.setState(s.split(",")[1]);

		
	}

//SaveData savedata=new SaveData();
	public String submitAction() {

			
		StudentService ss = new StudentService();		
		
		double mean=ss.calculateMean(stud);
		double deviation=ss.calculateSDeviation(stud);
		
		wr.setMean(mean);
		stud.setMean(mean);
		wr.setDeviation(deviation);
		stud.setDeviation(deviation);
		stud.setDeviation(wr.getDeviation());
		stud.setMean(wr.getMean());

			
		System.out.println("Persisting Data... ");
		try{
		
		SaveData.studentsData(stud);
		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		System.out.println("Data Persisted ");
		
		if (wr.getMean() > 90) {
			return "winningResult";
		} else
			return "SimpleAcknowledgement";
	}

	
	public String cancelAction()
	{
		return "CancelReturn";
	}
	
	
	
public ArrayList<Student> getStudentsarray() {

		EntityManager em= SaveData.getEntityManager();
		
		
		return (ArrayList<Student>) em.createNamedQuery("selectall",Student.class).getResultList();
	}



public void dateAfter(FacesContext context, UIComponent componentToValidate, Object value) throws ValidatorException
{
	Date dtSemStartDate = ((Date)value);

	Object surveyDateValue = componentToValidate.getAttributes().get("dateOfSurvey");
	Date dtSurveyDate = (Date) ((org.primefaces.component.calendar.Calendar)surveyDateValue).getValue();
	
	System.out.println(" semDate= " + dtSemStartDate);
	if (dtSemStartDate== null)
    		return;
	
	
	if(dtSurveyDate.after(dtSemStartDate))
	{
		FacesMessage message = new FacesMessage("Semester Start date cannot be before Survey date.");
		throw new ValidatorException(message);
	}

}

public void displayAll()
{
	Resources l=new Resources();
	String s="";
	
	s=l.LookUp(stud.getZip());
	if(s==null)
	{return;}
	stud.setCity(s.split(",")[0]);
	stud.setState(s.split(",")[1]);
}

}
