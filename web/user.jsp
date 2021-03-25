<%-- 
    Document   : user
    Created on : 11-03-2021, 10:24:14
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">
    </head>
    <body>
        <c:if test="${sessionScope.dto.roleID == 'user' || sessionScope.NAME !=null}">
            <nav class="navbar navbar-inverse" style="height: 78px;">

                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" style="padding-top: 18px;" href="viewCart.jsp">ViewCart</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <a class="navbar-brand" style="padding-top: 18px;" href="DispatcherServlet?btAction=History&txtCusName=${sessionScope.dto.userName}${sessionScope.NAME}">History</a>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="navbar-brand"><a href="#">Rental Car</a></li>
                    </ul>
                    <form action="DispatcherServlet" class="navbar-form navbar-left">
                        <input type="text" name="txtSearchValueByCarName" value="${param.txtSearchValueByCarName}" class="form-control mx-sm-3" placeholder="Name of Car"/>
                        <input type="submit" value="Find" name="btAction" class="form-control mx-sm-3" />
                    </form>
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
            <div class="container">

                <div class="row">
                    <c:choose>
                        <c:when test="${requestScope.SEARCHNAMEU!= null }">
                            <c:forEach var="L" items="${requestScope.SEARCHNAMEU}">
                                <form action="DispatcherServlet">
                                    <input type="hidden" name="txtCusname" value="${sessionScope.dto.name}${sessionScope.NAME}" />
                                    <input type="hidden" name="txtCarID" value="${L.carID}" />
                                    <div class="">
                                        <div class="row" style="width: 40em">
                                            <div class="col-lg-10 ">
                                                <div class="card h-100">
                                                    <a href="#" ><img class="card-img-top" src="${L.imageSrc}" alt="" style="height: 200px;"></a>
                                                    <div class="card-body">
                                                        <h4 class="card-title">
                                                            <a href="#">${L.carName}</a>
                                                            <input type="hidden" name="txtCarName" value="${L.carName}" />
                                                        </h4>
                                                        <h5>
                                                            ${L.price}$/day
                                                            <input type="hidden" name="txtPrice" value="${L.price}" />
                                                        </h5>
                                                        <p class="card-text">${L.description}</p>
                                                    </div>
                                                    <div class="card-footer">
                                                        <input type="submit" class="btn btn-success" name="btAction" value="AddToCart" />
                                                        <input type="hidden" name="lastSearchValue" value="${param.txtSearchValueByCarName}" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                            </c:forEach> 

                            <div style="display: block; width: 100%;">
                                <nav aria-label="..." class="d-flex justify-content-center">
                                    <ul class="pagination pagination-lg">
                                        <c:forEach begin="1" end="${totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pageIndex == i}">
                                                    <li class="page-item active" aria-current="page">
                                                        <span class="page-link">
                                                            ${i}
                                                            <span class="sr-only">(current)</span>
                                                        </span>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="SearchCarUserServlet?pageIndex=${i}">${i}</a></li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                    </ul>
                                </nav>
                            </div>


                        </c:when>
                        <c:otherwise>
                            <c:forEach var="L" items="${requestScope.LISTCARU}">
                                <form action="DispatcherServlet">
                                    <input type="hidden" name="txtCusname" value="${sessionScope.dto.name}${sessionScope.NAME}" />
                                    <input type="hidden" name="txtCarID" value="${L.carID}" />
                                    <div class="">
                                        <div class="row" style="width: 40em">
                                            <div class="col-lg-10 ">
                                                <div class="card h-100">
                                                    <a href="#" "><img class="card-img-top" src="${L.imageSrc}" alt="" style="height: 200px;"></a>
                                                    <div class="card-body">
                                                        <h4 class="card-title">
                                                            <a href="#">${L.carName}</a>
                                                            <input type="hidden" name="txtCarName" value="${L.carName}" />
                                                        </h4>
                                                        <h5>
                                                            ${L.price}$/day
                                                            <input type="hidden" name="txtPrice" value="${L.price}" />
                                                        </h5>
                                                        <p class="card-text">${L.description}</p>
                                                    </div>
                                                    <div class="card-footer">
                                                        <input type="submit" class="btn btn-success" name="btAction" value="AddToCart" />
                                                        <input type="hidden" name="lastSearchValue" value="${param.txtSearchValueByCarName}" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </c:forEach> 
                            <div style="display: block; width: 100%;">
                                <nav aria-label="..." class="d-flex justify-content-center">
                                    <ul class="pagination pagination-lg">
                                        <c:forEach begin="1" end="${totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${pageIndex == i}">
                                                    <li class="page-item active" aria-current="page">
                                                        <span class="page-link">
                                                            ${i}
                                                            <span class="sr-only">(current)</span>
                                                        </span>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="LoadCarUserServlet?pageIndex=${i}">${i}</a></li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                    </ul>
                                </nav>
                            </div>

                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <footer class="py-5 bg-dark">
                <div class="container">
                    <p class="m-0 text-center text-white">Copyright &copy; By Khoi 2021</p>
                </div>
            </footer>
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        </c:if>
        <c:if test="${sessionScope.dto.roleID == 'admin'}">
            <h2>
                You Can Not have permission to use this site <br/>
                <a href="login.html">Login With User</a>
            </h2>
        </c:if>
    </body>
</html>
