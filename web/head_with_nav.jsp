<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>


                          
                          
                          <nav class="navbar navbar-expand-lg bg-info rounded">
    <a class="navbar-brand text-light" href="${pageContext.request.contextPath}">Podflix</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent" style="display: unset !important;">
      <ul class="nav nav-pills mr-auto justify-content-end">
        <li class="nav-item active">
          <a class="nav-link text-light" href="${pageContext.request.contextPath}">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="#"><c:out value="${user.getUsername()}"/></a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-bell"></i>
          </a>
            <ul class="dropdown-menu">
              <li class="head text-light bg-dark">
                <div class="row">
                  <div class="col-lg-12 col-sm-12 col-12">
                    <span>Notifications (3)</span>
                    <a href="" class="float-right text-light">Mark all as read</a>
                  </div>
              </div></li>
              <li class="notification-box">
                <div class="row">
                  <div class="col-lg-3 col-sm-3 col-3 text-center">
                    <img src="resources/images/prof.jpg" class="w-50 rounded-circle">
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
                    <img src="resources/images/prof.jpg" class="w-50 rounded-circle">
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
                    <img src="resources/images/prof.jpg" class="w-50 rounded-circle">
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
      </ul>
    </div>
  </nav>