<%@page isELIgnored="false" language="java" %>
<h1 style="color:red;text-align:center;">Login Page</h1>
<hr/>
<form action="login.htm" method="POST">
	<b>Username: </b><input type="text" name="username"/><br/>
	<b>Password: </b><input type="text" name="password"/><br/>
	<input type="submit" value="Login"/>
</form>
${status}