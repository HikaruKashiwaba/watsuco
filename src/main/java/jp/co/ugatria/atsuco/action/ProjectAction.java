/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.ProjectCreateBean;
import jp.co.ugatria.atsuco.bean.ProjectListBean;
import jp.co.ugatria.atsuco.bean.ProjectUpdateBean;
import jp.co.ugatria.atsuco.form.ProjectCreateForm;
import jp.co.ugatria.atsuco.form.ProjectUpdateForm;
import jp.co.ugatria.atsuco.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/projects")
public class ProjectAction extends BaseAction {

	@Autowired
	private ProjectService service;

	@GET
	public Response list() {
		ProjectListBean bean = new ProjectListBean();
		bean.setLoginInfo(getLoginInfo());
		setBean(bean);

		service.getList(bean);

		return getViewResponse("projectList");
	}

	@GET
	@Path("{projectId}/update")
	public Response edit(@PathParam("projectId") String projectId) {
		ProjectUpdateBean bean = new ProjectUpdateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setProjectId(projectId);
		setBean(bean);

		service.getDataForUpdate(bean);

		return getViewResponse("projectUpdate");
	}

	@POST
	@Path("{projectId}/update")
	public Response update(@PathParam("projectId") String projectId, @InjectParam ProjectUpdateForm form) {
		ProjectUpdateBean bean = new ProjectUpdateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setProjectId(projectId);
		bean.setForm(form);
		setBean(bean);

		service.updateProject(bean);

		return redirect("/projects/" + projectId + "/update");
	}

	@GET
	@Path("create")
	public Response entry() {
		ProjectCreateBean bean = new ProjectCreateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setForm(new ProjectCreateForm());
		setBean(bean);

		service.getDataForCreate(bean);

		return getViewResponse("projectCreate");
	}

	@POST
	@Path("create")
	public Response create(@InjectParam ProjectCreateForm form) {
		ProjectCreateBean bean = new ProjectCreateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setForm(form);
		setBean(bean);

		service.createProject(bean);

		String projectId = "1";
		return redirect("/projects/" + projectId + "/update");
	}
}
