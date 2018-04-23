<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

    
<div class="container-fluid">
    <iframe width="100%" height="166" scrolling="no" frameborder="no"
      src="https://w.soundcloud.com/player/?url=<c:out value="${track.getStreamUrl()}"/>">
    </iframe>
    
    <div id="track-app">
        <p>Track added by {{track.user.username}}</p>
        
        <ul>
            <li @click="pin(board, index)" v-for="(board, index) in boards">{{board.title}} <span v-if="hasPinned(board, track)">(PINNED)</span></li>
        </ul>
        <input v-model="boardName" />
        <button @click="addBoard">Add board</button>
    </div>
</div>
       

<script>
    window.track = ${trackJson};
    window.userBoards = ${userBoards};
</script>
<script src="resources/track.js"></script>
<%@include file="footer.jsp"%>