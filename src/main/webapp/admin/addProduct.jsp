<%@ page import="com.example.ecommerce.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ecommerce.repo.CategoryRepository" %>
<%@ page import="com.example.ecommerce.entity.Product" %>
<%@ page import="com.example.ecommerce.repo.ProductRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<%
    List<Category> categories = CategoryRepository.findAll();
    String productId = request.getParameter("id");
    Product product = null;
    if (productId != null) {
        product = ProductRepository.findById(Integer.parseInt(productId));
    }
%>
<div class="container">
    <h1 class="mt-5 mb-3"><%=product != null ? "Update Product" : "Add Product"%>
    </h1>
    <form action="<%=product != null?"/product/update":"/product/add"%>" method="post"
          enctype="multipart/form-data">
        <%if (product != null) {%>
        <input type="hidden" value="<%=product.getId()%>" name="id">
        <%}%>
        <div class="mb-3">
            <input type="text" value="<%=product != null?product.getName():""%>" class="form-control" id="productName"
                   name="name" placeholder="enter product name"
                   required>
        </div>
        <div class="mb-3">
            <input type="number" value="<%=product != null?product.getPrice():0%>" class="form-control"
                   id="productPrice" name="price" placeholder="enter product price"
                   required>
        </div>
        <div class="mb-3">
            <select class="form-control" id="productCategory" name="categoryId">
                <option value="<%=product != null?product.getCategory().getId():categories.get(0).getId()%>">
                    <%=product != null ? product.getCategory().getName() : categories.get(0).getName()%>
                </option>
                <%for (Category category : categories) {%>
                <option value="<%=category.getId()%>"><%=category.getName()%>
                </option>
                <%}%>
            </select>
        </div>
        <div class="mb-3">
            <%if (product != null) {%>
            <img src="data:image/jpeg;base64,<%=product.getBase64Photo()%>" style="max-width: 60px">
            <%}%>
            <label for="productPhoto" class="form-label">Photo</label>
            <input type="file" class="form-control" id="productPhoto" name="photo" accept="image/*">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
