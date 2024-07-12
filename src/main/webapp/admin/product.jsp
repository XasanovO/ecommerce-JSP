<%@ page import="com.example.ecommerce.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ecommerce.repo.ProductRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
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
    <%
        List<Product> products = ProductRepository.findAll();
    %>
    <div class="col-9">
        <nav class="navbar navbar-light bg-light justify-content-between">
            <a class="navbar-brand">E commerce</a>
            <a href="/home/home.jsp">
                <button class="btn btn-outline-success my-2 my-sm-0">Home</button>
            </a>
        </nav>
        <a href="addProduct.jsp" class="btn btn-dark">Add Product</a>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>photo</th>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Id</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%for (Product product : products) {%>
            <tr>
                <td><img src="data:image/jpeg;base64,<%=product.getBase64Photo()%>" alt="Product Photo"
                         style="max-width: 60px"></td>
                <td><%=product.getName()%>
                </td>
                <td><%=product.getPrice()%>
                </td>
                <td><%=product.getCategory().getName()%>
                </td>
                <td><%=product.getId()%>
                </td>
                <td>
                    <a href="/admin/addProduct.jsp?id=<%=product.getId()%>" class="btn btn-info">edit</a>
                    <a href="/product/delete?id=<%=product.getId()%>" class="btn btn-danger">delete</a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
