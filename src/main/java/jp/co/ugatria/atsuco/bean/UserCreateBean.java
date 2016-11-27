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
}
