/**
 *
 */
package jp.co.ugatria.atsuco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ugatria.atsuco.bean.UserCreateBean;
import jp.co.ugatria.atsuco.bean.UserDetailBean;
import jp.co.ugatria.atsuco.bean.UserListBean;
import jp.co.ugatria.atsuco.bean.UserUpdateBean;
import jp.co.ugatria.atsuco.dao.ProjectTeamDao;
import jp.co.ugatria.atsuco.dao.UserDao;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.UserCreateForm;
import jp.co.ugatria.atsuco.form.UserUpdateForm;
import jp.co.ugatria.base.service.AbstractService;

/**
 * @author Kashiwaba
 *
 */
@Component
public class UserService extends AbstractService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProjectTeamDao projectTeamDao;

	public void getList(UserListBean bean) {
		LoginInfo info = bean.getLoginInfo();
		bean.setUsers(userDao.findAll(info.getCompanyId()));
	}

	public void select(UserDetailBean bean) {
		LoginInfo info = bean.getLoginInfo();
		Long userId = convertKey(bean.getUserId());

		bean.setUser(userDao.findByPrimary(userId));
		bean.setProjectTeams(projectTeamDao.findByProjectId(info.getCompanyId(), userId));
	}

	public void getDataForUpdate(UserUpdateBean bean) {
		LoginInfo info = bean.getLoginInfo();
		bean.setUser(userDao.findByPrimary(convertKey(bean.getUserId())));
	}

	public void update(UserUpdateBean bean) {
		LoginInfo info = bean.getLoginInfo();
		UserUpdateForm form = bean.getForm();

		User user = userDao.findByPrimary(convertKey(bean.getUserId()));
		user.setUserName(form.getUserName());
		user.setEmail(form.getEmail());
		user.setUpdateUserId(info.getUserId());
		userDao.update(user);
	}

	public void getDataForCreate(UserCreateBean bean) {
		LoginInfo info = bean.getLoginInfo();

	}

	public void insert(UserCreateBean bean) {
		LoginInfo info = bean.getLoginInfo();
		UserCreateForm form = bean.getForm();

		User user = new User();
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setCreateUserId(info.getUserId());
		user.setUpdateUserId(info.getUserId());
		userDao.insert(user);

		bean.setUserId(user.getUserId());
	}
}
