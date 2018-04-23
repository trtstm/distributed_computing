<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

<div id="welcome-app">
    
    <div class="container-fluid">
        
        <h3>Recommendations</h3>
        <div class="row">
            <div v-for="track in recommendations" class="col-1">
                <div class="card">
                  <img class="card-img-top" src="resources/no-image.png" alt="Card image cap">
                  <div class="card-body">
                      <p class="card-text"><a :href="rootUrl + '/tracks?id=' + track.id">{{track.title}}</a></p>
                  </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="resources/welcome.js"></script>
<%@include file="footer.jsp"%>