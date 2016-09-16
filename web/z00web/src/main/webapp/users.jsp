<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/ui/common/ctx.tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Legacy</title>
<script src="/patnzsite/resource/dist/jquery/jquery-3.1.0.js"></script>
<script src="/patnzsite/resource/js/common/entity.ui.js"></script>
<script src="/patnzsite/resource/js/user/user.ui.js"></script>
<script src="/patnzsite/resource/js/common/common.ns.js"></script>
<script src="/patnzsite/resource/js/common/ns.test.js"></script>

<script>


	function initPage(){
		$('#userList').wEntityList();
		var listObj = $('#userList').data('wEntityList');
		listObj.setListURL("${base}/web/data/user/users");
		listObj.setDeleteUrl("${base}/web/data/user/");
		listObj.setCreateUrl("${base}/web/data/user");
		listObj.setColumns({
			columns: [{title: "Login Name"},
						 {title: "First Name"},
						 {title: "Last Name"},
						 {title: "Email"},
						 {title: "Password"},
						 {title: "Actions"}]   
					  });
		listObj.loadData();
	};
	
	window.addEventListener("load", initPage);
</script>
</head>
<body>
	<%@ include file="/menu/menu.jspf"%>
	
	<div></div>
	
	<div>
		<h2>Create User</h2>
		<br/>	
			<table>
				<tr><th>User Name:</th><th>First Name:</th><th>Last Name:</th><th>Email:</th><th>Temporary Password:</th></tr>
				<tr>
					<td><input type="text" id="name" name="name"/></td>
					<td><input type="text" id="firstName" name="firstName" /></td>
					<td><input type="text" id="lastName" name="lastName" /></td>
					<td><input type="text" id="email" name="email" /></td>
					<td><input type="text" id="password" name="password" /></td>
				</tr>	
			<table/>
			<input id="createUserButton" type="button" name="createUserButton" value="Create User" onclick='createUser("${base}/web/data/user", 
																														$("#name").val(), 
																														$("#firstName").val(), 
																														$("#lastName").val(), 
																														$("#email").val(), 
																														$("#password").val(), 
																														cleanUserList());'/>																													
	</div>	
	<br/>
	<h2>User List</h2>		
	<input type="button" title="Refresh List" value="Refresh List" onclick="$('#userList').data('wEntityList').loadData();"/>
	
	<div id="userList"></div>

</body>
</html>