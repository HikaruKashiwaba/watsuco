/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.TaskChangeBean;
import jp.co.ugatria.atsuco.bean.TaskCreateBean;
import jp.co.ugatria.atsuco.bean.TaskUpdateBean;
import jp.co.ugatria.atsuco.form.JsonForm;
import jp.co.ugatria.atsuco.form.TaskChangeForm;
import jp.co.ugatria.atsuco.form.TaskCreateForm;
import jp.co.ugatria.atsuco.form.TaskUpdateForm;
import jp.co.ugatria.base.annotation.AsyncRequest;
import jp.co.ugatria.base.log.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/tasks")
public class TaskAction extends BaseAction {

	private Logger log = LoggerFactory.make();

	@GET
	@Path("{taskId}/update")
	@AsyncRequest
	public Response edit(@PathParam("taskId") String taskId) {
		TaskUpdateBean bean = new TaskUpdateBean();
		setBean(bean);

		return getViewResponse("taskDetail");
	}

	@POST
	@Path("{taskId}/update")
	@AsyncRequest
	public Response update(@PathParam("taskId") String taskId, @InjectParam JsonForm form) {
		TaskUpdateBean bean = new TaskUpdateBean();
		setBean(bean);

		log.info(form.getParam());

		Gson gson = new GsonBuilder().create();
		TaskUpdateForm taskForm = gson.fromJson(form.getParam(), TaskUpdateForm.class);
		bean.setForm(taskForm);

		return Response.ok("{\"userId\":\"1\",\"taskId\":\"2\",\"rankNo\":\"3\"}").build();
	}

	@GET
	@Path("create")
	@AsyncRequest
	public Response entry() {
		TaskCreateBean bean = new TaskCreateBean();
		setBean(bean);

		return getViewResponse("taskCreate");
	}

	@POST
	@Path("create")
	@AsyncRequest
	public Response create(@InjectParam JsonForm form) {
		TaskCreateBean bean = new TaskCreateBean();
		setBean(bean);

		log.info(form.getParam());

		Gson gson = new GsonBuilder().create();
		TaskCreateForm taskForm = gson.fromJson(form.getParam(), TaskCreateForm.class);
		bean.setForm(taskForm);

		return Response.ok("{\"taskId\":\"3\",\"rankNo\":\"1\"}").build();
	}


	@POST
	@Path("{taskId}/change")
	@AsyncRequest
	public Response change(@PathParam("taskId") String taskId, @InjectParam JsonForm form) {
		TaskChangeBean bean = new TaskChangeBean();
		setBean(bean);

		log.info(form.getParam());

		Gson gson = new GsonBuilder().create();
		TaskChangeForm changeForm = gson.fromJson(form.getParam(), TaskChangeForm.class);
		bean.setForm(changeForm);

		String message = "";
		if (changeForm.getStatus().equals("1")) {
			message = "タスクを未着手に変えたよ。";
		} else if (changeForm.getStatus().equals("2")) {
			message = "タスクを仕掛中にしたよ。";
		} else if (changeForm.getStatus().equals("3")) {
			message = "タスクが完了したよ。";
		}

		return Response.ok("{\"message\":\"" + message + "\"}").build();
	}


	@GET
	@Path("delete")
	public Response delete(@PathParam("taskId") String taskId) {
		return redirect("/tasks");
	}
}
