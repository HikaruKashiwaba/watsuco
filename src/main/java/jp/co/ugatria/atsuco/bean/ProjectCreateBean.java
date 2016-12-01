/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.ProjectCreateForm;

/**
 * @author Kashiwaba
 *
 */
public class ProjectCreateBean extends BaseBean {

	private ProjectCreateForm form;

	private List<User> users;

	/**
	 * formを取得します.
	 * @return ProjectCreateForm form
	 */

	public ProjectCreateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param ProjectCreateForm form
	 */

	public void setForm(ProjectCreateForm form) {
		this.form = form;
	}

	/**
	 * usersを取得します.
	 * @return List<User> users
	 */

	public List<User> getUsers() {
		return users;
	}

	/**
	 * users を設定します.
	 * @param List<User> users
	 */

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
