/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.form.TaskCreateForm;

/**
 * @author Kashiwaba
 *
 */
public class TaskCreateBean extends BaseBean {

	private TaskCreateForm form;

	/**
	 * formを取得します.
	 * @return TaskCreateForm form
	 */

	public TaskCreateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param TaskCreateForm form
	 */

	public void setForm(TaskCreateForm form) {
		this.form = form;
	}
}
