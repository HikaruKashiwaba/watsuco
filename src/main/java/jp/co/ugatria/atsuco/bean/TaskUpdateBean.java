/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.ProjectRank;
import jp.co.ugatria.atsuco.entity.Task;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.TaskUpdateForm;

/**
 * @author Kashiwaba
 *
 */
public class TaskUpdateBean extends BaseBean {

	private String taskId;

	private TaskUpdateForm form;

	private Task task;

	private List<User> users;

	private List<ProjectRank> projectRanks;

	/**
	 * taskIdを取得します.
	 * @return String taskId
	 */

	public String getTaskId() {
		return taskId;
	}

	/**
	 * taskId を設定します.
	 * @param String taskId
	 */

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * formを取得します.
	 * @return TaskUpdateForm form
	 */

	public TaskUpdateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param TaskUpdateForm form
	 */

	public void setForm(TaskUpdateForm form) {
		this.form = form;
	}

	/**
	 * taskを取得します.
	 * @return Task task
	 */

	public Task getTask() {
		return task;
	}

	/**
	 * task を設定します.
	 * @param Task task
	 */

	public void setTask(Task task) {
		this.task = task;
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
