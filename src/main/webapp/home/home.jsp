
<%@ page import="com.example.ecommerce.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ecommerce.repo.CategoryRepository" %>
<%@ page import="com.example.ecommerce.entity.Product" %>
<%@ page import="com.example.ecommerce.repo.ProductRepository" %>
<%@ page import="com.example.ecommerce.entity.Basket" %><%--
  Created by IntelliJ IDEA.
  User: ox121
  Date: 23.04.2024
  Time: 23:01
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
    String categoryId = request.getParameter("categoryId");
    List<Category> categories = CategoryRepository.findAll();
    List<Product> products = ProductRepository.findAll();
    if (categoryId != null) {
        products = ProductRepository.findAllByCategoryId(Integer.parseInt(categoryId));
    }
    Basket basket = new Basket();
    if (session.getAttribute("Basket") != null) {
        basket = new Basket((Basket) session.getAttribute("Basket"));
    } else {
        session.setAttribute("Basket", basket);
    }
    Object id = session.getAttribute("id");
    if (id != null) {
        System.out.println("\"nul email registred\" = " + "nul email registred");
    }
%>
<div class="row">
    <div class="col-3 bg-dark text-white p-2" style="height: 100vh">
        <ul class="list-group">
            <%for (Category category : categories) {%>
            <a href="/home/home.jsp?categoryId=<%=category.getId()%>">
                <li class="list-group-item text-dark"><%=category.getName()%>
                </li>
            </a>
            <%}%>
        </ul>
    </div>
    <div class="col-9">
        <nav class="navbar navbar-light bg-light justify-content-between">
            <a class="navbar-brand">E commerce</a>
            <a href="<%=session.getAttribute("id") != null ? "/admin/admin.jsp" : "/auth/Auth.jsp"%>">
                <button class="btn btn-outline-success my-2 my-sm-0"><%=session.getAttribute("id") != null ? "Admin" : "Login"%>
                </button>
            </a>
            <a href="/home/basket.jsp">
                <button class="btn btn-outline-success my-2 my-sm-0"><%=basket != null ? "Basket %d".formatted(basket.getBasketProducts().size()) : "Basket 0"%>
                </button>
            </a>
        </nav>
        <div class="container">
            <div class="row">
                <%for (Product product : products) {%>
                <div class="col-lg-3 col-md-2">
                    <div class="card">
                        <img src="data:image/jpeg;base64,<%=product.getBase64Photo()%>" alt="Product Photo"
                             style="max-width: 100%; height: auto">
                        <div class="card-body">
                            <h5 class="card-title"><%=product.getName()%>
                            </h5>
                            <p class="card-text text-muted"><%=product.getPrice()%>
                            </p>
                            <a href="/basket/add?productId=<%=product.getId()%>">
                                <button class="btn btn-success"  <%=basket.basketProducts.stream().filter(basketProduct -> basketProduct.getProductId() == product.getId()).toList().size() == 1 ? "disabled" : ""%>>
                                    Add
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
                <%}%>
                <!-- Add more product cards here if needed -->
            </div>
        </div>
    </div>
</div>
</body>
</html>
