/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.form.IssueUpdateForm;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/issues")
public class IssueAction extends BaseAction {

	@GET
	public Response list() {
		return getViewResponse("issueList");
	}

	@GET
	@Path("{issueId}")
	public Response select(@PathParam("issueId") String issueId) {
		return getViewResponse("issueDetail");
	}

	@GET
	@Path("{issueId}/update")
	public Response edit(@PathParam("issueId") String issueId) {
		return getViewResponse("issueUpdate");
	}

	@POST
	@Path("{issueId}/update")
	public Response update(@PathParam("issueId") String issueId, @InjectParam IssueUpdateForm form) {
		return redirect("/issues/" + issueId);
	}

	@GET
	@Path("delete")
	public Response delete(@PathParam("issueId") String issueId) {
		return redirect("/issues");
	}

}
