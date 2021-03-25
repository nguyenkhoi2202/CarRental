<%-- 
    Document   : register
    Created on : 11-03-2021, 18:40:25
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="jquery-3.5.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <style>
            body {
                background-image: url(image/carRental.jpg);
                background-repeat: initial;
                font-size: 12px
            }
            .main {
                max-width: 320px;
                margin: 0 auto;
            }
            .login-or {
                position: relative;
                font-size: 18px;
                color: #aaa;
                margin-top: 10px;
                margin-bottom: 10px;
                padding-top: 10px;
                padding-bottom: 10px;
            }
            .span-or {
                display: block;
                position: absolute;
                left: 50%;
                top: -2px;
                margin-left: -25px;
                background-color: #fff;
                width: 50px;
                text-align: center;
            }
            .hr-or {
                background-color: #cdcdcd;
                height: 1px;
                margin-top: 0px !important;
                margin-bottom: 0px !important;
            }
            h3 {
                text-align: center;
                line-height: 300%;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">

                <div class="main">

                    <h3>Please Log In </h3>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12">
                            <a href="login.html" class="btn btn-lg btn-info btn-block">Login</a>
                        </div>
                    </div>
                    <div class="login-or">
                        <hr class="hr-or">
                        <span class="span-or">or</span>
                    </div>

                    <form role="form" action="DispatcherServlet" method="POST">
                        <div class="form-group">
                            <label for="inputUsernameEmail">Username</label>
                            <input type="text" name="txtUsername" class="form-control" id="inputUsernameEmail">
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Password</label>
                            <input type="password" name="txtPassword" class="form-control" id="inputPassword">
                        </div>
                        <div class="form-group">
                            <label for="inputConfirmPassword">ConfirmPassword</label>
                            <input type="password" name="txtConfirmPassword" class="form-control" id="inputPassword">  
                        </div><h5><font color="red">${requestScope.ERRCONFIRM}</font></h5>
                        <div class="form-group">
                            <label for="Phone">Phone</label>
                            <input type="text" name="txtPhone" class="form-control" id="inputPassword">
                        </div>
                        <div class="form-group">
                            <label for="Email">Email</label>
                            <input type="text" name="txtEmail" class="form-control" id="inputPassword">
                        </div>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" name="txtName" class="form-control" id="inputPassword">
                        </div>
                        <div class="form-group">
                            <label for="Address">Address</label>
                            <input type="text" name="txtAddress" class="form-control" id="inputPassword">
                        </div>
                        <input type="submit" id="btn" value="Register" onclick="" name="btAction" class="btn btn btn-primary" />
                    </form>
                </div>

            </div>
        </div>
        
    </body>
</html>
