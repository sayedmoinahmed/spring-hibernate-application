package org.sapient.dozer.converter;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.dozer.CustomConverter;

public class TimestampConverter implements CustomConverter {

	private static final String TIMESTAMP_FORMAT = "kk:mm";

	SimpleDateFormat simpleDateFormat = null;

	public Object convert(Object destination, Object source,
			Class<?> destinationClass, Class<?> sourceClass) {

		if (source == null) {
			return null;
		}

		String formattedDate = null;

		if (source instanceof Date) {
			if (destination == null) {
				destination = new String();
			} else {
				formattedDate = (String) destination;
			}
			formattedDate = new SimpleDateFormat(TIMESTAMP_FORMAT)
					.format(source);
		}
		return formattedDate;
	}
}
