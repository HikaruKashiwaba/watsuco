/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.UserUpdateForm;

/**
 * @author Kashiwaba
 *
 */
public class UserUpdateBean extends BaseBean {

	private String userId;

	private User user;

	private UserUpdateForm form;

	/**
	 * userIdを取得します.
	 * @return String userId
	 */

	public String getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param String userId
	 */

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * userを取得します.
	 * @return User user
	 */

	public User getUser() {
		return user;
	}

	/**
	 * user を設定します.
	 * @param User user
	 */

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * formを取得します.
	 * @return UserUpdateForm form
	 */

	public UserUpdateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param UserUpdateForm form
	 */

	public void setForm(UserUpdateForm form) {
		this.form = form;
	}
}
