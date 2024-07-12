<%@ page import="com.example.ecommerce.entity.Category" %>
<%@ page import="com.example.ecommerce.repo.CategoryRepository" %>
Created by IntelliJ IDEA.
  User: ox121
  Date: 23.04.2024
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Category category = CategoryRepository.findById(id);
%>
<div class="container">
    <h2 class="mt-4 mb-4">Update Category</h2>
    <form action="/category/update" method="post">
        <div class="form-group">
            <input type="hidden" name="id" value="<%=category.getId()%>">
            <label for="name">Name:</label>
            <input value="<%=category.getName()%>" type="text" class="form-control" id="name" name="name"
                   placeholder="Enter category name" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
