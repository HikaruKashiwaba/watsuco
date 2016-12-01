package jp.co.ugatria.atsuco.form;

import javax.ws.rs.FormParam;

public class JsonForm {

	private String method;

	private String projectId;

	@FormParam("param")
	private String param;

	/**
	 * methodを取得します.
	 * @return String method
	 */

	public String getMethod() {
		return method;
	}

	/**
	 * method を設定します.
	 * @param String method
	 */

	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * projectIdを取得します.
	 * @return String projectId
	 */

	public String getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param String projectId
	 */

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
