<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fn2" uri="/jsp/tag/functions"%>
<%@taglib prefix="json" uri="/jsp/tag/json"%>
<%@taglib prefix="msg" uri="/jsp/tag/message"%>
<%@taglib prefix="page" uri="/jsp/tag/page"%>
<c:set scope="page" var="ctxp" value="${pageContext.request.contextPath}" />
<jsp:useBean id="today" class="java.util.Date" />
