package jp.co.ugatria.atsuco.bean;

import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.base.bean.AbstractBean;

public abstract class BaseBean extends AbstractBean {

	private LoginInfo loginInfo;


	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	public boolean isAdmin() {
		if (loginInfo != null) {
			Integer adminFlag = loginInfo.getAdminFlag();
			if (adminFlag != null) {
				return !adminFlag.equals(0);
			}
		}
		return false;
	}
}
