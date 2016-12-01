package jp.co.ugatria.atsuco.dto.response;

import java.util.List;

import jp.co.ugatria.atsuco.entity.Project;


public class LoginResponse extends JsonResponse {

	private Long companyId;

	private Long userId;

	private String email;

	private String name;

	private List<Project> projects;

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
	 * projectsを取得します.
	 * @return List<Project> projects
	 */

	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * projects を設定します.
	 * @param List<Project> projects
	 */

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
