package jp.co.ugatria.atsuco.form;

public class TaskChangeForm {

	private String taskId;

	private String companyId;

	private String projectId;

	private String userId;

	private String status;

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
	 * companyIdを取得します.
	 * @return String companyId
	 */

	public String getCompanyId() {
		return companyId;
	}

	/**
	 * companyId を設定します.
	 * @param String companyId
	 */

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

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
	 * statusを取得します.
	 * @return String status
	 */

	public String getStatus() {
		return status;
	}

	/**
	 * status を設定します.
	 * @param String status
	 */

	public void setStatus(String status) {
		this.status = status;
	}
}
