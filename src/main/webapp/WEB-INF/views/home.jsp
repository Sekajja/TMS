<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
a:link {
    color: #333333;
    text-decoration: none;
}

/* visited link */
a:visited {
    color: #454545;
    text-decoration: none;
}

/* mouse over link */
a:hover {
    color: #000000;
    text-decoration: none;
}

/* selected link */
a:active {
    color: #606060;
    text-decoration: none;
}
</style>



<body>

<header style="color:white;text-align:center;padding:14;height:40px;background-color:#454545;position:absolute;top:0px;left:0px;right:0px;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased;font-weight:100;font-size:25">
<img alt="" src="<c:url value="/resources/images/test/wierd6.png"/>"/>
</header>
<br><br><br><br><br>

<nav style=" 
	">
    
<a href="login">Home</a>. |
  <a href="login">About</a>. |
  <a href="login">Clients</a>. |
  <a href="login">Contact Us</a>.

</nav>
<br><br>
<article>
  <header style="color:#333333;">
 

    <h1 id="log" >System Event Log</h1>
    <p>logged 24th April 2014</p>
  </header>
  <p>
  <p id="verbose"></p>
   <br>
  
   
   ...
  <p>
 
</article>

<script type="text/javascript" src="<c:url value="/resources/js/test.js"/>"></script>
<footer style="color:white;text-align:center;padding:20;height:40px;background-color:#333333;position:absolute;bottom:0px;left:0px;right:0px;font-family: Impact, Charcoal, sans-serif, Sawasdee;-webkit-font-smoothing:antialiased;font-weight:100;">
This page is for testing purposes only!!
</footer>
</body>
</html>

<!-- Date: <input type="date"/><br>
Color: <input type="color"/><br>
Date: <input type="date"/><br>
DateTime: <input type="datetime"/><br>
Time: <input type="time" name="usr_time"><br>
DateTimeLocal: <input type="datetime-local"/><br>
Email: <input type="email"/><br>
Month: <input type="month"/><br>
Number: <input type="number"/><br>
Quantity: <input type="number" name="points" min="0" max="100" step="10" value="30"><br>
Range: <input type="range"/><br>
Search: <input type="search"/><br>
Telephone: <input type="tel"/><br>
Time: <input type="time"/><br>
Url: <input type="url"/><br>
Week: <input type="week"/><br> -->