/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.Project;
import jp.co.ugatria.atsuco.form.LoginForm;

/**
 * @author Kashiwaba
 *
 */
public class LoginBean extends BaseBean {

	private LoginForm form;

	private LoginInfo loginInfo;

	private List<Project> projects;

	/**
	 * formを取得します.
	 * @return LoginForm form
	 */

	public LoginForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param LoginForm form
	 */

	public void setForm(LoginForm form) {
		this.form = form;
	}

	/**
	 * loginInfoを取得します.
	 * @return LoginInfo loginInfo
	 */

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	/**
	 * loginInfo を設定します.
	 * @param LoginInfo loginInfo
	 */

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	/**
	 * projectsを取得します.
	 * @return List<Project> projects
	 */

	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * projects を設定します.
	 * @param List<Project> projects
	 */

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
