<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

<div id="welcome-app">
<div class="modal fade" id="boardsModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Pin/Unpin</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <div v-for="modalBoard in modalBoards" class="form-check">
              <label class="form-check-label">
                <input type="checkbox" class="form-check-input" v-model="modalBoard.pinned">{{modalBoard.board.title}}
              </label>
            </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" @click="savePins()">Save changes</button>
      </div>
    </div>
  </div>
</div>
    
<div class="modal fade" id="confirmUnfollow" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Are you sure you want to unfollow?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <p>Are you sure you want to unfollow this board?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-danger" @click="unfollow">Unfollow</button>
      </div>
    </div>
  </div>
</div>
    
<div class="container-fluid banner">
   		<div class="text" style="text-align: center;"><span class="oi oi-play-circle icon-play-main"></span></div>
  </div>
    
<div class="container-fluid">
    <div class="card-columns">
        <div class="card" v-for="track in pinnedTracks">
        <img class="card-img-top img-fluid" :src="(track.artworkUrl ? track.artworkUrl : 'resources/no-image.png')" alt="Card Columns 1">
        <div class="card-overlay">
            <div class="text"><a href="#"><span class="oi oi-play-circle icon-play"></span></a></div>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">{{track.title}}</h5>
            </div>
            <div class="col-md-6">
                <img @click="showBoardsModal(track)" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKXSURBVGhD7Zm7itVQGEaPyKiooL0ivoDdqL0I6hsoKIJYCDoKFhaKFr6JVyy8gpfGW6OF4gOITDGNIFPZKDOIuj6ZH342O5eT7J0cZC9YxclJdvYKSU4yMykUCoX/ivW4gHP/PuVjF17HB3gDj6P2nQQNdBv/4H3cgDk4hj9Q+/G+wx3Ym3PoB84RswdX0e/H+wV3Yi80aU3eD5w65jna2Mt4DW+6ZXLmY/ahH/cQGpfQf5csRhehH7hvjM79z2jjvcSQMOYT9j6AKWPCiN84jzHCmJPYmxQxYYS8iHXcQltXd9EkaNIP0U9EcW1iukSIq2jrP9KCVHSJ6RpxBHU3s230o5kUTVpHx0+sKqZLxAF8j36bn7gbk9M25i76dZoidEH/Qr/NCh7FbGzFD+h3GsZsw4+o75oiTmEY8Qz1BJCFw/gCqx4vdA2FMXoQrOM06lZsY+h03I9Z2IT2INlkGFPHGQwjdG1lYTO+Qj9Z+R0X1/y6tsxsE3MWB414g36SitqLHk06vAHUxZzHwSLEZfST05FXXIy2MSdw0Aihl6x76Ceni30jxmgTsx3tbjZIhJEiRp99jO5m+p0ZLMLIETMaJQb9+iUmB11ivqFffyZiYkdZ1sUsYbj+YxwtpirCrIqJhchRYmIR+tx0mq1DPZvZ9+ErwKAxVRFa3nTN6LHclusVYAuGYw0SUxdhVMXo2ey1W/YUhbbV5P36WWPaRBixmPAR/yAag8VME2HEYkz96yAkFvMEk8V0iTBiMTq96n5nssT0iTB8zFuseo8xNLYm7/fZK0Yb6h3CDzhthKGYK9gUYSSNCf/R0+b9OyWxmAs4NTqKd3CMCMPH6K83mlMntKGOwhgRhvatOXSOKBQKhVljMvkL8me3dDLtp0IAAAAASUVORK5CYII=">
            </div>
          </div>
        </div>
        </div>
  </div>
  <h3>Following</h3>
  <hr>
<div id="mixedSlider" class="podflixSlider">
      <div class="MS-content">
          <div class="item" v-for="board in followedBoards" @click="unfollowBoard(board)">
              <div class="imgTitle">
                  <h2 class="blogTitle">{{board.title}}</h2>
                  <img src="resources/images/movies.jpg" alt="">
              </div>
          </div>
      </div>
      <div class="MS-controls">
          <button class="MS-left"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
          <button class="MS-right"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
      </div>
  </div>
  
  <h3>Recommended For You</h3>
<div id="recommendedSlider" class="podflixSlider">
      <div class="MS-content">
          <div class="item" v-for="track in recommendedTracks" @click="showBoardsModal(track)">
              <div class="imgTitle">
                  <h2 class="blogTitle">{{track.title}}</h2>
                  <img :src="(track.artworkUrl ? track.artworkUrl : 'resources/no-image.png')" alt="">
              </div>
          </div>
      </div>
      <div class="MS-controls">
          <button class="MS-left"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
          <button class="MS-right"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
      </div>
  </div>

</div>
    
   
</div>

<script src="resources/welcome.js"></script>
<%@include file="footer.jsp"%>