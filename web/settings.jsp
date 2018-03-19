<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

<div class="container">
    <div class="row">
        <div class="col">
            
        <c:if test="${not empty success}">
            <div class="alert alert-success" role="alert">
              ${success}
            </div>
        </c:if>
 <form method="post">
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input type="text" class="form-control" name="first_name" id="first_name" placeholder="Enter First Name"
                    value="<c:out value="${user.getFirstName()}"/>"
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
                    value="<c:out value="${user.getLastName()}"/>"       
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
                         <c:if test="${user.getGender() == 'MALE'}">checked</c:if>
                  >
                  <label class="form-check-label" for="gender_male">
                    Male
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="gender" id="gender_female" value="F"
                         <c:if test="${user.getGender() == 'FEMALE'}">checked</c:if>
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
                <input disabled type="text" class="form-control" name="email" id="email" placeholder="Enter email" 
                       value="<c:out value="${user.getEmail()}"/>"   
                >
            </div>

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="Enter username"
                       value="<c:out value="${user.getUsername()}"/>"   
                >

                <c:forEach items="${errors.username}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Enter password"
                       value="<c:out value="${user.getPassword()}"/>"   
                >

                <c:forEach items="${errors.password}" var="entry">
                <div class="alert alert-danger" role="alert">
                    ${entry}
                </div>
                </c:forEach>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
         </form>  
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>