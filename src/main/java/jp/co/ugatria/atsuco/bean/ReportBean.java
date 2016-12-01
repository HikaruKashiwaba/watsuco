/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.Project;

/**
 * @author Kashiwaba
 *
 */
public class ReportBean extends BaseBean {

	private String projectId;

	private List<Project> projects;

	private String statusCntJson;

	private String delayCntJson;

	/**
	 * projectIdを取得します.
	 * @return String projectId
	 */

	public String getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param String projectId
	 */

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	/**
	 * statusCntJsonを取得します.
	 * @return String statusCntJson
	 */

	public String getStatusCntJson() {
		return statusCntJson;
	}

	/**
	 * statusCntJson を設定します.
	 * @param String statusCntJson
	 */

	public void setStatusCntJson(String statusCntJson) {
		this.statusCntJson = statusCntJson;
	}

	/**
	 * delayCntJsonを取得します.
	 * @return String delayCntJson
	 */

	public String getDelayCntJson() {
		return delayCntJson;
	}

	/**
	 * delayCntJson を設定します.
	 * @param String delayCntJson
	 */

	public void setDelayCntJson(String delayCntJson) {
		this.delayCntJson = delayCntJson;
	}
}
