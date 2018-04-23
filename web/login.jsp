<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_login.jsp"%>

<div class="login_page_wrapper container">
    <div class="form-wrapper">
    <div class="row logo-wrapper">
        <div class="col">
            <img width="50" height="50" src="resources/logo.png" alt="Avatar" class="avatar"></img>
        </div>
    </div>

    <c:forEach items="${errors.login}" var="entry">
    <div class="alert alert-danger" role="alert">
        ${entry}
    </div>
    </c:forEach>
        
        <form method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" name="email" id="email" placeholder="you@domain.com"
                    value="<c:out value="${param.email}"/>"
                >
            </div>

            <div class="form-group">
                <label for="email">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Password"
                    value=""
                >
            </div>

            <button type="submit" class="btn btn-login">Login</button>
        </form>
                
        <div class="social-wrapper">
            <button disabled type="button" class="btn btn-login btn-social">Login with Facebook</button>
            <button disabled type="button" class="btn btn-login btn-social">Login with Google</button>
            <p>Not on Pinterest yet?<a href="<c:url value="/register" />">  Register</a></p>
        </div>
    </div>

<%@include file="footer_login.jsp"%>