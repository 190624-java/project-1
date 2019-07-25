var baseURL = "http://localhost:8080/J2Inc";


// document.getElementById("LoginButton").onclick = () => {
// alert("Started LoginButton click handler");
//     let xhr = new XMLHttpRequest();

//     let message = "";
//     let username = document.getElementById("username").value;
//     let password = document.getElementById("password").value;

//     //xhr.open("POST", baseURL + "/app/login/?username="+username+"&password="+password);
//     xhr.open("POST", baseURL + "/app/login", true);

//     xhr.onreadystatechange = () => {
//         if(this.readyState === 4 ) { //i.e. "DONE" i.e. opened, sent, headers received, loading data completed.
//             if(this.status === 200){ //i.e. DONE responding i.e. "OK"
//             alert();
//                 //if the servlet didn't redirect, then this will not get the tag referenced, because it won't be there.
//                 //There won't be responseText
//                 //It shouldn't even give a status of 200, because the redirect to another page will happen.
//                 message = this.responseText;
//                 document.getElementById("InvalidCredentials").innerText = message;
//             }
//         }
//     }

//     //xhr.send();
//     xhr.send("username="+username+"&password="+password);
// };