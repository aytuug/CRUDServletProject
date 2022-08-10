
loadDoc=()=>{
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.responseText;
    }
    var apiGet  =  xhttp.open("GET", "http://localhost:8080/CRUDServletProject_war_exploded/employeeServlet", true);
    xhttp.send(apiGet);

}

