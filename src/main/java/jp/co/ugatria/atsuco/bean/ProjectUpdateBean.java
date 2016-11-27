package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.form.ProjectUpdateForm;

public class ProjectUpdateBean extends BaseBean {

	private String projectId;

	private ProjectUpdateForm form;

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
	 * formを取得します.
	 * @return ProjectUpdateForm form
	 */

	public ProjectUpdateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param ProjectUpdateForm form
	 */

	public void setForm(ProjectUpdateForm form) {
		this.form = form;
	}
}
