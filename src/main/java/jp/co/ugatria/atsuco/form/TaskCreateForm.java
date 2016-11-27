package jp.co.ugatria.atsuco.form;

import javax.ws.rs.FormParam;

public class TaskCreateForm {

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

	@FormParam("userId")
	private String userId;

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
}
