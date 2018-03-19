<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@include file="head_with_nav.jsp"%>

<div class="container">
    <div class="row">
        <div class="col">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Date</th>
                    </tr>
                </thead>

                <tbody>
                <c:forEach items="${logins}" var="login" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>${login.datetime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>