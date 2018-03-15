<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>

<form id="studentForm" class="container content">

            <div class="imgcontainer">
                <img src="resources/logo.png" alt="Avatar" class="avatar"></img>
            </div>

          <div class="container contents">
            <label for="uname"><b>First Name</b></label>
            <input type="text" placeholder="Enter First Name" name="first_name" id="first_name"></input>
            
            <label for="uname"><b>Last Name</b></label>
            <input type="text" placeholder="Enter Last Name" name="last_name" id="last_name"></input>
            
            <label for="psw"><b>Gender</b></label>
            <div class="radioContainer">
                <input type="radio" name="gender" value="male">Male</input>
            </div>
            <div class="radioContainer">
                <input type="radio" name="gender" value="female"> Female</input>
            </div>
            
            <div class="countryContainer">
                <label for="psw" class="country"><b>Country</b></label>
                <%@include file="countryList.jsp"%>
            </div>
            
            <label for="psw"><b>Email</b></label>
            <input type="email" placeholder="Create Email" name="email" id="inputEmail3"></input>
            
            <label for="uname"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" id="username"></input>
            
            <label for="pswd"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="inputPassword3" id="inputPassword3"></input> 
            
            <button type="submit">Register</button>
          </div>

          <div class="container contents" style="background-color:#f1f1f1">
            <button type="button" class="cancelbtn">Register with Facebook</button>
            <button type="button" class="cancelbtn">Register with Gmail</button>
            <p>Already a member?<a href="#">  Login</a></p>
          </div>
 </form>
<%@include file="footer.jsp"%>