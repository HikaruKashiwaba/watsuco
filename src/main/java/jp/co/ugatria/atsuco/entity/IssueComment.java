/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class IssueComment extends BaseEntity {

	private Integer companyId;

	private Integer projectId;

	private Integer taskId;

	private Integer issueId;

	private Integer commentNo;

	private String comment;

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
	 * issueIdを取得します.
	 * @return Integer issueId
	 */

	public Integer getIssueId() {
		return issueId;
	}

	/**
	 * issueId を設定します.
	 * @param Integer issueId
	 */

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	/**
	 * commentNoを取得します.
	 * @return Integer commentNo
	 */

	public Integer getCommentNo() {
		return commentNo;
	}

	/**
	 * commentNo を設定します.
	 * @param Integer commentNo
	 */

	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
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
