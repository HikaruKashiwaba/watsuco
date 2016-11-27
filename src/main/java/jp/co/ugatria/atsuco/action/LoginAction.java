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
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.LoginBean;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.form.LoginForm;
import jp.co.ugatria.atsuco.service.LoginService;
import jp.co.ugatria.base.annotation.AsyncRequest;
import jp.co.ugatria.base.annotation.UnnecessaryLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/")
public class LoginAction extends BaseAction {

	@Autowired
	private LoginService service;

	@GET
	@Path("login")
	@AsyncRequest
	@UnnecessaryLogin
	public Response entrance() {
		LoginBean bean = new LoginBean();
		setBean(bean);

		if (getSessionInfo().getLoginInfo() != null) {
			return redirect("/summary");
		}

		return getViewResponse("login");
	}

	@POST
	@Path("login")
	@AsyncRequest
	@UnnecessaryLogin
	public Response login(@InjectParam LoginForm form) {
		LoginBean bean = new LoginBean();
		bean.setForm(form);
		setBean(bean);

        // バリデーション
        Validator validator = getValidator();
        Set<ConstraintViolation<LoginForm>> cv = validator.validate(form);
        bean.addMessages(cv);

        if (bean.getMessages().isEmpty()) {
        	service.login(bean);

        	if (bean.getLoginInfo() != null) {
        		setLoginInfo(bean.getLoginInfo());
        		return redirect("/summary");
        	}
        }
		return getViewResponse("login");
	}

	@GET
	@Path("logout")
	@AsyncRequest
	@UnnecessaryLogin
	public Response logout() {
		return redirect("/");
	}
}
