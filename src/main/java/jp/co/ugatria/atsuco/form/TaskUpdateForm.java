package jp.co.ugatria.atsuco.form;

import javax.ws.rs.FormParam;

public class TaskUpdateForm {

	private String taskId;

	private String companyId;

	@FormParam("projectId")
	private String projectId;

	@FormParam("title")
	private String title;

	@FormParam("contents")
	private String contents;

	@FormParam("startDeadlineDate")
	private String startDeadlineDate;

	@FormParam("endDeadlineDate")
	private String endDeadlineDate;

	@FormParam("rankNo")
	private String rankNo;

	@FormParam("comment")
	private String comment;

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
	 * titleを取得します.
	 * @return String title
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * title を設定します.
	 * @param String title
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * contentsを取得します.
	 * @return String contents
	 */

	public String getContents() {
		return contents;
	}

	/**
	 * contents を設定します.
	 * @param String contents
	 */

	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * startDeadlineDateを取得します.
	 * @return String startDeadlineDate
	 */

	public String getStartDeadlineDate() {
		return startDeadlineDate;
	}

	/**
	 * startDeadlineDate を設定します.
	 * @param String startDeadlineDate
	 */

	public void setStartDeadlineDate(String startDeadlineDate) {
		this.startDeadlineDate = startDeadlineDate;
	}

	/**
	 * endDeadlineDateを取得します.
	 * @return String endDeadlineDate
	 */

	public String getEndDeadlineDate() {
		return endDeadlineDate;
	}

	/**
	 * endDeadlineDate を設定します.
	 * @param String endDeadlineDate
	 */

	public void setEndDeadlineDate(String endDeadlineDate) {
		this.endDeadlineDate = endDeadlineDate;
	}

	/**
	 * rankNoを取得します.
	 * @return String rankNo
	 */

	public String getRankNo() {
		return rankNo;
	}

	/**
	 * rankNo を設定します.
	 * @param String rankNo
	 */

	public void setRankNo(String rankNo) {
		this.rankNo = rankNo;
	}

	/**
	 * commentを取得します.
	 * @return String comment
	 */

	public String getComment() {
		return comment;
	}

	/**
	 * comment を設定します.
	 * @param String comment
	 */

	public void setComment(String comment) {
		this.comment = comment;
	}
}
