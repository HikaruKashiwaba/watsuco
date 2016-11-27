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
        </ul>
      </div>
    </div>
  </header>

  <div class="container">
    <h1>Edit project</h1>
    <form id="input-form" action="${ctxp}/page/projects/1/update" class="form-horizontal" role="form" method="post">
      <div  class="form-group">
        <label for="projectName" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">プロジェクト名</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <input type="text" id="projectName" name="projectName" class="form-control" placeholder="" autofocus />
        </div>
      </div>
      <div  class="form-group">
        <label for="summary" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">概要</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <textarea id="summary" name="summary" rows="15" class="form-control"></textarea>
        </div>
      </div>
      <div  class="form-group">
        <label for="startDate" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">開始日</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <input type="text" id="startDate" name="startDate" class="form-control datepicker" placeholder="YYYY/MM/DD" />
        </div>
      </div>
      <div  class="form-group">
        <label for="endDate" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">終了日</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <input type="text" id="endDate" name="endDate" class="form-control datepicker" placeholder="YYYY/MM/DD" />
        </div>
      </div>
      <div  class="form-group">
        <label class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">プロジェクトチーム</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <label class="form-check-inline">
            <input type="checkbox" id="userId-1" name="userId" class="form-check-input" value="1" /> 佐藤
          </label>
          <label class="form-check-inline">
            <input type="checkbox" id="userId-2" name="userId" class="form-check-input" value="2" /> 鈴木
          </label>
          <label class="form-check-inline">
            <input type="checkbox" id="userId-3" name="userId" class="form-check-input" value="3" /> 斎藤
          </label>
            <label class="form-check-inline">
          <input type="checkbox" id="userId-4" name="userId" class="form-check-input" value="4" /> 加藤
          </label>
          <label class="form-check-inline">
            <input type="checkbox" id="userId-5" name="userId" class="form-check-input" value="5" /> 山田
          </label>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <a href="${ctxp}/page/projects" class="btn btn-default" >戻る</a>
          <button class="btn btn-primary" type="submit">登録する</button>
        </div>
      </div>
    </form>
  </div>

</body>
</html>
