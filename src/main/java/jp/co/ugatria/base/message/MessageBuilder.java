package jp.co.ugatria.base.message;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * メッセージ構築クラス
 * @author Hikaru Kashiwaba
 * @version 1.0
 */
public final class MessageBuilder {
	private static final ApplicationContext context =
			new ClassPathXmlApplicationContext("classpath:/application-config.xml");

	/*
	 * メッセージクラスからメッセージを構築します。
	 * @param message
	 * @return
	 */
	public static String build(Message message) {
		MessageSource messageSource = (MessageSource) context.getBean("messageSource");
		String msg = messageSource.getMessage(message.getMessageTemplate(), message.getArgs(),
		        message.getMessageTemplate(), Locale.getDefault());

		return msg;
	}
}
