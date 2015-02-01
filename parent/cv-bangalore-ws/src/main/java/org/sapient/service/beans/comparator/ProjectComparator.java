/**
 * 
 */
package org.sapient.service.beans.comparator;

import java.util.Calendar;
import java.util.Comparator;

import org.sapient.service.beans.ProjectInfoVO;

/**
 * @author brout
 *
 */
public class ProjectComparator implements Comparator{
	
	public int compare(Object project1, Object project2) {
	       
        Calendar StartDate1 = ((ProjectInfoVO)project1).getStartDate(); 
        Calendar StartDate2 = ((ProjectInfoVO)project2).getStartDate();  
          
        if(StartDate1.before(StartDate2))
            return 1;
        else if(StartDate1.after(StartDate2 ))
            return -1;
        else
            return 0; 
	}

}
