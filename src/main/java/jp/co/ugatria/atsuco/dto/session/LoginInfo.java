package jp.co.ugatria.atsuco.dto.session;

import java.io.Serializable;

public class LoginInfo implements Serializable {


	private static final long serialVersionUID = 5718933882348866040L;

	private Long id;

	private String loginId;

	private String password;

	private String name;

	private Long centerId;

	private String centerName;

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	private String message;

	private Integer adminFlag;

	public LoginInfo() {
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	  * nameを取得します.
	  * @return String name
	  */

	public String getName() {
		return name;
	}

	/**
	 * name を設定します.
	 * @param String name
	 */

	public void setName(String name) {
		this.name = name;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    /**
      * messageを取得します.
      * @return String message
      */

    public String getMessage() {
        return message;
    }

    /**
     * message を設定します.
     * @param String message
     */

    public void setMessage(String message) {
        this.message = message;
    }

	/**
	 * adminFlagを取得します.
	 * @return Integer adminFlag
	 */
	public Integer getAdminFlag() {
		return adminFlag;
	}

	/**
	 * adminFlag を設定します.
	 * @param Integer adminFlag
	 */
	public void setAdminFlag(Integer adminFlag) {
		this.adminFlag = adminFlag;
	}


}
