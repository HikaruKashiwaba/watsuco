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
public class Task extends BaseEntity {

	private Integer companyId;

	private Integer projectId;

	private Integer taskId;

	private String title;

	private String contents;

	private Date startDeadlineDate;

	private Date endDeadlineDate;

	private Integer rankNo;

	private Integer point;

	private Integer userId;

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
	 * taskIdを取得します.
	 * @return Integer taskId
	 */

	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * taskId を設定します.
	 * @param Integer taskId
	 */

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
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
	 * @return Date startDeadlineDate
	 */

	public Date getStartDeadlineDate() {
		return startDeadlineDate;
	}

	/**
	 * startDeadlineDate を設定します.
	 * @param Date startDeadlineDate
	 */

	public void setStartDeadlineDate(Date startDeadlineDate) {
		this.startDeadlineDate = startDeadlineDate;
	}

	/**
	 * endDeadlineDateを取得します.
	 * @return Date endDeadlineDate
	 */

	public Date getEndDeadlineDate() {
		return endDeadlineDate;
	}

	/**
	 * endDeadlineDate を設定します.
	 * @param Date endDeadlineDate
	 */

	public void setEndDeadlineDate(Date endDeadlineDate) {
		this.endDeadlineDate = endDeadlineDate;
	}

	/**
	 * rankNoを取得します.
	 * @return Integer rankNo
	 */

	public Integer getRankNo() {
		return rankNo;
	}

	/**
	 * rankNo を設定します.
	 * @param Integer rankNo
	 */

	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}

	/**
	 * pointを取得します.
	 * @return Integer point
	 */

	public Integer getPoint() {
		return point;
	}

	/**
	 * point を設定します.
	 * @param Integer point
	 */

	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 * userIdを取得します.
	 * @return Integer userId
	 */

	public Integer getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param Integer userId
	 */

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
