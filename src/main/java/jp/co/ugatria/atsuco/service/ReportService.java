/**
 *
 */
package jp.co.ugatria.atsuco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jp.co.ugatria.atsuco.bean.ReportBean;
import jp.co.ugatria.atsuco.dao.DailyReportDao;
import jp.co.ugatria.atsuco.dao.ProjectDao;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.DailyReport;
import jp.co.ugatria.atsuco.entity.Project;
import jp.co.ugatria.base.message.Message;
import jp.co.ugatria.base.service.AbstractService;

/**
 * @author Kashiwaba
 *
 */
@Component
public class ReportService extends AbstractService {

	@Autowired
	private DailyReportDao dailyReportDao;

	@Autowired
	private ProjectDao projectDao;

	public void getReport(ReportBean bean) {
		LoginInfo info = bean.getLoginInfo();

		List<Project> projects = projectDao.findAll(info.getCompanyId());
		if (projects.isEmpty()) {
			bean.addMessages(new Message("info", "info.report.0001"));
			return;
		}
		bean.setProjects(projects);

		// セッションにプロジェクトIDを持っていない場合、先頭のプロジェクトを選択する.
		if (info.getProjectId() == null) {
			info.setProjectId(projects.get(0).getProjectId());
		}
		bean.setProjectId(info.getProjectId().toString());

		GsonBuilder gb = new GsonBuilder();
		gb.setDateFormat("yyyy-MM-dd");
		Gson gson = gb.create();
		// ステータスの推移状況
		bean.setStatusCntJson(gson.toJson(dailyReportDao.sumStatusCnt(info.getCompanyId(), info.getProjectId())));
		// 遅延状況
		bean.setDelayCntJson(gson.toJson(dailyReportDao.sumDelayCnt(info.getCompanyId(), info.getProjectId())));
	}
}
