package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.ProjectRank;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.ProjectUpdateForm;

public class ProjectUpdateBean extends BaseBean {

	private String projectId;

	private ProjectUpdateForm form;

	private List<User> users;

	private List<ProjectRank> projectRanks;

	/**
	 * projectIdを取得します.
	 * @return String projectId
	 */

	public String getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param String projectId
	 */

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * formを取得します.
	 * @return ProjectUpdateForm form
	 */

	public ProjectUpdateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param ProjectUpdateForm form
	 */

	public void setForm(ProjectUpdateForm form) {
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

	/**
	 * projectRanksを取得します.
	 * @return List<ProjectRank> projectRanks
	 */

	public List<ProjectRank> getProjectRanks() {
		return projectRanks;
	}

	/**
	 * projectRanks を設定します.
	 * @param List<ProjectRank> projectRanks
	 */

	public void setProjectRanks(List<ProjectRank> projectRanks) {
		this.projectRanks = projectRanks;
	}
}
