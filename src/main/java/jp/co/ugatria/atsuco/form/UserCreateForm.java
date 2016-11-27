package jp.co.ugatria.atsuco.form;

import javax.ws.rs.FormParam;

public class UserCreateForm {

	@FormParam("email")
	private String email;

	@FormParam("password")
	private String password;

	@FormParam("confirmPassword")
	private String confirmPassword;

	@FormParam("userName")
	private String userName;

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

	/**
	 * confirmPasswordを取得します.
	 * @return String confirmPassword
	 */

	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * confirmPassword を設定します.
	 * @param String confirmPassword
	 */

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * userNameを取得します.
	 * @return String userName
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * userName を設定します.
	 * @param String userName
	 */

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
