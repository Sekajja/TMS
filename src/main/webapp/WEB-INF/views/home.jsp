<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h1 align="center">PLAYLIST</h1>
<ul>
	<c:forEach var="track" items="${playlist}" varStatus="status">
		<li>
			<c:out value="${track}"></c:out>
		</li>
	</c:forEach>

</ul>
</body>
</html>
