<%@page pageEncoding="UTF-8"%>
<%@ include file="./include/common.jsp" %>
<form id="input-form" action="${ctxp}/page/tasks/create" class="form-horizontal" role="form">
  <input type="hidden" id="projectId" name="projectId" value="1" />
  <div  class="form-group">
    <label for="title" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">タイトル</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <input type="text" id="title" name="title" class="form-control" placeholder="" autofocus />
    </div>
  </div>
  <div  class="form-group">
    <label for="contents" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">内容</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <textarea id="contents" name="contents" class="form-control"></textarea>
    </div>
  </div>
  <div  class="form-group">
    <label for="startDeadlineDate" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">着手期限</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <input type="text" id="startDeadlineDate" name="startDeadlineDate" class="form-control datepicker" placeholder="YYYY/MM/DD" />
    </div>
  </div>
  <div  class="form-group">
    <label for="endDeadlineDate" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">完了期日</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <input type="text" id="endDeadlineDate" name="endDeadlineDate" class="form-control datepicker" placeholder="YYYY/MM/DD" />
    </div>
  </div>
  <div  class="form-group">
    <label for="rankNo" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">ランク</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <select id="rankNo" name="rankNo" class="form-control">
        <option value="1">S</option>
        <option value="2">A</option>
        <option value="3">B</option>
        <option value="4">C</option>
        <option value="5">D</option>
      </select>
    </div>
  </div>
  <div  class="form-group">
    <label for="userId" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">担当者</label>
    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
      <select id="userId" class="form-control">
        <option value="">--</option>
        <option value="1">佐藤</option>
        <option value="2">鈴木</option>
        <option value="3">加藤</option>
        <option value="4">田中</option>
        <option value="5">吉田</option>
      </select>
    </div>
  </div>
</form>
