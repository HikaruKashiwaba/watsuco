/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.form.ProjectCreateForm;

/**
 * @author Kashiwaba
 *
 */
public class ProjectCreateBean extends BaseBean {

	private ProjectCreateForm form;

	/**
	 * formを取得します.
	 * @return ProjectCreateForm form
	 */

	public ProjectCreateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param ProjectCreateForm form
	 */

	public void setForm(ProjectCreateForm form) {
		this.form = form;
	}
}
