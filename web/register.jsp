<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_login.jsp"%>

<div class="register_page_wrapper container">
    
    <div class="form-wrapper">
        <div class="row logo-wrapper">
            <div class="col">
                <img width="50" height="50" src="resources/logo.png" alt="Avatar" class="avatar"></img>
            </div>
        </div>

        <form method="post">
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input type="text" class="form-control" name="first_name" id="first_name" placeholder="Enter First Name"
                    value="<c:out value="${param.first_name}"/>"
                >

                <c:forEach items="${errors.first_name}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input type="text" class="form-control" name="last_name" id="last_name" placeholder="Enter Last Name"
                    value="<c:out value="${param.last_name}"/>"       
                >

                <c:forEach items="${errors.last_name}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="gender">Gender</label>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="gender" id="gender_male" value="M"
                         <c:if test="${param.gender == 'M'}">checked</c:if>
                  >
                  <label class="form-check-label" for="gender_male">
                    Male
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="gender" id="gender_female" value="F"
                         <c:if test="${param.gender == 'F'}">checked</c:if>
                  >
                  <label class="form-check-label" for="gender_female">
                    Female
                  </label>
                </div>

                <c:forEach items="${errors.gender}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>        

            <div class="form-group">
                <label for="country">Country</label>
                <%@include file="countryList.jsp"%>

                <c:forEach items="${errors.country}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" name="email" id="email" placeholder="Enter email" 
                       value="<c:out value="${param.email}"/>"   
                >

                <c:forEach items="${errors.email}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="Enter username"
                       value="<c:out value="${param.username}"/>"   
                >

                <c:forEach items="${errors.username}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">

                <c:forEach items="${errors.password}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <button type="submit" class="btn btn-login">Register</button>
         </form>  
                
        <div class="social-wrapper">
            <button disabled type="button" class="btn btn-login btn-social">Register with Facebook</button>
            <button disabled type="button" class="btn btn-login btn-social">Register with Google</button>

            <p>Already a member?<a href="<c:url value="/login" />">  Login</a></p>
        </div>
    </div>
</div>

<%@include file="footer_login.jsp"%>