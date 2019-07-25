var baseURL = "http://localhost:8080/J2Inc";

document.onload = function (mainHidableElement){
    let xhr = new XMLHttpRequest();

    let message = "";

    xhr.open("GET", baseURL + "/app/SessionChecker", true);

    xhr.onreadystatechange = () => {
        if(this.readyState === 4 ) { //i.e. "DONE" i.e. opened, sent, headers received, loading data completed.
            if(this.status === 200){ //i.e. DONE responding i.e. "OK"
                //if the servlet didn't redirect, then this will not get the tag referenced, because it won't be there.
                //There won't be responseText
                //It shouldn't even give a status of 200, because the redirect to another page will happen.
                
                message = xhr.responseText;
                if(message=="Logged In") { 
                    mainHidableElement.removeAttribute("hidden");
                } else {
                    alert("Sorry, Session not active");
                }
            }
        }
    }
    
    xhr.send();
};