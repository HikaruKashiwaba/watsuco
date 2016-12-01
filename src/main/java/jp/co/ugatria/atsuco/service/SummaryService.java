/**
 *
 */
package jp.co.ugatria.atsuco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ugatria.atsuco.bean.SummaryBean;
import jp.co.ugatria.atsuco.dao.ProjectDao;
import jp.co.ugatria.atsuco.dao.TaskDao;
import jp.co.ugatria.atsuco.dao.UserDao;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.Project;
import jp.co.ugatria.atsuco.entity.Task;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.base.message.Message;
import jp.co.ugatria.base.service.AbstractService;

/**
 * @author Kashiwaba
 *
 */
@Component
public class SummaryService extends AbstractService {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TaskDao taskDao;

	public void getSummary(SummaryBean bean) {
		LoginInfo info = bean.getLoginInfo();

		List<Project> projects = projectDao.findAll(info.getCompanyId());
		if (projects.isEmpty()) {
			bean.addMessages(new Message("info", "info.summary.0001"));
			return;
		}

		// セッションにプロジェクトIDを持っていない場合、先頭のプロジェクトを選択する.
		if (info.getProjectId() == null) {
			info.setProjectId(projects.get(0).getProjectId());
		}

		List<User> users = userDao.findByProjectId(info.getCompanyId(), info.getProjectId());
		if (users.isEmpty()) {
			bean.addMessages(new Message("info", "info.summary.0002"));
			return;
		}

		List<Task> tasks = taskDao.findByProjectId(info.getCompanyId(), info.getProjectId());

		bean.setProjects(projects);
		bean.setUsers(users);
		bean.setTasks(tasks);
	}
}
