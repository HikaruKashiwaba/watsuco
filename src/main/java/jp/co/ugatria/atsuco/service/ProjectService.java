/**
 *
 */
package jp.co.ugatria.atsuco.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ugatria.atsuco.bean.ProjectCreateBean;
import jp.co.ugatria.atsuco.bean.ProjectListBean;
import jp.co.ugatria.atsuco.bean.ProjectUpdateBean;
import jp.co.ugatria.atsuco.dao.ProjectDao;
import jp.co.ugatria.atsuco.dao.ProjectRankDao;
import jp.co.ugatria.atsuco.dao.ProjectTeamDao;
import jp.co.ugatria.atsuco.dao.UserDao;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.Project;
import jp.co.ugatria.atsuco.entity.ProjectRank;
import jp.co.ugatria.atsuco.entity.ProjectTeam;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.ProjectCreateForm;
import jp.co.ugatria.atsuco.form.ProjectUpdateForm;
import jp.co.ugatria.base.service.AbstractService;
import jp.co.ugatria.base.util.DateUtil;

/**
 * @author Kashiwaba
 *
 */
@Component
public class ProjectService extends AbstractService {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private ProjectTeamDao projectTeamDao;

	@Autowired
	private ProjectRankDao projectRankDao;

	@Autowired
	private UserDao userDao;

	public void getList(ProjectListBean bean) {
		LoginInfo info = bean.getLoginInfo();

		List<Project> projects = projectDao.findAll(info.getCompanyId());
		bean.setProjects(projects);
	}

	public void getDataForUpdate(ProjectUpdateBean bean) {
		LoginInfo info = bean.getLoginInfo();

		// プロジェクト
		Project project = projectDao.findByPrimary(info.getCompanyId(), convertKey(bean.getProjectId()));

		if (project == null) {
			return;
		}

		// プロジェクトチーム
		List<User> members = userDao.findByProjectId(info.getCompanyId(), convertKey(bean.getProjectId()));
		// ランク
		List<ProjectRank> projectRanks = projectRankDao.findByProjectId(info.getCompanyId(), convertKey(bean.getProjectId()));
		// 全担当者
		List<User> users = userDao.findAll(info.getCompanyId());

		// フォームに変換する
		ProjectUpdateForm form = new ProjectUpdateForm();
		form.setProjectName(project.getProjectName());
		form.setSummary(project.getSummary());
		if (project.getStartDate() != null) {
			form.setStartDate(DateUtil.formatDate(project.getStartDate(), "yyyy/MM/dd"));
		}
		if (project.getEndDate() != null) {
			form.setEndDate(DateUtil.formatDate(project.getEndDate(), "yyyy/MM/dd"));
		}
		List<String> userId = new ArrayList<String>();
		for (User member : members) {
			userId.add(member.getUserId().toString());
		}
		form.setUserId(userId);
		bean.setForm(form);

		bean.setProjectRanks(projectRanks);
		bean.setUsers(users);
	}

	public void updateProject(ProjectUpdateBean bean) {
		LoginInfo info = bean.getLoginInfo();

		ProjectUpdateForm form = bean.getForm();
		Long projectId = convertKey(bean.getProjectId());

		// プロジェクト
		Project project = projectDao.findByPrimary(info.getCompanyId(), projectId);

		if (project == null) {
			return;
		}

		// プロジェクトの更新
		project.setProjectName(form.getProjectName());
		project.setSummary(form.getSummary());
		if (StringUtils.isNotEmpty(form.getStartDate())) {
			project.setStartDate(DateUtil.parseDate(form.getStartDate(), "yyyy/MM/dd"));
		}
		if (StringUtils.isNotEmpty(form.getEndDate())) {
			project.setEndDate(DateUtil.parseDate(form.getEndDate(), "yyyy/MM/dd"));
		}
		project.setUpdateUserId(info.getUserId());
		projectDao.update(project);

		// プロジェクトメンバーの更新（削除->登録）
		projectTeamDao.deleteByProjectId(info.getCompanyId(), projectId);

		ProjectTeam team = new ProjectTeam();
		team.setCompanyId(info.getCompanyId());
		team.setProjectId(projectId);
		team.setUpdateUserId(info.getUserId());;
		team.setCreateUserId(info.getUserId());;

		for (String userId : form.getUserId()) {
			team.setUserId(convertKey(userId));
			projectTeamDao.insert(team);
		}
	}

	public void getDataForCreate(ProjectCreateBean bean) {
		LoginInfo info = bean.getLoginInfo();

		// 全担当者
		List<User> users = userDao.findAll(info.getCompanyId());
		bean.setUsers(users);
	}

	public void createProject(ProjectCreateBean bean) {
		LoginInfo info = bean.getLoginInfo();

		ProjectCreateForm form = bean.getForm();

		// プロジェクト
		Project project = new Project();

		// プロジェクトの登録
		project.setCompanyId(info.getCompanyId());
		project.setProjectName(form.getProjectName());
		project.setSummary(form.getSummary());
		if (StringUtils.isNotEmpty(form.getStartDate())) {
			project.setStartDate(DateUtil.parseDate(form.getStartDate(), "yyyy/MM/dd"));
		}
		if (StringUtils.isNotEmpty(form.getEndDate())) {
			project.setEndDate(DateUtil.parseDate(form.getEndDate(), "yyyy/MM/dd"));
		}
		project.setCreateUserId(info.getUserId());
		project.setUpdateUserId(info.getUserId());
		projectDao.insert(project);

		// プロジェクトメンバーの更新（削除->登録）
		ProjectTeam team = new ProjectTeam();
		team.setCompanyId(info.getCompanyId());
		team.setProjectId(project.getProjectId());
		team.setUpdateUserId(info.getUserId());;
		team.setCreateUserId(info.getUserId());;

		for (String userId : form.getUserId()) {
			team.setUserId(convertKey(userId));
			projectTeamDao.insert(team);
		}
	}
}
