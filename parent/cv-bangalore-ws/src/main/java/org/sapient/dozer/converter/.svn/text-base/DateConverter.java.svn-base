package org.sapient.dozer.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.dozer.CustomConverter;

public class DateConverter implements CustomConverter {

	private static final String DATE_WITH_SLASHES = "dd/MM/yyyy";

	public Object convert(Object destination, Object source,
			Class<?> destinationClass, Class<?> sourceClass) {

		if (source == null) {
			return null;
		}

		String formattedDate = null;

		if (source instanceof Calendar) {
			source = ((Calendar) source).getTime();
		}

		if (source instanceof Date) {
			if (destination == null) {
				destination = new String();
			} else {
				formattedDate = (String) destination;
			}
			formattedDate = new SimpleDateFormat(DATE_WITH_SLASHES)
					.format(source);
		} else if (source instanceof String) {
			Date objDate = null;
			try {
				objDate = new SimpleDateFormat(DATE_WITH_SLASHES)
						.parse((String) source);
			} catch (ParseException e) {
				
			}
			Calendar objCalendar = Calendar.getInstance();
			objCalendar.setTime(objDate);
			return objCalendar;
		}
		return formattedDate;
	}
}