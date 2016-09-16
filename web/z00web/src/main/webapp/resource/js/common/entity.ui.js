(function ($) {
  'use strict';

  function EntityList(el) {
	    this.$el = $(el);
	    this.generate();
  }  
  
  
  EntityList.prototype = {  
		  listUrl : "",
		  deleteUrl : "",
		  createUrl : "",
		  columns : null,
		  setListURL: function(listUrl){
			  this.listUrl = listUrl;  
		  },

		  setDeleteUrl: function(deleteUrl){
			  this.deleteUrl = deleteUrl;  
		  },		  
		  setCreateUrl : function(createUrl){
			  this.createUrl = createUrl;  
		  },		   
		  setColumns : function(columns){
			this.columns = columns;  
		  },
		  generate: function () {    		
		  },

		  loadData: function () { 
			  var elem = this.$el;	
			  var columns = this.columns;
			  elem.empty();
			  $.ajax({
				  url: this.listUrl,
				  type: "GET", 
		
				   success: function(data) {
					   var result = "<table>";
					   var header = "";					   
					   
					   // case when columns are defined
					   if(columns != null){
						   $.each(columns.columns, function(key,value) {
							   header = header + "<th>" + value.title + "</th>";
							 });
						   result = result + header;
					   }
					   

					   for(var i = 0 ; i <  data.rows.length; i++){
						   var lineRes = "";
						
						   // case when columns are not defined						   
						   var keys = "";
						   $.each(data.rows[i], function(key,value) {
							   lineRes = lineRes + "<td>" + value + "</td>";
							   keys = keys + "<th>" + key + "</th>";
							 });						
						   
						   if(header == ""){
							   header = keys;
							   result = result + header + "<th>actions</th>"; 
						   }
					   
						   result =  result + "<tr>" + lineRes +
					   		"<td><input type='button' id='del"+data.rows[i].id+"' name='del"+data.rows[i].id+"' " +
			   				"onclick=\"$('#"+elem.attr('id')+"').data('wEntityList').deleteEntity("+data.rows[i].id+")\" value='Delete'>" + "</td>" +
			   				"</tr>";

					   }
					   result =  result + "</table>"
					   elem.append(result);
				   },
				   error: function() {
					   elem.html('<p>An error has occurred</p>');
				   }
			  });   
		  }, 
		  createEntity: function (inData, callback) { 	  
			  $.ajax({
				  url: this.createUrl,
				  type: "POST", 
				  data: inData,
				   success: callback,
				   error: function() {
					   elem.html('<p>An error has occurred</p>');
				   }
			  });   
		  }, 		  
		  deleteEntity: function (id) { 
			  var lId = id;
			  var elem = this.$el;			  
			  $.ajax({
				  url: this.deleteUrl+lId,
				  type: "DELETE", 		
				   success: function(data) {
					   elem.empty();
					   elem.data('wEntityList').loadData();
				   },
				   error: function() {
					   elem.html('<p>An error has occurred</p>');
				   }
			  });   
		  }  		  
  };
  
  $.fn.wEntityList = function () {
	  
	  function get(){
		  var wEntityList = $.data(this, 'wEntityList');
	      if (!wEntityList) {
	    	  wEntityList = new EntityList(this);
	        $.data(this, 'wEntityList', wEntityList);
	      }
	      return wEntityList;
	  }
		  		  	  
	  return this.each(get);
  };
})(jQuery);
