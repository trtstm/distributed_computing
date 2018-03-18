<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>

<nav class="navbar navbar-expand-md navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="resources/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
    Pinterest
  </a>
    
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/welcome" />">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/stats" />">Stats</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Settings</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
      </li>
    </ul>
  </div>
</nav>