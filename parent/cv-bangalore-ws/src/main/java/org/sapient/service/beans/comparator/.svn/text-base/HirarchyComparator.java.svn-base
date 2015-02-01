package org.sapient.service.beans.comparator;

import java.util.Comparator;

import org.sapient.service.beans.PersonalInfoVO;

/**
 * @author brout
 *
 */
public class HirarchyComparator implements Comparator {
	
	public int compare(Object empOne, Object empTwo) {
		
   String empNameOne = ((PersonalInfoVO)empOne).getFirstName();        
   String empNameTwo = ((PersonalInfoVO)empTwo).getFirstName();
        
   return empNameOne.compareTo(empNameTwo);
	}

}
