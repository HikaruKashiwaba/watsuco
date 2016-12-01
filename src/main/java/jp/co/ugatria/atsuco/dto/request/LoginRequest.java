package jp.co.ugatria.atsuco.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlAttribute;

@XmlRootElement
public class LoginRequest {

	private String email;

	private String password;

	/**
	 * emailを取得します.
	 * @return String email
	 */
	@XmlAttribute("email")
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
	@XmlAttribute("password")
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
