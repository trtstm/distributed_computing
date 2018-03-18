<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>
    <div class="navbar navbar-inverse navbar-static-top" role="navigation">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" rel="home" href="/" title="Aahan Krish's Blog - Homepage"></a>
            </div>

            <div class="collapse navbar-collapse navbar-ex1-collapse">

                <ul class="nav navbar-nav">
                    <li><a href="/topic/notes/">Home</a></li>
                    <li><a href="/topic/dev/">Setting</a></li>
                    <li><a href="/topic/good-reads/">Stats</a></li>
                   
                </ul>

                <div class="col-sm-3 col-md-3 pull-right">
                <form class="navbar-form" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term"></input>
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
                </form>
                </div>

            </div>
        </div>
        
        <!--Beginning of the card component-->
        <div class="wrapper">
            <div class="masonry">

                <div class="item">
                    <img src="resources/Pix/card3.jpg"></img>
                </div>
                <div class="item">
                    <img src="resources/Pix/card2.jpg"></img>
                </div>
               <div class="item">
                    <img src="resources/Pix/card1.jpg"></img>
                </div>
                <div class="item">
                    <img src="resources/Pix/card4.jpg"></img>
                </div>
                <div class="item">
                    <img src="resources/Pix/card5.jpg"></img>
                </div>
                <div class="item">
                    <img src="resources/Pix/card6.png"></img>
                </div>
                <div class="item">
                    <img src="resources/Pix/card7.jpg"></img>
                </div>
                <div class="item">
                    <img src="resources/Pix/card8.jpg"></img>
                </div>
                <div class="item">
                    <img src="resources/Pix/card9.jpg"></img>
                </div>
            </div>
        </div>
<%@include file="footer.jsp"%>
