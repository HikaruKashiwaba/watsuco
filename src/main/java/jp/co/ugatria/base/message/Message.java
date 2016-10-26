package jp.co.ugatria.base.message;

import java.util.Arrays;

import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.ArrayUtils;

public final class Message {
	private String propertyName;
	private String messageTemplate;
	private Object[] args;

	public Message(String propertyName, String messageTemplate) {
		this(propertyName, messageTemplate, (Object) null);
	}

	public Message(String propertyName, String messageTemplate, Object... args) {
		this.propertyName = propertyName;
		this.messageTemplate = messageTemplate;
		this.args = args;
	}

	public Message(ConstraintViolation<?> cv) {
		this(cv, (Object) null);
	}

	public Message(ConstraintViolation<?> cv, Object... args) {
		this.propertyName = cv.getPropertyPath().toString();
		this.messageTemplate = cv.getMessageTemplate();
		this.args = args;
	}

	public String getPropertyName() {
		return propertyName;
	}
	public String getMessageTemplate() {
		return messageTemplate;
	}
	public String getMessage() {
		return MessageBuilder.build(this);
	}
	public Object[] getArgs() {
		return args;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}

		Message another = (Message) o;
		if (propertyName != null ? propertyName.equals(another.propertyName) : another.propertyName != null) {
			return false;
		}

		if (messageTemplate != null ? messageTemplate.equals(another.messageTemplate) : another.messageTemplate != null) {
			return false;
		}
		if (args != null ? ArrayUtils.isEquals(args, another) : another.args != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = propertyName != null ? propertyName.hashCode() : 0;
		result = 31 * result + ( messageTemplate != null ? messageTemplate.hashCode() : 0 );
		result = 31 * result + ( args != null ? args.hashCode() : 0 );
		return result;
	}

	@Override
	public String toString() {
		return "Message [propertyName=" + propertyName + ", messageTemplate=" + messageTemplate + ", args="
				+ Arrays.toString(args) + "]";
	}


}
