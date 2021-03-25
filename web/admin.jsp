<%-- 
    Document   : admin
    Created on : 11-03-2021, 10:24:05
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${sessionScope.dto.roleID == 'admin'}">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Search Admin</a></li>
                    </ul>
                    <form action="DispatcherServlet" class="navbar-form navbar-left">
                        <input type="text" name="txtSearchValueByQuestionName" value="${param.txtSearchValueByCarName}" class="form-control mx-sm-3" placeholder="Name of Question"/>
                        <select name="categoryCar" class="form-control mx-sm-3">

                            <c:forEach var="dto" items="${sessionScope.LISTCATEGORY}">
                                <c:choose>
                                    <c:when test="${pageScope.dto.categoryID eq requestScope.categoryName}">
                                        <option value="${pageScope.dto.categoryID}" selected="">${pageScope.dto.categoryName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${pageScope.dto.categoryID}">${pageScope.dto.categoryName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Search" name="btAction" class="form-control mx-sm-3" />
                        <input type="submit" value="GetAll" name="btAction" class="form-control mx-sm-3"/>
                    </form>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a><span class="glyphicon glyphicon-user"></span>
                                <font color="white">
                                Welcome, ${sessionScope.dto.name}
                                </font>
                            </a></li>
                        <li>
                            <a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>

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
                                <li class="page-item"><a class="page-link" href="LoadCarServlet?pageIndex=${i}">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                </ul>
            </nav>
            <c:choose>
                <c:when test="${requestScope.SEARCHNAME != null}">
                    <table border="1" style="background: pink;">
                        <thead>
                            <tr>
                                <th>   ID</th>
                                <th>   Name   </th>
                                <th>   Image </th>
                                <th>   Color     </th>
                                <th>   Year   </th>
                                <th>   Price   </th>
                                <th>   Quantity   </th>
                                <th>   Description   </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" items="${SEARCHNAME}">

                                <tr>

                                    <td style="width: 50px;">${dto.carID}</td>
                                    <td style="width: 100px;">${dto.carName} </td>
                                    <td style="width: 400px;"><img src="${dto.imageSrc}" height="150px" weight="210px"></img> </td>    
                                    <td style="width: 50px;" > ${dto.color}</td>
                                    <td style="width: 50px;"> ${dto.year}</td>
                                    <td style="width: 100px;"> ${dto.price}</td>
                                    <td> ${dto.quantity}</td>
                                    <td style="width: 700px;"> ${dto.description}</td>    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <table border="1" style="background: pink;">
                        <thead>
                            <tr>
                                <th>   ID</th>
                                <th>   Name   </th>
                                <th>   Image </th>
                                <th>   Color     </th>
                                <th>   Year   </th>
                                <th>   Price   </th>
                                <th>   Quantity   </th>
                                <th>   Description   </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" items="${LISTCAR}">

                                <tr>

                                    <td style="width: 50px;">${dto.carID}</td>
                                    <td style="width: 100px;">${dto.carName} </td>
                                    <td style="width: 250px;"><img src="${dto.imageSrc}" height="150px" weight="210px"></img> </td>    
                                    <td style="width: 50px;" > ${dto.color}</td>
                                    <td style="width: 50px;"> ${dto.year}</td>
                                    <td style="width: 100px;"> ${dto.price}</td>
                                    <td> ${dto.quantity}</td>
                                    <td style="width: 700px;"> ${dto.description}</td>    
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <footer class="py-5 bg-dark">
                <div class="container">
                    <p class="m-0 text-center text-white">Copyright &copy; By Khoi 2021</p>
                </div>
            </footer>
        </c:if>

        <c:if test="${sessionScope.dto.roleID != 'admin'}">
            <h2>
                You Can Not have permission to use this site <br/>
                <a href="login.html">Login With Admin</a>
            </h2>
        </c:if>
    </body>
</html>
