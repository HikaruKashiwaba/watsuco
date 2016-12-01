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

	private String taskId;

	private TaskChangeForm form;

	/**
	 * taskIdを取得します.
	 * @return String taskId
	 */

	public String getTaskId() {
		return taskId;
	}

	/**
	 * taskId を設定します.
	 * @param String taskId
	 */

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

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
