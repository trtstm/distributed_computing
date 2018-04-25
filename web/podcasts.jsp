<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

  <div class="container-fluid banner">
  </div>
  <div class="container podcasts">
    <h3>Available podcasts</h3>
    <hr>
  <div id="mixedSlider" class="podflixSlider">
        <div class="MS-content">
            <div class="item">
                <div class="imgTitle" class="rounded-circle" style="border-radius: 50%;">
                    <h2 class="blogTitle">Season 1</h2>
                    <img src="resources/images/season-1.jpg" alt="" />
                </div>
            </div>
            <div class="item">
                <div class="imgTitle">
                    <h2 class="blogTitle">Season 2</h2>
                    <img src="resources/images/season-2.jpg" alt="" />
                </div>
            </div>
            <div class="item">
                <div class="imgTitle">
                    <h2 class="blogTitle">Season 3</h2>
                    <img src="resources/images/season-3.jpg" alt="" />
                </div>
            </div>
            <div class="item">
                <div class="imgTitle">
                    <h2 class="blogTitle">Season 4</h2>
                    <img src="resources/images/season-4.jpg" alt="" />
                </div>
            </div>
             <div class="item">
                <div class="imgTitle">
                    <h2 class="blogTitle">Season 5</h2>
                    <img src="resources/images/season-5.jpg" alt="" />
                </div>
            </div>
             <div class="item">
                <div class="imgTitle">
                    <h2 class="blogTitle">Season 6</h2>
                    <img src="resources/images/season-6.jpg" alt="" />
                </div>
            </div>
            <div class="item">
                <div class="imgTitle">
                    <h2 class="blogTitle">Season 7</h2>
                    <img src="resources/images/season-7.jpg" alt="" />
                </div>
            </div>


        </div>
        <div class="MS-controls">
            <button class="MS-left"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
            <button class="MS-right"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
        </div>
    </div>
  </div>
  <div class="container podcasts">
   <h3>Available episodes</h3>
    <hr>
    <h3>Season 1</h3>
    <div class="row episodes">
      <div class="col-md-3">
        <div class="row">
        <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 1</div>
        </div>
      </div>
       <div class="col-md-3">
        <div class="row">
        <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 2</div>
        </div>
      </div>
       <div class="col-md-3">
        <div class="row">
          <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 3</div>
        </div>
      </div>
       <div class="col-md-3">
        <div class="row">
        <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 4</div>
        </div>
      </div>
    </div>
     <h3>Season 2</h3>
    <div class="row episodes">
      <div class="col-md-3">
        <div class="row">
        <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 1</div>
        </div>
      </div>
       <div class="col-md-3">
        <div class="row">
         <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 2</div>
        </div>
      </div>
       <div class="col-md-3">
        <div class="row">
        <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 3</div>
        </div>
      </div>
       <div class="col-md-3">
        <div class="row">
         <div class="col-md-3"><span class="oi oi-play-circle icon-playP"></span></div>
          <div class="col-md-9">episode 4</div>
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