//Renu Nishitha Salver
//This Class is used to calculate the mean and and standard  deviation of the raffle ticket
package Nisha_JPA;

import java.io.Serializable; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentService  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	

	public double calculateSDeviation(Student student){
		String r[]= (student.getRaffleT()).split(",");	
		int raffleTicket[]=new int[20];
		int i=0;
		int sum=0;
		double deviation;
		for (String string : r) {
			raffleTicket[i]=Integer.parseInt(string);
			i++;
		}
		  
		 		
		double mean= calculateMean(student);
		for (int j = 0; j < r.length; j++) {
			sum+=Math.pow((raffleTicket[j]-mean), 2);
			
		}
		deviation=Math.pow(sum/(r.length-1),1/2);
		
		
		return deviation;
	}
	
public double calculateMean(Student student){
	String r[]= (student.getRaffleT()).split(",");	

  int sum=0;

  int i;
  for (i = 0; i < r.length; i++) 
  {
	  int c=Integer.parseInt(r[i]);
	  sum+=c;
	    }
  
	
  return sum/i;

}


}