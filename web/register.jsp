<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>

<div class="container">
   
    <form method="POST">
      <div class="form-group row">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
          <input name="email" type="email" class="form-control" id="inputEmail3" placeholder="Email">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
          <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="Password">
        </div>
      </div>
        
      <div class="form-group row">
        <label for="username" class="col-sm-2 col-form-label">Username</label>
        <div class="col-sm-10">
          <input name="username" type="text" class="form-control" id="username" placeholder="Username">
        </div>
      </div>
        
      <div class="form-group row">
        <label for="first_name" class="col-sm-2 col-form-label">First name</label>
        <div class="col-sm-10">
          <input name="first_name" type="text" class="form-control" id="first_name" placeholder="First name">
        </div>
      </div>
        
      <div class="form-group row">
        <label for="last_name" class="col-sm-2 col-form-label">Last name</label>
        <div class="col-sm-10">
          <input name="last_name" type="text" class="form-control" id="last_name" placeholder="Last name">
        </div>
      </div>
        
      <div class="form-group row">
        <label for="country" class="col-sm-2 col-form-label">Country</label>
        <div class="col-sm-10">
          <input name="country" type="text" class="form-control" id="country" placeholder="Country">
        </div>
      </div>
        
        
      <fieldset class="form-group">
        <div class="row">
          <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
          <div class="col-sm-10">
            <div class="form-check">
              <input class="form-check-input" type="radio" name="gender" id="gemder_m" value="M" checked>
              <label class="form-check-label" for="gender_m">
                Male
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="gender" id="gender_f" value="F">
              <label class="form-check-label" for="gender_f">
                Female
              </label>
            </div>
          </div>
        </div>
      </fieldset>

      <div class="form-group row">
        <div class="col-sm-10">
          <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
      </div>
    </form>
</div>

<%@include file="footer.jsp"%>