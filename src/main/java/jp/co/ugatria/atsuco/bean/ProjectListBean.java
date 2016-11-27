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
public class ProjectListBean extends BaseBean {

	private List<Project> projects;

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
