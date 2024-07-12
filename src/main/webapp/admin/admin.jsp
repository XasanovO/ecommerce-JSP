<%--
  Created by IntelliJ IDEA.
  User: ox121
  Date: 23.04.2024
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>

<div class="row">
    <div class="col-3 bg-dark text-white" style="height: 100vh">
        <ul class="list-group p-2">
            <a href="/admin/category.jsp">
                <li class="list-group-item text-dark">Category</li>
            </a>

            <a href="/admin/product.jsp">
                <li class="list-group-item text-dark">Product</li>
            </a>
        </ul>
    </div>
    <div class="col-9">
        <nav class="navbar navbar-light bg-light justify-content-between">
            <a class="navbar-brand">E commerce</a>
            <a href="/home/home.jsp">
                <button class="btn btn-outline-success my-2 my-sm-0">Home</button>
            </a>
        </nav>
    </div>
</div>

</body>
</html>
