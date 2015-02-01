package org.sapient.web.controller.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author brout
 * 
 */
@Component("dateValidator")
public class DateValidator {
	private static Log log = LogFactory.getLog(DateValidator.class);

	private String build(int year, int month, int day) {
		StringBuffer yearAsString, monthAsString, dayAsString;
		yearAsString = new StringBuffer(String.valueOf(year));
		monthAsString = new StringBuffer(String.valueOf(month));
		dayAsString = new StringBuffer(String.valueOf(day));
		if (yearAsString.length() < 4) {
			return null;
		}
		if (monthAsString.length() < 2 && monthAsString.length() == 1) {
			monthAsString = new StringBuffer("0").append(monthAsString);
		}
		if (dayAsString.length() < 2 && dayAsString.length() == 1) {
			dayAsString = new StringBuffer("0").append(dayAsString);
		}
		StringBuffer dateAsString = yearAsString.append(monthAsString).append(
				dayAsString);
		log.info((String.format("The Formatted Date is [%s]", dateAsString)));
		return dateAsString.toString();
	}

	public boolean validate(int year, int month, int day) {
		String date = build(year, month, day);
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			try {
				formatter.setLenient(false);
				formatter.parse(date.toString());
			} catch (ParseException e) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	public boolean isFutureDate(int year, int month, int day) {
		Calendar cal = GregorianCalendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = cal.get(Calendar.YEAR);
		int currentDay = cal.get(Calendar.DAY_OF_MONTH);
		log.info(String.format("calendar day instance [%s]", currentDay));
		log.info(String.format("calendar day instance [%s]", currentMonth));
		log.info(String.format("calendar day instance [%s]", currentYear));

		if (day >= currentDay && month >= currentMonth && year >= currentYear) {
			return true;
		} else if (month > currentMonth && year >= currentYear) {
			return true;
		} else if (year > currentYear) {
			return true;
		}
		return false;
	}

}