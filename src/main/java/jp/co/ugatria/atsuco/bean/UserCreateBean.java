/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.form.UserCreateForm;

/**
 * @author Kashiwaba
 *
 */
public class UserCreateBean extends BaseBean {

	private UserCreateForm form;

	private Long userId;

	/**
	 * formを取得します.
	 * @return UserCreateForm form
	 */

	public UserCreateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param UserCreateForm form
	 */

	public void setForm(UserCreateForm form) {
		this.form = form;
	}

	/**
	 * userIdを取得します.
	 * @return Long userId
	 */

	public Long getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param Long userId
	 */

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
