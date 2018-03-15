<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>
<div class="wrapper_login">
    <form id="studentForm" class="container content_login">

                <div class="imgcontainer">
                    <img src="resources/logo.png" alt="Avatar" class="avatar"></img>
                </div>

              <div class="container contents">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname"></input>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw"></input>

                <button type="submit">Login</button>
                <label>
                  <input type="checkbox" checked="checked" name="remember"> Remember me</input>
                </label>
              </div>

              <div class="container contents" style="background-color:#f1f1f1">
                <button type="button" class="cancelbtn">Login with Facebook</button>
                <button type="button" class="cancelbtn">Login with Gmail</button>
              </div>

        </form>
    </div>

<%@include file="footer.jsp"%>