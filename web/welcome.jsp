<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

<div id="welcome-app">
    
    <div class="container">
        
        <h3>Recommended For You</h3>
        <div class="row">
            <div v-for="track in recommendations" class="col-3">
                <div class="card track-card" :title="track.description">
                  <div class="podflix-image" :style="{backgroundImage: 'url(' + (track.artworkUrl ? track.artworkUrl : 'resources/no-image.png') + ')'}"></div>
                  <div class="card-body">
                    <h5 class="card-title">{{track.title}} <small>Uploaded by: {{track.user.username}}</small></h5>
                    
                    <a :href="rootUrl + 'tracks?id=' + track.id.toString()" class="">Read More</a>
                  </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="resources/welcome.js"></script>
<%@include file="footer.jsp"%>