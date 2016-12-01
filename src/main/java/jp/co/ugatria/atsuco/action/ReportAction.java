/**
 *
 */
package jp.co.ugatria.atsuco.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.ReportBean;
import jp.co.ugatria.atsuco.service.ReportService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kashiwaba
 *
 */
@Component
@Path("report")
public class ReportAction extends BaseAction {

	@Autowired
	private ReportService service;

	@GET
	public Response showReport(@QueryParam("projectId") String projectId) {
		ReportBean bean = new ReportBean();
		bean.setLoginInfo(getLoginInfo());
		setBean(bean);

		// ログイン情報のプロジェクトIDを変更する
		if (StringUtils.isNotEmpty(projectId)) {
			getLoginInfo().setProjectId(convertKey(projectId));
		}

		service.getReport(bean);

		return getViewResponse("report");
	}
}
