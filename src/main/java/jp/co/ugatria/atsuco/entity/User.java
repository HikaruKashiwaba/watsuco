/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import java.util.Date;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class User extends BaseEntity {

	private Integer userId;

	private String email;

	private String password;

	private String userName;

	private String authority;

	private String authCtrl;

	private String iconFile;

	private Date lastLoginDate;

	/**
	 * userIdを取得します.
	 * @return Integer userId
	 */

	public Integer getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param Integer userId
	 */

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	/**
	 * authorityを取得します.
	 * @return String authority
	 */

	public String getAuthority() {
		return authority;
	}

	/**
	 * authority を設定します.
	 * @param String authority
	 */

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * authCtrlを取得します.
	 * @return String authCtrl
	 */

	public String getAuthCtrl() {
		return authCtrl;
	}

	/**
	 * authCtrl を設定します.
	 * @param String authCtrl
	 */

	public void setAuthCtrl(String authCtrl) {
		this.authCtrl = authCtrl;
	}

	/**
	 * iconFileを取得します.
	 * @return String iconFile
	 */

	public String getIconFile() {
		return iconFile;
	}

	/**
	 * iconFile を設定します.
	 * @param String iconFile
	 */

	public void setIconFile(String iconFile) {
		this.iconFile = iconFile;
	}

	/**
	 * lastLoginDateを取得します.
	 * @return Date lastLoginDate
	 */

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * lastLoginDate を設定します.
	 * @param Date lastLoginDate
	 */

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


}
