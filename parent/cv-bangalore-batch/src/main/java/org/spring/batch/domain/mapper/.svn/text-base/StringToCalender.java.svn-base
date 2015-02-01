package org.spring.batch.domain.mapper;

import java.util.*;
import java.text.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringToCalender {
	private static final Log LOG = LogFactory.getLog(StringToCalender.class);
	private Calendar calendar;

	public static void main(String[] args) {
		try {
			String str_date = "8-Feb-11";
			DateFormat formatter;
			Date date;
			formatter = new SimpleDateFormat("dd-MMM-yy");
			date = (Date) formatter.parse(str_date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			System.out.println(date);
			LOG.info("Today is " + date);
		} catch (ParseException e) {
			LOG.info("Exception :" + e);
		}

	}

	public Calendar getCalendar(String str) {
		try {
			DateFormat formatter;
			Date date;
			if(str.contains("-"))
				formatter = new SimpleDateFormat("dd-MM-yyyy");
			else
				formatter = new SimpleDateFormat("MM/dd/yyyy");
			date = (Date) formatter.parse(str);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			System.out.println("Today is " + date);
			this.calendar = cal;
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}
		return this.calendar;
	}
}