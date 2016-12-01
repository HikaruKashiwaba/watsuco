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

	private Long companyId;

	private Long projectId;

	private Long taskId;

	private String title;

	private String contents;

	private Date startDeadlineDate;

	private Date endDeadlineDate;

	private String status;

	private Integer rankNo;

	private Integer point;

	private Long userId;

	/**
	 * companyIdを取得します.
	 * @return Integer companyId
	 */

	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * companyId を設定します.
	 * @param Integer companyId
	 */

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * projectIdを取得します.
	 * @return Integer projectId
	 */

	public Long getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param Integer projectId
	 */

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * taskIdを取得します.
	 * @return Integer taskId
	 */

	public Long getTaskId() {
		return taskId;
	}

	/**
	 * taskId を設定します.
	 * @param Integer taskId
	 */

	public void setTaskId(Long taskId) {
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

	public Long getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param Integer userId
	 */

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
