function validate(){
var uname = document.getElementById("uname").value;
var pword = document.getElementById("pword").value;
if (uname === "" || pword === "") {
    alert("Please enter both username and password");
    return false;
  } else {
    console.log("Username: " + uname);
    console.log("Password: " + pword);
  }
}

