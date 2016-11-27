/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.form.TaskChangeForm;

/**
 * @author Kashiwaba
 *
 */
public class TaskChangeBean extends BaseBean {

	private TaskChangeForm form;

	/**
	 * formを取得します.
	 * @return TaskChangeForm form
	 */

	public TaskChangeForm getForm() {
		return form;
	}

	/**
	 * form を設定します.
	 * @param TaskChangeForm form
	 */

	public void setForm(TaskChangeForm form) {
		this.form = form;
	}
}
