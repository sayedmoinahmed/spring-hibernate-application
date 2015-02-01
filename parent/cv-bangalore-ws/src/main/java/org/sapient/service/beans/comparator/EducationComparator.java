package org.sapient.service.beans.comparator;

import java.util.Calendar;
import java.util.Comparator;


import org.sapient.service.beans.EducationInfoVO;

public class EducationComparator implements Comparator{

	public int compare(Object education1, Object education2) {
	       
        Calendar yearOfJoinning1 = ((EducationInfoVO)education1).getYearOfJoining(); 
        Calendar yearOfJoinning2 = ((EducationInfoVO)education2).getYearOfJoining();  
          
        if(yearOfJoinning1.before(yearOfJoinning2))
            return 1;
        else if(yearOfJoinning1.after(yearOfJoinning2))
            return -1;
        else
            return 0; 
	}

}
