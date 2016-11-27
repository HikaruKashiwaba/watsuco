/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.UserCreateBean;
import jp.co.ugatria.atsuco.bean.UserDetailBean;
import jp.co.ugatria.atsuco.bean.UserListBean;
import jp.co.ugatria.atsuco.bean.UserUpdateBean;
import jp.co.ugatria.atsuco.form.UserCreateForm;
import jp.co.ugatria.atsuco.form.UserUpdateForm;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/users")
public class UserAction extends BaseAction {

	@GET
	public Response list() {
		UserListBean bean = new UserListBean();
		setBean(bean);

		return getViewResponse("userList");
	}

	@GET
	@Path("{userId}")
	public Response select(@PathParam("userId") String userId) {
		UserDetailBean bean = new UserDetailBean();
		setBean(bean);

		return getViewResponse("userDetail");
	}

	@GET
	@Path("{userId}/update")
	public Response edit(@PathParam("userId") String userId) {
		UserUpdateBean bean = new UserUpdateBean();
		bean.setUserId(userId);
		bean.setForm(new UserUpdateForm());
		setBean(bean);

		return getViewResponse("userUpdate");
	}

	@POST
	@Path("{userId}/update")
	public Response update(@PathParam("userId") String userId, @InjectParam UserUpdateForm form) {
		UserUpdateBean bean = new UserUpdateBean();
		bean.setUserId(userId);
		bean.setForm(form);
		setBean(bean);

		return redirect("/users/" + userId);
	}

	@GET
	@Path("create")
	public Response entry() {
		UserCreateBean bean = new UserCreateBean();
		bean.setForm(new UserCreateForm());
		setBean(bean);

		return getViewResponse("userCreate");
	}

	@POST
	@Path("create")
	public Response create(@InjectParam UserCreateForm form) {
		UserCreateBean bean = new UserCreateBean();
		bean.setForm(form);
		setBean(bean);

		String userId = "1";
		return redirect("/users/" + userId);
	}


	@GET
	@Path("delete")
	public Response delete(@PathParam("userId") String userId) {
		return redirect("/users");
	}

}
