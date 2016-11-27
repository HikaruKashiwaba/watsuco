/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.SummaryBean;

import org.springframework.stereotype.Component;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/summary")
public class SummaryAction extends BaseAction {

	@GET
	public Response showSummary() {
		SummaryBean bean = new SummaryBean();
		setBean(bean);

		return getViewResponse("summary");
	}
}
