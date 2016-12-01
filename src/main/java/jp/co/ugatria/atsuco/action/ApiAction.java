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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.LoginBean;
import jp.co.ugatria.atsuco.dto.request.LoginRequest;
import jp.co.ugatria.atsuco.dto.request.TaskListRequest;
import jp.co.ugatria.atsuco.dto.response.LoginResponse;
import jp.co.ugatria.atsuco.dto.response.TaskListResponse;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.form.LoginForm;
import jp.co.ugatria.atsuco.service.LoginService;
import jp.co.ugatria.base.annotation.AsyncRequest;
import jp.co.ugatria.base.annotation.UnnecessaryLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/api")
public class ApiAction extends BaseAction {

	@Autowired
	private LoginService service;

	@POST
	@Path("login")
	@AsyncRequest
	@UnnecessaryLogin
	public Response login(@InjectParam LoginForm form) {
		LoginResponse res = new LoginResponse();

		LoginBean bean = new LoginBean();
		bean.setForm(form);

        // バリデーション
        Validator validator = getValidator();
        Set<ConstraintViolation<LoginForm>> cv = validator.validate(form);
        bean.addMessages(cv);

        if (bean.getMessages().isEmpty()) {
        	service.login(bean);

        	if (bean.getLoginInfo() != null) {
        		LoginInfo info = bean.getLoginInfo();
        		setLoginInfo(info);

        		res.setCompanyId(info.getCompanyId());
        		res.setUserId(info.getUserId());
        		res.setEmail(info.getEmail());
        		res.setName(info.getName());
        		res.setProjects(bean.getProjects());

        		Gson gson = new GsonBuilder().create();
        		return Response.ok(gson.toJson(res)).build();
        	}
        }

		return Response.ok("{\"message\":\"メールアドレスまたはパスワードが違います。\"}").build();
	}

	@GET
	@Path("tasks")
	public Response getTaskList(@InjectParam TaskListRequest req) {

		TaskListResponse res = new TaskListResponse();
		Gson gson = new GsonBuilder().create();
		return Response.ok(gson.toJson(res)).build();
	}
}
