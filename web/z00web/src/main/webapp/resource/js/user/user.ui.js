function createUser(createUserUrl, inName, inFirstName, inLastName, inEmail, inPassword, callback) {
	var listObj = $('#userList').data('wEntityList');
	var data = {
			name: inName,
			firstName : inFirstName,
	  		lastName : inLastName, 
	  		email : inEmail, 
	  		password : inPassword   
		  };	
	listObj.createEntity(data, callback);
};  
