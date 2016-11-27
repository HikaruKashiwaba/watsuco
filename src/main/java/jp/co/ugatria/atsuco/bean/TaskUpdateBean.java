/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.form.TaskUpdateForm;

/**
 * @author Kashiwaba
 *
 */
public class TaskUpdateBean extends BaseBean {

	private TaskUpdateForm form;

	/**
	 * formを取得します.
	 * @return TaskUpdateForm form
	 */

	public TaskUpdateForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param TaskUpdateForm form
	 */

	public void setForm(TaskUpdateForm form) {
		this.form = form;
	}
}
