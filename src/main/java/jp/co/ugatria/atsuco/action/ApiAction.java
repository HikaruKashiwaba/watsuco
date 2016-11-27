/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.dto.request.LoginRequest;
import jp.co.ugatria.atsuco.dto.request.TaskListRequest;
import jp.co.ugatria.atsuco.dto.response.LoginResponse;
import jp.co.ugatria.atsuco.dto.response.TaskListResponse;
import jp.co.ugatria.base.annotation.AsyncRequest;
import jp.co.ugatria.base.annotation.UnnecessaryLogin;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/api")
public class ApiAction extends BaseAction {

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@AsyncRequest
	@UnnecessaryLogin
	public Response login(LoginRequest req) {
		LoginResponse res = new LoginResponse();

		Gson gson = new GsonBuilder().create();
		return Response.ok(gson.toJson(res)).build();
	}

	@GET
	@Path("tasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTaskList(TaskListRequest req) {
		TaskListResponse res = new TaskListResponse();

		Gson gson = new GsonBuilder().create();
		return Response.ok(gson.toJson(res)).build();
	}
}
