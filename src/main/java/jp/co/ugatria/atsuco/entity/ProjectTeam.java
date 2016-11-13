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

	private Integer companyId;

	private Integer projectId;

	private Integer userId;

	private String role;

	private Integer carryPoint;

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

}
