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
        </ul>
      </div>
    </div>
  </header>

  <div class="container">
    <h1 class="col-lg-6 col-md-6 col-sm-6 col-xs-6">Member</h1>
    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-right">
       <button type="button" onclick="location.href='${ctxp}/page/users/create'" class="btn btn-default" ><i class="glyphicon glyphicon-plus"></i> 追加する</button>
    </div>

    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th>ID</th>
          <th>メールアドレス</th>
          <th>氏名</th>
          <th>権限</th>
          <th>最終ログイン日時</th>
        </tr>
      </thead>
      <tbody>
        <tr onclick="location.href='${ctxp}/page/users/1'">
          <td>1</td>
          <td>kashiwaba@ugatria.co.jp</td>
          <td>柏葉　光</td>
          <td>一般</td>
          <td>2016/11/03</td>
        </tr>
      </tbody>
    </table>
  </div>

</body>
</html>
