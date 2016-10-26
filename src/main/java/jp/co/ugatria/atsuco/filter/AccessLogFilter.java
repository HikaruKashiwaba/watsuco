package jp.co.ugatria.atsuco.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jp.co.ugatria.atsuco.dto.session.LoginInfo;
import jp.co.ugatria.atsuco.dto.session.SessionInfo;
import jp.co.ugatria.base.log.LoggerFactory;

public class AccessLogFilter implements Filter {

	private static final String BEFORE_LOGIN_LOG_START = "★★ Request start -- URL[%s]";
	private static final String BEFORE_LOGIN_LOG_END   = "☆☆ Request end   -- URL[%s]";
	@SuppressWarnings("unused")
	private static final String AFTER_LOGIN_LOG_START  = "★★ Request start -- URL[%s] LoginID[%s]";
	private static final String AFTER_LOGIN_LOG_END    = "☆☆ Request end   -- URL[%s] LoginID[%s]";

	private Logger log = LoggerFactory.make();

	@SuppressWarnings("unused")
	private SessionInfo sessionInfo;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession session = hsr.getSession();
		String sessionId = session.getId();
		if (sessionId == null) {
			sessionId = "";
		}
		MDC.put("sessionId", session.getId());

		String loginId = null;
		if (session != null) {
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
			SessionInfo sessionInfo = (SessionInfo)context.getBean(SessionInfo.class);
		}

		if (loginId == null) {
			log.info(String.format(BEFORE_LOGIN_LOG_START, hsr.getRequestURI()));
		}

		logParameters((HttpServletRequest)request);

		try {
			chain.doFilter(request, response);
		}
		finally {
			if (loginId == null) {
				log.info(String.format(BEFORE_LOGIN_LOG_END, hsr.getRequestURI()));
			}
			else {
				log.info(String.format(AFTER_LOGIN_LOG_END, hsr.getRequestURI(), loginId));
			}
			MDC.remove("sessionId");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		sessionInfo = (SessionInfo) context.getBean("sessionInfo");
	}

	private void logParameters(HttpServletRequest req) {
		log.debug("Start parameter log =======================>");
		// リクエストパラメータ出力
		req.getParameterNames();


    	Enumeration<String> names = req.getParameterNames();
		log.debug("<-------- Request parameter -------->");
    	while (names.hasMoreElements()) {
    		String name = names.nextElement();
    		String[] values = req.getParameterValues(name);
    		log.debug(String.format("[%s]=%s", name, StringUtils.join(values)));
    	}

		// セッション内の値出力
		HttpSession session = req.getSession(false);
		if (session != null) {
			names = session.getAttributeNames();
			log.debug("<-------- Session attribute -------->");
	    	while (names.hasMoreElements()) {
	    		String name = names.nextElement();
	    		Object o = session.getAttribute(name);
	    		log.debug(String.format("[%s]=%s", name, o != null ? o.toString() : "null"));
	    	}
		}
		log.debug("End parameter log =======================>");
	}
}
