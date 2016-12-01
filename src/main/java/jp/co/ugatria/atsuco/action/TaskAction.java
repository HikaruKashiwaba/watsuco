/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.TaskCreateBean;
import jp.co.ugatria.atsuco.bean.TaskUpdateBean;
import jp.co.ugatria.atsuco.entity.Task;
import jp.co.ugatria.atsuco.form.TaskCreateForm;
import jp.co.ugatria.atsuco.form.TaskUpdateForm;
import jp.co.ugatria.atsuco.service.TaskService;
import jp.co.ugatria.base.annotation.AsyncRequest;
import jp.co.ugatria.base.log.LoggerFactory;
import jp.co.ugatria.base.util.DateUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/tasks")
public class TaskAction extends BaseAction {

	private Logger log = LoggerFactory.make();

	@Autowired
	private TaskService service;

	@GET
	@Path("{taskId}/update")
	@AsyncRequest
	public Response edit(@PathParam("taskId") String taskId) {
		TaskUpdateBean bean = new TaskUpdateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setTaskId(taskId);
		setBean(bean);

		service.getDataForUpdate(bean);

		Task task = bean.getTask();

		TaskUpdateForm form = new TaskUpdateForm();
		form.setProjectId(task.getProjectId().toString());
		form.setTitle(task.getTitle());
		form.setContents(task.getContents());
		if (task.getStartDeadlineDate() != null) {
			form.setStartDeadlineDate(DateUtil.formatDate(task.getStartDeadlineDate(), "yyyy/MM/dd"));
		}
		if (task.getEndDeadlineDate() != null) {
			form.setEndDeadlineDate(DateUtil.formatDate(task.getEndDeadlineDate(), "yyyy/MM/dd"));
		}
		form.setRankNo(task.getRankNo().toString());
		bean.setForm(form);


		return getViewResponse("taskDetail");
	}

	@GET
	@Path("create")
	@AsyncRequest
	public Response entry() {
		TaskCreateBean bean = new TaskCreateBean();
		bean.setLoginInfo(getLoginInfo());
		setBean(bean);

		service.getDataForCreate(bean);

		TaskCreateForm form = new TaskCreateForm();
		form.setProjectId(getLoginInfo().getProjectId().toString());
		bean.setForm(form);

		return getViewResponse("taskCreate");
	}
}
