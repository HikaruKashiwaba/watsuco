package jp.co.ugatria.base.exeption;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.api.view.Viewable;

@Provider
public class IllegalAccessExceptionMapper implements ExceptionMapper<IllegalAccessParamException> {

    private static final String JSP_FILE = "/%s.jsp";

	@Override
	public Response toResponse(IllegalAccessParamException exception) {
		return Response.ok(new Viewable(String.format(JSP_FILE, "illegalAccess"), null)).build();
	}
}
