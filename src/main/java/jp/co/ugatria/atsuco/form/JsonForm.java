package jp.co.ugatria.atsuco.form;

import javax.ws.rs.FormParam;

public class JsonForm {

	@FormParam("param")
	private String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
