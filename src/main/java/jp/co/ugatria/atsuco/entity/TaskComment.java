/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class TaskComment extends BaseEntity {

	private Long companyId;

	private Long projectId;

	private Long taskId;

	private Integer commentNo;

	private String comment;

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
