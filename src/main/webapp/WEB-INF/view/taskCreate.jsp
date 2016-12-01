<%@page pageEncoding="UTF-8"%>
<%@ include file="./include/common.jsp" %>
<form id="input-form" action="${ctxp}/page/tasks/create" class="form-horizontal" role="form">
  <input type="hidden" id="companyId" name="companyId" value="${it.bean.loginInfo.companyId}" />
  <input type="hidden" id="projectId" name="projectId" value="${it.bean.form.projectId}" />
  <div  class="form-group">
    <label for="title" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">タイトル</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <input type="text" id="title" name="title" class="form-control" value="<c:out value="${it.bean.form.title}" />" autofocus />
    </div>
  </div>
  <div  class="form-group">
    <label for="contents" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">内容</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <textarea id="contents" name="contents" rows="10" class="form-control"><c:out value="${it.bean.form.contents}" /></textarea>
    </div>
  </div>
  <div  class="form-group">
    <label for="startDeadlineDate" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">着手期限</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <input type="text" id="startDeadlineDate" name="startDeadlineDate" class="form-control datepicker" value="<c:out value="${it.bean.form.startDeadlineDate}" />" placeholder="YYYY/MM/DD" />
    </div>
  </div>
  <div  class="form-group">
    <label for="endDeadlineDate" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">完了期日</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <input type="text" id="endDeadlineDate" name="endDeadlineDate" class="form-control datepicker" value="<c:out value="${it.bean.form.endDeadlineDate}" />" placeholder="YYYY/MM/DD" />
    </div>
  </div>
  <div  class="form-group">
    <label for="rankNo" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">ランク</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <select id="rankNo" class="form-control">
        <option value="1" <c:if test="${it.bean.form.rankNo == '1'}">selected="selected"</c:if>>S</option>
        <option value="2" <c:if test="${it.bean.form.rankNo == '2'}">selected="selected"</c:if>>A</option>
        <option value="3" <c:if test="${it.bean.form.rankNo == '3'}">selected="selected"</c:if>>B</option>
        <option value="4" <c:if test="${it.bean.form.rankNo == '4'}">selected="selected"</c:if>>C</option>
        <option value="5" <c:if test="${it.bean.form.rankNo == '5'}">selected="selected"</c:if>>D</option>
      </select>
    </div>
  </div>
  <div  class="form-group">
    <label for="userId" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">担当者</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <select id="userId" class="form-control">
        <option value="">--</option>
        <c:forEach var="user" items="${it.bean.users}">
        <option value="${user.userId}" <c:if test="${user.userId.toString() == it.bean.form.userId}">selected="selected"</c:if>><c:out value="${user.userName}"/></option>
        </c:forEach>
      </select>
    </div>
  </div>
</form>
