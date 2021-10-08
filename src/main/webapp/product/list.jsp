<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/8/2021
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <a href="/product?action=create" class="btn btn-primary">Create</a>
                <form action="/product" class="d-flex float-end">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="q">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Color</th>
                        <th>Category</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.quantity}</td>
                            <td>${product.color}</td>
                            <td>${product.categoryName}</td>
                            <td>
                                <a href="/product?action=edit&id=${product.id}" class="btn btn-primary">Edit</a>
                                <a href="/product?action=delete&id=${product.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="card-footer text-muted">
                2 days ago
            </div>
        </div>
    </div>

</body>
</html>
