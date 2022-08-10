
class Emp{
    constructor(name, password, email, country) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.country = country;
    }
}

var _name = document.getElementById("name");
var _password = document.getElementById("password");
var _email = document.getElementById("email");
var _country = document.getElementById("country");

var emp = new Emp(_name, _password, _email, _country);

parseJson = () =>{
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.responseText;
        postMet(this.responseText);
        console.log(this.responseText);
        // var result = JSON.parse(this.responseText);
        // console.log(result);
        // document.getElementById("demo").innerHTML = this.responseText;
    }
    var apiGet = xhttp.open("GET", "http://localhost:8080/CRUDServletProject_war_exploded/employeeServlet", true);

    xhttp.send(apiGet);
}


postMet=(postmessage)=>{
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        // console.log(this.responseText);
        // var result = JSON.parse(this.responseText);
        // console.log(result);
        // document.getElementById("demo").innerHTML = this.responseText;
    }
    xhttp.open("POST", "http://localhost:8080/CRUDServletProject_war_exploded/editServlet2", true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhttp.send(postmessage);
}