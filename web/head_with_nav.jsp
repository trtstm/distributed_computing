<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>


<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" style="padding: 2px;padding-left: 5px; padding-right: 5px;">
	<a class="navbar-brand" href="${pageContext.request.contextPath}" style="color: #00ebac; margin-left: 10px;">Podflix  <img src="resources/Imagesnew/logo.png" style="width: 40px; height: 40px"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	   <span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
	<ul class="navbar-nav">
		<li class="nav-item active">
			<a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
		</li>
		<li class="nav-item">
      <a class="nav-link" href="#"><c:out value="${user.getUsername()}"/></a>
		</li>
		<li class="nav-item dropdown dropdown-large">
			 <li class="nav-item dropdown">
    <a class="nav-link text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      <i class="fa fa-bell" style="padding-top: 2px;"></i>
    </a>
      <ul class="dropdown-menu">
        <li class="head text-light bg-dark">
          <div class="row">
            <div class="col-lg-12 col-sm-12 col-12">
              <span>Notifications (3)</span>
              <a href="" class="float-right text-light">Mark all as read</a>
            </div>
        </li>
        <li class="notification-box">
          <div class="row">
            <div class="col-lg-3 col-sm-3 col-3 text-center">
              <img src="images/prof.jpg" class="w-50 rounded-circle">
            </div>    
            <div class="col-lg-8 col-sm-8 col-8">
              <strong class="text-info">David John</strong>
              <div>
                Lorem ipsum dolor sit amet, consectetur
              </div>
              <small class="text-warning">27.11.2015, 15:00</small>
            </div>    
          </div>
        </li>
        <li class="notification-box bg-gray">
          <div class="row">
            <div class="col-lg-3 col-sm-3 col-3 text-center">
              <img src="images/prof.jpg" class="w-50 rounded-circle">
            </div>    
            <div class="col-lg-8 col-sm-8 col-8">
              <strong class="text-info">David John</strong>
              <div>
                Lorem ipsum dolor sit amet, consectetur
              </div>
              <small class="text-warning">27.11.2015, 15:00</small>
            </div>    
          </div>
        </li>
        <li class="notification-box">
          <div class="row">
            <div class="col-lg-3 col-sm-3 col-3 text-center">
              <img src="images/prof.jpg" class="w-50 rounded-circle">
            </div>    
            <div class="col-lg-8 col-sm-8 col-8">
              <strong class="text-info">David John</strong>
              <div>
                Lorem ipsum dolor sit amet, consectetur
              </div>
              <small class="text-warning">27.11.2015, 15:00</small>
            </div>    
          </div>
        </li>
        <li class="footer bg-dark text-center">
          <a href="" class="text-light">View All</a>
        </li>
      </ul>
  </li>
	</li>
	</ul>
	</div>
  <p style="margin-left: 10px;"><i class="fa fa-sign-out" aria-hidden="true" style="color: white; font-size: 20px;margin-left: 10px;"></i></p>
</nav>