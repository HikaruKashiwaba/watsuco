package jp.co.ugatria.base.bean;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import jp.co.ugatria.base.message.Message;

/**
 * 画面表示用ビーン基底クラス
 * @author Hikaru Kashiwaba
 * @version 1.0
 */
public abstract class AbstractBean {

	private Set<Message> messages = new LinkedHashSet<Message>();

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public void addMessages(Message message) {
		this.messages.add(message);
	}

	public void addMessages(Message[] messages) {
		this.messages.addAll(Arrays.asList(messages));
	}

	public void addMessages(Message[] messages, Object... args) {
		for (Message m : messages) {
			this.messages.add(new Message(m.getPropertyName(), m.getMessageTemplate(), args));
		}
	}

	public void addMessages(Collection<?> messages) {
		for (Iterator<?> ite = messages.iterator(); ite.hasNext();) {
			Object obj = ite.next();
			if (obj instanceof ConstraintViolation<?>) {
				this.messages.add(new Message((ConstraintViolation<?>) obj));
			} else if (obj instanceof Message) {
				this.messages.add((Message) obj);
			}
		}
	}

	public void addMessages(Collection<?> messages, Object... args) {
		for (Iterator<?> ite = messages.iterator(); ite.hasNext();) {
			Object obj = ite.next();
			if (obj instanceof ConstraintViolation<?>) {
				this.messages.add(new Message((ConstraintViolation<?>) obj, args));
			} else if (obj instanceof Message) {
				Message m = (Message) obj;
				this.messages.add(new Message(m.getPropertyName(), m.getMessageTemplate(), args));
			}
		}
	}

	public boolean hasMessage() {
		return messages.size() != 0;
	}

	public boolean hasMessage(String key) {
		for (Iterator<Message> ite = messages.iterator(); ite.hasNext();) {
			Message obj = ite.next();
			if (obj.getPropertyName().equals(key)) {
				return true;
			}
		}
		return false;
	}
}
