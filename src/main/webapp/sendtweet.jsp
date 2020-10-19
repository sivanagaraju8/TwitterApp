    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Send Tweet</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
		<%-- <h2>Context Path => ${contextPath}</h2>
		<h2>Context Path => ${_csrf.parameterName}</h2>
		<h2>Context Path => ${_csrf.token}</h2> modelAttribute="tweetForm"--%>
        <h3 style="color:#000;font-style:Verdana;font-weight:bold;" class="pull-right">Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>           
    </c:if>
			
		<div class="row">
		<div class="col-md-6">
        <form:form method="POST" modelAttribute="userForm" class="form-sigin ">
        <h3 class="text-success font-weight-bold"><b>${success}</b></h3> <br>
            <h4 class="form-signin-heading">Say What's in your mind!</h4>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true" readOnly="true" value="${pageContext.request.userPrincipal.name}"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>
			<spring:bind path="tweet">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:textarea type="text" path="tweet" class="form-control" placeholder="Tweet Here!"
                                autofocus="true"></form:textarea>
                    <form:errors path="tweet"></form:errors>
                </div>
            </spring:bind>
            

            <button class="btn btn-md btn-info btn-block" type="submit">Send Tweet!</button>
        </form:form>
        </div>
        </div>
	<h3 class="text-dark"><b>Here are your Tweets!</b></h3>
	
	<c:forEach var="tweet" items="${UserTweets}">
	<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Tweet Count No: ${tweet.getId()}</h5>
    <h6 class="card-subtitle mb-2 text-muted">Sent Time:  ${tweet.getTweettime()}</h6>
    <p class="card-text text-dark">${tweet.getTweet()}</p>
  </div>
</div> <br>
			<%-- <c:out value="${tweet.getId()}"/> 
            <c:out value="${tweet.getUsername()}"/>
            <c:out value="${tweet.getTweet()}"/>
            <c:out value="${tweet.getTweettime()}"/>  --%>
        </c:forEach>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
  