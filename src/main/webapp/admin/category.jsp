<%@ page import="com.example.ecommerce.entity.Category" %>
<%@ page import="com.example.ecommerce.repo.CategoryRepository" %>
<%@ page import="java.util.List" %>
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
            <a href="category.jsp">
                <li class="list-group-item text-dark">Category</li>
            </a>

            <a href="product.jsp">
                <li class="list-group-item text-dark">Product</li>
            </a>
        </ul>
    </div>
    <%List<Category> categories = CategoryRepository.findAll();%>
    <div class="col-9">
        <nav class="navbar navbar-light bg-light justify-content-between">
            <a class="navbar-brand">E commerce</a>
            <a href="/home/home.jsp">
                <button class="btn btn-outline-success my-2 my-sm-0">Home</button>
            </a>
        </nav>
        <a href="addCategory.jsp" class="btn btn-dark">Add Category</a>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%for (Category category : categories) {%>
            <tr>
                <td><%=category.getId()%>
                </td>
                <td><%=category.getName()%>
                </td>
                <td>
                    <a href="/admin/updateCategory.jsp?id=<%=category.getId()%>" class="btn btn-info">edit</a>
                    <a href="/category/delete?id=<%=category.getId()%>" class="btn btn-danger">delete</a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
