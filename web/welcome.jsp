<%-- 
    Document   : register
    Created on : Mar 10, 2018, 2:52:29 PM
    Author     : timo
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head.jsp"%>

<div class="container">
   
WELCOME

<canvas id="login_history_canvas"></canvas>


</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script>
$(function() {
    var logins = [
<c:forEach items="${logins}" var="login">
            {${login.datetime.getTime()}: 1},
</c:forEach>
    ];
    
    var ctx = document.getElementById('login_history_canvas');
    var loginHistoryChart = new Chart(ctx, {
        type: 'line',
        data: {
          //labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
          datasets: [{
            backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
            data: [2478,5267,734,784,433]
          }]
        },
        options: {
          title: {
            display: true,
            text: 'Login history'
          }
        }
    });
});  
</script>

<%@include file="footer.jsp"%>