/**
 *
 */
package jp.co.ugatria.atsuco.action;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.UserCreateBean;
import jp.co.ugatria.atsuco.bean.UserDetailBean;
import jp.co.ugatria.atsuco.bean.UserListBean;
import jp.co.ugatria.atsuco.bean.UserUpdateBean;
import jp.co.ugatria.atsuco.form.LoginForm;
import jp.co.ugatria.atsuco.form.UserCreateForm;
import jp.co.ugatria.atsuco.form.UserUpdateForm;
import jp.co.ugatria.atsuco.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/users")
public class UserAction extends BaseAction {

	@Autowired
	private UserService service;

	@GET
	public Response list() {
		UserListBean bean = new UserListBean();
		bean.setLoginInfo(getLoginInfo());
		setBean(bean);

		service.getList(bean);

		return getViewResponse("userList");
	}

	@GET
	@Path("{userId}")
	public Response select(@PathParam("userId") String userId) {
		UserDetailBean bean = new UserDetailBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setUserId(userId);
		setBean(bean);

		service.select(bean);

		if (bean.getUser() == null) {
			return Response.status(404).build();
		}

		return getViewResponse("userDetail");
	}

	@GET
	@Path("{userId}/update")
	public Response edit(@PathParam("userId") String userId) {
		UserUpdateBean bean = new UserUpdateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setUserId(userId);
		setBean(bean);

		service.getDataForUpdate(bean);

		if (bean.getUser() != null) {
			UserUpdateForm form = new UserUpdateForm();
			form.setEmail(bean.getUser().getEmail());
			form.setUserName(bean.getUser().getUserName());
			bean.setForm(form);
			return getViewResponse("userUpdate");
		}
		return Response.status(404).build();
	}

	@POST
	@Path("{userId}/update")
	public Response update(@PathParam("userId") String userId, @InjectParam UserUpdateForm form) {
		UserUpdateBean bean = new UserUpdateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setUserId(userId);
		bean.setForm(form);
		setBean(bean);

        // バリデーション
        Validator validator = getValidator();
        Set<ConstraintViolation<UserUpdateForm>> cv = validator.validate(form);
        bean.addMessages(cv);

        if (bean.getMessages().isEmpty()) {
        	service.update(bean);
        }

		return redirect("/users/" + userId);
	}

	@GET
	@Path("create")
	public Response entry() {
		UserCreateBean bean = new UserCreateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setForm(new UserCreateForm());
		setBean(bean);

		return getViewResponse("userCreate");
	}

	@POST
	@Path("create")
	public Response create(@InjectParam UserCreateForm form) {
		UserCreateBean bean = new UserCreateBean();
		bean.setLoginInfo(getLoginInfo());
		bean.setForm(form);
		setBean(bean);

        // バリデーション
        Validator validator = getValidator();
        Set<ConstraintViolation<UserCreateForm>> cv = validator.validate(form);
        bean.addMessages(cv);

        if (bean.getMessages().isEmpty()) {
        	service.insert(bean);
        }

		String userId = "1";
		return redirect("/users/" + userId);
	}


	@GET
	@Path("delete")
	public Response delete(@PathParam("userId") String userId) {
		return redirect("/users");
	}

}
