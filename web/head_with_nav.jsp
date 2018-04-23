<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>

	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
	  <a class="navbar-brand" href="${pageContext.request.contextPath}">podflix</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	    </ul>
	    <form class="form-inline my-2 my-lg-0">
	    	<ul class="navbar-nav mr-auto">
                    <li class="profile-item"><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li class="profile-item"><a href="<c:url value="/boards" />">Boards</a></li>
	    	 	  <li class="profile-item"><span class="oi oi-magnifying-glass" title="magnifying-glass" aria-hidden="true"><span>     Search</span></li>
			      <li class="profile-item"><span class="oi oi-person" title="person" aria-hidden="true"></span></li>
				  <li class="profile-item"><span class="oi oi-comment-square" title="comment-square" aria-hidden="true"></span></li>
			      
			 </ul>
	    </form>
	  </div>
	</nav>