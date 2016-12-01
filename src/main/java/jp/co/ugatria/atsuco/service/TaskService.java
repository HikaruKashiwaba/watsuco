package jp.co.ugatria.atsuco.service;

import jp.co.ugatria.atsuco.bean.TaskChangeBean;
import jp.co.ugatria.atsuco.bean.TaskCreateBean;
import jp.co.ugatria.atsuco.bean.TaskUpdateBean;
import jp.co.ugatria.atsuco.dao.ProjectRankDao;
import jp.co.ugatria.atsuco.dao.TaskCommentDao;
import jp.co.ugatria.atsuco.dao.TaskDao;
import jp.co.ugatria.atsuco.dao.UserDao;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.Task;
import jp.co.ugatria.atsuco.entity.TaskComment;
import jp.co.ugatria.atsuco.form.TaskChangeForm;
import jp.co.ugatria.atsuco.form.TaskCreateForm;
import jp.co.ugatria.atsuco.form.TaskUpdateForm;
import jp.co.ugatria.base.service.AbstractService;
import jp.co.ugatria.base.util.DateUtil;

import org.apache.commons.lang3.StringUtils;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService extends AbstractService {

	@Autowired
	private ProjectRankDao projectRankDao;

	@Autowired
	private TaskDao taskDao;

	@Autowired
	private TaskCommentDao taskCommentDao;

	@Autowired
	private UserDao userDao;


	public void getDataForCreate(TaskCreateBean bean) {
		LoginInfo info = bean.getLoginInfo();

		bean.setProjectRanks(projectRankDao.findByProjectId(info.getCompanyId(), info.getProjectId()));
		bean.setUsers(userDao.findByProjectId(info.getCompanyId(), info.getProjectId()));
	}

	public void create(TaskCreateBean bean) {
		TaskCreateForm form = bean.getForm();
		Long companyId = convertKey(form.getCompanyId());
		Long projectId = convertKey(form.getProjectId());

		Task task = new Task();
		task.setCompanyId(companyId);
		task.setProjectId(projectId);
		task.setTitle(form.getTitle());
		task.setContents(form.getContents());
		if (StringUtils.isNotEmpty(form.getStartDeadlineDate())) {
			task.setStartDeadlineDate(DateUtil.parseDate(form.getStartDeadlineDate(), "yyyy/MM/dd"));
		}
		if (StringUtils.isNotEmpty(form.getEndDeadlineDate())) {
			task.setEndDeadlineDate(DateUtil.parseDate(form.getEndDeadlineDate(), "yyyy/MM/dd"));
		}
		task.setRankNo(Integer.parseInt(form.getRankNo()));

		if (StringUtils.isNotEmpty(form.getUserId())) {
			task.setUserId(Long.parseLong(form.getUserId()));
		}
		task.setCreateUserId(1L);
		task.setUpdateUserId(1L);
		taskDao.insert(task);

		// コメントの登録
		if (StringUtils.isNotEmpty(form.getComment())) {
			TaskComment taskComment = new TaskComment();
			taskComment.setCompanyId(task.getCompanyId());
			taskComment.setProjectId(task.getProjectId());
			taskComment.setTaskId(task.getTaskId());
			taskComment.setComment(form.getComment());
			taskCommentDao.insert(taskComment);
		}
		Log.info(task.getTaskId());
		bean.setTaskId(task.getTaskId());
	}

	public void getDataForUpdate(TaskUpdateBean bean) {
		LoginInfo info = bean.getLoginInfo();
		Long taskId = convertKey(bean.getTaskId());

		bean.setTask(taskDao.findByPrimary(info.getCompanyId(), info.getProjectId(), taskId));
		bean.setProjectRanks(projectRankDao.findByProjectId(info.getCompanyId(), info.getProjectId()));
	}

	public void update(TaskUpdateBean bean) {
		TaskUpdateForm form = bean.getForm();
		Long taskId = convertKey(form.getTaskId());
		Long companyId = convertKey(form.getCompanyId());
		Long projectId = convertKey(form.getProjectId());

		Task task = taskDao.findByPrimary(companyId, projectId, taskId);
		if (task != null) {
			task.setTitle(form.getTitle());
			task.setContents(form.getContents());
			if (StringUtils.isNotEmpty(form.getStartDeadlineDate())) {
				task.setStartDeadlineDate(DateUtil.parseDate(form.getStartDeadlineDate(), "yyyy/MM/dd"));
			}
			if (StringUtils.isNotEmpty(form.getEndDeadlineDate())) {
				task.setEndDeadlineDate(DateUtil.parseDate(form.getEndDeadlineDate(), "yyyy/MM/dd"));
			}
			task.setRankNo(Integer.parseInt(form.getRankNo()));
			taskDao.update(task);

			// コメントの登録
			if (StringUtils.isNotEmpty(form.getComment())) {
				TaskComment taskComment = new TaskComment();
				taskComment.setCompanyId(task.getCompanyId());
				taskComment.setProjectId(task.getProjectId());
				taskComment.setTaskId(task.getTaskId());
				taskComment.setComment(form.getComment());
				taskCommentDao.insert(taskComment);
			}
		}
	}

	public void change(TaskChangeBean bean) {
		TaskChangeForm form = bean.getForm();
		Long taskId = convertKey(form.getTaskId());
		Long companyId = convertKey(form.getCompanyId());
		Long projectId = convertKey(form.getProjectId());

		Task task = taskDao.findByPrimary(companyId, projectId, taskId);
		if (task != null) {
			if (StringUtils.isEmpty(form.getUserId())) {
				task.setUserId(null);
			} else {
				task.setUserId(Long.parseLong(form.getUserId()));
			}
			task.setStatus(form.getStatus());
			taskDao.updateUserAndStatus(task);
		}
	}
}
