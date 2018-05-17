<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>
<div class="container">
  <div class="row">
    <div id="demo" class="col-md-10 carousel slide" data-ride="carousel">

      <!-- Indicators -->
      <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
      </ul>

      <div class="carousel-inner inner">
        <div class="carousel-item active">
          <img src="resources/Imagesnew/got.jpg" alt="Los Angeles">
        </div>
        <div class="carousel-item">
          <img src="resources/Imagesnew/sherlock1.jpg" alt="Chicago">
        </div>
        <div class="carousel-item">
          <img src="resources/Imagesnew/jessica.jpg" alt="New York">
        </div>
      </div>

      <!-- Left and right controls -->
      <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
      </a>
      <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
      </a>

    </div>
    <div class="col-md-2 side" style="margin-top: 20px; background: #474747;">
      <div class="wrapper">

          <nav id="sidebar">
              <!-- Sidebar Header -->
              <!-- Sidebar Links -->
              <ul class="list-unstyled components">
                  <li class="active"><a href="#">BOARDS</a></li>
                  <li><a href="#">RECOMMENDED</a></li>

                  <li><!-- Link with dropdown items -->
                      <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">LISTINGS</a>
                      <ul class="collapse list-unstyled" id="homeSubmenu">
                          <li><a href="#">Page</a></li>
                          <li><a href="#">Page</a></li>
                          <li><a href="#">Page</a></li>
                      </ul>

                  <li><a href="#">TRENDING</a></li>
                  <li><a href="#">SEARCH</a></li>
                  <li><a href="#">SETTINGS</a></li>
                  <li><a href="#">STATISTICS</a></li>
              </ul>
          </nav>
    </div>
    </div>
  </div>
</div>
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
        <form class="form-inline">
          <div class="form-group mb-2">
            <input type="text" v-model="newBoard.title" class="form-control-plaintext" id="staticEmail2" placeholder="board title">
          </div>
          <div class="form-group mx-sm-3 mb-2">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" v-model="newBoard.isPrivate" id="defaultCheck1">
              <label class="form-check-label" for="defaultCheck1">
                Private
              </label>
            </div>
          </div>
          <a href="#" @click="addBoard()" class="btn btn-primary mb-2">Add Board</a>
        </form>
          
            <div v-for="modalBoard in modalBoards" class="form-check">
              <label class="form-check-label">
                <input type="checkbox" class="form-check-input" v-model="modalBoard.pinned">{{modalBoard.board.title}}
              </label>
            </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" @click="savePins()">Save pins</button>
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
<div class="container items">
	<h2>Boards you follow</h2>
	<!-- Tabs -->
<section id="tabs">
<div class="container">
    <div class="row">
        <div class="col-xs-12 ">
                <nav>
                    <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Comedy</a>
                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Romance</a>
                        <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Thriller</a>
                        <a class="nav-item nav-link" id="nav-about-tab" data-toggle="tab" href="#nav-about" role="tab" aria-controls="nav-about" aria-selected="false">Others</a>
                </div>
            </nav>
            <div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">

                <div class="tab-pane active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                    <div class="container accordion">
                      <ul>
                        <li style="background-image: url(resources/Imagesnew/got.jpg); background-size:cover;">
                          <div> <a href="#">
                            <h2>Game of thrones</h2>
                            <p>Unfollow</p>
                            </a> </div>
                        </li>
                        <li style="background-image: url(resources/Imagesnew/hoc.jpg); background-size:cover;">
                          <div> <a href="#">
                            <h2>Breaking bad</h2>
                            <p>Unfollow</p>
                            </a> </div>
                        </li>
                        <li style="background-image: url(resources/Imagesnew/orange.jpg); background-size:cover;">
                          <div> <a href="#">
                            <h2>Prison break</h2>
                            <p>Unfollow</p>
                            </a> </div>
                        </li>
                        <li style="background-image: url(resources/Imagesnew/prisonbreak.jpg); background-size:cover;">
                          <div> <a href="#">
                            <h2>Scandal</h2>
                            <p>More</p>
                            </a> </div>
                        </li>
                        <li style="background-image: url(resources/Imagesnew/scandal.jpg); background-size:cover;">
                          <div> <a href="#">
                            <h2>House of cards</h2>
                            <p>More</p>
                            </a> </div>
                        </li>
                        <li style="background-image: url(resources/Imagesnew/sherlock.jpg); background-size:cover;">
                          <div> <a href="#">
                            <h2>Orange is the new black</h2>
                            <p>More</p>
                            </a> </div>
                        </li>
                      </ul>
                    </div>
                    </div>
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                            Et et consectetur ipsum labore excepteur est proident excepteur ad velit occaecat qui minim occaecat veniam. Fugiat veniam incididunt anim aliqua enim pariatur veniam sunt est aute sit dolor anim. Velit non irure adipisicing aliqua ullamco irure incididunt irure non esse consectetur nostrud minim non minim occaecat. Amet duis do nisi duis veniam non est eiusmod tempor incididunt tempor dolor ipsum in qui sit. Exercitation mollit sit culpa nisi culpa non adipisicing reprehenderit do dolore. Duis reprehenderit occaecat anim ullamco ad duis occaecat ex.
                    </div>
                    <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                            Et et consectetur ipsum labore excepteur est proident excepteur ad velit occaecat qui minim occaecat veniam. Fugiat veniam incididunt anim aliqua enim pariatur veniam sunt est aute sit dolor anim. Velit non irure adipisicing aliqua ullamco irure incididunt irure non esse consectetur nostrud minim non minim occaecat. Amet duis do nisi duis veniam non est eiusmod tempor incididunt tempor dolor ipsum in qui sit. Exercitation mollit sit culpa nisi culpa non adipisicing reprehenderit do dolore. Duis reprehenderit occaecat anim ullamco ad duis occaecat ex.
                    </div>
                    <div class="tab-pane fade" id="nav-about" role="tabpanel" aria-labelledby="nav-about-tab">
                            Et et consectetur ipsum labore excepteur est proident excepteur ad velit occaecat qui minim occaecat veniam. Fugiat veniam incididunt anim aliqua enim pariatur veniam sunt est aute sit dolor anim. Velit non irure adipisicing aliqua ullamco irure incididunt irure non esse consectetur nostrud minim non minim occaecat. Amet duis do nisi duis veniam non est eiusmod tempor incididunt tempor dolor ipsum in qui sit. Exercitation mollit sit culpa nisi culpa non adipisicing reprehenderit do dolore. Duis reprehenderit occaecat anim ullamco ad duis occaecat ex.
                    </div>
            </div>
        </div>
    </div>
</div>
</section>
<!-- ./Tabs -->
</div>    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <!--THE PREVIOUS CODE STARTS FROM HERE-->
    
    
    
    
    
<div class="container-fluid">
    <div class="card-columns">
        <div class="card" v-for="track in pinnedTracks">
        <img class="card-img-top img-fluid" :src="(track.artworkUrl ? track.artworkUrl : 'resources/no-image.png')" alt="Card Columns 1">
        <div class="card-overlay">
            <div class="text"><a :href="'<c:url value="/tracks" />' + '?id=' + track.id.toString()"><span class="oi oi-play-circle icon-play"></span></a></div>
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