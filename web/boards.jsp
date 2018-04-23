<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

<div id="boards-app">
    
    <div class="container-fluid">
        
        <h3>My Boards</h3>
        Title <input type="text" v-model="newBoard.title" />
        Private <input type="checkbox" v-model="newBoard.private" />
        <button @click="addBoard">Create</button>

        <div class="row">
            <div v-for="board in boards.userBoards" class="col-1">
                <div class="card">
                  <div class="card-body">
                      <p class="card-text">{{board.title}}</p>
                      <small>Private {{board.isPrivate ? 'yes' : 'no'}}</small>
                      <small>Podcasts: {{board.tracks.length}}</small>
                  </div>
                </div>
            </div>
        </div>
        
        
        <h3>Followed Boards</h3>
        <div class="row">
            <div v-for="board in boards.followedBoards" class="col-1">
                <div class="card">
                  <div class="card-body">
                      <p class="card-text">{{board.title}}</p>
                      <small>Podcasts: {{board.tracks.length}}</small>
                  </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script>   
$(function() {

   new Vue({
       el: '#boards-app',
       components: {
       },
       data() {
           return {
               boards: ${boards},
               newBoard: {}
           };
       },
       
       mounted() {
       },
       
       methods: {
           addBoard() {
                var self = this;
                $.getJSON({
                    url: GLOBALS.root_url + 'boards?action=create',
                    method: 'post',
                    data: {
                        title: self.newBoard.title,
                        isPrivate: self.newBoard.private,
                    }
                }).done(function(resp) {
                    self.boards.userBoards.push(resp);
                });
           },
       }
   }); 
});
    
</script>
<%@include file="footer.jsp"%>