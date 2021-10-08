<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: t
  Date: 10/8/2021
  Time: 10:34 AM
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
  <form method="post">
    <div class="mb-3">
      <label class="form-label">Product Name</label>
      <input type="text" class="form-control" name="productName" value="${product.name}">
    </div>
    <div class="mb-3">
      <label class="form-label">Price</label>
      <input type="text" class="form-control" name="price" value="${product.price}">
    </div>
    <div class="mb-3">
      <label class="form-label">Quantity</label>
      <input type="number" class="form-control" name="quantity" value="${product.quantity}">
    </div>
    <div class="mb-3">
      <label class="form-label">Color</label>
      <input type="text" class="form-control" name="color" value="${product.color}">
    </div>
    <div class="mb-3">
      <label class="form-label">Description</label>
      <input type="text" class="form-control" name="description" value="${product.description}">
    </div>
    <div class="mb-3">
      <label class="form-label">Category</label>
      <select class="form-select" name="categoryId">
        <c:forEach items="${categories}" var="category">
          <c:if test="${product.categoryId == category.id}">
            <option value="${category.id}" selected>${category.name}</option>
          </c:if>
          <c:if test="${product.categoryId != category.id}">
            <option value="${category.id}" selected>${category.name}</option>
          </c:if>
        </c:forEach>
      </select>
    </div>

    <button type="submit" class="btn btn-primary">Edit</button>
    <a class="btn btn-primary" href="/product">Back</a>
  </form>
</div>

</body>
</html>
