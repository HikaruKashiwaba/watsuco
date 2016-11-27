package jp.co.ugatria.atsuco.form;

import java.util.List;

import javax.ws.rs.FormParam;

public class ProjectUpdateForm {

	@FormParam("projectName")
	private String projectName;

	@FormParam("summary")
	private String summary;

	@FormParam("startDate")
	private String startDate;

	@FormParam("endDate")
	private String endDate;

	@FormParam("userId")
	private List<String> userId;

	/**
	 * projectNameを取得します.
	 * @return String projectName
	 */

	public String getProjectName() {
		return projectName;
	}

	/**
	 * projectName を設定します.
	 * @param String projectName
	 */

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * summaryを取得します.
	 * @return String summary
	 */

	public String getSummary() {
		return summary;
	}

	/**
	 * summary を設定します.
	 * @param String summary
	 */

	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * startDateを取得します.
	 * @return String startDate
	 */

	public String getStartDate() {
		return startDate;
	}

	/**
	 * startDate を設定します.
	 * @param String startDate
	 */

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * endDateを取得します.
	 * @return String endDate
	 */

	public String getEndDate() {
		return endDate;
	}

	/**
	 * endDate を設定します.
	 * @param String endDate
	 */

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * userIdを取得します.
	 * @return List<String> userId
	 */

	public List<String> getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param List<String> userId
	 */

	public void setUserId(List<String> userId) {
		this.userId = userId;
	}

}
