package jp.co.ugatria.atsuco.form;

import javax.ws.rs.FormParam;

/**
 * ログイン画面用入力フォーム.
 *
 * @author Kashiwaba
 *
 */
public class LoginForm {

	@FormParam("email")
	private String email;

	@FormParam("password")
	private String password;

	/**
	 * emailを取得します.
	 * @return String email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * email を設定します.
	 * @param String email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * passwordを取得します.
	 * @return String password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * password を設定します.
	 * @param String password
	 */

	public void setPassword(String password) {
		this.password = password;
	}
}
