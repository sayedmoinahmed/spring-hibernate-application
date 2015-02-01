/**
 * 
 */
package org.sapient.service.beans.comparator;

import java.util.Calendar;
import java.util.Comparator;

import org.sapient.service.beans.EmploymentInfoVO;

/**
 * @author brout
 *
 */
public class EmploymentComparator implements Comparator {
	
	public int compare(Object employment1, Object employment2) {
	       
        Calendar dateOfJoining1 = ((EmploymentInfoVO)employment1).getDateOfJoining();        
        Calendar dateOfJoining2 = ((EmploymentInfoVO)employment2).getDateOfJoining();
        
        if(dateOfJoining1.before(dateOfJoining2))
            return 1;
        else if(dateOfJoining1.after(dateOfJoining2))
            return -1;
        else
            return 0; 
	}

}
