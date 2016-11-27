/**
 *
 */
package jp.co.ugatria.atsuco.service;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.ugatria.atsuco.bean.LoginBean;
import jp.co.ugatria.atsuco.dao.UserDao;
import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.entity.User;
import jp.co.ugatria.atsuco.form.LoginForm;
import jp.co.ugatria.base.message.Message;
import jp.co.ugatria.base.service.AbstractService;
import jp.co.ugatria.base.util.CryptUtil;

/**
 * @author Kashiwaba
 *
 */
public class LoginService extends AbstractService {

	@Autowired
	private UserDao dao;

	public void login(LoginBean bean) {
		LoginForm form = bean.getForm();
		String encryptedPass1 = CryptUtil.encryptPassword(form.getPassword());

		User user = dao.findByLoginId(form.getEmail());
		if (user != null) {
			String encryptedPass2 = CryptUtil.encryptPassword(user.getPassword());
			if (encryptedPass1.equals(encryptedPass2)) {
				LoginInfo info = new LoginInfo();
				info.setUserId(user.getUserId());
				info.setEmail(user.getEmail());
				info.setName(user.getUserName());
				bean.setLoginInfo(info);
				return;
			}
		}
		bean.addMessages(new Message("error", "error.login.001"));
	}
}
