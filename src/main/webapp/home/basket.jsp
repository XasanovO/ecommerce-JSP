<%@ page import="com.example.ecommerce.entity.Basket" %>
<%@ page import="com.example.ecommerce.entity.BasketProduct" %>
<%@ page import="com.example.ecommerce.entity.Product" %>
<%@ page import="com.example.ecommerce.repo.ProductRepository" %>
Created by IntelliJ IDEA.
  User: ox121
  Date: 30.04.2024
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<%
    Object userId = session.getAttribute("id");

%>
<div class="col-15">
    <nav class="navbar navbar-light bg-light justify-content-between">
        <a href="/home/home.jsp" class="btn btn-info">Back</a>
        <a href="<%=userId != null?"/order/add":"/auth/Auth.jsp?p=checkout"%><%if (userId == null) {session.setAttribute("generateOrder", true);}%>">
            <button class="btn btn-outline-success my-2 my-sm-0">Checkout</button>
        </a>
    </nav>

</div>

<div class="container">
    <div class="row">
        <%
            Basket basket = new Basket();
            if (session.getAttribute("Basket") != null) {
                basket = new Basket((Basket) session.getAttribute("Basket"));
            }
            for (BasketProduct basketProduct : basket.basketProducts) {
                Product product = ProductRepository.findById(basketProduct.getProductId());
        %>
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img src="data:image/jpeg;base64,<%=product.getBase64Photo()%>" alt="Product Photo"
                     style="max-width: 100%; height: auto">
                <div class="card-body">
                    <h5 class="card-title"><%=product.getName()%>
                    </h5>
                    <p class="card-text text-muted"><%=product.getPrice()%>
                    </p>
                    <div class="row ml-3 align-items-center">
                        <div class="col-1 ml-2"><a href="/basket/update?id=<%=basketProduct.getId()+"&opt=-"%>"
                                                   class="btn btn-primary">-</a></div>
                        <div class="col-1 ml-2"><%=basketProduct.getAmount()%>
                        </div>
                        <div class="col-1 ml-2"><a href="/basket/update?id=<%=basketProduct.getId()+"&opt=+"%>"
                                                   class="btn btn-primary">+</a></div>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
