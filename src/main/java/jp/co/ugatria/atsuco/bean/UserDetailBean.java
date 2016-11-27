/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.Project;
import jp.co.ugatria.atsuco.entity.User;

/**
 * @author Kashiwaba
 *
 */
public class UserDetailBean extends BaseBean {

	private User user;

	private List<Project> projects;

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
