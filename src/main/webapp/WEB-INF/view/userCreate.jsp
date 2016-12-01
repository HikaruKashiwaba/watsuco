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
          <li><a href="${ctxp}/page/projects">プロジェクト</a></li>
          <li class="active"><a href="${ctxp}/page/users">担当者</a></li>
          <li><a href="${ctxp}/page/issues">課題管理</a></li>
          <li><a href="${ctxp}/page/report">レポート</a></li>
        </ul>
      </div>
    </div>
  </header>

  <div class="container">
    <h1>Registration Member</h1>
    <form id="input-form" action="${ctxp}/page/users/create" class="form-horizontal" role="form" method="post">
      <div  class="form-group">
        <label for="email" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">メールアドレス</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <input type="text" id="email" name="email" class="form-control" placeholder="" autofocus />
        </div>
      </div>
      <div  class="form-group">
        <label for="password" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">パスワード</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <input type="text" id="password" name="password" class="form-control" />
        </div>
      </div>
      <div  class="form-group">
        <label for="confirmPassword" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">確認用パスワード</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <input type="text" id="confirmPassword" name="confirmPassword" class="form-control" />
        </div>
      </div>
      <div  class="form-group">
        <label for="userName" class="control-labnel col-lg-2 col-md-2 col-sm-2 col-xs-2">氏名</label>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
          <input type="text" id="userName" name="userName" class="form-control" placeholder="" autofocus />
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <a href="${ctxp}/page/users" class="btn btn-default" >戻る</a>
          <button class="btn btn-primary" type="submit">登録する</button>
        </div>
      </div>
    </form>
  </div>

</body>
</html>
