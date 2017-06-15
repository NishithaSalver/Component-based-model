//Renu Nishitha Salver G00941178
//Resource class which contains zipcode,city and state details
package Nisha_JPA;

import java.util.*; 

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/zips")
public class Resources {

	Map<String,Place> zips;
	public Resources()
	{
		super();
		zips=new HashMap<String,Place>();
		zips.put("22312",new Place("VA","Alexandria","22312"));
	    zips.put("22030",new Place("VA","Fairfax","22030"));
		zips.put("22301",new Place("MD","Tysons Corner","22301"));
		zips.put("20148",new Place("VA","Ashburn","20148"));
	
	}
@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("{zip}")
public String LookUp(@PathParam("zip")String zip)
{
	Place matchedLocation=zips.get(zip);
	
	String cityState=new String(matchedLocation.getCity()+","+matchedLocation.getState());
	return cityState;
}

	
	
	
}
