<%@ include file="/WEB-INF/jsp/ui/common/ctx.tag"%>
<html>
<body>
<h2>Hello World   hjghjg!</h2>



<form id="createUser" name="createUser" action="${base}/web/data/user" method="post">
<h2>Create User</h2>
	User Name:
	<input type="text" id="name" name="name"/>
	<br/>
	First Name:
	<input type="text" id="firstName" name="firstName" />
	<br/>
	Last Name:
	<input type="text" id="lastName" name="lastName" />
	<br/>
	Email:
	<input type="text" id="email" name="email" />
	<br/>
	Temporary Password:
	<input type="text" id="password" name="password" />
	<br/>
	<input type="submit" id="createUserButton" name="createUserButton" value="Create User" />
</form>
</body>
</html>
