package jp.co.ugatria.atsuco.action;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.dto.session.SessionInfo;
import jp.co.ugatria.base.action.AbstractAction;

public abstract class BaseAction extends AbstractAction {

	@Autowired
	private SessionInfo session;

	/**
	 * 初期化処理.
	 */
	public void beforeProcess() {
		if (model == null) {
			model = new HashMap<String, Object>();
		}
		else {
			model.clear();
		}
		model.put("logined", new Boolean(false));
		model.put("loginInfo", null);

		if (getSessionInfo() != null) {
			model.put("logined", new Boolean(getSessionInfo().getLoginInfo() != null));
			model.put("loginInfo", getSessionInfo().getLoginInfo());
		}
	}

	/**
	 * 終了時の共通設定初期化処理.
	 */
	public void afterProcess() {
		model.put("token", getSessionInfo().getToken());
	}
	protected SessionInfo getSessionInfo() {
		return session;
	}

	/**
	 * ログイン情報をセッションにセットする.
	 * @param loginInfo ログイン情報
	 */
	protected void setLoginInfo(LoginInfo loginInfo) {
		session.setLoginInfo(loginInfo);
	}

	/**
	 * ログイン情報をセッションにセットする.
	 * @param loginInfo ログイン情報
	 */
	protected LoginInfo getLoginInfo() {
		return session.getLoginInfo();
	}

	protected void setSessionParam(String key, String value) {
		session.setParam(key, value);
	}

	protected String getSessionParam(String key) {
		return session.getParam(key);
	}

	protected void removeSessionParam(String key) {
		session.removeParam(key);
	}

	/**
	 * ログイン情報を無効化する.
	 * @param loginInfo ログイン情報
	 */
	protected void invalidateLoginInfo() {
		session.setLoginInfo(null);
	}

}
