/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.SummaryBean;
import jp.co.ugatria.atsuco.service.SummaryService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("/summary")
public class SummaryAction extends BaseAction {

	@Autowired
	private SummaryService service;

	@GET
	public Response showSummary(@QueryParam("projectId") String projectId) {
		SummaryBean bean = new SummaryBean();
		bean.setLoginInfo(getLoginInfo());
		setBean(bean);

		// ログイン情報のプロジェクトIDを変更する
		if (StringUtils.isNotEmpty(projectId)) {
			getLoginInfo().setProjectId(convertKey(projectId));
		}

		service.getSummary(bean);

		return getViewResponse("summary");
	}
//
//	@GET
//	@Path("project")
//	public Response changeProject(@QueryParam("projectId") String projectId) {
//		SummaryBean bean = new SummaryBean();
//		bean.setLoginInfo(getLoginInfo());
//		setBean(bean);
//
//		// ログイン情報のプロジェクトIDを変更する
//		getLoginInfo().setProjectId(convertKey(projectId));
//
//		service.getSummary(bean);
//
//		return getViewResponse("summary");
//	}
}
