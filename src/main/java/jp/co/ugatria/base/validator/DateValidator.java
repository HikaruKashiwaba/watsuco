package jp.co.ugatria.base.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.ugatria.base.validator.constraints.Date;

public class DateValidator implements ConstraintValidator<Date, String> {
	
	private String[] format;
	
	public void initialize(final Date parameters) {
		format = parameters.format();
	}

	public boolean isValid( String value, ConstraintValidatorContext context ) {
		if (value == null || value.length() == 0) {
			return true;
		}
		
		for (int i = 0; i < format.length; i++) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format[i]);
				if (sdf.format(sdf.parse(value)).equals(value)) {
					return true;
				}
			} catch (ParseException e) {
			}
		}
		return false;
	}
}