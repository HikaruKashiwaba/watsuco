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
    <h1>Member</h1>
    <div  class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label class="col-lg-2 col-md-2 col-sm-12 col-xs-12">メールアドレス</label>
      <div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
        kashiwaba@ugatria.co.jp
      </div>
    </div>
    <div  class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label class="col-lg-2 col-md-2 col-sm-12 col-xs-12">氏名</label>
      <div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
        柏葉　光
      </div>
    </div>
    <div  class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label class="col-lg-2 col-md-2 col-sm-12 col-xs-12">最終ログイン日時</label>
      <div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
        2016/11/28 10:34:20
      </div>
    </div>
  </div>

  <div class="container">
    <h1>Project</h1>
    <table class="table table-striped table-bordered">
      <thead>
        <tr>
          <th rowspan="2">ID</th>
          <th rowspan="2">プロジェクト名</th>
          <th colspan="3">タスク数</th>
          <th rowspan="2">保有ポイント</th>
        </tr>
        <tr>
          <th>未着手</th>
          <th>仕掛</th>
          <th>完了</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>FSP</td>
          <td class="text-right">21</td>
          <td class="text-right">4</td>
          <td class="text-right">35</td>
          <td>56pt</td>
        </tr>
        <tr>
          <td>2</td>
          <td>fahnir</td>
          <td class="text-right">45</td>
          <td class="text-right">2</td>
          <td class="text-right">25</td>
          <td>56pt</td>
        </tr>
      </tbody>
    </table>
  </div>

  <div class="container">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
      <a href="${ctxp}/page/projects" class="btn btn-default" >戻る</a>
      <a href="${ctxp}/page/projects/1/update" class="btn btn-primary" >変更する</a>
    </div>
  </div>

</body>
</html>
