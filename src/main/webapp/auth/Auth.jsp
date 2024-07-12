<%--
  Created by IntelliJ IDEA.
  User: ox121
  Date: 02.05.2024
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="text-center mb-4">
                <h2>Authentication</h2>
            </div>
            <div class="text-center">
                <a href="/auth/signUp.jsp">
                    <button type="button" class="btn btn-primary btn-lg btn-block mb-3">Sign Up</button>
                </a>
                <a href="/auth/signIn.jsp">
                    <button type="button" class="btn btn-success btn-lg btn-block">Sign In</button>
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
