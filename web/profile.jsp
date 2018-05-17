<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

<div class="container-fluid" style="text-align: center; background: #8e8e8e; height: 300px;">
    <div class="row">
            <div id="demo" class="col-md-12" data-ride="carousel">
                    <div class="row" style="display: block;">
                            <!--INCLUDES THE IMAGE OF THE PROFILE OR AN AVATAR-->
                            <p style="border-radius: 100%; margin: 0 auto; margin-top: 150px;"><i class="fa fa-user" aria-hidden="true" style="width: 20%; height: 20%; color: white; font-size: 50px;"></i></p>
                            <p style="color: black;">ANGELA MIZERO</p>
                    </div>
            </div>
    </div>
    </div>
<div class="container items">
<h2>Following</h2>

  <div class="container podcasts">
<div class="bd-example bd-example-tabs">
  <nav>
    <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Boards</a>
            <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Users</a>
    </div>
</nav>
  <div class="tab-content" id="nav-tabContent">
    <div class="tab-pane fade active show" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" aria-expanded="true">
            <div class="card-columns">
        <div class="card">
        <img class="card-img-top img-fluid" src="resources/images/rsz_house-of-cards.jpg" alt="Card Columns 1">
        <div class="card-overlay">
          <div class="text"><span class="oi oi-play-circle icon-play"></span></div>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">House of cards</h5>
            </div>
            <div class="col-md-6">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKXSURBVGhD7Zm7itVQGEaPyKiooL0ivoDdqL0I6hsoKIJYCDoKFhaKFr6JVyy8gpfGW6OF4gOITDGNIFPZKDOIuj6ZH342O5eT7J0cZC9YxclJdvYKSU4yMykUCoX/ivW4gHP/PuVjF17HB3gDj6P2nQQNdBv/4H3cgDk4hj9Q+/G+wx3Ym3PoB84RswdX0e/H+wV3Yi80aU3eD5w65jna2Mt4DW+6ZXLmY/ahH/cQGpfQf5csRhehH7hvjM79z2jjvcSQMOYT9j6AKWPCiN84jzHCmJPYmxQxYYS8iHXcQltXd9EkaNIP0U9EcW1iukSIq2jrP9KCVHSJ6RpxBHU3s230o5kUTVpHx0+sKqZLxAF8j36bn7gbk9M25i76dZoidEH/Qr/NCh7FbGzFD+h3GsZsw4+o75oiTmEY8Qz1BJCFw/gCqx4vdA2FMXoQrOM06lZsY+h03I9Z2IT2INlkGFPHGQwjdG1lYTO+Qj9Z+R0X1/y6tsxsE3MWB414g36SitqLHk06vAHUxZzHwSLEZfST05FXXIy2MSdw0Aihl6x76Ceni30jxmgTsx3tbjZIhJEiRp99jO5m+p0ZLMLIETMaJQb9+iUmB11ivqFffyZiYkdZ1sUsYbj+YxwtpirCrIqJhchRYmIR+tx0mq1DPZvZ9+ErwKAxVRFa3nTN6LHclusVYAuGYw0SUxdhVMXo2ey1W/YUhbbV5P36WWPaRBixmPAR/yAag8VME2HEYkz96yAkFvMEk8V0iTBiMTq96n5nssT0iTB8zFuseo8xNLYm7/fZK0Yb6h3CDzhthKGYK9gUYSSNCf/R0+b9OyWxmAs4NTqKd3CMCMPH6K83mlMntKGOwhgRhvatOXSOKBQKhVljMvkL8me3dDLtp0IAAAAASUVORK5CYII=">
            </div>
          </div>
        </div>
        </div>
        <div class="card">
        <img class="card-img-top img-fluid" src="resources/images/rsz_prison-break.jpg" alt="Card Columns 1">
                <div class="card-overlay">
          <div class="text"><span class="oi oi-play-circle icon-play"></span></div>
        </div>
        <div class="card-body">
         <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">Prison break</h5>
            </div>
            <div class="col-md-6">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKXSURBVGhD7Zm7itVQGEaPyKiooL0ivoDdqL0I6hsoKIJYCDoKFhaKFr6JVyy8gpfGW6OF4gOITDGNIFPZKDOIuj6ZH342O5eT7J0cZC9YxclJdvYKSU4yMykUCoX/ivW4gHP/PuVjF17HB3gDj6P2nQQNdBv/4H3cgDk4hj9Q+/G+wx3Ym3PoB84RswdX0e/H+wV3Yi80aU3eD5w65jna2Mt4DW+6ZXLmY/ahH/cQGpfQf5csRhehH7hvjM79z2jjvcSQMOYT9j6AKWPCiN84jzHCmJPYmxQxYYS8iHXcQltXd9EkaNIP0U9EcW1iukSIq2jrP9KCVHSJ6RpxBHU3s230o5kUTVpHx0+sKqZLxAF8j36bn7gbk9M25i76dZoidEH/Qr/NCh7FbGzFD+h3GsZsw4+o75oiTmEY8Qz1BJCFw/gCqx4vdA2FMXoQrOM06lZsY+h03I9Z2IT2INlkGFPHGQwjdG1lYTO+Qj9Z+R0X1/y6tsxsE3MWB414g36SitqLHk06vAHUxZzHwSLEZfST05FXXIy2MSdw0Aihl6x76Ceni30jxmgTsx3tbjZIhJEiRp99jO5m+p0ZLMLIETMaJQb9+iUmB11ivqFffyZiYkdZ1sUsYbj+YxwtpirCrIqJhchRYmIR+tx0mq1DPZvZ9+ErwKAxVRFa3nTN6LHclusVYAuGYw0SUxdhVMXo2ey1W/YUhbbV5P36WWPaRBixmPAR/yAag8VME2HEYkz96yAkFvMEk8V0iTBiMTq96n5nssT0iTB8zFuseo8xNLYm7/fZK0Yb6h3CDzhthKGYK9gUYSSNCf/R0+b9OyWxmAs4NTqKd3CMCMPH6K83mlMntKGOwhgRhvatOXSOKBQKhVljMvkL8me3dDLtp0IAAAAASUVORK5CYII=">
            </div>
          </div>
        </div>
        </div>
        <div class="card">
        <img class="card-img-top img-fluid" src="resources/images/rsz_game-of-thrones.jpg" alt="Card Columns 1">
                <div class="card-overlay">
          <div class="text"><span class="oi oi-play-circle icon-play"></span></div>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">Game of thrones</h5>
            </div>
            <div class="col-md-6">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKXSURBVGhD7Zm7itVQGEaPyKiooL0ivoDdqL0I6hsoKIJYCDoKFhaKFr6JVyy8gpfGW6OF4gOITDGNIFPZKDOIuj6ZH342O5eT7J0cZC9YxclJdvYKSU4yMykUCoX/ivW4gHP/PuVjF17HB3gDj6P2nQQNdBv/4H3cgDk4hj9Q+/G+wx3Ym3PoB84RswdX0e/H+wV3Yi80aU3eD5w65jna2Mt4DW+6ZXLmY/ahH/cQGpfQf5csRhehH7hvjM79z2jjvcSQMOYT9j6AKWPCiN84jzHCmJPYmxQxYYS8iHXcQltXd9EkaNIP0U9EcW1iukSIq2jrP9KCVHSJ6RpxBHU3s230o5kUTVpHx0+sKqZLxAF8j36bn7gbk9M25i76dZoidEH/Qr/NCh7FbGzFD+h3GsZsw4+o75oiTmEY8Qz1BJCFw/gCqx4vdA2FMXoQrOM06lZsY+h03I9Z2IT2INlkGFPHGQwjdG1lYTO+Qj9Z+R0X1/y6tsxsE3MWB414g36SitqLHk06vAHUxZzHwSLEZfST05FXXIy2MSdw0Aihl6x76Ceni30jxmgTsx3tbjZIhJEiRp99jO5m+p0ZLMLIETMaJQb9+iUmB11ivqFffyZiYkdZ1sUsYbj+YxwtpirCrIqJhchRYmIR+tx0mq1DPZvZ9+ErwKAxVRFa3nTN6LHclusVYAuGYw0SUxdhVMXo2ey1W/YUhbbV5P36WWPaRBixmPAR/yAag8VME2HEYkz96yAkFvMEk8V0iTBiMTq96n5nssT0iTB8zFuseo8xNLYm7/fZK0Yb6h3CDzhthKGYK9gUYSSNCf/R0+b9OyWxmAs4NTqKd3CMCMPH6K83mlMntKGOwhgRhvatOXSOKBQKhVljMvkL8me3dDLtp0IAAAAASUVORK5CYII=">
            </div>
          </div>
        </div>
        </div>
        <div class="card">
        <img class="card-img-top img-fluid" src="resources/images/rsz_scandal.jpg" alt="Card Columns 1">
                <div class="card-overlay">
          <div class="text"><span class="oi oi-play-circle icon-play"></span></div>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">Scandal</h5>
            </div>
            <div class="col-md-6">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKXSURBVGhD7Zm7itVQGEaPyKiooL0ivoDdqL0I6hsoKIJYCDoKFhaKFr6JVyy8gpfGW6OF4gOITDGNIFPZKDOIuj6ZH342O5eT7J0cZC9YxclJdvYKSU4yMykUCoX/ivW4gHP/PuVjF17HB3gDj6P2nQQNdBv/4H3cgDk4hj9Q+/G+wx3Ym3PoB84RswdX0e/H+wV3Yi80aU3eD5w65jna2Mt4DW+6ZXLmY/ahH/cQGpfQf5csRhehH7hvjM79z2jjvcSQMOYT9j6AKWPCiN84jzHCmJPYmxQxYYS8iHXcQltXd9EkaNIP0U9EcW1iukSIq2jrP9KCVHSJ6RpxBHU3s230o5kUTVpHx0+sKqZLxAF8j36bn7gbk9M25i76dZoidEH/Qr/NCh7FbGzFD+h3GsZsw4+o75oiTmEY8Qz1BJCFw/gCqx4vdA2FMXoQrOM06lZsY+h03I9Z2IT2INlkGFPHGQwjdG1lYTO+Qj9Z+R0X1/y6tsxsE3MWB414g36SitqLHk06vAHUxZzHwSLEZfST05FXXIy2MSdw0Aihl6x76Ceni30jxmgTsx3tbjZIhJEiRp99jO5m+p0ZLMLIETMaJQb9+iUmB11ivqFffyZiYkdZ1sUsYbj+YxwtpirCrIqJhchRYmIR+tx0mq1DPZvZ9+ErwKAxVRFa3nTN6LHclusVYAuGYw0SUxdhVMXo2ey1W/YUhbbV5P36WWPaRBixmPAR/yAag8VME2HEYkz96yAkFvMEk8V0iTBiMTq96n5nssT0iTB8zFuseo8xNLYm7/fZK0Yb6h3CDzhthKGYK9gUYSSNCf/R0+b9OyWxmAs4NTqKd3CMCMPH6K83mlMntKGOwhgRhvatOXSOKBQKhVljMvkL8me3dDLtp0IAAAAASUVORK5CYII=">
            </div>
          </div>
        </div>
        </div>
        <div class="card">
        <img class="card-img-top img-fluid" src="resources/images/rsz_sherlock.jpg" alt="Card Columns 1">
          <div class="card-overlay">
            <div class="text"><span class="oi oi-play-circle icon-play"></span></div>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">Sherlock</h5>
            </div>
            <div class="col-md-6">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKXSURBVGhD7Zm7itVQGEaPyKiooL0ivoDdqL0I6hsoKIJYCDoKFhaKFr6JVyy8gpfGW6OF4gOITDGNIFPZKDOIuj6ZH342O5eT7J0cZC9YxclJdvYKSU4yMykUCoX/ivW4gHP/PuVjF17HB3gDj6P2nQQNdBv/4H3cgDk4hj9Q+/G+wx3Ym3PoB84RswdX0e/H+wV3Yi80aU3eD5w65jna2Mt4DW+6ZXLmY/ahH/cQGpfQf5csRhehH7hvjM79z2jjvcSQMOYT9j6AKWPCiN84jzHCmJPYmxQxYYS8iHXcQltXd9EkaNIP0U9EcW1iukSIq2jrP9KCVHSJ6RpxBHU3s230o5kUTVpHx0+sKqZLxAF8j36bn7gbk9M25i76dZoidEH/Qr/NCh7FbGzFD+h3GsZsw4+o75oiTmEY8Qz1BJCFw/gCqx4vdA2FMXoQrOM06lZsY+h03I9Z2IT2INlkGFPHGQwjdG1lYTO+Qj9Z+R0X1/y6tsxsE3MWB414g36SitqLHk06vAHUxZzHwSLEZfST05FXXIy2MSdw0Aihl6x76Ceni30jxmgTsx3tbjZIhJEiRp99jO5m+p0ZLMLIETMaJQb9+iUmB11ivqFffyZiYkdZ1sUsYbj+YxwtpirCrIqJhchRYmIR+tx0mq1DPZvZ9+ErwKAxVRFa3nTN6LHclusVYAuGYw0SUxdhVMXo2ey1W/YUhbbV5P36WWPaRBixmPAR/yAag8VME2HEYkz96yAkFvMEk8V0iTBiMTq96n5nssT0iTB8zFuseo8xNLYm7/fZK0Yb6h3CDzhthKGYK9gUYSSNCf/R0+b9OyWxmAs4NTqKd3CMCMPH6K83mlMntKGOwhgRhvatOXSOKBQKhVljMvkL8me3dDLtp0IAAAAASUVORK5CYII=">
            </div>
          </div>
        </div>
        </div>
        <div class="card">
        <img class="card-img-top img-fluid" src="resources/images/orange-is-the-new-black.jpg" alt="Card Columns 1">
        <div class="card-overlay">
            <div class="text"><span class="oi oi-play-circle icon-play"></span></div>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-8">
              <h5 class="card-title">Orange is the new black</h5>
            </div>
            <div class="col-md-4">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKXSURBVGhD7Zm7itVQGEaPyKiooL0ivoDdqL0I6hsoKIJYCDoKFhaKFr6JVyy8gpfGW6OF4gOITDGNIFPZKDOIuj6ZH342O5eT7J0cZC9YxclJdvYKSU4yMykUCoX/ivW4gHP/PuVjF17HB3gDj6P2nQQNdBv/4H3cgDk4hj9Q+/G+wx3Ym3PoB84RswdX0e/H+wV3Yi80aU3eD5w65jna2Mt4DW+6ZXLmY/ahH/cQGpfQf5csRhehH7hvjM79z2jjvcSQMOYT9j6AKWPCiN84jzHCmJPYmxQxYYS8iHXcQltXd9EkaNIP0U9EcW1iukSIq2jrP9KCVHSJ6RpxBHU3s230o5kUTVpHx0+sKqZLxAF8j36bn7gbk9M25i76dZoidEH/Qr/NCh7FbGzFD+h3GsZsw4+o75oiTmEY8Qz1BJCFw/gCqx4vdA2FMXoQrOM06lZsY+h03I9Z2IT2INlkGFPHGQwjdG1lYTO+Qj9Z+R0X1/y6tsxsE3MWB414g36SitqLHk06vAHUxZzHwSLEZfST05FXXIy2MSdw0Aihl6x76Ceni30jxmgTsx3tbjZIhJEiRp99jO5m+p0ZLMLIETMaJQb9+iUmB11ivqFffyZiYkdZ1sUsYbj+YxwtpirCrIqJhchRYmIR+tx0mq1DPZvZ9+ErwKAxVRFa3nTN6LHclusVYAuGYw0SUxdhVMXo2ey1W/YUhbbV5P36WWPaRBixmPAR/yAag8VME2HEYkz96yAkFvMEk8V0iTBiMTq96n5nssT0iTB8zFuseo8xNLYm7/fZK0Yb6h3CDzhthKGYK9gUYSSNCf/R0+b9OyWxmAs4NTqKd3CMCMPH6K83mlMntKGOwhgRhvatOXSOKBQKhVljMvkL8me3dDLtp0IAAAAASUVORK5CYII=">
            </div>
          </div>
        </div>
        </div>
  </div>
    </div>
  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" aria-expanded="false">
    <div class="row" style="padding-top: 10px;">
        <!--HERE ALL THE USERS THAT THE PROFILE FOLLOWS-->
          <div class="col-md-4">
                <i class="fa fa-user" aria-hidden="true" style="width: 20%; height: auto; color:white;"></i>
     
                <p>Anoushka</p>
                <p>Unfollow</p>
            </div>
          <div class="col-md-4">
                <i class="fa fa-user" aria-hidden="true" style="width: 20%; height: auto;color:white;"></i>
       
                <p>Anoushka</p>
                <p>Unfollow</p>
            </div>
          <div class="col-md-4">
                <i class="fa fa-user" aria-hidden="true" style="width: 20%; height: auto;color:white;"></i>
            
                <p>Anoushka</p>
                <p>Unfollow</p>
            </div>
        </div>
    </div>
   </div>
  </div>
</div>
  </div>

<script>
$('#basicSlider').multislider({
			continuous: true,
			duration: 2000
		});
		$('#mixedSlider').multislider({
			duration: 750,
			interval: 3000
		});
</script>

<%@include file="footer.jsp"%>