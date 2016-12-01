package jp.co.ugatria.atsuco.dto.session;

import java.io.Serializable;

public class LoginInfo implements Serializable {


	private static final long serialVersionUID = 5718933882348866040L;

	private Long companyId;

	private Long userId;

	private String email;

	private String name;

	private Integer adminFlag;

	private Long projectId;

	public LoginInfo() {
	}

	/**
	 * companyIdを取得します.
	 * @return Long companyId
	 */

	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * companyId を設定します.
	 * @param Long companyId
	 */

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * userIdを取得します.
	 * @return Long userId
	 */

	public Long getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param Long userId
	 */

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * emailを取得します.
	 * @return String email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * email を設定します.
	 * @param String email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * nameを取得します.
	 * @return String name
	 */

	public String getName() {
		return name;
	}

	/**
	 * name を設定します.
	 * @param String name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * adminFlagを取得します.
	 * @return Integer adminFlag
	 */

	public Integer getAdminFlag() {
		return adminFlag;
	}

	/**
	 * adminFlag を設定します.
	 * @param Integer adminFlag
	 */

	public void setAdminFlag(Integer adminFlag) {
		this.adminFlag = adminFlag;
	}

	/**
	 * projectIdを取得します.
	 * @return Long projectId
	 */

	public Long getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param Long projectId
	 */

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
}
