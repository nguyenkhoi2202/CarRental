<%-- 
    Document   : history
    Created on : 11-03-2021, 12:25:56
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
        
        <style>
            .title_oder_header{
                display: flex;
            }
            .title_order_body_row_head{
                display: flex;

            }
            .title_oder_header_row{
                margin-right: 45px;

            }
            #a{
                margin-top: 15px;
            }

            .title_order_body_row{
                margin-right: 60px;
            }
            .title_order{
                display: flex;
            }


            .title_view_header{
                display: flex;
            }
            .title_view_body_row_head{
                display: flex;

            }
            .title_view_header_row{
                margin-right: 110px;

            }

            .title_view_body_row{
                margin-right: 40px;
                width: 130px;
                height: 50px;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.dto.roleID == 'user' || sessionScope.NAME !=null}">
            <form action="DispatcherServlet">
                <input type="hidden" name="txtCusName" value="${sessionScope.dto.userName}${sessionScope.NAME}" />
                Date:<input type="date" name="txtSearchDate" value="" />
                Name Car:<input type="text" name="txtSearchNameCar" value="" />
                <input type="submit" value="SearchHistory" name="btAction" />
            </form>

            <c:choose>
                <c:when test="${empty requestScope.LISTSEARCHHISTORY && empty requestScope.LISTSEARCHHISTORYDETAIL}">
                    <div class="title_order">
                        <div class="title_order_1">
                            <div class="title_oder_header">
                                <div class="title_oder_header_row">
                                    <Strong>
                                        id
                                    </Strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <Strong>
                                        UserName
                                    </Strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <Strong>
                                        Total Price
                                    </Strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>
                                        Begin Date
                                    </strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>
                                        End Date
                                    </strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>
                                        Total Date Rental
                                    </strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>

                                    </strong>
                                </div>
                            </div>
                            <div class="title_order_body">
                                <form action="DispatcherServlet">
                                    <c:forEach var="dto" items="${requestScope.HISTORY}" >
                                        <div class="title_order_body_row_head">
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.rentalID}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.cusName}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.totalPrice}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.checkIn}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.checkOut}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.bookDate}
                                                </p>
                                            </div>

                                            <div class="title_order_body_row" id="a" >
                                                <a href="DispatcherServlet?btAction=ShowOrder&rentalID=${dto.rentalID}" >View</a>
                                                <a href="DispatcherServlet?btAction=DeleteHistory&rentalID=${dto.rentalID}&userName=${sessionScope.dto.userName}${sessionScope.NAME}" >Delete</a>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </form>
                            </div>
                        </div>
                        <c:if test="${not empty requestScope.HISTORYDETAIL}">
                            <div class="title_order_2">
                                <div class="title_view_header">
                                    <div class="title_view_header_row">
                                        <Strong>
                                            Car Name
                                        </Strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <Strong>
                                            Price
                                        </Strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <Strong>
                                            Quantity
                                        </Strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <strong>
                                            Total Price
                                        </strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <strong>
                                            Rate
                                        </strong>
                                    </div>
                                </div>
                                <div class="title_view_body">
                                    <c:forEach var="dtoDetail" items="${requestScope.HISTORYDETAIL}">
                                        <div class="title_view_body_row_head">
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.carName}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.price}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.quantity}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.price * dtoDetail.quantity}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                <form action="DispatcherServlet">
                                                    <input type="hidden" name="userName" value="${sessionScope.dto.userName}${sessionScope.NAME}" />
                                                    <input type="hidden" name="nameCar" value=" ${dtoDetail.carName}" />
                                                    <input type="text" name="txtRate" min="1" max="10" placeholder="1~10"/>
                                                    <input type="submit" value="Rate" name="btAction" />
                                                </form>
                                                </p>
                                            </div>
                                            <c:set var="total" value="${total + dtoDetail.price * dtoDetail.quantity}"/>
                                        </div>
                                    </c:forEach>
                                    <h2>Total : ${total} </h2> 
                                    </form>
                                </div>
                            </c:if>
                        </div>
                        <h2><a href="LoadCarUserServlet">Home</a></h2>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="title_order">
                        <div class="title_order_1">
                            <div class="title_oder_header">
                                <div class="title_oder_header_row">
                                    <Strong>
                                        id
                                    </Strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <Strong>
                                        UserName
                                    </Strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <Strong>
                                        Total Price
                                    </Strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>
                                        Begin Date
                                    </strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>
                                        End Date
                                    </strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>
                                        Total Date Rental
                                    </strong>
                                </div>
                                <div class="title_oder_header_row">
                                    <strong>

                                    </strong>
                                </div>
                            </div>
                            <div class="title_order_body">
                                <form action="DispatcherServlet">
                                    <c:forEach var="dto" items="${requestScope.LISTSEARCHHISTORY}" >
                                        <div class="title_order_body_row_head">
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.rentalID}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.cusName}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.totalPrice}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.checkIn}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.checkOut}
                                                </p>
                                            </div>
                                            <div class="title_order_body_row">
                                                <p>
                                                    ${dto.bookDate}
                                                </p>
                                            </div>

                                            <div class="title_order_body_row" id="a">
                                                <input type="submit" value="ShowOrder" name="btAction" />
                                                <input type="hidden" name="rentalID" value="${dto.rentalID}" />
                                            </div>
                                        </div>
                                    </c:forEach>
                                </form>
                            </div>
                        </div>
                        <c:if test="${not empty requestScope.LISTSEARCHHISTORYDETAIL}">
                            <div class="title_order_2">
                                <div class="title_view_header">
                                    <div class="title_view_header_row">
                                        <Strong>
                                            Car Name
                                        </Strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <Strong>
                                            Price
                                        </Strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <Strong>
                                            Quantity
                                        </Strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <strong>
                                            Total Price
                                        </strong>
                                    </div>
                                    <div class="title_view_header_row">
                                        <strong>
                                            Rate
                                        </strong>
                                    </div>
                                </div>
                                <div class="title_view_body">
                                    <c:forEach var="dtoDetail" items="${requestScope.LISTSEARCHHISTORYDETAIL}">
                                        <div class="title_view_body_row_head">
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.carName}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.price}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.quantity}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                    ${dtoDetail.price * dtoDetail.quantity}
                                                </p>
                                            </div>
                                            <div class="title_view_body_row">
                                                <p>
                                                <form action="DispatcherServlet">
                                                    <input type="hidden" name="userName" value="${sessionScope.dto.userName}${sessionScope.NAME}" />
                                                    <input type="hidden" name="nameCar" value="${dtoDetail.carName}" />
                                                    <input type="text" name="txtRate" min="1" max="10" placeholder="1~10"/>
                                                    <input type="submit" value="Rate" name="btAction" />
                                                </form>
                                                </p>
                                            </div>
                                            <c:set var="total" value="${total + dtoDetail.price * dtoDetail.quantity}"/>
                                        </div>
                                    </c:forEach>
                                    <h2>Total : ${total} </h2> 
                                    </form>
                                </div>
                            </c:if>
                        </div>
                        <h2><a href="LoadCarUserServlet">Home</a></h2>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${sessionScope.dto.roleID == 'admin' || sessionScope.NAME ==null} ">
            <h2>
                You Can Not have permission to use this site <br/>
                <a href="login.html">Login With User</a>
            </h2>
        </c:if>
    </body>
</html>

