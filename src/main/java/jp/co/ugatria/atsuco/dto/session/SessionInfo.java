package jp.co.ugatria.atsuco.dto.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * セッションで保持するデータを管理するクラス.
 * @author Hikaru Kashiwaba
 * @version 1.0
 */
public class SessionInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * キャッシュ対応用のトークン
	 */
	private String token;

	/** ログイン情報. */
    private LoginInfo loginInfo;

    private Map<String , String> params;

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getParam(String key) {
    	return params != null ? params.get(key) : null;
    }

    public void setParam(String key, String value) {
    	if (params == null) {
    		params = new HashMap<String, String>();
    	}
    	params.put(key, value);
    }

    public void removeParam(String key) {
    	if (params != null) {
    		params.remove(key);
    	}
    }
}
