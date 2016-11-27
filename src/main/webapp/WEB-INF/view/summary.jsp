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
        </ul>
      </div>
    </div>
  </header>

  <div class="container no-pad">
    <div class="mb05">
      <button type="button" class="btn btn-outline-primary" onclick="addTask();"><i class="glyphicon glyphicon-plus"></i> タスクを追加する</button>
    </div>

    <div id="not-asigned" class="col-lg-3 color-not-asigned mh-600 not-asigned">
      <img id="100" src="${ctxp}/images/sticky-red.png" class="sticky" />
      <img id="101" src="${ctxp}/images/sticky-blue.png" class="sticky" />
      <img id="102" src="${ctxp}/images/sticky-green.png" class="sticky" />
      <img id="103" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
      <img id="104" src="${ctxp}/images/sticky-red.png" class="sticky" />
      <img id="105" src="${ctxp}/images/sticky-blue.png" class="sticky" />
      <img id="106" src="${ctxp}/images/sticky-green.png" class="sticky" />
      <img id="107" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
      <img id="108" src="${ctxp}/images/sticky-red.png" class="sticky" />
      <img id="109" src="${ctxp}/images/sticky-blue.png" class="sticky" />
      <img id="110" src="${ctxp}/images/sticky-green.png" class="sticky" />
      <img id="111" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
    </div>
    <div class="col-lg-9 no-pad mh-600">
      <div id="user-1" class="col-lg-12 bb-gray no-pad" style="height:33%;">
        <div id="not-start-1" class="col-lg-4 color-not-start h-100p not-start">
          <img id="200" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="201" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="202" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="203" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
        <div class="col-lg-4 color-in-work h-100p in-work">
          <img id="204" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="205" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="206" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="207" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
        <div class="col-lg-4 color-finish h-100p finish">
          <img id="208" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="209" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="210" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="211" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
      </div>
      <div id="user-2" class="col-lg-12 bb-gray  no-pad" style="height:33%;">
        <div id="not-start-2" class="col-lg-4 color-not-start h-100p not-start">
          <img id="300" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="301" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="302" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="303" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
        <div class="col-lg-4 color-in-work h-100p in-work">
          <img id="304" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="305" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="306" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="307" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
        <div class="col-lg-4 color-finish h-100p finish">
          <img id="308" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="309" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="310" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="311" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
      </div>
      <div id="user-3" class="col-lg-12 bb-gray  no-pad" style="height:34%;">
        <div id="not-start-3" class="col-lg-4 color-not-start h-100p not-start">
          <img id="400" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="401" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="402" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="403" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
        <div class="col-lg-4 color-in-work h-100p in-work">
          <img id="404" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="405" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="406" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="407" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
        <div class="col-lg-4 color-finish h-100p finish">
          <img id="408" src="${ctxp}/images/sticky-red.png" class="sticky" />
          <img id="409" src="${ctxp}/images/sticky-blue.png" class="sticky" />
          <img id="410" src="${ctxp}/images/sticky-green.png" class="sticky" />
          <img id="411" src="${ctxp}/images/sticky-yellow.png" class="sticky" />
        </div>
      </div>
    </div>
  </div>

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
