package jp.co.ugatria.base.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 非同期通信処理を表すタグ.
 * @author hikaru.kashiwaba
 *
 */
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface AsyncRequest {

}
