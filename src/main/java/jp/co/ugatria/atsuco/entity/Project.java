/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import java.util.Date;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class Project extends BaseEntity {

	private Integer companyId;

	private Integer projectId;

	private String projectName;

	private String summary;

	private Date startDate;

	private Date endDate;

	/**
	 * companyIdを取得します.
	 * @return Integer companyId
	 */

	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * companyId を設定します.
	 * @param Integer companyId
	 */

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * projectIdを取得します.
	 * @return Integer projectId
	 */

	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param Integer projectId
	 */

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

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
	 * @return Date startDate
	 */

	public Date getStartDate() {
		return startDate;
	}

	/**
	 * startDate を設定します.
	 * @param Date startDate
	 */

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * endDateを取得します.
	 * @return Date endDate
	 */

	public Date getEndDate() {
		return endDate;
	}

	/**
	 * endDate を設定します.
	 * @param Date endDate
	 */

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
