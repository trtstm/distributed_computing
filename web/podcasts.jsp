<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

  <div class="container-fluid banner">
      <!--PICTURE OF THE CLICKED BOARD-->
      <img src="resources/Imagesnew/got.jpg">
  </div>
  <div class="container podcasts">
   <h3>Available pins</h3>
    <hr>
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
        <div class="col-md-9">episode 3</div>
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