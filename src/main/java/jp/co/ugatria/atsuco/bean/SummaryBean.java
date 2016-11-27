/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.Project;
import jp.co.ugatria.atsuco.entity.Task;
import jp.co.ugatria.atsuco.entity.User;

/**
 * @author Kashiwaba
 *
 */
public class SummaryBean extends BaseBean {

	private List<Project> projects;

	private List<User> users;

	private List<Task> tasks;

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

	/**
	 * tasksを取得します.
	 * @return List<Task> tasks
	 */

	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * tasks を設定します.
	 * @param List<Task> tasks
	 */

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
