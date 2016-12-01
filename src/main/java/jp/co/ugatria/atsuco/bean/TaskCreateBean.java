/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.ProjectRank;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.TaskCreateForm;

/**
 * @author Kashiwaba
 *
 */
public class TaskCreateBean extends BaseBean {

	private TaskCreateForm form;

	private List<User> users;

	private List<ProjectRank> projectRanks;

	private Long taskId;


	/**
	 * formを取得します.
	 * @return TaskCreateForm form
	 */

	public TaskCreateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param TaskCreateForm form
	 */

	public void setForm(TaskCreateForm form) {
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

	/**
	 * taskIdを取得します.
	 * @return Long taskId
	 */

	public Long getTaskId() {
		return taskId;
	}

	/**
	 * taskId を設定します.
	 * @param Long taskId
	 */

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
}
