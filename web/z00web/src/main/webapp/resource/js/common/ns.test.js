//**********************************************
//**********************************************
PATNZ.Person = function (firstName, lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
};

PATNZ.Person.prototype.sayHello = function() {
  console.log("Hello, I'm " + this.firstName);
};


//**********************************************
//**********************************************
PATNZ.Student = function (firstName, lastName) {
	PATNZ.Person.call(this, firstName);
};

PATNZ.Student.prototype = Object.create(PATNZ.Person.prototype); 

PATNZ.Student.prototype.study = function() {
	  console.log("I'm studying ");
};



var person1 = new PATNZ.Person("Leon", "First");
person1.sayHello();

var student1 = new PATNZ.Student("LeonS", "Student");
student1.sayHello();
student1.study();