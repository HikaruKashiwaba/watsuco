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

import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/projects")
public class ProjectAction extends BaseAction {

	@GET
	public Response list() {
		ProjectListBean bean = new ProjectListBean();
		setBean(bean);

		return getViewResponse("projectList");
	}

	@GET
	@Path("{projectId}/update")
	public Response edit(@PathParam("projectId") String projectId) {
		ProjectUpdateBean bean = new ProjectUpdateBean();
		bean.setProjectId(projectId);
		bean.setForm(new ProjectUpdateForm());
		setBean(bean);

		return getViewResponse("projectUpdate");
	}

	@POST
	@Path("{projectId}/update")
	public Response update(@PathParam("projectId") String projectId, @InjectParam ProjectUpdateForm form) {
		ProjectUpdateBean bean = new ProjectUpdateBean();
		bean.setProjectId(projectId);
		bean.setForm(form);
		setBean(bean);

		return redirect("/projects/" + projectId + "/update");
	}

	@GET
	@Path("create")
	public Response entry() {
		ProjectCreateBean bean = new ProjectCreateBean();
		bean.setForm(new ProjectCreateForm());
		setBean(bean);

		return getViewResponse("projectCreate");
	}

	@POST
	@Path("create")
	public Response create(@InjectParam ProjectCreateForm form) {
		ProjectCreateBean bean = new ProjectCreateBean();
		bean.setForm(form);
		setBean(bean);

		String projectId = "1";
		return redirect("/projects/" + projectId + "/update");
	}
}
