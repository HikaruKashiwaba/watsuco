/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class ProjectTeam extends BaseEntity {

	private Long companyId;

	private Long projectId;

	private Long userId;

	private String role;

	private Integer carryPoint;

	private Project project;

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

	/**
	 * roleを取得します.
	 * @return String role
	 */

	public String getRole() {
		return role;
	}

	/**
	 * role を設定します.
	 * @param String role
	 */

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * carryPointを取得します.
	 * @return Integer carryPoint
	 */

	public Integer getCarryPoint() {
		return carryPoint;
	}

	/**
	 * carryPoint を設定します.
	 * @param Integer carryPoint
	 */

	public void setCarryPoint(Integer carryPoint) {
		this.carryPoint = carryPoint;
	}

	/**
	 * projectを取得します.
	 * @return Project project
	 */

	public Project getProject() {
		return project;
	}

	/**
	 * project を設定します.
	 * @param Project project
	 */

	public void setProject(Project project) {
		this.project = project;
	}

}
