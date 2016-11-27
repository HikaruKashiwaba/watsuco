<%@page pageEncoding="UTF-8"%>
<%@ include file="./include/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="./include/meta.jsp" %>
<title>ログイン</title>
</head>

  <body>

    <header id="header" class="navbar navbar-inverse navbar-static-top" role="banner">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">Atsuco</a>
        </div>
      </div>
    </header>

    <div class="container">

      <form class="form-horizontal" action="${ctxp}/page/login" method="post">
        <h2 class="form-signin-heading">Atsuco Logn in</h2>
        <div class="form-group">
          <label for="email" class="col-sm-2 control-label">Email address</label>
          <div class="col-sm-10">
            <input type="text" id="email" name="email" class="form-control" placeholder="Email address" autofocus />
          </div>
        </div>
        <div class="form-group">
          <label for="password" class="col-sm-2 control-label">Password</label>
          <div class="col-sm-10">
            <input type="password" id="password" name="password" class="form-control" placeholder="Password">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button class="btn btn-default" type="submit">Log in</button>
          </div>
        </div>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
