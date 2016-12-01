<%@page pageEncoding="UTF-8"%>
<%@ include file="./include/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="./include/meta.jsp" %>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<title></title>
</head>

<body>
  <header id="header" class="navbar navbar-inverse navbar-static-top" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarEexample">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand">Atsuco</a>
      </div>
      <div class="collapse navbar-collapse" id="navbarEexample">
        <ul class="nav navbar-nav">
          <li><a href="${ctxp}/page/summary">タスク看板</a></li>
          <li><a href="${ctxp}/page/projects">プロジェクト</a></li>
          <li><a href="${ctxp}/page/users">担当者</a></li>
          <li><a href="${ctxp}/page/issues">課題管理</a></li>
          <li class="active"><a href="${ctxp}/page/report">レポート</a></li>
        </ul>
      </div>
    </div>
  </header>

  <c:forEach var="message" items="${msg:list(it.bean.messages, 'info')}" >
    <div class="alert alert-info" role="alert"><c:out value="${message.message}" /></div>
  </c:forEach>

<c:if test="${!empty it.bean.projects}">
  <div class="container">
    <div class="mb05">
      <div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-6 col-xs-offset-6 col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
        <form name="form1" id="form1" action="${ctxp}/page/report" class="form-horizontal" role="form" method="get">
          <input type="hidden" id="companyIdSel" name="companyId" value="${it.bean.loginInfo.companyId}" />
          <select id="projectIdSel" name="projectId" onchange="document.form1.submit();">
            <c:forEach var="project" items="${it.bean.projects}" >
              <option value="${project.projectId}" <c:if test="${project.projectId == it.bean.loginInfo.projectId}">selected="selected"</c:if>><c:out value="${project.projectName}" /></option>
            </c:forEach>
          </select>
        </form>
      </div>
    </div>
  </div>

  <div class="container">
    <h1 class="alert alert-info">タスク状況推移</h1>
    <div id="myfirstchart" style="height: 250px;"></div>

    <h1 class="alert alert-danger">タスク遅延状況</h1>
    <div id="delaychart" style="height: 250px;"></div>
  </div>

<script type="text/javascript"><!--
new Morris.Line({
	  // ID of the element in which to draw the chart.
	  element: 'myfirstchart',
	  data: ${it.bean.statusCntJson},
	  xkey: 'reportDate',
	  ykeys: ['notStartCnt', 'inWorkCnt', 'finishCnt'],
	  labels:['未着手', '仕掛り', '完了']
	});

Morris.Bar({
	  element: 'delaychart',
	  data: ${it.bean.delayCntJson},
	  xkey: 'reportDate',
	  ykeys: ['startDelayedCnt', 'completeDelayedCnt'],
	  labels: ['開始遅延', '完了遅延']
});
//--></script>
</c:if>
</body>
</html>
