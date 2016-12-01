<%@page pageEncoding="UTF-8"%>
<%@ include file="./include/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="./include/meta.jsp" %>
<link href="${ctxp}/css/override.css" rel="stylesheet">
<script src="${ctxp}/js/summary.js"></script>
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
          <li class="active"><a href="${ctxp}/page/summary">タスク看板</a></li>
          <li><a href="${ctxp}/page/projects">プロジェクト</a></li>
          <li><a href="${ctxp}/page/users">担当者</a></li>
          <li><a href="${ctxp}/page/issues">課題管理</a></li>
          <li><a href="${ctxp}/page/report">レポート</a></li>
        </ul>
      </div>
    </div>
  </header>

  <c:forEach var="message" items="${msg:list(it.bean.messages, 'info')}" >
    <div class="alert alert-info" role="alert"><c:out value="${message.message}" /></div>
  </c:forEach>

  <c:if test="${!empty it.bean.projects}">
  <div class="container no-pad">
    <div class="mb05">
      <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
        <button type="button" class="btn btn-outline-primary" onclick="addTask();"><i class="glyphicon glyphicon-plus"></i> タスクを追加する</button>
      </div>
      <div class="col-lg-offset-6 col-md-offset-6 col-sm-offset-6 col-xs-offset-6 col-lg-3 col-md-3 col-sm-3 col-xs-3 text-right">
        <form name="form1" id="form1" action="${ctxp}/page/summary" class="form-horizontal" role="form" method="get">
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

  <div class="container no-pad">
    <div id="not-asigned" class="col-lg-3 color-not-asigned mh-600 not-asigned">
      <c:forEach var="task" items="${it.bean.tasks}">
        <c:if test="${task.userId == null}">
          <c:choose>
            <c:when test="${task.rankNo == 1}"><img id="${task.taskId}" src="${ctxp}/images/sticky-red.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
            <c:when test="${task.rankNo == 2}"><img id="${task.taskId}" src="${ctxp}/images/sticky-yellow.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
            <c:when test="${task.rankNo == 3}"><img id="${task.taskId}" src="${ctxp}/images/sticky-blue.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
            <c:when test="${task.rankNo == 4}"><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
            <c:otherwise><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:otherwise>
          </c:choose>
        </c:if>
      </c:forEach>
    </div>
    <div class="col-lg-9 no-pad mh-600">
      <c:forEach var="user" items="${it.bean.users}">
        <div id="user-${user.userId}" class="col-lg-12 bb-gray no-pad" style="height:28%;">
          <div class="col-lg-1 h-100p"><c:out value="${user.userName}" /></div>
          <div id="not-start-${user.userId}" class="col-lg-4 color-not-start h-100p not-start">
            <c:forEach var="task" items="${it.bean.tasks}">
              <c:if test="${task.userId == user.userId && task.status == '1'}">
                <c:choose>
                  <c:when test="${task.rankNo == 1}"><img id="${task.taskId}" src="${ctxp}/images/sticky-red.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 2}"><img id="${task.taskId}" src="${ctxp}/images/sticky-yellow.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 3}"><img id="${task.taskId}" src="${ctxp}/images/sticky-blue.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 4}"><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:otherwise><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:otherwise>
                </c:choose>
              </c:if>
            </c:forEach>
          </div>
          <div id="in-work-${user.userId}" class="col-lg-3 color-in-work h-100p in-work">
            <c:forEach var="task" items="${it.bean.tasks}">
              <c:if test="${task.userId == user.userId && task.status == '2'}">
                <c:choose>
                  <c:when test="${task.rankNo == 1}"><img id="${task.taskId}" src="${ctxp}/images/sticky-red.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 2}"><img id="${task.taskId}" src="${ctxp}/images/sticky-yellow.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 3}"><img id="${task.taskId}" src="${ctxp}/images/sticky-blue.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 4}"><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:otherwise><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:otherwise>
                </c:choose>
              </c:if>
            </c:forEach>
          </div>
          <div id="finish-${user.userId}" class="col-lg-4 color-finish h-100p finish">
            <c:forEach var="task" items="${it.bean.tasks}">
              <c:if test="${task.userId == user.userId && task.status == '3'}">
                <c:choose>
                  <c:when test="${task.rankNo == 1}"><img id="${task.taskId}" src="${ctxp}/images/sticky-red.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 2}"><img id="${task.taskId}" src="${ctxp}/images/sticky-yellow.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 3}"><img id="${task.taskId}" src="${ctxp}/images/sticky-blue.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:when test="${task.rankNo == 4}"><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:when>
                  <c:otherwise><img id="${task.taskId}" src="${ctxp}/images/sticky-green.png" class="sticky" title="<c:out value="${task.title}" />" /></c:otherwise>
                </c:choose>
              </c:if>
            </c:forEach>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  </c:if>

  <div id="log-character" class="bottom-fixed w-100p" style="display:none;">
    <div class="col-sm-offset-9 col-sm-2" style="position:relative;">
      <div id="popover-comment" class="popover left text-right" style="display:none; position:relative;">
        <div class="arrow"></div>
        <div class="popover-content">
          <p id="result"></p>
        </div>
      </div>
    </div>
    <div class="col-sm-1 text-right">
      <img src="${ctxp}/images/dog1.png" data-toggle="popover" data-placement="left" data-container="body" data-content="aaaaa" />
    </div>
  </div>

  <div class="modal" id="staticModal" tabindex="-1" role="dialog" aria-labelledby="staticModalLabel" aria-hidden="true" data-show="true" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">
            <span aria-hidden="true">&#215;</span><span class="sr-only">閉じる</span>
          </button>
          <h4 class="modal-title">タスク</h4>
        </div><!-- /modal-header -->
        <div class="modal-body">
          <div id="task-form" class="container-fluid">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">閉じる</button>
          <button type="button" class="btn btn-primary" onclick="registerTask()">保存する</button>
        </div>
      </div> <!-- /.modal-content -->
    </div> <!-- /.modal-dialog -->
  </div> <!-- /.modal -->

</body>
</html>
