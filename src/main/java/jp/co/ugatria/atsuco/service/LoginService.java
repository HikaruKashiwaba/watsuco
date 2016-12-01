/**
 *
 */
package jp.co.ugatria.atsuco.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ugatria.atsuco.bean.LoginBean;
import jp.co.ugatria.atsuco.dao.ProjectDao;
import jp.co.ugatria.atsuco.dao.UserDao;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.LoginForm;
import jp.co.ugatria.base.log.LoggerFactory;
import jp.co.ugatria.base.message.Message;
import jp.co.ugatria.base.service.AbstractService;
import jp.co.ugatria.base.util.CryptUtil;

/**
 * @author Kashiwaba
 *
 */
@Component
public class LoginService extends AbstractService {

	private Logger log = LoggerFactory.make();

	@Autowired
	private UserDao dao;

	@Autowired
	private ProjectDao projectDao;

	public void login(LoginBean bean) {
		LoginForm form = bean.getForm();
		String encryptedPass1 = CryptUtil.encryptPassword(form.getPassword());
		log.info(encryptedPass1);

		User user = dao.findByLoginId(form.getEmail());
		if (user != null) {
			if (encryptedPass1.equals(user.getPassword())) {
				LoginInfo info = new LoginInfo();
				info.setCompanyId(user.getCompanyId());
				info.setUserId(user.getUserId());
				info.setEmail(user.getEmail());
				info.setName(user.getUserName());
				bean.setLoginInfo(info);

				// ログインユーザーがメンバーになっているプロジェクト一覧を取得
				bean.setProjects(projectDao.findByUserId(info.getCompanyId(), user.getUserId()));
				return;
			}
		}
		bean.addMessages(new Message("error", "error.login.001"));
	}
}
