package org.sapient.web.form;

import java.io.Serializable;



/**
 * @author spash1
 *
 */
public class PrintResumeForm implements Serializable
{
	
	private boolean mailResume ;

	/**
	 * @return the mailResume
	 */
	public boolean isMailResume() {
		return mailResume;
	}

	/**
	 * @param mailResume the mailResume to set
	 */
	public void setMailResume(boolean mailResume) {
		this.mailResume = mailResume;
	}
	
	

}
