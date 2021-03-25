<%-- 
    Document   : viewCart
    Created on : 11-03-2021, 12:26:51
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ViewCart Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
            $(function () {
                $("#datepicker1").datepicker();
            });
        </script>
    </head>
    <body>
        <c:if test="${sessionScope.dto.roleID == 'user' || sessionScope.NAME !=null}" >
            <nav class="navbar navbar-inverse" style="height: 78px;">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" style="padding-top: 18px;" href="viewCart.jsp">ViewCart</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li><a href="history.jsp">History</a></li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="LoadCarUserServlet">Rental Car</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a><span class="glyphicon glyphicon-user"></span>
                                <font color="white">
                                Welcome, ${sessionScope.dto.name}${sessionScope.NAME}
                                </font>
                            </a></li>
                        <li>
                            <a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <c:set var="cart"  value="${sessionScope.CUSTCART}" scope="session" />          
            <c:choose>
                <c:when test="${not empty cart}">
                    <c:choose>
                        <c:when test="${not empty cart.item}">
                            <div class="container">
                                <div class="row">
                                    <div class="col-xs-8">
                                        <div class="panel panel-info">
                                            <div class="panel-heading">
                                                <div class="panel-title">
                                                    <div class="row">
                                                        <div class="col-xs-3">
                                                            <h5><span class="glyphicon glyphicon-shopping-cart"></span> Car Cart</h5>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <h4> Customer Name : ${sessionScope.dto.name}${sessionScope.NAME}</h4>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <form action="DispatcherServlet">
                                                                <input type="submit" class="btn btn-primary btn-lg" value="Add more item" name="btAction" />
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <form action="DispatcherServlet">
                                                <c:forEach var="dto" items="${cart.item}" varStatus="counter">
                                                    <div class="panel-body">
                                                        <input type="hidden" name="txtCusname" value="${sessionScope.dto.name}${sessionScope.NAME}" />
                                                        <div class="col-xs-3">
                                                            <h4 class="product-name"><strong>${dto.value.carName}</strong></h4>
                                                            <input type="hidden" name="txtCarName" value="${dto.value.carName}" />                                      
                                                            <input type="hidden" name="txtCarID" value="${dto.value.carID}" />                                      
                                                        </div>
                                                        <div class="col-xs-3">

                                                        </div>
                                                        <div class="col-xs-6">
                                                            <div class="col-xs-6 text-right">
                                                                <h6><strong><span class="text-muted"> ${dto.value.price}$</span></strong></h6>
                                                                <input type="hidden" name="txtPrice" value="${dto.value.price}" />
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <input type="number" name="quantity" min="1"  class="form-control input-sm" value="${dto.value.quantity}">
                                                                <input type="hidden" name="txtquantity" value="${dto.value.quantity}" />
                                                            </div>
                                                            <div class="col-xs-2">
                                                                <input type="checkbox" name="chkitem" value="${dto.key}" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <c:set var="total" value="${total + dto.value.price * dto.value.quantity}"></c:set>

                                                </c:forEach>
                                                <hr>
                                                <div class="row">
                                                    <div class="text-center">
                                                        <div class="col-xs-9">
                                                            <input type="text" name="txtDiscount" value="" placeholder="Discount"/>
                                                            <h6 class="text-right">Added items?</h6>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <input type="submit" class="btn btn-default btn-sm btn-block" value="Remove Selected" name="btAction" />
                                                            <input type="submit" value="Update Quantity" class="btn btn-success" name="btAction" />
                                                        </div>
                                                    </div>
                                                </div>
                                        </div>
                                        <div class="col-xs-4" style="display: flex;">
                                            <p>Date Begin: <input type="date" name="txtDateBegin" ></p>                                                 
                                            <p>Date End: <input type="date" name="txtDateEnd"></p>      
                                        </div> 

                                        <div class="panel-footer">
                                            <div class="row text-center">
                                                <div class="col-xs-9">
                                                    <h4 class="text-right">${total}$ <strong>${cart.item.value.price * cart.item.value.quantity}</strong></h4>
                                                </div>
                                                <div class="col-xs-3">
                                                    <input type="submit" class="btn btn-success btn-block" value="Checkout" name="btAction" />

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <h2>
                            <font color="red">
                            ${requestScope.DISCOUNTERR}
                            ${requestScope.OVER} 
                            </font>
                        </h2> 
                    </form>
                </c:when>
                <c:otherwise>
                    <h1> Cart have no item</h1> 
                    <a href="LoadCarUserServlet"> Add Item to cart</a>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <h1> Cart have no item</h1> 
            <a href="LoadCarUserServlet"> Add Item to cart</a>
        </c:otherwise>
    </c:choose>
</c:if>
<c:if test="${sessionScope.dto.roleID == 'admin'}">
    <h2>
        You Can Not have permission to use this site <br/>
        <a href="login.html">Login With User</a>
    </h2>
</c:if>
</body>
</html>
