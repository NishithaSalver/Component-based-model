//Renu Nishitha Salver
//This is the Student class which contains references to the survey for

package Nisha_JPA;
import java.io.Serializable;    
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@NamedQueries(value = { @NamedQuery(name = "selectall", query = "SELECT s FROM Student s"),
		@NamedQuery(name = "searchfname", query = "SELECT s FROM Student s WHERE s.fname=:fnames"),
		@NamedQuery(name = "searchlname", query = "SELECT s FROM Student s WHERE s.lname=:lnames"),
		@NamedQuery(name = "searchcity", query = "SELECT s FROM Student s WHERE s.city=:city"),
		@NamedQuery(name = "searchstate", query = "SELECT s FROM Student s WHERE s.state=:state"),
		@NamedQuery(name = "searchall", query = "SELECT s FROM Student s WHERE s.city=:city AND s.state=:state AND s.fname=:fnames AND s.lname=:lnames"),
		@NamedQuery(name = "searchfnameslnames", query = "SELECT s FROM Student s WHERE s.fname=:fnames AND s.lname=:lnames"),
		@NamedQuery(name = "searchfnamescity", query = "SELECT s FROM Student s WHERE s.fname=:fnames AND s.city=:city"),
		@NamedQuery(name = "searchfnamestate", query = "SELECT s FROM Student s WHERE s.state=:state AND s.fname=:fname")

})
@Entity
@Table



public class Student implements Serializable
{
	 static final long serialVersionUID = 1L;
	
	
	int sid;
	 String fname;
	  String lname;
   String saddress;
  String city;
   String state;
   String zip;
   String email;
   String tphn;
  List <String> chekbox;
   String radiob;
   String dropd;
   String raffleT;
   String sdate;
   String semdate;
   String comments;
   double mean;
  double deviation;
     
  
  
  
  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid")
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

  
 
	@Column
  public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column
	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	@Column
	public String getSaddress() {
		return saddress;
	}


	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}


	@Column
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	@Column
   public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Column
    public String getZip() {
		return zip;
	}


	public void setZip(String zip) 
	{
		this.zip = zip;
		
		    
	}


	@Column
   public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Column
	public String getTphn() {
		return tphn;
	}


	public void setTphn(String tphn) {
		this.tphn = tphn;
	}
	
	@Column
public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	@Column
	public String getSemdate() {
		return semdate;
	}
	public void setSemdate(String semdate) {
		this.semdate = semdate;
	}
	
	
	@Column
	@ElementCollection(fetch = FetchType.EAGER)
	public List<String> getChekbox() {

		return chekbox;
	}

	public void setChekbox(List<String> chekbox) {
		this.chekbox = chekbox;
	}



	@Column
 public String getRadiob() {
		return radiob;
	}


	public void setRadiob(String radiob) {
		this.radiob = radiob;
	}
	  

	

	@Column
    public String getDropd() {
		return dropd;
	}


	public void setDropd(String dropd) {
		this.dropd = dropd;
	}

	@Column
	public String getRaffleT() {
		return raffleT;
	}


	public void setRaffleT(String raffleT) {
		this.raffleT = raffleT;
	}
	@Column
	public String getComments()
	{
		return comments;
	}
  public void setComments(String comments)
  {
  	this.comments=comments;
  }

public double getMean() {
	return mean;
}

public void setMean(double mean) {
	this.mean = mean;
}

public double getDeviation() {
	return deviation;
}

public void setDeviation(double deviation) {
	this.deviation = deviation;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}    
  
  
  
}
