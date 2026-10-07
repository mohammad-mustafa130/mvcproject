/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

let asynreq = function() {
    const req = new XMLHttpRequest();
    
    let email= field.value;
    req.open("GET", "http://localhost:8080/mvcproject/fc/models/emailVerifier?email=" + email, true);
     req.onreadystatechange = function() {
        if(req.readyState === 4) {
            if(req.status === 200){
               let obj = JSON.parse(req.responseText);
               let textdata = obj.exist;
               if(textdata === "false") {
                   document.getElementById("espan").innerHTML = "Email Available";
                   req.open("GET", "http://localhost:8080/mvcproject/fc/models/register?email=" + email, true);
                   req.send(null);
               } else {
                   document.getElementById("espan").innerHTML = "Email already registered";
               }
            }
        }
    };
    req.send(null);   
};

let field = document.querySelector("#eml");
field.addEventListener('blur', asynreq);

