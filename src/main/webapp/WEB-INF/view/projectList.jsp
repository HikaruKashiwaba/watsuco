<%@page pageEncoding="UTF-8"%>
<%@ include file="./include/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="./include/meta.jsp" %>
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
          <li class="active"><a href="${ctxp}/page/projects">プロジェクト</a></li>
          <li><a href="${ctxp}/page/users">担当者</a></li>
          <li><a href="${ctxp}/page/issues">課題管理</a></li>
          <li><a href="${ctxp}/page/report">レポート</a></li>
        </ul>
      </div>
    </div>
  </header>

  <div class="container">
    <h1 class="col-lg-6 col-md-6 col-sm-6 col-xs-6">Project</h1>
    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-right">
       <button type="button" onclick="location.href='${ctxp}/page/projects/create'" class="btn btn-default" ><i class="glyphicon glyphicon-plus"></i> 作成する</button>
    </div>
  </div>

  <div class="container">

	<c:if test="${empty it.bean.projects }">
      <div class="alert alert-info" role="alert">プロジェクトはありません。</div>
	</c:if>

	<c:if test="${!empty it.bean.projects }">
    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th rowspan="2">ID</th>
          <th rowspan="2">プロジェクト名</th>
          <th rowspan="2">開始日</th>
          <th rowspan="2">終了日</th>
          <th colspan="3">タスク数</th>
        </tr>
        <tr>
          <th>未着手</th>
          <th>仕掛</th>
          <th>完了</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="project" items="${it.bean.projects}" >
        <tr onclick="location.href='${ctxp}/page/projects/${project.projectId}/update'">
          <td>${project.projectId}</td>
          <td><c:out value="${project.projectName}" /></td>
          <td><fmt:formatDate value="${project.startDate}" pattern="yyyy/MM/dd"/></td>
          <td><fmt:formatDate value="${project.endDate}" pattern="yyyy/MM/dd"/></td>
          <td class="text-right">${project.notStartCnt}</td>
          <td class="text-right">${project.inWorkCnt}</td>
          <td class="text-right">${project.finishCnt}</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
	</c:if>
  </div>

</body>
</html>
