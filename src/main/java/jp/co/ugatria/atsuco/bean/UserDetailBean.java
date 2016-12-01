/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.Project;
import jp.co.ugatria.atsuco.entity.ProjectTeam;
import jp.co.ugatria.atsuco.entity.User;

/**
 * @author Kashiwaba
 *
 */
public class UserDetailBean extends BaseBean {

	private String userId;

	private User user;

	private List<Project> projects;

	private List<ProjectTeam> projectTeams;

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
	 * projectTeamsを取得します.
	 * @return List<ProjectTeam> projectTeams
	 */

	public List<ProjectTeam> getProjectTeams() {
		return projectTeams;
	}

	/**
	 * projectTeams を設定します.
	 * @param List<ProjectTeam> projectTeams
	 */

	public void setProjectTeams(List<ProjectTeam> projectTeams) {
		this.projectTeams = projectTeams;
	}
}
